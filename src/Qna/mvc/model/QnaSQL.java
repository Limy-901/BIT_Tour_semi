package Qna.mvc.model;

public class QnaSQL {
	final static String LIST
	="select * from BOARD order by SEQ desc";
	final static String LIST_PAGE
	= "select * from (select ROWNUM rnum, aa.* from "
			+ "(select nick, qna.* from QNA, MEMBER "
			+ "where qna.member_no=member.member_no "
			+ "order by QGROUP desc, QLEVEL asc) aa) "
			+ "where rnum>? and rnum<=?";
	final static String COUNT 
	= "select max(ROWNUM) from QNA";
	final static String INSERT
    ="insert into QNA values(QNA_SEQ.nextval,?, ?,?, SYSDATE, ?,?,?)";
	final static String CONTENT
	= "select * from (select QNA.*, NAME from QNA,MEMBER where QNA.MEMBER_NO=MEMBER.MEMBER_NO) where QNA_NO=?";
	final static String DEL
	= "delete from QNA where QNA_NO=?";
	final static String UPDATE
    = "update QNA set SUBJECT=?, CONTENT=? where QNA_NO=?";
	final static String NAME
	= "select NICK from member where MEMBER_NO=?";
}
