package com.encore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.DataSourceManager;

public class ItemDao implements ItemDaoTemplete {
	// Field
	private DataSource ds;

	// Singletone
	private static ItemDao dao = new ItemDao();

	private ItemDao() {
		// 이전 코드는 DataSourceManager로 가져감 -> DataSourceManager에서 ds를 받아옴
		ds = DataSourceManager.getInstance().getConnection();
	}

	public static ItemDao getInstance() {
		return dao;
	}

	// Common Logic
	public Connection getConnection() throws SQLException {
		System.out.println("DB Connecting");
		return ds.getConnection();
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

	// Business Logic
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
	public Item getItem(int itemId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Item item = new Item();

		try {
			conn = getConnection();
			String query = "SELECT * FROM item WHERE item_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemId);

			rs = ps.executeQuery();

			if (rs.next()) {
				item = new Item(itemId, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} finally {
			closeAll(rs, ps, conn);
		}

		return item;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;

		try {
			conn = getConnection();

			String query = "UPDATE item SET count=count+1 WHERE item_id=? ";

			ps = conn.prepareStatement(query);
			ps.setInt(1, itemId);

			int row = ps.executeUpdate();
			if (row > 0) {
				result = true;
			}
		} finally {
			closeAll(ps, conn);
		}

		return result;
	}

}
