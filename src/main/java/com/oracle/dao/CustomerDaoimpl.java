package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Customer;
import com.oracle.entity.Nominee;
import com.oracle.entity.Program;
import com.oracle.secure.model.UserDto;
@Component
public class CustomerDaoimpl implements CustomerDao {

	

	public List<Customer> getCustomerDetails() {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="";
		try {
			PreparedStatement ps=con.prepareStatement(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public List<ActiveLoans> getLoanDetails(String userName) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		List<ActiveLoans> loans=new ArrayList<>();
		//String sql="select * from activeloans where customerId=?";
		try {
			String sql="select customer_id from customerdetails where username=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userName);
			ResultSet rs=ps.executeQuery();
			String cust_id=null;
			System.out.println("username"+userName);
			if(rs.next()) {
				cust_id=rs.getString("cutsomerid");
			}else {
				System.out.println("no data found");
			}
			if(cust_id!=null) {
				sql="select * from activeloans where customerId=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, cust_id);
				rs=ps.executeQuery();
				while(rs.next()) {
					ActiveLoans obj=new ActiveLoans();
					obj.setAmountPaid(rs.getLong("amount_paid"));
					obj.setAmountSanctioned(rs.getLong("amount_sanctioned"));
					obj.setApproverName(rs.getString("approver_name"));
					obj.setDate(rs.getDate("start_date"));
					obj.setEmisPaid(rs.getInt("emis_paid"));
					obj.setLoanId(rs.getLong("loan_id"));
					obj.setProgrameName(rs.getString("programe_name"));
					obj.setRoi(rs.getFloat("roi"));
					obj.setTenure(rs.getInt("tenure"));
					obj.setType(rs.getString("loan_type"));
					loans.add(obj);
					
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loans;
	}

   
	
	

}
