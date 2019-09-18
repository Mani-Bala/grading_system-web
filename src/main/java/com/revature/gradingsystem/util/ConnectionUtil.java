package com.revature.gradingsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.gradingsystem.exception.DBException;

public class ConnectionUtil {

	private static final String driverClassName = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://trainingdb.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/manikandan_db";
	private static final String username = "manikandan";
<<<<<<< HEAD
	private static final String password = "manikandan";
=======
	private static final String password = "manikandan"
			+ "";
>>>>>>> 2d4647fb878d6815f72df24c957d09e9fb84fd67

	public static Connection getConnection() throws DBException {

		Connection con = null;

		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			throw new DBException("Unable to load the driver class", e);
		} catch (SQLException e) {
			throw new DBException("Unable to get DB Connection", e);
		}

		return con;
	}

	public static void close(Connection con, PreparedStatement pst, ResultSet rs) throws DBException {

		try {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			throw new DBException("Unable to close the Connection", e);
		}
	}

	public static void close(Connection con, PreparedStatement pst) throws DBException {

		try {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			throw new DBException("Unable to close the Connection", e);
		}

	}

}
