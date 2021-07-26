package project배달;

public class User {

	private String u_id;
	private int u_pw;
	private String u_name;
	private String u_addr;
	private String u_phone;
	private String u_birth;
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getU_pw() {
		return u_pw;
	}
	public void setU_pw(int u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_addr() {
		return u_addr;
	}
	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_birth() {
		return u_birth;
	}
	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}
	
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_addr=" + u_addr + ", u_phone="
				+ u_phone + ", u_birth=" + u_birth + "]";
	}
	
	public User() {
		super();
	}
	
	public User(String u_id, int u_pw, String u_name, String u_addr, String u_phone, String u_birth) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_addr = u_addr;
		this.u_phone = u_phone;
		this.u_birth = u_birth;
	}
	
	
}
