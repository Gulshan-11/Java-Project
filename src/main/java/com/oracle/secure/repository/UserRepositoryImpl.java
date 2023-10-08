package com.oracle.secure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.oracle.dao.DBConnection;
import com.oracle.secure.model.User;
@Component
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	DBConnection dbConnection;
	@Override
	public User findByUsername(String username) {
		Connection con=	dbConnection.connect();
		   User user=new User();
		 try {
	    	String sql="select * from userdetails where username=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
		    ResultSet rs= pstmt.executeQuery();
		 
		   if( rs.next()) {
			   System.out.println("user found .....");
			   int id=rs.getInt("id");
		    String uname=rs.getString("username");
		    String role=rs.getString("role");
		    String password=rs.getString("password");
		    user.setId(id);
		    user.setUsername(uname);
		    user.setRole(role);
		    user.setPassword(password);
		   }
		   else {
			   System.out.println("Customer record not found !!!!");
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    finally {
	    	try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		 return user;
	}

	@Override
	public User save(User user) {

Connection con=	dbConnection.connect();
String sql="insert into userdetails values(?,?,?,userIdSeq.nextval)";
try {
	PreparedStatement pstmt=con.prepareStatement(sql);	
	pstmt.setString(1, user.getUsername());
	pstmt.setString(2, user.getPassword());
	pstmt.setString(3, user.getRole());
	int count=pstmt.executeUpdate();//query will get fired here...
	System.out.println(count+" no of row(s)s updated");
	//con.close();//this code wont execute if any errors occured in try block

} catch (SQLException e) {
	e.printStackTrace();
}
//con.close(); //this code wont execute if any exception occured in catch block ....
finally {
	try {
		con.close();//executes in all scenarios 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

		return user;
	}

}
