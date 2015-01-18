package code.apps.simpleCalc;

import java.util.UUID;

/**
 * This is a simple class that models a student. Each student has a name,
 * and a UUID (unique user ID).  For more information on UUIDs see:
 * http://docs.oracle.com/javase/7/docs/api/java/util/UUID.html
 */
public class Student{
	private String Name;
	private UUID Id;

	
    /**
     * This constructor should create a student without a name. The name is null by default, so
     * you don't need to change that.
     */
    public Student(){
    }

    /**
     * A constructor that creates a student with the given name
     * @param name the name of the student.
     */
    public Student(String name){
    	this.Name = name;
    }

    /**
     * Returns the name of the student. You will have to create
     * a variable in order to hold the name value.
     * @return The name of the student
     */
    public String getName(){
        return Name;
    }

    /**
     * Changes the student's name to given specified name.
     * @param name The new name for the student.
     */
    public void setName(String name){
    	this.Name = name;
    }
    
    /**
     * 
     * @return the student's ID
     */
    public UUID getId(){
        return Id;
    }

    /**
     * Changes the id to the specified value.
     * @param id the new id value
     */
    public void setId(UUID id){
    	this.Id = id;
    }



    /**
     * Checks to see if this student is the same as another student.
     * Returns true if this student is the same as the other student and false otherwise.
     *
     * Note: you do not need to write or modify any part of this method.
     *
     * @param other
     * @return boolean value
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Student student = (Student) other;

        if (!getId().equals(student.getId())) return false;
        if (!getName().equals(student.getName())) return false;

        return true;
    }



}
