package transaction;

public class InventoryEntry {
	private String inventoryName;
	private float inventoryPrice;
	private int number;
	public InventoryEntry(Item t,int num) {
		// TODO Auto-generated constructor stub
		this.setInventoryName(t.getName());
		this.setInventoryPrice(t.getPrice());
		this.setNumber(num);
	}
	
	public InventoryEntry(String name, float price, int num) {
		// TODO Auto-generated constructor stub
		this.setInventoryName(name);
		this.setInventoryPrice(price);
		this.setNumber(num);
	}
	public InventoryEntry(String name) {
		// TODO Auto-generated constructor stub
		this.setInventoryName(name);
		this.setNumber(0);
	}
	
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public float getInventoryPrice() {
		return inventoryPrice;
	}
	public void setInventoryPrice(float inventoryPrice) {
		this.inventoryPrice = inventoryPrice;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
