package implementation;

import java.util.*;

public class Prereq{
	private Vector studentIDs = new Vector();
	private Vector courses = new Vector();
	private Vector advancedCourse = new Vector();
	private Vector studentNames = new Vector();

/*------------------------------------------------------------*/

	public int getCourses(){return courses.size();}
	public int getStudents(){return studentIDs.size();}

	public boolean checkPrereq(String course)
	{
		if (advancedCourse.contains(course))
			return true;
		return false;
	}

	public void enroll ( String id, String course )
	{
		if (studentIDs.contains(id) == false)
			studentIDs.addElement(id);
		if (courses.contains(course) == false)
			courses.addElement(course);
	}

	public void courseCheck ( String course, String prereq)
	{
		if(advancedCourse.contains(course) == false)
			advancedCourse.addElement(course);
	}

	public void associate ( String name, String id)
	{
		if (studentIDs.contains(id) == false && studentNames.contains(name) == false)
		{
			int hold;
			studentIDs.addElement(id);
			hold = studentIDs.indexOf(id);
			studentNames.add(hold, name);
		}

		else if (studentIDs.contains(id))
		{
			int hold = studentIDs.indexOf(id);
			studentNames.add(hold, name);
		}

		else if (studentNames.contains(name))
		{
			int hold = studentNames.indexOf(name);
			studentIDs.add(hold, name);
		}

		//System.out.println(studentIDs.indexOf(id));
		//System.out.println(studentNames.indexOf(name));
	}

	public boolean associated ( String name, String id)
	{
		if (studentIDs.indexOf(id) == studentNames.indexOf(name))
			return true;
		return false;
	}	

}