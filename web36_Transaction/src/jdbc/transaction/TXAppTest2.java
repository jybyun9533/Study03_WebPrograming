package jdbc.transaction;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class TXAppTest2 {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs = null;
		
		//1. 파일의 정보를 읽어온다...
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			//2. key로 읽어들인 값을 각각의 변수에 할당
			String driverName = p.getProperty("jdbc.mysql.driver");
			String url = p.getProperty("jdbc.mysql.url");
			String user = p.getProperty("jdbc.mysql.user");
			String pass = p.getProperty("jdbc.mysql.pass");
			String selectQuery = p.getProperty("jdbc.sql.select");
			String decreaseQuery = p.getProperty("jdbc.sql.decreaseupdate");
			String increaseQuery = p.getProperty("jdbc.sql.increaseupdate");
			
			//3. 드라이버 로딩
			Class.forName(driverName);
			System.out.println("드라이버 로딩...");
			
			//4. 서버연결
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("디비연결 성공..");
			
			/*
			 * 지금 부터는 계좌이체에 관련된 모든 쿼리를 하나로 묶을 것이다..하나의 단일 트랜젝션처리
			 * setAutocommit(), commit(), rollback() 함수를 적절한 위치에 작성해 보세요
			 */
			
			//트랜젝션 시작
			//
			conn.setAutoCommit(false);
			
			ps1 = conn.prepareStatement(selectQuery);
			rs = ps1.executeQuery();
			System.out.println("===========SELECT ==============");
			while(rs.next()) {
				System.out.println(rs.getString("name")
							  +" "+rs.getString("bankname")
							  +" "+rs.getInt("balance"));
			}
			System.out.println("================================");
			
			//윤아의 계좌에서 50만원을 출금함..
			ps2 = conn.prepareStatement(decreaseQuery);
			ps2.setInt(1, 500000);
			ps2.setString(2, "윤아");
			ps2.executeUpdate();
			
			//승기의 계좌로 50만원이 입금됨...
			ps3 = conn.prepareStatement(increaseQuery);
			ps3.setInt(1, 500000);
			ps3.setString(2, "승기");
			ps3.executeUpdate();
			
			conn.commit();
		}catch(Exception e) {
			System.out.println("===== 계좌이체시 오류발생 ======");
			conn.rollback();
		}finally {
			System.out.println("===== 계좌이체후 정보확인 ======");
			
			rs = ps1.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name")
						  +" "+rs.getString("bankname")
						  +" "+rs.getInt("balance"));
			}
			conn.setAutoCommit(true);
		}
	}
}
