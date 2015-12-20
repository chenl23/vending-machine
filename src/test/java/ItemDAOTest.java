package transaction;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		InventoryEntry v =new InventoryEntry("test",10f,5);
		ItemDAO d= new ItemDAO();
		d.insert(v);
		Assert.assertEquals(5, d.getItemsByName("test").getNumber());
		v.setInventoryPrice(5f);
		v.setNumber(10);
		d.update(v);
		//Assert.assertEquals(d.getItemsByName("test").getInventoryPrice(), 5f);
		Assert.assertEquals(d.getItemsByName("test").getNumber(), 10);
		d.delete(v);
		d.getAllItems();
		Assert.assertNull(d.getItemsByName("test"));
	}

}
