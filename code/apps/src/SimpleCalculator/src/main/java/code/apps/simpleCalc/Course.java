package code.apps.simpleCalc;

import java.util.*;


/**
 * This is a simple class that models a Course.  Each Course has a course name, 
 * a list of students, and a UUID (unique user ID).  For more information on UUIDs see:
 * http://docs.oracle.com/javase/7/docs/api/java/util/UUID.html
 * 
 * Note: All of these fields are already given to you.
 */
public class Course {
    private String        courseName;
    private List<Student> students;
    private UUID          id;

    /**
     * The no arguments constructor for Course. The courseName should be null (which it is by default, so you
     * don't need to do anything) , and the id should be a random UUID.
     * The students ArrayList has already been set for you.
     */
    public Course() {
        this.students = new ArrayList<Student>(); //Leave this be.
        //FIXME Set the value of id to be a random UUID
        this.id = UUID.randomUUID();
    }
    
    /**
     * A single-argument constructor for the Course class. You should set the courseName to the
     * given name and the id to a random UUID.  The students ArrayList has already been set for you. 
     * 
     * @param courseName
     */
    public Course(String courseName){
    	this.students = new ArrayList<Student>(); //Leave this be.
    	//FIXME Set the value of id to be a random UUID and the course name to the given name
    	this.id = UUID.randomUUID();
    	this.courseName = courseName;
    }
    
    /**
     * A two-argument constructor for the Course class.  You should set the courseName to the
     * give name, the id to a random UUID, and the students to the given list of students.
     * 
     * @param courseName
     * @param students
     */
    public Course(String courseName, List<Student> students){
    	//FIXME Set the id to a random UUID, the course name to the given name, and the course's students to the given students
    	this.id =  UUID.randomUUID();
    	this.courseName = courseName;
    	this.students = students;
    }

    /**
     * Returns the id of the course
     * 
     * @return the UUID of this course
     */
    public UUID getId() {
        //FIXME Return the id value.
    	return id;
    }

    /**
     * Sets the id of the course to the given id
     * 
     * @param id
     */
    public void setId(UUID id) {
        //FIXME set the id value
    	this.id = id;
    }
    
    /**
     * Returns the name of the course
     * 
     * @return
     */
    public String getCourseName() {
        //FIXME Return the courseName value.
    	return courseName;
    }

    /**
     * Sets the name of the course to the given courseName
     * 
     * @param courseName
     */
    public void setCourseName(String courseName) {
        //FIXME set the courseName value
        this.courseName = courseName;
    }

    /**
     * Returns a list of all the students in the class
     * 
     * @return
     */
    public List<Student> getStudents() {
    	//FIXME return the actually set of enrolled students.
    	return students;
    }

    /**
     * Sets the list of students in the class to the given list
     * 
     * @param students
     */
    public void setStudents(List<Student> students) {
        //FIXME Set the students value
        this.students = students;

    }

    /**
     * This method takes a student and adds them to the list of enrolled students.
     * Students may be rejected or not enrolled for 1 of 2 reasons
     * 1) They are already enrolled (i.e already a member of students)
     * 2) Their enrollment would cause the number of students to exceed the maximum
     *    number of students for the course.
     *
     * @param student The student to be added.
     * @return true if and only if the student has been successfully enrolled in the course
     */
    public Boolean enrollStudent(Student student) {
    	if (isEnrolled(student) || students.size() == COURSE_ENROLLMENT_LIMIT)
		{
			return false;
		}
    	
    	students.add(student);
    	return true;
    }
    
    /**
     * Checks to see if the given student is enrolled in the course
     * 
     * @param student
     * @return true if and only if the given student is enrolled in the course
     */
    public Boolean isEnrolled(Student student){ 
    	List<Student> students = getStudents();

    	for (int i = 0; i < students.size(); i++)
		{
    		// i would think using student.equals() should work, but im having an issue with it.
			if (student.getName() == students.get(i).getName() & student.getId() == students.get(i).getId())
			{
				return true;
			}
		}
		return false;
    }

    /**
     * Removes the given student from the course. If the student is not enrolled,
     * do nothing.
     *
     * @param student The student to be removed.
     */
    public void removeStudent(Student student) {
    	java.util.Iterator<Student> itr = students.iterator();
    	
        if (isEnrolled(student))
		{
	        while (itr.hasNext())
	        {
	        	Student s = itr.next();
	        	if (s.getName() == student.getName())
	        	{
	        		itr.remove();
	        		return;
	        	}
	        }
		}
    }
    


    /**
     * The maximum number of students allowed to be enrolled in the class at a given time.
     * Does it matter that this is static?
     *
     * yes, because the static keyword indicates that the constant belongs to the class
     * and not to methods. but since we are only using this constant once in the code, in the 
     * enrollStudent() method, we could just put the constant in there, then it wouldnt need
     * to be static.
     */
    public static final int COURSE_ENROLLMENT_LIMIT = 90;
}
