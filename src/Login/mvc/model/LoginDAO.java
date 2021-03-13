package Login.mvc.model;

import static Login.mvc.model.LoginSQL.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Domain.Member;

public class LoginDAO {
	private DataSource ds;
	LoginDAO(){
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	Member getMember(String email) {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = MEMBER;
		try {
			con = ds.getConnection();						
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int member_no = rs.getInt(1);					
				//String email = rs.getString(2);
				String pwd = rs.getString(3);				
				String name = rs.getString(4);				
				String nickname = rs.getString(5);				
				String phone = rs.getString(6);
				Date rdate = rs.getDate(7);
				long tripno = rs.getLong(8);
				Date bdate = rs.getDate(9);
				String withdrawal= rs.getString(10);			
				return new Member(member_no, email, pwd, name, nickname, phone, rdate,
						tripno, bdate, withdrawal);
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void insert(Member dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		System.out.println("insert 메소드까지옴");
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getNickname());
			pstmt.setString(5, dto.getPhone());
			pstmt.setLong(6, dto.getTripno());
			pstmt.setString(7, dto.getWithdrawal());
			pstmt.executeUpdate();
		}catch(SQLException se){
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
	}
	String findId(String name, String phone){
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = FINDID;
	    try {
	    	con = ds.getConnection();
	    	pstmt = con.prepareStatement(sql);
	    	pstmt.setString(1, name);
	    	pstmt.setString(2, phone);
	    	rs	= pstmt.executeQuery();
	    	if(rs.next()) {
	    		String email = rs.getString("email");
	    		return email;
	    	}else {
	    		return null;
	    	}
	    }catch(SQLException se) {
	    	System.out.println(se);
	    	return null;
	    }finally {
	    	try {
	    		if(rs != null) rs.close();
	    		if(pstmt != null) pstmt.close();
	    		if(con != null) con.close();
	    	}catch(SQLException se) {}
	    }
	}
	String findPwd(String phone, String email){
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = FINDPWD;
	    try {
	    	con = ds.getConnection();
	    	pstmt = con.prepareStatement(sql);
	    	pstmt.setString(1, phone);
	    	//System.out.println(phone);
	    	pstmt.setString(2, email);
	    	rs	= pstmt.executeQuery();
	    	//System.out.println(phone+email);
	    	if(rs.next()) {
	    		String pwd = rs.getString("pwd");
	    		return pwd;
	    	}else {
	    		return null;
	    	}
	    }catch(SQLException se) {
	    	System.out.println(se);
	    	return null;
	    }finally {
	    	try {
	    		if(rs != null) rs.close();
	    		if(pstmt != null) pstmt.close();
	    		if(con != null) con.close();
	    	}catch(SQLException se) {}
	    }
	}
	
}
