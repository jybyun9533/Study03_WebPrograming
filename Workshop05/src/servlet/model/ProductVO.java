package servlet.model;

public class ProductVO {

	private int number;
	private String name;
	private double price;
	private String desc;

	public ProductVO(String name, double price, String desc) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
	}
	
	public ProductVO(int number, String name, double price, String desc) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.desc = desc;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "ProductVO [number=" + number + ", name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}

}
