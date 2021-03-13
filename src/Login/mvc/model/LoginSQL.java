package Login.mvc.model;

class LoginSQL {
		static final String MEMBER = "select * from MEMBER where EMAIL=?";
		static final String INSERT = "insert into MEMBER values(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, SYSDATE, ?, SYSDATE, ?)";
		final static String FINDID = "select email from MEMBER where NAME= ? and PHONE=?";
		final static String FINDPWD = "select pwd from MEMBER where PHONE=? and EMAIL=?";
	}

