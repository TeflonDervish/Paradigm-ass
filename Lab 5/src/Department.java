import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Department parent;
    private List<Department> subDepartments;

    public Department(String name) {
        this.name = name;
        this.subDepartments = new ArrayList<>();
    }

    public void addSubDepartment(Department subDepartment) {
        subDepartments.add(subDepartment);
        subDepartment.setParent(this);
    }

    public String getName() {
        return name;
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
}