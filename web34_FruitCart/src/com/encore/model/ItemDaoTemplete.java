package com.encore.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDaoTemplete {

	ArrayList<Item> getAllItem() throws SQLException;
	
	Item getItem(int itemId) throws SQLException;
	
	boolean updateRecordCount(int itemId) throws SQLException;
}
