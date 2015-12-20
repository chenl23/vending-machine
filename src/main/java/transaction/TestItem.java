package transaction;

public class TestItem implements Item {
	private float price;
	private String name;

	public TestItem() {
		// TODO Auto-generated constructor stub
		this.name="test";
		this.price=10f;
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
