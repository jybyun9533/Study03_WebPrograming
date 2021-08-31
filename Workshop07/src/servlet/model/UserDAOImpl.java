package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {

	// 필드
	private DataSource ds; //

	// 싱글톤 구현
	private static UserDAOImpl dao = new UserDAOImpl();

	private UserDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
		}
	}

	public static UserDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
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
	public UserVO login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;

		try {
			conn = getConnection();
			String query = "select * from userinfo where userId =? and password=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, userId);
			ps.setString(2, password);

			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new UserVO(userId, password, rs.getString("name"), rs.getString("email"));
			}

		} finally {
			closeAll(rs, ps, conn); // Pool에서 꺼낸 Connection이 다시 Pool로 반환
		}
		return vo;
	}

}
