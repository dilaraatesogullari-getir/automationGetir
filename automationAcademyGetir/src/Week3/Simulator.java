package Week3;

import java.util.ArrayList;
import java.util.Random;

public class Simulator extends Person{

    public static void main(String args[]){
        Random random = new Random();
        Person student;
        Person teacher;
        Courses c1;
        ArrayList teacherArray= new ArrayList();
        ArrayList studentArray= new ArrayList();
        ArrayList teacherCourses= new ArrayList();
        ArrayList studentCourses= new ArrayList();

        for (int n=0;n<=random.nextInt(6);n++)
        {
            student = new Person(23,"Ali","Veli","male",2);
            Object Sstr="Name: " + student.name+ " Surname: " +student.surname +" Age: "+ student.age +" Gender: "+ student.gender +" Year: "+ student.year;
            studentArray.add(Sstr);
        }
        for (int s=0;s<=random.nextInt(6);s++)
        {
            teacher = new Person(s+20,"Teacher Name","Teacher Surname","female");
            Object Tstr="Name: " + teacher.name+ " Surname: " +teacher.surname +" Age: "+ teacher.age +" Gender: "+ teacher.gender;
            teacherArray.add(Tstr);
        }
        //Teacher Courses
        for (int j=1;j<teacherArray.size();j++)
        {
            for (int i=1;i<=3;i++)
            {
                int credit= i+4;
                String name = "Course"+i;
                int studentCount=20;
                c1 = new Courses(credit,name,studentCount);
               // c1.printCourse();

                Object crs="Name: " + c1.name+ " Credit: "+ c1.credit +" Student Count: "+ c1.studentCount;
                String teacherCourse= teacherArray.get(j) + " HAVE " + crs.toString();
                teacherCourses.add( teacherCourse);
            }
            System.out.println("For Teacher : " + teacherCourses.get(j).toString() +" ");
        }

        //Student Courses
        for (int j=1;j<studentArray.size();j++)
        {
            int totalCredit=0;
            while(totalCredit<=20)
            {
                int credit= j+4;
                String name = "Course"+j;
                int studentCount=20;
                totalCredit =totalCredit+credit;
                c1 = new Courses(credit,name,studentCount);
                Object crs="Name: " + c1.name+ " Credit: "+ c1.credit +" Student Count: "+ c1.studentCount;
                String studentCourse= studentArray.get(j) + " ENROLLED " + crs.toString() + "Total Credit: " +totalCredit;
                studentCourses.add(studentCourse);

            }
            System.out.println("For Student : " + studentCourses.get(j).toString() +" ");
        }

    }
}
