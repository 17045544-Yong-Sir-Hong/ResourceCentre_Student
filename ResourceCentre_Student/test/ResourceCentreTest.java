import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void testAddChromebook() {//brandon did this
		//fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that can add a new item
				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				ResourceCentre.addChromebook(chromebookList, cb1);		
				assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
				
				//The item just added is as same as the first item of the list
				assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));
				
				//Add another item. test The size of the list is 2?
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	}
	
	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList); 
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList); 
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder); 
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void testRetrieveAllChromebook() { //Sir Hong
		// write your code here
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList); 
		
		//test if the list of chromebook retrieved from the SourceCentre is empty
		String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList); 
		String testOutput = "";
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook); 
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, chromebookList.size());
		
		//test if the expected output string same as the list of chromebook retrieved from the SourceCentre
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebook);
		
	}

	@Test
	public void testDoLoanCamcorder() { //Pei Shan
		//fail("Not yet implemented");
		// write your code here
		
		// Test if Item list is not null but empty, so that can loan a item
		assertNotNull("Test if there is valid Camcorder arraylist to loan from", camcorderList); 
		
		ResourceCentre.addCamcorder(camcorderList, cc1);
		// normal 
		Boolean ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020" );
		//System.out.println("Normal");
		//System.out.println(ok);
		assertTrue("Test if an available item is ok to loan?", ok);
		//error condition
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020" );
		//System.out.println("Error");
	    //System.out.println(ok);
		assertFalse("Test if an same item is NOT ok to loan?", ok);
		//error condition
		ResourceCentre.addCamcorder(camcorderList,  cc2);
		cc2.setIsAvailable(false);
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "8-8-2020" );
		//System.out.println("Error2");
		//System.out.println(ok);
		assertFalse("Test that un-available item is NOT ok to loan?", ok);
		//error condition
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "8-8-2020" );
		assertFalse("Test that non-existing item is NOT ok to loan?", ok);
		
	}
	
	@Test
	public void testDoLoanChromebook() { //Pei Shan
		//fail("Not yet implemented");
		// write your code here
		
		// Test if Item list is not null but empty, so that can loan a item
		assertNotNull("Test if there is valid Chromebook arraylist to loan from", chromebookList); 
				
		ResourceCentre.addChromebook(chromebookList, cb1);
		// normal 
		Boolean ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020" );
		//System.out.println("Normal");
		//System.out.println(ok);
		assertTrue("Test if an available item is ok to loan?", ok);
		//error condition
		ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020" );
		//System.out.println("Error");
	    //System.out.println(ok);
		assertFalse("Test if an same item is NOT ok to loan?", ok);
		//error condition
		ResourceCentre.addChromebook(chromebookList,  cb2);
		cc2.setIsAvailable(false);
		ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020" );
		//System.out.println("Error2");
		//System.out.println(ok);
		assertFalse("Test that un-available item is NOT ok to loan?", ok);
		//error condition
		ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "8-8-2020" );
		assertFalse("Test that non-existing item is NOT ok to loan?", ok);
		
	}
	
	@Test
	public void testDoReturnCamcorder() {//Shania
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.doReturnCamcorder(camcorderList, cc1.getAssetTag());
		camcorderList.add(cc1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		assertTrue(cc1.getIsAvailable());
		
		
		ResourceCentre.doReturnCamcorder(camcorderList, cc2.getAssetTag());
		camcorderList.add(cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		assertTrue(cc2.getIsAvailable());

		
	}
	@Test
	public void testDoReturnChromebook() {//Shania
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		ResourceCentre.doReturnChromebook(chromebookList, cb1.getAssetTag());
		chromebookList.add(cb1);
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
		assertTrue(cb1.getIsAvailable());
		
		ResourceCentre.doReturnChromebook(chromebookList, cb2.getAssetTag());
		chromebookList.add(cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
		assertTrue(cb2.getIsAvailable());
		

		
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
