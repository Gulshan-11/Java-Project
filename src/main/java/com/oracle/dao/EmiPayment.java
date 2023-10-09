package com.oracle.dao;
import java.util.UUID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class EmiPayment {

@Scheduled(fixedRate=10000)
public void payEmi() {
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String sql="select emi,loan_id from activeloans where loan_status!=0";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet  rs=ps.executeQuery();
		while(rs.next()) {
			int emi=(int)rs.getFloat("emi");
			int loanId=rs.getInt("loan_id");
			sql="update activeloans set emis_paid=emis_paid+1,amount_paid=amount_paid+? where loan_status!=0 and loan_id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,emi);
			ps.setInt(2, loanId);
			ps.executeUpdate();	
			System.out.println("while loop");
            String transactionId = UUID.randomUUID().toString();

			sql="insert into transactiondetails values(?,?,SYSTIMESTAMP,?)";
			ps=con.prepareStatement(sql);
            ps.setInt(1, loanId);
            ps.setString(2,transactionId);
            ps.setInt(3, emi);
            ps.executeQuery();           
		}
		sql="update activeloans set loan_status=0 where amount_paid >=AMOUNT_SANCTIONED ";
		ps=con.prepareStatement(sql);
		ps.executeUpdate();
		System.out.println("updated");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	
}
