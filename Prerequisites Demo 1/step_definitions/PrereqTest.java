package step_definitions;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import implementation.Prereq;
import static org.junit.Assert.*;

public class PrereqTest{
Prereq prereq = new Prereq();
	@Given("^student \"(.*?)\" takes course \"(.*?)\"$")
	public void studentTakesCourse(String arg1, String arg2) throws Throwable {
	    prereq.enroll(arg1, arg2);
	}

	@Then("^number of courses is (\\d+)$")
	public void numberOfCoursesIs(int arg1) throws Throwable {
	    assertEquals(prereq.getCourses(), arg1);
	}

	@Then("^number of students is (\\d+)$")
	public void numberOfStudentsIs(int arg1) throws Throwable {
	    assertEquals(prereq.getStudents(), arg1);
	}

	@Given("^course \"(.*?)\" has prereq \"(.*?)\"$")
	public void courseHasPrereq(String arg1, String arg2) throws Throwable {
	   	prereq.courseCheck(arg1, arg2);
	}

	@Then("^\"(.*?)\" has a prereq is \"(.*?)\"$")
	public void hasAPrereqIs(String arg1, boolean arg2) throws Throwable {
	    assertEquals(prereq.checkPrereq(arg1), arg2);
	}

	@Given("^student named \"(.*?)\" has ID \"(.*?)\"$")
	public void studentNamedHasID(String arg1, String arg2) throws Throwable {
	    prereq.associate(arg1, arg2);
	}

	@Then("^\"(.*?)\" is associated with \"(.*?)\"$")
	public void isAssociatedWith(String arg1, String arg2) throws Throwable {
	    assertEquals(prereq.associated(arg1, arg2), true);
	}
}