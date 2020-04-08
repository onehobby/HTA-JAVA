package com.sample.bookstore.vo;

public class User {

	public int no;					//회원번호
	public String name;			//회원이름
	public String tel;				//회원전화번호
	public int point;
	public boolean isDisabled;		//탈퇴여부, false > 사용가능 고객, true > 탈퇴처리된 고객 
	
	public User() {}
	
	public User(int no, String name, String tel, int point, boolean isDisalbed) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.point = point;
		this.isDisabled = isDisalbed;
	}
}
