package transaction;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InventoryTest {

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
		TestItem test= new TestItem();
		InventoryEntry e = new InventoryEntry("test");
		Inventory v =new Inventory();
		Assert.assertTrue(v.addInventory(test, 5));
		Assert.assertEquals(v.getInventory(test),5);
		v.reduceInventory(test, 3);
		Assert.assertEquals(2,v.getInventory(test));
		Assert.assertTrue(v.reduceInventory(test, 1));
		Assert.assertEquals(1,v.getInventory(test));
		Assert.assertTrue(v.removeInventory(test));
		
		
		
	}

}
