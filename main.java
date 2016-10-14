import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
 
class main
{
   private static Vector courses = new Vector();
   private static Vector students = new Vector();
   private static Vector banner = new Vector();
   private static Vector courseNames = new Vector();
   private static Vector studentsInCourse = new Vector();
   private static Vector advancedCourse = new Vector();
   private static Vector grades = new Vector();
   private static Vector subject = new Vector();
   private static Vector number = new Vector();
   private static Vector basicCourse = new Vector();
   private static Vector prereqs = new Vector();

   public static void testFunction(String arg1)
   {
      String csvFile = arg1;
      String line = "";
      String cvsSplitBy = ",";
      Vector inside = new Vector();
      Vector outside = new Vector();
      int count = 0;
      String pHold = "";


      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
         {

            while ((line = br.readLine()) != null) 
               {
                  // use comma as separator
                  //Maybe go back and account for values in quotes that use commas
                  Vector test = new Vector();
                  String[] hold = line.split(cvsSplitBy);
                  String names = hold[6] + " " + hold[7];
                  String courseName = hold[1] + hold[2] + "." + hold[3] + "/" + hold[0];
                  int studentIndex;
                  String currentCheck;
                  int currentIndex;
                  /*try {
                     //int courseNumber = Integer.valueOf(hold[2]);
                     if (advancedCourse.contains(courseName) == false && Integer.valueOf(hold[2]) >= 200)
                        advancedCourse.add(courseName);
                  } catch ( NumberFormatException e ) {
                  }

                  try{
                     if (basicCourse.contains(courseName) == false && Integer.valueOf(hold[2]) < 200)
                        basicCourse.add(courseName);
                  } catch( NumberFormatException e ){

         
                  }*/
                  

                  /*test.add(hold[0]);   //CRN numbers
                  test.add(hold[1]);   //Subject code (ACCT, CS)
                  test.add(hold[2]);   //Course number
                  test.add(hold[3]);   //Section number
                  test.add(hold[4]);   //Grade received
                  test.add(hold[5]);   //Banner ID
                  test.add(hold[6]);   //First Name
                  test.add(hold[7]);   //Last Name*/
                  //outside.add(test);

                  if (students.contains(names) == false)
                     students.add(names);
                  studentIndex = students.indexOf(names);
                  if (banner.contains(hold[5]) == false)
                     banner.add(studentIndex, hold[5]);
                  if (courses.contains(hold[0]) == false)
                     courses.add(hold[0]);
                  if (courseNames.contains(courseName) == false)
                     courseNames.add(courseName);
                  /*if (subject.contains(hold[1]) == false && number.contains(hold[2]) == false)
                  {
                     subject.add(hold[1]);
                     currentIndex = subject.indexOf(hold[1]);
                     number.add(currentIndex, hold[2]);
                  }*/


                  if (count == 15)
                  {
                     advancedCourse.add(courseName);
                     prereqs.add(advancedCourse.indexOf(courseName), pHold);
                     pHold = "";
                     count  = 0;
                  }
                  else
                  {
                     
                        basicCourse.add(courseName);
                        pHold += courseName + ";";
                        count++;
                     
                  }

               

                  currentIndex = courseNames.indexOf(courseName);
                  try {
                     currentCheck = studentsInCourse.get(currentIndex).toString();
                     currentCheck += "," + names;
                     studentsInCourse.set(currentIndex, currentCheck);
                  } catch ( IndexOutOfBoundsException e ) {
                     studentsInCourse.add(currentIndex, names);
                  }

                  /*if (studentsInCourse.get(currentIndex) == null)
                     studentsInCourse.add(currentIndex, names);
                  else
                  {
                     currentCheck = studentsInCourse.get(currentIndex).toString();
                     currentCheck += "," + names;
                     studentsInCourse.set(currentIndex, currentCheck);
                  }*/

               }

         } catch (IOException e) {
            e.printStackTrace();
        }

         /*
         //displays number of elements of all vectors
         System.out.println(students.size() + ";" + banner.size() + ";" + courses.size() + ";" + courseNames.size());
         
         //display contents of students vector
         for (int i = 0; i < students.size();i++)
            System.out.println(students.get(i));
         //display contents of banner vector
         for (int i = 0; i < banner.size(); i++)
            System.out.println(banner.get(i));
         //display contents of courses vector
         for (int i = 0; i < courses.size(); i++)
            System.out.println(courses.get(i));
         //display contents of courseNames vector
         for (int i = 0; i < courseNames.size(); i++)
            System.out.println(courseNames.get(i));
         //displays all students in each course
         System.out.println(studentsInCourse.size());
         for (int i = 0; i < studentsInCourse.size(); i++)
            System.out.println(courseNames.get(i) + ":" + studentsInCourse.get(i));
            
            return;
          */
            //System.out.println(advancedCourse.size() + " " + basicCourse.size());
            //for (int i = 0; i < advancedCourse.size(); i++)
            //   System.out.println(advancedCourse.get(i));
            //System.out.println(basicCourse.size());
            //for (int i = 0; i < basicCourse.size(); i++)
            //   System.out.println(basicCourse.get(i));
           }


   public static void checkClass(String arg1)
   {
      //System.out.println("test");
      String output;
      int indexC;
      if (courseNames.contains(arg1) == false)
      {
         System.out.println( "No course exists.");
         return;
      }
      int index = courseNames.indexOf(arg1);
      output = studentsInCourse.get(index).toString();
      System.out.println("Students in the course are: " + output);
      if (advancedCourse.contains(arg1) == false)
         System.out.println("No prereqs for this course.");
      else
      {
         indexC = advancedCourse.indexOf(arg1);
         System.out.println("Prerequisites for this class are: " + prereqs.get(index));
      }
      return;
   }

   public static void main(String args[])
   {
      int a;
      float b;
      String s;
      String csv = "WorkingCopy.csv";


      Scanner in = new Scanner(System.in);

      System.out.println("Using filename: \"WorkingCopy.csv\"");
      //csv = in.nextLine();
      testFunction(csv);
      System.out.println("Enter a course name. ex(CS220.1/14812)");
      //s = in.nextLine();
      s = in.nextLine();
      while(true)
      {
         checkClass(s);
         s = in.nextLine();
      }
      /*while (true)
      {
         if (s == "quit")
            break;
         System.out.println(s);
         checkClass(s);
         s = in.nextLine();
         System.out.println("Enter a course name.");
      }*/


 
      /*System.out.println("Enter a string");
      s = in.nextLine();
      System.out.println("You entered string "+s);
 
      System.out.println("Enter an integer");
      a = in.nextInt();
      System.out.println("You entered integer "+a);
 
      System.out.println("Enter a float");
      b = in.nextFloat();
      System.out.println("You entered float "+b);*/
   }


}