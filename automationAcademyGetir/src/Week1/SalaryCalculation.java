package Week1;

import java.util.Scanner;

public class SalaryCalculation {

    public static void main(String[] args) {

        int baseSalary = 0;
        int workingHourStandard = 40;
        int workingHourStandardforWeekend = 10;
        int weekdayWorkingHours = 0;
        int weekendWorkingHours = 0;
        int perHourSalary = 0;
        double totalWeekSalary= 0.0;
        double overallSalary;
        /**Homework:
         *
         * Base salary must be at least 1000 euros.
         * The weekly working hour standard is 40 hours per week.
         * If the employee has worked less than 40 hours, her/his salary should be reduced proportionally
         * For every hour worked on weekdays over 40 hours, 1.5 times the hourly unit wage is paid.
         * For every hour worked on weekends over 40 hours, 2 times the hourly unit wage is paid.
         * If the employee has worked at least 40 hours during the week and more than 10 hours on the weekend, he or she will receive an additional bonus of $500.**/

        // Test Data

        /**
         Enter Salary:
         1000
         Enter working hours:
         56
         Enter working weekday hours:
         45
         **/
//----
        //Base salary must be at least 1000 euros.
        System.out.println("Enter Salary:");
        Scanner scanner =new Scanner(System.in);
        baseSalary = scanner.nextInt();
        if (baseSalary < 1000 ) {
            System.out.println("We can not give less than 1000 Euro as a sallary because of that we set 1000 Euro as Salary.");
            baseSalary = 1000;
        }

        // The weekly working hour standard is 40 hours per week.

        System.out.println("Enter working weekday hours:");
        scanner =new Scanner(System.in);
        weekdayWorkingHours = scanner.nextInt();

        System.out.println("Enter working weekend hours:");
        scanner =new Scanner(System.in);
        weekendWorkingHours = scanner.nextInt();

        // If the employee has worked less than 40 hours, her/his salary should be reduced proportionally
        perHourSalary = baseSalary /workingHourStandard;

        // For every hour worked on weekdays over 40 hours, 1.5 times the hourly unit wage is paid.

        int extraWeekdayPayment= weekdayWorkingHours - workingHourStandard;
        double extraSalaryforWeekday = extraWeekdayPayment * ( perHourSalary * 1.5 );
        totalWeekSalary = totalWeekSalary + extraSalaryforWeekday;
        Double salary=(extraSalaryforWeekday+baseSalary);


        // For every hour worked on weekends over 40 hours, 2 times the hourly unit wage is paid.

        double extraSalaryforWeekend = weekendWorkingHours * ( perHourSalary * 2 );
        totalWeekSalary = totalWeekSalary +extraSalaryforWeekend;
        Double salary1=(extraSalaryforWeekend+baseSalary);
        overallSalary = totalWeekSalary+baseSalary;

        // System.out.println("Total Weekly Salary: " +(overallSalary));

        // If the employee has worked at least 40 hours during the week and more than 10 hours on the weekend, he or she will receive an additional bonus of $500.**/
        if (weekdayWorkingHours>=workingHourStandard && weekendWorkingHours>=workingHourStandardforWeekend)
        {
            overallSalary = overallSalary + 500;
            System.out.println("Total Weekly Salary with Promotion: " +(overallSalary));
        }
        else if(weekendWorkingHours > 0)
            System.out.println("Total Weekly Salary without Promotion: " +(salary1));
        else
            System.out.println("Total Weekly Salary without Promotion: " +(salary));
    }
}



