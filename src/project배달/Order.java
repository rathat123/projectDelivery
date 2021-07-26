package project배달;

public class Order {

	private String o_name;
	private String o_price;
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public String getO_price() {
		return o_price;
	}
	public void setO_price(String o_price) {
		this.o_price = o_price;
	}
	
	@Override
	public String toString() {
		return "Order [o_name=" + o_name + ", o_price=" + o_price + "]";
	}
	
	public Order() {
		super();
	}
	
	public Order(String o_name, String o_price) {
		super();
		this.o_name = o_name;
		this.o_price = o_price;
	}
	
	
}
