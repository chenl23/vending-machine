package transaction;

public class Transaction {

	private float balance;
	
	private  Inventory inventory= new Inventory();
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Transaction(){
	 
	}
	public void addBalance(float amount){
		this.balance += amount;
	}
	public float getBalance(){

		return this.balance;

	}
	public boolean selectItem(Item t){
		if (t instanceof Coke){
			if (inventory.getInventory(t)==0)
				return false;
			else
				return true;
		}
		else
			return false;

	}
	public boolean proceed(Item t){
		if (this.balance>=t.getPrice())
		{
			if(inventory.getInventory(t)>0){
				inventory.reduceInventory(t, 1);
				return true;
			}
			else
				return false;
		}
		else
			return false;

	}

	public static void main(String[] args){
		Transaction t =new Transaction();
		Coke c = new Coke();
		t.inventory.addInventory(c, 3);
		t.addBalance(25.0f);
		
		
		System.out.printf("Current balance is %f dollars\n", t.getBalance());

		
		if (t.selectItem(c)) {
			System.out.printf("user select item is %s\n", c.getName());
			if (t.proceed(c)) {
				System.out.println("completed transaction");
				System.out.printf("Current inventory of %s is %d\n",c.getName(), t.inventory.getInventory(c));
			}
		}
		else {
			System.out.printf("the selected item %s is not available\n", c.getName());
		}
		t.inventory.removeInventory(c);

	}

}

