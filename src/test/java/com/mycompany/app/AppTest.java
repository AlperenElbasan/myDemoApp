package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
	public void testFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertTrue(new App().search(array, 4));
    }

    public void testNotFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertFalse(new App().search(array, 5));
    }

    public void testEmptyArray() {
      ArrayList<Integer> array = new ArrayList<>();
      assertFalse(new App().search(array, 1));
    }

    public void testNull() {
      assertFalse(new App().search(null, 1));
    }


	public void testReturnsNullIfAIsNull(){
		String arr[] = {"1","2","3","4","5","4","3","2","1"};
		assertNull(App.copyPaste(null , arr, 4, 1));		
	}

	public void testReturnsNullIfBIsNull(){
		String arr[] = {"1","2","3","4","5","4","3","2","1"};
		assertNull(App.copyPaste(arr, null , 4, 1));		
	}

	public void testReturnsNullIfBIsNotLargeEnough(){
		String arr[] = {"0","1","2","3","4","5"};
		String arr2[] = {"0","1","2","3"};
		assertNull(App.copyPaste(arr , arr2, 0, 4));		
	}

	public void testReturnsNullIfAIsNotLargeEnough(){
		String arr[] = {"0","1","2","3","4","5"};
		String arr2[] = {"0","1","2","3"};
		assertNull(App.copyPaste(arr , arr2, 7, 4));		
	}

	public void testReturnsArr2IfNoProblemOcccured(){
		String arr[] = {"0","11","22","33","4","5"};
		String arr2[] = {"323","1231","4522","1253"};
		String answer[] = {"11","22","4522","1253"};
		assertEquals(Arrays.toString(App.copyPaste(arr, arr2, 1, 2)), Arrays.toString(answer));
	}
}
