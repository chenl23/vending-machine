package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
	
	
	private Connection conn = null;
	private Statement stmt=null;
	private ResultSet rs = null;
	public ItemDAO() {
		// TODO Auto-generated constructor stub
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionUrl = "jdbc:mysql://192.168.99.100:3306/testdatabase";
		String connectionUser = "root";
		String connectionPassword = "promise";
		
		this.conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Item getById(int id) {
		return null;
	}
	
	public List<InventoryEntry> getAllItems() {
		try {
			List<InventoryEntry> l = new ArrayList<InventoryEntry>();
			stmt = this.conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM inventory");
			while (rs.next()) {
				l.add(new InventoryEntry(rs.getString("name"), rs.getFloat("price"), rs.getInt("number")));
			}

			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}
	public InventoryEntry getItemsByName(String name) {
		try {
			stmt = this.conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM inventory where name = '" + name + "'");
			while (rs.next()) {
			return new InventoryEntry(rs.getString("name"), rs.getFloat("price"), rs.getInt("number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}
	public boolean insert(InventoryEntry v)
	{
		
		String sql="";


		try {
			stmt = this.conn.createStatement();
			//rs = stmt.executeQuery("SELECT * FROM inventory");
			//while (rs.next()) {
				sql="INSERT INTO inventory(name,price,number) "+ "VALUES('"+v.getInventoryName()+"',"+"'"+v.getInventoryPrice()+"',"+"'"+v.getNumber()+"')";
                System.out.println(sql);
				stmt.executeUpdate(sql);		   
                return true;

			//}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return false;
	}

	public boolean update(InventoryEntry v) {
		String sql="";

		try {
			stmt = this.conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM inventory");
			while (rs.next()) {
				sql="UPDATE inventory SET "+ "price="+v.getInventoryPrice()+","+"number="+v.getNumber()+" WHERE name='"+v.getInventoryName()+"'";
				stmt.executeUpdate(sql);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return false;	
	}
	
	public boolean delete(InventoryEntry v) {
		String sql="";

		try {
		
			
				sql="DELETE FROM inventory WHERE name='"+v.getInventoryName()+"'";
				stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return false;
	}
}
