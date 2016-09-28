package implementation;

import java.util.*;

public class Prereq{
	private Vector studentIDs = new Vector();
	private Vector studentInCourse = new Vector();
	private Vector coursesPerStudent = new Vector();
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
		{
			advancedCourse.addElement(course);
			courses.addElement(course);
			int x = courses.indexOf(course);
			studentInCourse.add(x, 1);
		}

		int x = courses.indexOf(course);
		int i = (int) studentInCourse.get(x);
		//System.out.println(i);
		i++;
		studentInCourse.set(x, i);
		//System.out.println(studentInCourse.get(x));

	}

	public void courseCheck ( String course, String prereq)
	{
		courses.addElement(course);
		if(advancedCourse.contains(course) == false)
		{
			int x = courses.indexOf(course);
			advancedCourse.add(x,course);
		}
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

	public void concatCourse (String parent, String prereq)
	{
		int x = advancedCourse.indexOf(parent);
		String hold = (courses.get(x)).toString();
		//System.out.println(hold);
		hold = hold + ":" + prereq;
		courses.set(x, hold);
		//System.out.println(courses.get(x));
	}

	public int getCourseStudents(String course)
	{
		int x = courses.indexOf(course);
		//System.out.println(x);
		int i = (int) studentInCourse.get(x);
		//System.out.println(i);
		return i;
	}

}