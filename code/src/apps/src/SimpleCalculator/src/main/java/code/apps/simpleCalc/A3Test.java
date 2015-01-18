package code.apps.simpleCalc;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class A3Test {

	List<Student> students;
	Course course;
	Student student;

	@Before
	public void setUp() throws Exception {
		students = new ArrayList<Student> 
		(Arrays.asList(new Student("brandon"), new Student("john"), new Student("jess")));
		student = new Student("alex");
		course = new Course("compsci", students);
	}

	@Test
	public void studentTest1()
	{
		assertEquals("alex", student.getName());
	}
	
	@Test
	public void studentTest2()
	{
		student.setName("john");
		assertEquals("john", student.getName());
	}
	
	@Test
	public void studentTest3()
	{
		UUID id = UUID.randomUUID();
		student.setId(id);
		assertEquals(id, student.getId());
	}
	
	@Test
	public void courseTest1()
	{
		assertEquals(students, course.getStudents());
	}

	@Test
	public void courseTest2()
	{
		assertEquals("compsci", course.getCourseName());
	}

	
	@Test
	public void courseTest3()
	{
		assertEquals(true, course.isEnrolled(new Student("brandon")));
	}
	
	@Test
	public void courseTest4()
	{
		assertEquals(true, course.isEnrolled(new Student("john")));
	}
	
	@Test
	public void courseTest5()
	{
		assertEquals(false, course.isEnrolled(new Student("wat")));
	}
	@Test
	public void courseTest6()
	{
		course.removeStudent(new Student("john"));
		assertEquals(false, course.isEnrolled(new Student("john")));
	}
	
	@Test
	public void courseTest7()
	{
		assertEquals(false, course.enrollStudent(new Student("brandon")));
	}
	
	@Test
	public void courseTest8()
	{
		assertEquals(true, course.enrollStudent(new Student("candy")));
	}
}
