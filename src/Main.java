import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
 	StudentGroup s = new StudentGroup(10);	
	Student stu1 = new Student(0, "Karthi Keyan", new Date(), 55);
	Student stu2 = new Student(2, "sdf", new Date(), 55);
	Student stu3 = new Student(4, "xn", new Date(), 55);
	Student stu4 = new Student(5, "cvb", new Date(), 55);
	Student stu5 = new Student(2, "ert", new Date(), 55);
	Student stu6 = new Student(4, "cvb", new Date(), 55);
	Student stu7 = new Student(8, "dfg", new Date(), 55);
	s.add(stu1, 1);
	s.addFirst(stu2);
	s.remove(stu2);
	s.addFirst(stu2);
	s.addFirst(stu2);
	s.addLast(stu3);
	 s.bubbleSort();
	 
for (Student st : s.getStudents()) 
{
	if(st!=null)
	System.out.println(st.getFullName()); 
}

	}

}
