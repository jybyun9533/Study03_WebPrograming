package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {
	// 싱글톤...
	private static MemberDAOImpl dao = new MemberDAOImpl();

	private DataSource ds;

	private MemberDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("data source lookup ok");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup fail");
		}
	}

	/*
	 * private MemberDAOImpl() { try { Class.forName(ServerInfo.DRIVER);
	 * System.out.println("드라이버 로딩 성공...");
	 * 
	 * } catch (ClassNotFoundException e) { System.out.println("드라이버 로딩 실패..."); } }
	 */

	public static MemberDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공....");
		return ds.getConnection();

		/*
		 * Connection conn = DriverManager.getConnection(ServerInfo.URL,
		 * ServerInfo.USER, ServerInfo.PASSWORD); return conn;
		 */
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO member VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");

			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());

			System.out.println(ps.executeUpdate() + " row INSERT OK!!");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT id, password, name, address From member";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"),
						rs.getString("address")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = getConnection();
			String query = "SELECT id,password,name,address From member where id=?";

			ps = conn.prepareStatement(query);
			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new MemberVO(id, rs.getString("password"), rs.getString("name"), rs.getString("address"));
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}

	@Override
	public MemberVO login(String id, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;

		try {
			conn = getConnection();
			String query = "select id, password, name, address from member where id =? and password=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, id);
			ps.setString(2, password);

			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(id, password, rs.getString("name"), rs.getString("Address"));
			}

		} finally {
			closeAll(rs, ps, conn); // Pool에서 꺼낸 Connection이 다시 Pool로 반환
		}
		System.out.println("리턴합니다합니다");
		return vo;
	}

	/*
	 * public static void main(String[] args) throws Exception { MemberDAOImpl dao =
	 * MemberDAOImpl.getInstance(); // doa.registerMember(); }
	 * 
	 * MemberVO vo = dao.login("encore", "playdata"); System.out.println(vo); }
	 */

}
