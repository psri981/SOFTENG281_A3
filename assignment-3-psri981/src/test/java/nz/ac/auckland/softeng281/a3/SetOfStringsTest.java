package nz.ac.auckland.softeng281.a3;

// YOU SHOULD ADD NEW TEST CASES

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetOfStringsTest {
	SetOfStrings set1, set2;

	@Before
	public void setUp() {
		set1 = new SetOfStrings();
		set2 = new SetOfStrings();
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testUnion() {

		set1.insertElement("a");
		set2.insertElement("b");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		assertEquals(expected, set1.union(set2));
	}

  
  @Test
	public void testInsert() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("a");
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		assertEquals(expected, set1);
	}

	
	@Test
	public void testInsert1() {
		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("a");
		assertEquals(set1.size(),2);
	}

  @Test
  public void testIntersection() {

    set1.insertElement("a");
    set2.insertElement("a");
    set2.insertElement("b");

    SetOfStrings expected = new SetOfStrings();
    expected.insertElement("a");
    assertEquals(expected, set1.intersection(set2));

  }

  @Test
  public void testDifference() {

    set1.insertElement("a");
    set1.insertElement("b");
    set1.insertElement("c");
    set2.insertElement("a");
    set2.insertElement("b");

    SetOfStrings expected = new SetOfStrings();
    expected.insertElement("c");
    assertEquals(expected, set1.difference(set2));

  }

}
