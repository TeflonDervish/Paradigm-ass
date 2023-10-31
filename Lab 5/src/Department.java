import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Department implements Comparator<Department> {
    private String name;
    private Department parent;
    private List<Department> subDepartments;

    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.subDepartments = new ArrayList<>();
    }

    public void addSubDepartment(Department subDepartment) {
        subDepartments.add(subDepartment);
        subDepartment.setParent(this);
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public int getEmployeeCount() {
        int count = employees.size();
        for (Department subDepartment : subDepartments) {
            count += subDepartment.getEmployeeCount();
        }
        return count;
    }

    public double getAverageSalary() {
        if (employees.isEmpty()) return 0;

        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.size();
    }

    public double getTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public void displayInfo() {
        System.out.println("Подразделение: " + name);
        if (parent != null) {
            System.out.println("Главное подразделение: " + parent.getName());
        }
        System.out.println("Подчиненные подразделения:");
        for (Department subDepartment : subDepartments) {
            System.out.println("- " + subDepartment.getName());
        }
    }

    public int compare(Department dep1, Department dep2) {
        return Integer.compare(dep1.getEmployeeCount(), dep2.getEmployeeCount());
    }
}