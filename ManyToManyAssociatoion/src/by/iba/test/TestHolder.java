package by.iba.test;

import by.iba.entity.Professor;
import by.iba.entity.Student;
import by.iba.holder.AssociationHolder;

public class TestHolder {

	public static void main(String[] args) {
		
		Student student1 = new Student("Ivan","Ivanov");
		Student student2 = new Student("Alexei","Ivanov");
		Student student3 = new Student("Egor","Ivanov");
		Student student4 = new Student("Gleb","Ivanov");
		
		Professor professor1 = new Professor("Petr", "Petrov", "320");
		Professor professor2 = new Professor("Nikolai", "Sidorov", "320");
		Professor professor3 = new Professor("Valerii", "Ionov", "321");
		
		AssociationHolder holder = new AssociationHolder();
		
		holder.add(student1, professor1);
		holder.add(student1, professor2);
		holder.add(professor2, student3);
		holder.add(professor2, student4);
		holder.add(professor3, student2);
		
		System.out.println("Professors of  "+ student1 + ":\n" + holder.getProfessorsByStudent(student1));
		System.out.println("Students of "+ professor2 +":\n" + holder.getStudentsByProfessor(professor2));
	}

}
