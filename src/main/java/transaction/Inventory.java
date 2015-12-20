package transaction;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
import java.util.Hashtable;
import java.util.Iterator;

public class Inventory {

        private static Inventory inventory = null;

	private Hashtable<String, Integer> htable = new Hashtable<String, Integer>();
	
	private ItemDAO dao = new ItemDAO();

        public static Inventory getInstance() {
            if (inventory == null)
                inventory = new Inventory();
            
            return inventory;
        }
	
	private Inventory()
	{
		try {
			List<InventoryEntry> entries = dao.getAllItems();
			for (InventoryEntry entry:entries) {
				htable.put(entry.getInventoryName(), entry.getNumber());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	public boolean addInventory(Item t, int i){


		try {
			InventoryEntry e = new InventoryEntry(t.getName(),t.getPrice(),i);
			dao.insert(e);
			htable.put(t.getName(), i);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	public boolean reduceInventory(Item t,int i){
		
        int num = htable.get(t.getName());
		if (num < i){
			return false;
		}
		
		htable.put(t.getName(), num - i);

		//now update DB
		try {
			InventoryEntry e = new InventoryEntry(t, num);
			dao.update(e) ;

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return true;

	}
	public int getInventory(Item t){
		
		return htable.get(t.getName());
		

	}
	public boolean removeInventory(Item t){
		InventoryEntry e = new InventoryEntry(t.getName());
		
		dao.delete(e);
		return true;
	}
	public static void main(String args[]){
		
	}
}
