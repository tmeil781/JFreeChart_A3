package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	/*getLowerBound tests
	 * Of course all of this is dependent on the range constructor working correctly
	 * ranges that should be valid
	 * and expected results
	 * (10, 20) -> 10
	 * (0, 10)  -> 0
	 * (-10, 0) -> -10
	 * (6.6, 10) -> 6.6
	 * (-6.6, 10) -> -6.6
	 * (1, 1) -> 1
	 * */
	
	@Test
	void testGetLowerValid() {
		Range range1 = new Range(10, 20);
		assertEquals(range1.getLowerBound(), 10);
	}
	
	@Test
	void testGetLowerValid2() {
		Range range1 = new Range(0, 10);
		assertEquals(range1.getLowerBound(), 0);
	}
	
	@Test
	void testGetLowerValid3() {
		Range range2 = new Range(-10, 0);
		assertEquals(range2.getLowerBound(), -10);
	}
	
	@Test
	void testGetLowerDecimal() {
		Range range1 = new Range(6.6, 10);
		assertEquals(range1.getLowerBound(), 6.6);
	}
	
	@Test
	void testGetLowerDecimal2() {
		Range range1 = new Range(-6.6, 10);
		assertEquals(range1.getLowerBound(), -6.6);
	}
	
	@Test
	void testGetLowerSame() {
		Range range1 = new Range(1, 1);
		assertEquals(range1.getLowerBound(), 1);
	}
	
	
	/*getUpperBound tests
	 * 
	 * ranges that should be valid
	 * and expected results
	 * (0, 10) -> 10
	 * (-10, 0) -> 0
	 * (-20, -10) -> -10
	 * (1, 6.6) -> 6.6
	 * (-10, -6.6) -> -6.6
	 * (1,1) -> 1
	 */
	
	@Test
	void testGetUpperValid() {
		Range range1 = new Range(0, 10);
		assertEquals(range1.getUpperBound(), 10);
	}
	
	@Test
	void testGetUpperValid2() {
		Range range1 = new Range(-10, 0);
		assertEquals(range1.getUpperBound(), 0);
	}
	
	@Test
	void testGetUpperValid3() {
		Range range1 = new Range(-20, -10);
		assertEquals(range1.getUpperBound(), -10);
	}
	
	@Test
	void testGetUpperDecimal() {
		Range range1 = new Range(0, 6.6);
		assertEquals(range1.getUpperBound(), 6.6);
	}
	
	@Test
	void testGetUpperDecimal2() {
		Range range1 = new Range(-10, -6.6);
		assertEquals(range1.getUpperBound(), -6.6);
	}
	
	@Test
	void testGetUpperSame() {
		Range range1 = new Range(1, 1);
		assertEquals(range1.getUpperBound(), 1);
	}
	
	/*getLength tests
	 * 
	 * ranges that should be valid
	 * and expected results
	 * 
	 *(0, 5) -> 5
	 * (-5, 5) ->10
	 * (-10, -5) -> 5
	 *(1,1) -> 1
	 * 
	 * 
	 */

	@Test
	void testGetLength() {
		Range range1 = new Range(0, 5);
		assertEquals(range1.getLength(), 5);
	}
	
	@Test
	void testGetLength2() {
		Range range1 = new Range(-5, 5);
		assertEquals(range1.getLength(), 10);
	}
	
	@Test
	void testGetLength3() {
		Range range1 = new Range(-10, -5);
		assertEquals(range1.getLength(), 5);
	}
	
	@Test
	void testGetLengthShort() {
		Range range1 = new Range(1, 1);
		assertEquals(range1.getLength(), 0);
	}
	
	/*getCentralValue
	 * 
	 * 
	 * 	 * ranges that should be valid
	 * and expected results
	 * 
	 * (1, 3) -> 2
	 * (1, 1) -> 1
	 * (1, 4) -> 2.5
	 * (-3, -1) -> -2
	 * (-1, -1) -> -1
	 * (-4, -1) -> -2.5
	 * 
	 * 
	 */
	@Test
	void testGetCentralValid() {
		Range range1 = new Range(1, 3);
		assertEquals(range1.getCentralValue(), 2);
	}
	
	@Test
	void testGetCentralValid2() {
		Range range1 = new Range(1, 1);
		assertEquals(range1.getCentralValue(), 1);
	}
	
	@Test
	void testGetCentralDecimal() {
		Range range1 = new Range(1, 4);
		assertEquals(range1.getCentralValue(), 2.5);
	}
	
	@Test
	void testGetCentralValidNeg() {
		Range range1 = new Range(-3, -1);
		assertEquals(range1.getCentralValue(), -2);
	}
	
	@Test
	void testGetCentralValidNeg2() {
		Range range1 = new Range(-1, -1);
		assertEquals(range1.getCentralValue(), -1);
	}
	
	@Test
	void testGetCentralDecimalNeg() {
		Range range1 = new Range(-4, -1);
		assertEquals(range1.getCentralValue(), -2.5);
	}
	
	/*getCentralValue
	 * 
	 * 
	 * 	 * ranges that should be valid
	 * and expected results
	 * 
	 * (1, 3) 2-> True
	 * (1, 1) 1-> True
	 * (1, 4) 2.5-> True
	 * (-3, -1) -2-> True
	 * (-1, -1) -1-> True
	 * (-4, -1) -2.5-> True
	 * (-10, 10) 0 -> True
	 * (-10, 10) -11 -> False
	 * (-10, 10) 11 -> False
	 */
	
	@Test
	void testContainsPositiveTrue() {
		Range range1 = new Range(1, 3);
		assertTrue(range1.contains(2));
	}
	
	@Test
	void testContainsPositiveTrue2() {
		Range range1 = new Range(1, 1);
		assertTrue(range1.contains(1));
	}
	
	@Test
	void testContainsPositiveDecimalTrue() {
		Range range1 = new Range(1, 4);
		assertTrue(range1.contains(2.5));
	}
	
	@Test
	void testContainsNegTrue() {
		Range range1 = new Range(-3, -1);
		assertTrue(range1.contains(-2));
	}
	
	@Test
	void testContainsNegTrue2() {
		Range range1 = new Range(-1, -1);
		assertTrue(range1.contains(-1));
	}
	
	@Test
	void testContainsNegDecimalTrue() {
		Range range1 = new Range(-4, -1);
		assertTrue(range1.contains(-2.5));
	}
	
	@Test
	void testContainsZeroTrue() {
		Range range1 = new Range(-10, 10);
		assertTrue(range1.contains(0));
	}
	@Test
	void testContainsNegativeFalse() {
		Range range1 = new Range(-10, 10);
		assertFalse(range1.contains(-11));
	}
	
	@Test
	void testContainsPositiveFalse() {
		Range range1 = new Range(-10, 10);
		assertFalse(range1.contains(11));
	}
	
	/*combines
    *
    *
    *      * ranges that should be valid
    * and expected results
    *
    * (3, 20), (1,10) -> (1, 20)
    * (null), (null) => null
    * (4,15) (null) -> (4,15)
    * (-3.0, -2.0), (-30.0, -13.0) -> (-30.0, -13.0)
    */
    
    //Test combines for valid entries
    @Test
    void testCombinesValidEntries() {
        Range range1 = new Range(3.0, 20.0);
        Range range2 = new Range(1.0, 10.0);
        
        Range actual = Range.combine(range1, range2);
        Range expected = new Range(1.0, 20.0);
        
        assertAll(
                () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),    
                () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
            );
    }
    //Test null ranges
    @Test
    void testCombinesNullRanges() {
    
        
        Range actual = Range.combine(null, null);
        Range expected = null;
        
        assertEquals(expected, actual);
    }
    //Test one null range
    @Test
    void testCombinesOneNull() {
    
        Range range1 = new Range(4.0, 15.0);
        Range actual = Range.combine(null, range1);
        Range expected = new Range(4.0, 15.0);
        
        assertEquals(expected, actual);
    }
    
    //Test with negative ranges
    @Test
    void testCombinesNegativeRanges() {
        Range range1 = new Range(-3.0, -2.0);
        Range range2 = new Range(-30.0, -13.0);
        
        Range actual = Range.combine(range1, range2);
        Range expected = new Range(-30.0, -13.0);
        
        assertAll(
                () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),    
                () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
            );
    }

/*constrain
    *
    *
    *      * values and ranges that should be valid
    * and expected results
    *
    * 10, (3,7) -> 7
    * -8, (3, 7) -> 3
    * 3, (-9, -2) -> -2
    */
    
    //Test with valid entries
    @Test
    void testConstrain() {
        double value = 10.0;
        Range range = new Range(3.0,7.0);
        double actual = range.constrain(value);
        
        double expected = 7.0;
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testConstrainNegativeValue() {
        double value = -8.0;
        Range range = new Range(3.0,7.0);
        double actual = range.constrain(value);
        
        double expected = 3.0;
        
        assertEquals(expected, actual);
    }
    
    //Tests constrain method with negative range
    @Test
    void testConstrainNegativeRange() {
        double value = 3.0;
        Range range = new Range(-9.0,-2.0);
        double actual = range.constrain(value);
        
        double expected = -2.0;
        
        assertEquals(expected, actual);
    }

 /*equals
    *
    *
    *      *ranges that should be valid
    * and expected results
    *
    * (-3.0, 13.0), (-3.0, 13.0) -> true
    * (2.0, 10.0), null -> false
    * (2.0, 10.0), (2,10) -> true
    */
    
    //Test equal method with valid entries
    @Test
    void testEqualsValidEntries() {
        Range range = new Range(-3.0, 13.0);
        Range range1 = new Range(-3.0, 13.0);
        boolean expected = true;
        
        boolean actual = range.equals(range1);
        
        assertEquals(expected, actual);
    }
    
    //Test with a null object
    @Test
    void testEqualsNullObj() {
        Range range = new Range(2.0, 10.0);
        
        boolean expected = false;
        
        boolean actual = range.equals(null);
        
        assertEquals(expected, actual);
    }
    
    //Compares a double and int
    @Test
    void testEqualsDoubleAndInt() {
        Range range = new Range(2.0, 10.0);
        Range range1 = new Range(2,10);
        
        boolean expected = true;
        
        boolean actual = range.equals(range1);
        
        assertEquals(expected, actual);
    }
/*expand
    *
    *
    *      *ranges that should be valid
    * and expected results
    *
    * (2, 6), (range, 0.25, 0.5) -> (1, 8)
    * (-6, -2), (range, 0.25, 0.5) -> (-5, -4)
    *
    */
    
    //Tests expand with valid entries
    @Test
    void testExpandValidEntries() {
        Range range = new Range(2, 6);
        Range actual = Range.expand(range, 0.25, 0.5);
        
        Range expected = new Range(1, 8);
        
        
        assertEquals(expected, actual);
    }
    
    //Tests exapnd class with negative ranges
    @Test
    void testExpandNegativeRanges() {
        Range range = new Range(-6, -2);
        Range actual = Range.expand(range, 0.25, 0.5);
        
        Range expected = new Range(-5, -4);
        
        
        assertEquals(expected, actual);
    }
    
    /*expandToInclude
    *
    *
    *      * ranges that should be valid
    * and expected results
    *
    * Range(5, 15) value(15) -> (5, 15)
    * Range(null, 15) -> (15, 15)
    * Range(3, 15) -6 -> (-6, 15)
    */

    
    //tests valid parameters
    @Test
    void testExpandToIncludeValidEntry() {
        Range range1 = new Range(5, 13);
        double value = 15.0;
        Range actual = Range.expandToInclude(range1, value);
        Range expected = new Range(5, 15);
        
        assertAll(
            () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),    
            () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
        );
    }
    
    //Tests with null range and valid double
    @Test
    void testExpandToIncludeNullRange() {
        double value = 15.0;
        Range actual = Range.expandToInclude(null, value);
        Range expected = new Range(15, 15);
        
        assertAll(
            () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),    
            () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
        );
    }
    
    //Tests with a negative value to see if it expands negative
    @Test
    void testExpandToIncludeNegativeValue() {
        double value = -6.0;
        Range range = new Range(3, 10);
        Range actual = Range.expandToInclude(range, value);
        Range expected = new Range(-6.0, 10.0);
        
        assertAll(
            () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),    
            () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
        );
    }
    
    @Test
	//Regular Test
	//(1 - 5) (3 - 6) => True
	void intersectRegularTest() {
		
	Range range1 = new Range(1, 5);
		assertTrue(range1.intersects(3, 6));
	}
	
	@Test
	//Does not intersect
	//(1 - 5) (6 - 10) => False
	void intersectFailTest() {
		
		Range range1 = new Range(1, 5);
		assertFalse(range1.intersects(6, 10));

	}
	
	@Test
	//Range 1 encompasses Range 2
	//(1 - 10) (3 - 4) => True 
	void intersectEncompassTest() {
		Range range1 = new Range(1, 10);
		assertTrue(range1.intersects(3, 4));
	}
	
	@Test
	//Negative Range compared to positive
	//(-6 - -1) (4 - 7) => False
	void intersectNegativeTest() {
		Range range1 = new Range(-6, -1);
		assertFalse(range1.intersects(4, 7));	
	}
	
	@Test
	//Decimal
	//(1 - 5.5) (5.4 - 10) => True
	void intersectDecimalTest() {
		Range range1 = new Range(1, 5.5);
		assertTrue(range1.intersects(5.4, 10));
	}
	
	@Test
	//Regular Test
	//(1 - 5) shift 2 => (3 - 7)
	void shiftRegularTest() {
		Range range1 = new Range(1, 5);
		Range expected = new Range(3, 7);
		Range result = Range.shift(range1, 2);
		
		assertAll(
		 () -> assertEquals(result.getLowerBound(), expected.getLowerBound()),    
		 () -> assertEquals(result.getUpperBound(), expected.getUpperBound())
		);

	}
	
	@Test
	//Shifts by decimal delta
	//(1 - 5) shifts 2.5 => (3.5 - 7.5)
	void shiftDecimalTest() {
		Range range1 = new Range(1, 5);
		Range expected = new Range(3.5, 7.5);
		Range result = Range.shift(range1, 2.5);
		
		assertAll(
			() -> assertEquals(Range.shift(range1, 2.5).getLowerBound(), expected.getLowerBound()),    
			() -> assertEquals(Range.shift(range1, 2.5).getUpperBound(), expected.getUpperBound())
		);
	
	}
	
	@Test
	//Negative shifts to positive Test
	//(-5 - -2) shifts 5 => (0 - 3)
	void shiftNegativetoPositiveTest() {
		Range range1 = new Range(-5, -2);
		Range expected = new Range(0, 3);
		Range result = Range.shift(range1, 5);
		assertAll(
				() -> assertEquals(result.getLowerBound(), expected.getLowerBound()),    
				() -> assertEquals(result.getUpperBound(), expected.getUpperBound())
		);
	}
	
	@Test
	// Same number range shift
	//(1 - 1) shifts 2 => (3 - 3)
	void shiftNoRangeTest() {
		Range range1 = new Range(1, 1);
		Range expected = new Range(3, 3);
		Range result = Range.shift(range1, 2);
		assertAll(
			() -> assertEquals(result.getLowerBound(), expected.getLowerBound()),    
			() -> assertEquals(result.getUpperBound(), expected.getUpperBound())
		);
	}
	
	@Test
	//Shift value is 0
	//(1 - 5) shift 0 => (1 - 5)
	void shiftByZeroTest() {
		Range range1 = new Range(1, 5);
		Range expected = new Range(1, 5);
		Range result = Range.shift(range1, 0);
		assertAll(
			() -> assertEquals(result.getLowerBound(), expected.getLowerBound()),    
			() -> assertEquals(result.getUpperBound(), expected.getUpperBound())
		);
	}
	
	@Test
	//Negative delta value
	//(1 - 5) shift -3 => (-2 - 2)
	void shiftNegativeDeltaTest() {
		Range range1 = new Range(1, 5);
		Range expected = new Range(-2, 2);
		Range result = Range.shift(range1, -3);
		assertAll(
			() -> assertEquals(result.getLowerBound(), expected.getLowerBound()),    
			() -> assertEquals(result.getUpperBound(), expected.getUpperBound())
		);
	}
	
	@Test
	//Shift Boolean True
	//(-5 - -1) shift 3 True =>(-2 - 2)
	void shiftZeroCrossTrueTest() {
		Range range1 = new Range(-5, -1);
		Range expected = new Range(-2, 10);
		Range result = Range.shift(range1, 3, true);
		assertAll(
			() -> assertEquals(result.getLowerBound(), expected.getLowerBound()),    
			() -> assertEquals(result.getUpperBound(), expected.getUpperBound())
		);
	}
	
	@Test
	//Shift Boolean True
	//(-5 - -1) shift 3 True =>(-2 - 2)
	void shiftZeroCrossFalseTest() {
		Range range1 = new Range(-5, -1);
		Range expected = new Range(-2, 0);
		Range result = Range.shift(range1, 5, false);
		assertAll(
			() -> assertEquals(result.getLowerBound(), expected.getLowerBound()),    
			() -> assertEquals(result.getUpperBound(), expected.getUpperBound())
		);
	}
	
	@Test
	//Negative delta value, False zero cross
	//(1 - 5) shift -3 => (0 - 2)
	void shiftNegativeDeltaFalseCrossTest() {
		Range range1 = new Range(1, 5);
		Range expected = new Range(0, 2);
		Range result = Range.shift(range1, 5, false);
		assertAll(
			() -> assertEquals(result.getLowerBound(), expected.getLowerBound()),    
			() -> assertEquals(result.getUpperBound(), expected.getUpperBound())
		);
	}
	
	@Test
	//Regular toString
	//(1 - 5) to String => "Range[1, 5]"
	void stringRegularTest() {
		Range range1 = new Range(1, 5);
		String expectedString = "Range[1, 5]";
		String resultedString = range1.toString();
		assertEquals(expectedString, resultedString);
		
	}
	
	@Test
	//Negative Range to String
	//(-5 - -3) to String => "Range[-5, -3]"
	void stringNegativeTest () {
		Range range1 = new Range(-5, -3);
		String expectedString = "Range[-5, -3]";
		String resultedString = range1.toString();
		assertEquals(expectedString, resultedString);
	}
	
	@Test 
	//Decimal range to string
	//(2.5 - 5.21) to String => "Range[2.5, 5.21]"
	void stringDecimalTest() {
		Range range1 = new Range(2.5, 5.21);
		String expectedString = "Range[2.5, 5.21]";
		String resultedString = range1.toString();
		assertEquals(expectedString, resultedString);
	}
	
	


	
}
