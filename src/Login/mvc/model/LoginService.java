package Login.mvc.model;

import static Login.mvc.model.LoginCase.*;

import java.sql.Date;

import Domain.Member;


public class LoginService {
	private LoginDAO dao;
	
	private static final LoginService instance = new LoginService();
	private LoginService() {
		dao = new LoginDAO();
	}
	public static LoginService getInstance() {
		return instance;
	}
	public int checkMember(String email, String pwd) {
		Member m = dao.getMember(email);
		System.out.println("email:"+email);
		if(m ==null) {
			System.out.println("m이 널임");
			return NO_ID;
			
		}else {
			System.out.println("m이 널이아님");
			String pwdDb = m.getPwd();
			if(pwdDb != null) pwdDb = pwdDb.trim();
			
			if(!pwd.equals(pwdDb)) {
				return NO_PWD;				
			}else {
				System.out.println("PASS된건가");
				return PASS;
			}
		}
	}
	public int joinS(String email) {//회원가입용
		Member m = dao.getMember(email);	
		String emailDb = m.getEmail();		
		//if(emailDb !=null) emailDb = emailDb.trim();	
		if(m==null) {
			return SIGN_UP;
		}else {
			return ER_SIGNUP;
		}
	}
	public Member getMemberS(String email) {
		Member m = dao.getMember(email);
		m.setPwd(""); //for 보안성
		return m;
	}
	public int insertS(Member dto, String email) {
		Member m = dao.getMember(email);//비교가 아니고 대입이다..
		if(m==null) {//이게 비교야..
			dao.insert(dto);
			return SIGN_UP;
		}else {
			return ER_SIGNUP;
		}
		
	}
	public int checkPwd(String email, String pwd) {
		Member m = dao.getMember(email);
		String pwdDb = m.getPwd();		
		if(pwdDb != null) pwdDb = pwdDb.trim();			
		if(pwdDb != null) {
			return NO_PWD;
		}else {
			return PASS;
		}
	}
	public String findIdS(String name, String phone) {
		String email = dao.findId(name, phone);
		if(email !=null) {
			return email; //email 값 나와라
		}else {
			return null;//email 이 없음
		}
	}
	public String findPwdS(String phone, String email) {
		String pwd = dao.findPwd(phone, email);
		if(pwd !=null) {
			return pwd; //pwd 값 나와라
		}else {
			return null;//pwd 이 없음
		}
	}
	
}

