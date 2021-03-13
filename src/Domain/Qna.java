package Domain;

import java.sql.Date;

public class Qna {
	private long seq;
	private long memno;
	private String subject;
	private String content;
	private Date rdate;
	private int group;
	private int level;
	private int order;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public long getMemno() {
		return memno;
	}

	public void setMemno(long memno) {
		this.memno = memno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Qna(long seq, long memno, String subject, String content, Date rdate, int group, int level, int order, String name) {
		super();
		this.seq = seq;
		this.memno = memno;
		this.subject = subject;
		this.content = content;
		this.rdate = rdate;
		this.group = group;
		this.level = level;
		this.order = order;
		this.name = name;
	}

	public Qna() {}
}
