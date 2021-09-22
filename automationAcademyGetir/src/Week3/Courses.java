package Week3;

public class Courses {

    int credit= 0;
    String name = null;
    int studentCount = 0;

    public Courses(int credit, String name,int studentCount)
    {
        this.credit = credit;
        this.name = name;
        this.studentCount = studentCount;

    }
    public Courses()
    {
        this.credit = credit;
        this.name = name;
        this.studentCount = studentCount;
    }

    public void printCourse() {
        System.out.println(this.name + ", credit is " + this.credit + " and student count " + this.studentCount );
    }
}
