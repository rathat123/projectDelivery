package project배달;

public class Shop {
	
	private String s_name;
	private String s_addr;
	private String s_phone;
	
	
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_addr() {
		return s_addr;
	}
	public void setS_addr(String s_addr) {
		this.s_addr = s_addr;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	
	@Override
	public String toString() {
		return "Shop [s_name=" + s_name + ", s_addr=" + s_addr + ", s_phone=" + s_phone + "]";
	}
	public Shop() {
		super();
	}
	public Shop(String s_name, String s_addr, String s_phone) {
		super();
		this.s_name = s_name;
		this.s_addr = s_addr;
		this.s_phone = s_phone;
	}
	
	

	
}
