package nz.ac.auckland.softeng281.a3;

//*******************************
//YOU SHOULD MODIFY THIS CLASS FOR TASK2, TASK3, TASK4, TASK5, and TASK6.
//- you can add all the methods that you need.
//- you cannot modify the method signature (return type, method name and parameters) of the existing methods
//- you can change the code of the existing methods but at your own risk! the program might not work properly
//*******************************
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Enumeration;
/**
 * A class for binary relations over a set of strings.
 *
 * @author Partha Roop
 */
public class StringRelation extends SetOfStrings {
	// This is a set used to store the members of the binary relation
	private SetOfStrings setMembers;

	/**
	 * create an empty StringRelation when no arguments are given -- constructor In
	 * this event the setMembers is a new SetOfStrings with no members yet
	 */
	public StringRelation() {
		this(new SetOfStrings());
	}

	/**
	 * create a StringRelation object
	 */
	public StringRelation(SetOfStrings setMembers) {
		super();
		this.setMembers = setMembers;
	}

	public void setSetMemberElements(SetOfStrings set) {
		setMembers = set;
	}

	public boolean isValid() {
		SetOfStrings product = setMembers.product(setMembers);
		return product.isSupersetOf(this);
	}

 //
	public boolean isReflexive() {
		if (!isValid()) {
			return false;
    }

		for (String s : setMembers.getElements()){
      String elements = s + "," + s;
      if(!this.isMember(elements)){
        return false;
      }
    }
    return true;
	} 

	public boolean isSymmetric() {
    if (!isValid()) {
			return false;
		}

    List<String> relationsList = this.getElements();

    for(String s : relationsList){
      int indexComma = s.indexOf(",");
      String val1 = s.substring(0,indexComma);
      String val2 = s.substring (indexComma + 1);
      String testArray = val2 + "," + val1;
      if(!relationsList.contains(testArray)){
        return false;
      }
	  }
  return true;
  }

//Returns true if the relation is transitive,false otherwise.
	public boolean isTransitive() {
		if (!isValid()) {
			return false;
		}
    
    List<String> relationsList = this.getElements();
    // seperate the values by getting a value from each index and then comparing the difference values to check for transitivity with the relations set
    for (String set1 : relationsList){
      int indexComma = set1.indexOf(",");
      String set1Val1 = set1.substring(0,indexComma);
      String set1Val2 = set1.substring (indexComma + 1);
      for (String set2 : relationsList){
        int indexComma2 = set2.indexOf(",");
        String set2Val1 = set2.substring(0,indexComma2);
        String set2Val2 = set2.substring(indexComma2 + 1);
        if (set1Val2.equals(set2Val1)){
          String testArray = set1Val1 + "," + set2Val2;
          if (!relationsList.contains(testArray)){
            return false;
          }
        }
      }
    }
    return true;
	}

//checks if relations set is reflexive, symmetric and transitive. Returns false if not. 
	public boolean isEquivalence() {
		if(isReflexive() && isSymmetric() && isTransitive()){
      return true;
    }
    return false;
	}

	/**
	 * do not change this method
	 * 
	 * @param node
	 * @return
	 */
	public SetOfStrings eqClass(String node) {
		if (!isEquivalence()) {
			System.out.println("Can't compute equivalence class.. NOT an equivalence relation");
			return new SetOfStrings();
		}
		return computeEqClass(node);
	}

// computes the equicalence class to check if the relations list is equal to the node. returns back the equivalence classArray.
	public SetOfStrings computeEqClass(String node) {
    SetOfStrings eqClassArray = new SetOfStrings();
    List<String> relationsList = this.getElements();
    // loops through each value in relationsList
    for(String s : relationsList){
      int indexComma = s.indexOf(",");
      String val1 = s.substring(0,indexComma);
      //only runs if first value is equal to the node
      if (val1.equals(node)){
        String val2 = s.substring(indexComma + 1);
        eqClassArray.insertElement(val2);
      }
    }
    return eqClassArray;
	} 
}
