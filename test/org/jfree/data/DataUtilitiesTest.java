package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataUtilitiesTest {
	
	
	private KeyedValues keyedValues1;
	private KeyedValues keyedValues2;
	private KeyedValues keyedValues3;
	private KeyedValues keyedValues4;
	private Values2D value;
	@BeforeEach
	void setUp() throws Exception {
		value = mock(Values2D.class);
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(3);
		//row 1
		when(value.getValue(0, 0)).thenReturn(1);
		when(value.getValue(0, 1)).thenReturn(8);
		when(value.getValue(0, 2)).thenReturn(5);
		when(value.getValue(0, 3)).thenReturn(7);
		//row 2
		when(value.getValue(1, 0)).thenReturn(6);
		when(value.getValue(1, 1)).thenReturn(2);
		when(value.getValue(1, 2)).thenReturn(7);
		when(value.getValue(1, 3)).thenReturn(9);
		//row 3
		when(value.getValue(2, 0)).thenReturn(3);
		when(value.getValue(2, 1)).thenReturn(2);
		when(value.getValue(2, 2)).thenReturn(1);
		when(value.getValue(2, 3)).thenReturn(4);
		
		/* what the entire value2D looks like
		 *
		 *			1	8	5	7
		 * 			6	2	7	9
		 * 			3	2	1	4
		*/
		
		
		///Mock 5
		//total 21, all positive values
				keyedValues1 = mock(KeyedValues.class);
				
				when(keyedValues1.getItemCount()).thenReturn(4);
				
				when(keyedValues1.getValue(0)).thenReturn(1);
				when(keyedValues1.getValue(1)).thenReturn(8);
				when(keyedValues1.getValue(2)).thenReturn(5);
				when(keyedValues1.getValue(3)).thenReturn(7);

				when(keyedValues1.getKey(0)).thenReturn(0);
				when(keyedValues1.getKey(1)).thenReturn(1);
				when(keyedValues1.getKey(2)).thenReturn(2);
				when(keyedValues1.getKey(3)).thenReturn(3);
				
				/////////////////////////////////////////////////////////////
				
				//total 9, negative value mock
				keyedValues2 = mock(KeyedValues.class);
				
				when(keyedValues2.getItemCount()).thenReturn(3);
				
				when(keyedValues2.getValue(0)).thenReturn(3);
				when(keyedValues2.getValue(1)).thenReturn(-2);
				when(keyedValues2.getValue(2)).thenReturn(8);

				when(keyedValues2.getKey(0)).thenReturn(0);
				when(keyedValues2.getKey(1)).thenReturn(1);
				when(keyedValues2.getKey(2)).thenReturn(2);
				
				///////////////////////////////////////////////////////////
				
				//total 13.4, decimal value test
				keyedValues3 = mock(KeyedValues.class);
				
				when(keyedValues3.getItemCount()).thenReturn(3);
						
				when(keyedValues3.getValue(0)).thenReturn(2.5);
				when(keyedValues3.getValue(1)).thenReturn(4.3);
				when(keyedValues3.getValue(2)).thenReturn(6.6);

				when(keyedValues3.getKey(0)).thenReturn(0);
				when(keyedValues3.getKey(1)).thenReturn(1);
				when(keyedValues3.getKey(2)).thenReturn(2);
				
				//////////////////////////////////////////////////////////////
				
				//total 16, each and total value is negative
				keyedValues4 = mock(KeyedValues.class);
				
				when(keyedValues4.getItemCount()).thenReturn(3);
						
				when(keyedValues4.getValue(0)).thenReturn(-5);
				when(keyedValues4.getValue(1)).thenReturn(-8);
				when(keyedValues4.getValue(2)).thenReturn(-3);

				when(keyedValues4.getKey(0)).thenReturn(0);
				when(keyedValues4.getKey(1)).thenReturn(1);
				when(keyedValues4.getKey(2)).thenReturn(2);
		
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	
	/*Calculate Column Total tests
	 * 
	 * Count column 0 return 10
	 * Count column 1 return 12
	 * Count Column 3 return 13
	 * Count Column 4 return 20
	 * Count Column 5 (invalid) should return 0
	 * Count COlumn -1 (invalid should return 0
	 */
	
	@Test
	void testColumnTotal1() {
		assertEquals(10, DataUtilities.calculateColumnTotal(value, 0), 0.01d); // i dont know why we need a delta but its in the example
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testColumnTotal2() {
		assertEquals(12, DataUtilities.calculateColumnTotal(value, 1), 0.01d); 
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}

	@Test
	void testColumnTotal3() {
		assertEquals(13, DataUtilities.calculateColumnTotal(value, 2), 0.01d);
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}

	@Test
	void testColumnTotal4() {
		assertEquals(20, DataUtilities.calculateColumnTotal(value, 3), 0.01d); 
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testColumnTotal5PositiveOOB() {
		assertEquals(0, DataUtilities.calculateColumnTotal(value, 4), 0.01d); 
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testColumnTotal6NegativeOOB() {
		assertEquals(0, DataUtilities.calculateColumnTotal(value, -1), 0.01d); 
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	/*Calculate Row Total Tests
	 * 
	 * Count Row 1
	 * Count row 2
	 * Count Row 3
	 * Count row 3
	 * 
	 * 
	 */
	/* what the entire value2D looks like
	 *
	 *			1	8	5	7
	 * 			6	2	7	9
	 * 			3	2	1	4
	*/
	
	@Test
	void testRowTotal1() {
		assertEquals(21, DataUtilities.calculateRowTotal(value, 0), 0.01d);
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testRowTotal2() {
		assertEquals(24, DataUtilities.calculateRowTotal(value, 1), 0.01d);
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testRowTotal3() {
		assertEquals(10, DataUtilities.calculateRowTotal(value, 2), 0.01d);
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testRowTotalPositiveOOB() {
		assertEquals(0, DataUtilities.calculateRowTotal(value, 3), 0.01d);
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testRowTotalNegativeOOB() {
		assertEquals(0, DataUtilities.calculateRowTotal(value, -1), 0.01d);
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}
	
	  //Test with valid arguments
    @Test
    void createNumberArrayValidArray() {
        double[] data = {1,8,5,7};
        Number[] actual = DataUtilities.createNumberArray(data);
        assertEquals(data, actual);
    }
    //Test with negative array values
    @Test
    void createNumberArrayNegativeArray() {
        double[] data = {-1,-8,-5,-7};
        Number[] actual = DataUtilities.createNumberArray(data);
        assertEquals(data, actual);
    }
    
    
    /*createNumberArray2D
     * 1 8 5 7
     * 6 2 7 9
     * 3 2 1 4
     *
     * -1 8 5 -7
     * 6 2 -7 9
     * -3 2 -1 4
     *
     * 3 5 2
     * 4 7 8
     * 1 8 3
     */
    //Test with valid 2D array
    
    @Test
    //Tests with valid 2D array
    void createNumberArray2DValid() {
        double[][] data = {{1,8,5,7},{6,2,7,9},{3,2,1,4}};
        Number[][] actual = DataUtilities.createNumberArray2D(data);
        assertEquals(data, actual);
    }
    
    @Test
    //Tests with negative 2D arrays
    void createNumberArray2DNegative() {
        double[][] data = {{-1,8,5,-7},{6,2,-7,9},{-3,2,-1,4}};
        Number[][] actual = DataUtilities.createNumberArray2D(data);
        assertEquals(data, actual);
    }
    
    @Test
    //Tests with 2D array 3 x 3 dimensions
    void createNumberArray2D3and3() {
        double[][] data = {{3,5,2},{4,7,8},{1,8,3}};
        Number[][] actual = DataUtilities.createNumberArray2D(data);
        assertEquals(data, actual);
    }
    
    @Test
	//regular test  checking for nearest 3 decimals 
	void getCumulativePercentageRegTest() {
		
		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);
		
		assertAll(
				() -> assertEquals(0.0476, result.getValue(0).doubleValue(), 0.001d),
				() -> assertEquals(0.4286, result.getValue(1).doubleValue(), 0.001d),
				() -> assertEquals(0.6667, result.getValue(2).doubleValue(), 0.001d),
				() -> assertEquals(1.0, result.getValue(3))
				);
	}
	
	@Test
	//Testing with a negative Value 
	void getPercentageWithNegValTest() {
	KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues2);
		
		assertAll(
				() -> assertEquals(0.3333, result.getValue(0).doubleValue(), 0.001d),
				() -> assertEquals(0.1111, result.getValue(1).doubleValue(), 0.001d),
				() -> assertEquals(1.0, result.getValue(2))
				);
	}

	@Test
	//Testing with decimal values
	void getPercentageWithDecimalsTest() {
	KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues3);
		
		assertAll(
				() -> assertEquals(0.1866, result.getValue(0).doubleValue(), 0.001d),
				() -> assertEquals(0.5075, result.getValue(1).doubleValue(), 0.001d),
				() -> assertEquals(1.0, result.getValue(2))
				);
	}
	
	@Test
	//Testing with negative total and value
	void getPercentageNegTotalAndValuesTest() {
	KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues4);
		
		assertAll(
				() -> assertEquals(0.3125, result.getValue(0).doubleValue(), 0.001d),
				() -> assertEquals(0.8125, result.getValue(1).doubleValue(), 0.001d),
				() -> assertEquals(1.0, result.getValue(2))
				);
	}
	
	

}
