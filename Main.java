import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        ArrayList<Employee> list = new ArrayList<>();

        int sum = 0;

        Employee highest = null;
        Employee lowest = null;

        System.out.println("Enter Employee ID, Name and Score:");

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            int score = sc.nextInt();

            Employee emp = new Employee(id, name, score);

            list.add(emp);

            sum = sum + score;

            if (highest == null || emp.score > highest.score) {
                highest = emp;
            }

            if (lowest == null || emp.score < lowest.score) {
                lowest = emp;
            }
        }

        double average = (double) sum / n;

        System.out.printf("\nAverage Score: %.2f\n", average);

        System.out.println("Highest Scorer: " + highest.name + " " + highest.score);

        System.out.println("Lowest Scorer: " + lowest.name + " " + lowest.score);

        ArrayList<Employee> qualified = new ArrayList<>();

        for (Employee emp : list) {

            if (emp.score >= average) {
                qualified.add(emp);
            }

        }

        Collections.sort(qualified, new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {

                if (e1.score != e2.score) {
                    return e2.score - e1.score;
                }

                return e1.name.compareTo(e2.name);
            }
        });

        System.out.println();

        System.out.println("Qualified Employees:");

        for (Employee emp : qualified) {
            System.out.println(emp.name + " " + emp.score);
        }

        sc.close();
    }
}