package com.encore.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.model.Item;
import com.encore.model.ItemDaoTemplete;

import config.ServerInfo;

public class DaoUnitTest implements ItemDaoTemplete {
	DaoUnitTest() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		}
	}

	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공....");
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Item> list = new ArrayList<>();

		try {
			conn = getConnection();

			String query = "SELECT * FROM Item";

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6)));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public Item getItem(int itemid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Item item = new Item();

		try {
			conn = getConnection();
			String query = "SELECT * FROM item WHERE item_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemid);

			rs = ps.executeQuery();

			if (rs.next()) {
				item = new Item(itemid, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} finally {
			closeAll(rs, ps, conn);
		}

		return item;
	}

	@Override
	public boolean updateRecordCount(int itemid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;

		try {
			conn = getConnection();

			String query = "UPDATE item SET count=count+1 WHERE item_id=? ";

			ps = conn.prepareStatement(query);
			ps.setInt(1, itemid);

			int row = ps.executeUpdate();
			if (row > 0) {
				result = true;
			}
		} finally {
			closeAll(ps, conn);
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		DaoUnitTest test = new DaoUnitTest();
		// getAllItem()
		// ArrayList<Item> list = test.getAllItem();
		// System.out.println(list);

		// getItem()
		// System.out.println(test.getItem(1111));

		// updateRecordCount()
		boolean result=test.updateRecordCount(1111);
		System.out.println(result);
	}

}
