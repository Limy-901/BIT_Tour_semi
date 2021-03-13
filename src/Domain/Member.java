package Domain;

import java.sql.Date;

public class Member {
	private int member_no;
	private String email;
	private String pwd;
	private String name;
	private String nickname;
	private String phone;
	private Date rdate;
	private long tripno;
	private Date bdate;
	private String withdrawal;
	
	public Member() {}

	public Member(int member_no, String email, String pwd, String name, String nickname, String phone, Date rdate,
			long tripno, Date bdate, String withdrawal) {
		super();
		this.member_no = member_no;
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.rdate = rdate;
		this.tripno = tripno;
		this.bdate = bdate;
		this.withdrawal = withdrawal;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public long getTripno() {
		return tripno;
	}

	public void setTripno(long tripno) {
		this.tripno = tripno;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(String withdrawal) {
		this.withdrawal = withdrawal;
	}
}
	