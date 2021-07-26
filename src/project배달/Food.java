package project배달;

public class Food {

	private String f_sname;
	private String f_name;
	private String f_price;
	
	public String getF_sname() {
		return f_sname;
	}
	public void setF_sname(String f_sname) {
		this.f_sname = f_sname;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_price() {
		return f_price;
	}
	public void setF_price(String f_price) {
		this.f_price = f_price;
	}
	
	@Override
	public String toString() {
		return "Food [f_sname=" + f_sname + ", f_name=" + f_name + ", f_price=" + f_price + "]";
	}
	
	public Food() {
		super();
	}
	
	public Food(String f_sname, String f_name, String f_price) {
		super();
		this.f_sname = f_sname;
		this.f_name = f_name;
		this.f_price = f_price;
	}
	
	
}
