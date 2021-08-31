package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TXAppTest1 {

	public static void main(String[] args) throws Exception{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩");
		Connection conn = DriverManager.getConnection(ServerInfo.URL,"root","1234");
		System.out.println("DB 연결 성공");
		
		String query1 = "INSERT INTO test (name, birthday) VALUES(?, ?)";
		String query2 = "SELECT num, name, birthday FROM test WHERE num=?";
		
		// transaction 시작
		conn.setAutoCommit(false);
		/*
		 * 이 안에 들어오는 모든 작업은 원자성을 갖는다.
		 */
		PreparedStatement ps = conn.prepareStatement(query1);
		ps.setString(1, "전지현");
		ps.setString(2, "1985-03-04"); // num : 3
		ps.executeUpdate();
		
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 4); // num이 4인 사람을 받아오라는 뜻. 4인 사람은 없기 때문에 에러.. rollback :: 위의 전지현도 추가 X
		ResultSet rs =ps2.executeQuery();
		
		if(!rs.next()) { // 4에 해당하는 사람이 존재하지 않는다면
			// rollback
			conn.rollback();
			System.out.println("롤백. 전지현 추가X");
		} else {
			// commit;
			conn.commit();
			System.out.println("commit");
		}
		
		
		
		//transaction 마무리 -> 원래대로 돌려놓음
		conn.setAutoCommit(true);
		
	}

}
