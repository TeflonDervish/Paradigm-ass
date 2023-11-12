import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Position p1 = new Position("просто должность");

        Employee e1 = new Employee("1", "1", "1", new Date(1111, 11, 11), "1");
        Employee e2 = new Employee("2", "1", "1", new Date(1111, 11, 11), "1");
        Employee e3 = new Employee("3", "1", "1", new Date(1111, 11, 11), "1");

        Department d1 = new Department("1");
        Department d2 = new Department("2");
        Department d3 = new Department("3");

        d1.addSubDepartment(d2);
        d1.addSubDepartment(d3);

        d1.addEmployee(e1, p1, 14000.0);
        d1.addEmployee(e2, p1, 20000.0);
        d1.addEmployee(e3, p1, 30000.0);

        System.out.println(d1.getAverageSalary());
        System.out.println(d1.getTotalSalary());
        System.out.println(d1.getEmployeeCount());
        System.out.println();

        d1.removeEmployee(e1);

        System.out.println(d1.getAverageSalary());
        System.out.println(d1.getTotalSalary());
        System.out.println(d1.getEmployeeCount());
        System.out.println();

    }
}