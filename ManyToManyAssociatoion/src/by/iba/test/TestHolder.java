package by.iba.test;

import by.iba.entity.Professor;
import by.iba.entity.Student;
import by.iba.entity.UniversityMember;
import by.iba.holder.AssociationHolder;

public class TestHolder {

	public static void main(String[] args) {
		
		UniversityMember student1 = new Student("Ivan","Ivanov");
		UniversityMember student2 = new Student("Alexei","Ivanov");
		UniversityMember student3 = new Student("Egor","Ivanov");
		UniversityMember student4 = new Student("Gleb","Ivanov");
		
		UniversityMember professor1 = new Professor("Petr", "Petrov", "320");
		UniversityMember professor2 = new Professor("Nikolai", "Sidorov", "320");
		UniversityMember professor3 = new Professor("Valerii", "Ionov", "321");
		
		AssociationHolder holder = new AssociationHolder();
		
		holder.add(student1, professor1);
		holder.add(student1, professor2);
		holder.add(student3, professor2);
		holder.add(student4, professor2);
		holder.add(student2, professor3);
		
		System.out.println("Professors of  "+ student1 + ":\n" + holder.getRightByLeft(student1));
		System.out.println("Students of "+ professor2 +":\n" + holder.getLeftByRight(professor2));
	}

}
