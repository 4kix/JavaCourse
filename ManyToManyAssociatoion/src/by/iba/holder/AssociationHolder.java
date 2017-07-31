package by.iba.holder;

import java.util.*;

import by.iba.entity.Professor;
import by.iba.entity.Student;

/**Holds many-to-many associations between two classes
 * 
 * @author Ilya Falko
 *
 */
public class AssociationHolder {
	private Map<Student, LinkedList<Professor>> studToProf;
	private Map<Professor, LinkedList<Student>> profToStud;
	
	public AssociationHolder() {
		studToProf = new HashMap<Student, LinkedList<Professor>>();
		profToStud = new HashMap<Professor, LinkedList<Student>>();
	}
	
	/** Adds new association
	 * 
	 * @param student
	 * @param professor
	 */
	public void add(Student student, Professor professor) {
		
		//adding new Student to Professor association
		if (studToProf.containsKey(student)) {
			List<Professor> profList = studToProf.get(student);
			profList.add(professor);
		} else {
			LinkedList<Professor> profList= new LinkedList<Professor>();
			profList.add(professor);
			studToProf.put(student, profList);
		}
		
		//adding new Professor to Student association
		if (profToStud.containsKey(professor)) {
			List<Student> studList = profToStud.get(professor);
			studList.add(student);
		} else {
			LinkedList<Student> studList= new LinkedList<Student>();
			studList.add(student);
			profToStud.put(professor, studList);
		}
	}
	
	public void add(Professor professor, Student student) {
		add(student, professor);
	}
	
	/**Method for getting a list of students associated with professor
	 * 
	 * @param professor professor
	 * @return returns a list of students
	 */
	public List<Student> getStudentsByProfessor(Professor professor) {
		return profToStud.get(professor);
	}
	
	/**Method for getting a list of professors associated with student
	 * 
	 * @param student - student
	 * @return returns a list of professors
	 */
	public List<Professor> getProfessorsByStudent(Student student) {
		return studToProf.get(student);
	}
}
