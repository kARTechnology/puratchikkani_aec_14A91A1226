import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;

	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * 
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if (students == null)
			throw new IllegalArgumentException();
		this.students = students;
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException {
		if (index < 0 || index >= students.length)
 			throw new IllegalArgumentException();
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException {
		if (student == null)
			throw new IllegalArgumentException();
		if (index < 0 || index >= students.length)
 			throw new IllegalArgumentException();
 		this.students[index] = student;
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {
		if (student == null)
			throw new IllegalArgumentException();
		this.students = addStudent(this.students, 0, student);

	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException {
		if (student == null)
			throw new IllegalArgumentException();
		this.students = addStudent(this.students, this.students.length, student);
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException {
		if (student == null)
			throw new IllegalArgumentException();
		if (index < 0 || index >= students.length)
 			throw new IllegalArgumentException();
		this.students = addStudent(this.students, index, student);
	}

	@Override
	public void remove(int index) throws IllegalArgumentException {
		if (index < 0 || index >= students.length)
 			throw new IllegalArgumentException();

		Student[] result = new Student[this.students.length - 1];
		for (int i = 0; i < index; i++)
			result[i] = this.students[i];

		for (int i = index + 1; i < this.students.length; i++)
			result[i] = this.students[i];

		this.students = result;
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException {
		if (student == null)
			throw new IllegalArgumentException();

		int index = getStudentIndex(this.students, student);
		if (index == -1)
			throw new IllegalArgumentException("Student not exist");
		remove(index);
	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException {
		if (index < 0 || index >= students.length)
 			throw new IllegalArgumentException();

		this.students = removeStudents(this.students, 0, index);
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException {
		if (student == null)
			throw new IllegalArgumentException();
		int index = getStudentIndex(this.students, student);
		if (index == -1)
			throw new IllegalArgumentException("Student not exist");
		removeFromIndex(index);
	}

	@Override
	public void removeToIndex(int index) throws IllegalArgumentException {
		if (index < 0 || index >= students.length)
 			throw new IllegalArgumentException();
		this.students = removeStudents(this.students, index, this.students.length);
	}

	@Override
	public void removeToElement(Student student) throws IllegalArgumentException {
		if (student == null)
			throw new IllegalArgumentException();
		int index = getStudentIndex(this.students, student);
		if (index == -1)
			throw new IllegalArgumentException("Student not exist");
		removeToIndex(index);
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) throws IllegalArgumentException {
		if (date == null)
			throw new IllegalArgumentException();

		List<Student> list = new ArrayList<Student>();
		for (Student s : this.students) {
			if (s.getBirthDate().compareTo(date) <= 0)
				list.add(s);
		}
		return (Student[]) list.toArray();
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException {
		if (firstDate == null || lastDate == null)
			throw new IllegalArgumentException();

		List<Student> list = new ArrayList<Student>();
		for (Student s : this.students) {
			if (s.getBirthDate().compareTo(firstDate) >= 0 && s.getBirthDate().compareTo(lastDate) <= 0)
				list.add(s);
		}
		return (Student[]) list.toArray();
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if (date == null)
			throw new IllegalArgumentException();

		return getBetweenBirthDates(date, addDays(date, days));

	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) throws IllegalArgumentException {
		if (indexOfStudent < 0)
			throw new IllegalArgumentException();
		else if (indexOfStudent >= students.length)
			throw new IllegalArgumentException();
		LocalDate date1 = new java.sql.Date(getStudent(indexOfStudent).getBirthDate().getTime()).toLocalDate();
		LocalDate date2 = new java.sql.Date(new Date().getTime()).toLocalDate();
		return Period.between(date1, date2).getYears();

	}

	@Override
	public Student[] getStudentsByAge(int age) {
		List<Student> list = new ArrayList<Student>();
		for (int i = 0; i < this.students.length; i++) {
			if (getCurrentAgeByDate(i) == age)
				list.add(students[i]);
		}
		return (Student[]) list.toArray();
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) throws IllegalArgumentException {
		if (student == null)
			throw new IllegalArgumentException();
		int index = getStudentIndex(this.students, student);
		if (index == -1)
			throw new IllegalArgumentException("Student not exist");
		index = index + 1;
		if (index >= students.length)
			throw new IllegalArgumentException();
		return students[index];
	}

	private static Student[] addStudent(Student[] a, int pos, Student student) {
		Student[] result = new Student[a.length + 1];
		for (int i = 0; i < pos; i++)
			result[i] = a[i];
		result[pos] = student;
		for (int i = pos + 1; i < a.length; i++)
			result[i] = a[i - 1];
		return result;
	}

	private static Student[] removeStudents(Student[] a, int from, int to) {
		Student[] result = new Student[to - from];
		for (int i = to; i < from; i++)
			result[i] = a[i];
		return result;
	}

	private static int getStudentIndex(Student[] a, Student student) {
		for (int i = 0; i < a.length; i++)
			if (a[i].equals(student))
				return i;
		return -1;
	}

	private static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

}
