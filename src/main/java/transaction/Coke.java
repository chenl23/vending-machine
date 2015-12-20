package transaction;

public final class Coke implements Item {
	private float price;
	private String name;

	public Coke() {
		// TODO Auto-generated constructor stub
		this.name = "Coke";
		this.price = 20f;
	}
	
	
	public Coke(float price) {
		// TODO Auto-generated constructor stub
		this.name = "Coke";
		this.price = price;
	}

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
