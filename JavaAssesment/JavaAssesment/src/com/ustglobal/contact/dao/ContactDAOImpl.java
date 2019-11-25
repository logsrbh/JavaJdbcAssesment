package com.ustglobal.contact.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ustglobal.contact.dto.ContactBean;

public class ContactDAOImpl implements ContactDAO {

	@Override
	public List<ContactBean> getAllContact() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql = "select * from contact ";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			ArrayList<ContactBean> result = new ArrayList<ContactBean>();
			while (rs.next()) {
				ContactBean bean = new ContactBean();
				String name = rs.getString("name");
				bean.setName(name);
				bean.setNum(rs.getInt("number"));
				bean.setGroupName(rs.getString("group_name"));
				result.add(bean);

			}
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}

		} // end of try-catch-finally

	}

	@Override
	public ContactBean searchContact(String name) {
		String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql = "select * from contact where name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ContactBean bean = new ContactBean();
				bean.setName(rs.getString("name"));
				bean.setNum(rs.getInt("number"));
				bean.setGroupName(rs.getString("group_name"));

				return bean;

			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

	}

	@Override
	public String call() {
		String msg = "Calling ";
		return msg;

	}

	@Override
	public String message() {
		String msg = "Message Sending ";
		return msg;
	}

	@Override
	public void addContact(String name, int number, String groupName) {
		String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql = "insert into contact values('" + name + "','" + number + "','" + groupName + "' )";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);

			stmt = conn.prepareStatement(sql);

			int rs1 = stmt.executeUpdate(sql);

			if (rs1 > 0) {
				System.out.println("Data Inserted");
			} else {
				System.out.println("Data Not Inserted");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

	}

	@Override
	public boolean deleteContact(String name) {

		String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql = "delete from contact where name ='" + name + "'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);

			stmt = conn.prepareStatement(sql);

			int rs1 = stmt.executeUpdate(sql);

			if (rs1 > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

		finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

	}

	@Override
	public boolean updateContact(String name, int number, String groupName) {
		String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql = "update contact set name ='" + name + "', number ='" + number + "', group_name ='" + groupName
				+ "'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);

			stmt = conn.prepareStatement(sql);

			int rs1 = stmt.executeUpdate(sql);

			if (rs1 > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

		finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
	}
}
