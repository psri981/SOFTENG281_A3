package nz.ac.auckland.softeng281.a3;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StringRelationTest {

	private StringRelation relation;
	private SetOfStrings setMembers;

	@Before
	public void setUp() {
		setMembers = new SetOfStrings();
		relation = new StringRelation(setMembers);
	}

	@After
	public void tearDown() {

	}
  
  // Tests for isReflective
	@Test
	public void testReflexive() {
		relation.insertElement("1,1");
		setMembers.insertElement("1");
		assertTrue(relation.isReflexive());
	}

  @Test
	public void testReflexive2() {
		relation.insertElement("0,0");
    relation.insertElement("0,0");
		setMembers.insertElement("0");
		assertTrue(relation.isReflexive());
	}

  @Test
  public void testReflexive3() {
    relation.insertElement("3,4");
    setMembers.insertElement("4");
    assertFalse(relation.isSymmetric());
  }

  // Tests for isSymmetric
  @Test
  public void testSymmetric() {
    relation.insertElement("3,4");
    relation.insertElement("4,3");
    setMembers.insertElement("4");
    setMembers.insertElement("3");
    assertTrue(relation.isSymmetric());

  }
  
  @Test
  public void testSymmetric2() {
    relation.insertElement("1,2");
    relation.insertElement("1,2");
    relation.insertElement("2,1");
    setMembers.insertElement("1");
    setMembers.insertElement("2");
    assertTrue(relation.isSymmetric());
  }

  @Test
  public void testSymmetric3() {
    relation.insertElement("3,4");
    relation.insertElement("4,4");
    setMembers.insertElement("4");
    setMembers.insertElement("3");
    assertFalse(relation.isSymmetric());
  }

  // Tests for isTransitive
  @Test
  public void testTransitve(){
    relation.insertElement("0,1");
    relation.insertElement("1,2");
    relation.insertElement("0,2");
    setMembers.insertElement("0");
    setMembers.insertElement("1");
    setMembers.insertElement("2");
    assertTrue(relation.isTransitive());
  }
  
  @Test
  public void testTransitve2(){
    relation.insertElement("0,3");
    relation.insertElement("3,2");
    relation.insertElement("0,2");
    setMembers.insertElement("0");
    setMembers.insertElement("3");
    setMembers.insertElement("2");
    assertTrue(relation.isTransitive());
  }

  //Tests for equivalence
  @Test
  public void testEquivalence() {

    relation.insertElement("0,0");
    relation.insertElement("1,1");
    relation.insertElement("2,2");
    relation.insertElement("0,1");
    relation.insertElement("1,0");
    relation.insertElement("0,2");
    relation.insertElement("1,2");
    relation.insertElement("2,1");
    relation.insertElement("2,0");
    setMembers.insertElement("0");
    setMembers.insertElement("1");
    setMembers.insertElement("2");
    assertTrue(relation.isEquivalence());
  }

  @Test
  public void testEquivalence2() {

    relation.insertElement("0,0");
    relation.insertElement("1,1");
    relation.insertElement("2,2");
    relation.insertElement("0,1");
    relation.insertElement("1,0");
    relation.insertElement("0,2");
    relation.insertElement("1,2");
    relation.insertElement("2,1");
    relation.insertElement("2,0");
    setMembers.insertElement("2");
    setMembers.insertElement("3");
    setMembers.insertElement("4");
    assertFalse(relation.isEquivalence());
  }


  //Test cases for EqClass
  @Test
  public void testEqClass() {

    relation.insertElement("0,0");
    relation.insertElement("1,1");
    relation.insertElement("2,2");
    relation.insertElement("0,1");
    relation.insertElement("1,0");
    relation.insertElement("0,2");
    relation.insertElement("1,2");
    relation.insertElement("2,1");
    relation.insertElement("2,0");
    setMembers.insertElement("0");
    setMembers.insertElement("1");
    setMembers.insertElement("2");
    SetOfStrings expected = new SetOfStrings();
    expected.insertElement("0");
    expected.insertElement("1"); 
    expected.insertElement("2"); 
    assertEquals(expected,relation.eqClass("0"));
  }

}