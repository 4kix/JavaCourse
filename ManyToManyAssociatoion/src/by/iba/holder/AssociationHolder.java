package by.iba.holder;

import java.util.*;

import by.iba.entity.Professor;
import by.iba.entity.Student;
import by.iba.entity.UniversityMember;

/**Holds many-to-many associations between two classes
 * 
 * @author Ilya Falko
 *
 */
public class AssociationHolder implements HolderInterface {
	private Map<UniversityMember, LinkedList<UniversityMember>> leftToRight;
	private Map<UniversityMember, LinkedList<UniversityMember>> rightToLeft;
	
	public AssociationHolder() {
		leftToRight = new HashMap<UniversityMember, LinkedList<UniversityMember>>();
		rightToLeft = new HashMap<UniversityMember, LinkedList<UniversityMember>>();
	}
	
	/** Adds new association
	 * 
	 * @param leftMember
	 * @param rightMember
	 */
	public void add(UniversityMember leftMember, UniversityMember rightMember) {
		
		//adding new left to right association
		if (leftToRight.containsKey(leftMember)) {
			List<UniversityMember> rightList = leftToRight.get(leftMember);
			rightList.add(rightMember);
		} else {
			LinkedList<UniversityMember> rightList= new LinkedList<UniversityMember>();
			rightList.add(rightMember);
			leftToRight.put(leftMember, rightList);
		}
		
		//adding new right to left association
		if (rightToLeft.containsKey(rightMember)) {
			List<UniversityMember> leftList = rightToLeft.get(rightMember);
			leftList.add(leftMember);
		} else {
			LinkedList<UniversityMember> leftList= new LinkedList<UniversityMember>();
			leftList.add(leftMember);
			rightToLeft.put(rightMember, leftList);
		}
	}
	
	
	
	/**Method for getting a list of left members associated with right member
	 * 
	 * @param rightMember -rightMember
	 * @return returns a list of Left Members
	 */
	public List<UniversityMember> getLeftByRight(UniversityMember rightMember) {
		return rightToLeft.get(rightMember);
	}
	
	/**Method for getting a list of right members associated with left member
	 * 
	 * @param leftMember - leftMember
	 * @return returns a list of Right Members
	 */
	public List<UniversityMember> getRightByLeft(UniversityMember leftMember) {
		return leftToRight.get(leftMember);
	}
}
