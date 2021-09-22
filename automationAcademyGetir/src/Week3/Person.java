package Week3;

public class Person {

    int age= 0;
    String name = null;
    String surname = null;
    String gender = null;
    int year=0;


        public Person()
        {
            this.age = age;
            this.name = name;
            this.surname = surname;
            this.gender = gender;
        }

        //teacher
        public Person(int age, String name, String surname, String gender)
        {
            this.age = age;
            this.name = name;
            this.surname = surname;
            this.gender = gender;
        }

        //student
        public Person(int age, String name, String surname, String gender,int year)
        {
            this.age = age;
            this.year = year;
            this.name = name;
            this.surname = surname;
            this.gender = gender;
        }
    public void printStudent() {
        System.out.println(this.name + " " + this.surname +  " is " + this.gender + ". And his class is " + this.year + ". His age is " + this.age );
    }
    public void printTeacher() {
        System.out.println(this.name + " " + this.surname +  " is " + this.gender + ". His age is " + this.age );
    }
}
