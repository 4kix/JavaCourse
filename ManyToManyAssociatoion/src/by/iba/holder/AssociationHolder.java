package by.iba.holder;

import java.util.*;

import by.iba.entity.Professor;
import by.iba.entity.Student;

public class AssociationHolder {
	private Map<Student, LinkedList<Professor>> studToProf;
	private Map<Professor, LinkedList<Student>> profToStud;
	
	public AssociationHolder() {
		studToProf = new HashMap<Student, LinkedList<Professor>>();
		profToStud = new HashMap<Professor, LinkedList<Student>>();
	}
	
	
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
	
	public List<Student> getStudentsByProfessor(Professor professor) {
		//null pointer exception		
		
		return profToStud.get(professor);
	}
	
	public List<Professor> getProfessorsByStudent(Student student) {
		//null pointer exception
		return studToProf.get(student);
	}
}
