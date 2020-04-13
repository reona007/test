package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	final String URL = "jdbc:postgresql://localhost:5432/user_db?useSSL=false";
	final String USER = "postgres";
	final String PASSWORD = "password";

	public List<UserBean>findAll(){

		Connection conn =null;
		List<UserBean>userList= new ArrayList<>();

		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(URL,USER,PASSWORD);

			String sql="SELECT USER_ID,PASSWORD,NAME,AGE FROM M_USER ORDER BY user_id DESC";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			ResultSet rs=pStmt.executeQuery();

			while(rs.next()) {
				String id =rs.getString("USER_ID");
				String pass=rs.getString("password");
				String name =rs.getString("NAME");
				int age =rs.getInt("age");
				//	UserBean userlogin=new UserBean();
				UserBean user =new UserBean(id,pass,name,age);
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

}
