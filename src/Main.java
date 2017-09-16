import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
 	StudentGroup s = new StudentGroup(10);	
	Student stu1 = new Student(0, "Karthi Keyan", new Date(), 55);
	Student stu2 = new Student(2, "sdf", new Date(), 55);
	Student stu3 = new Student(4, "xn", new Date(), 55);
	Student stu4 = new Student(5, "cvb", new Date(), 55);
	Student stu5 = new Student(2, "ert", new Date(2323223232L), 55);
	Student stu6 = new Student(4, "cvb", new Date(), 55);
	Student stu7 = new Student(8, "dfg", new Date(), 55);
	s.add(stu1, 1);
	s.addFirst(stu2);
	s.remove(stu2);
	s.addFirst(stu2);
	s.addFirst(stu2);
	s.addLast(stu3);
	s.setStudent(stu5,5);
	
	
	s.add(stu1, 1);
	s.add(stu3, 1);
	s.add(stu4, 1);
	s.add(stu5, 1);
	s.addLast(stu2);
 	s.bubbleSort();
	s.getBetweenBirthDates(new Date(2323223232L) , new Date());
	s.getByBirthDate(new Date(2323223232L));
	s.getCurrentAgeByDate(4);
	s.getNearBirthDate(new Date(2323223232L), 5);
	s.getNextStudent(stu1);
	s.getStudent(3);
	s.getStudents();
	s.getStudentsByAge(19);
	 s.getStudentsWithMaxAvgMark();
	//s.remove(1);
	//s.remove(stu3);
	//s.removeFromElement(stu4);
//	s.removeFromIndex(1);
	s.add(stu5, 1);
s.removeToElement(stu5);
	s.removeToIndex(2);
	s.setStudent(stu7, 4);
	//s.setStudents(students);
 	 
for (Student st : s.getStudents()) 
{
	if(st!=null)
	System.out.println(st.getFullName()); 
}

	}

}
