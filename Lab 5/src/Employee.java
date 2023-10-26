import java.util.Date;

public class Employee extends Person {
    private Department department;
    private Position position;
    private double salary;

    public Employee(String lastName, String firstName, String middleName, Date birthDate, String gender) {
        super(lastName, firstName, middleName, birthDate, gender);
    }

    public void hire(Department department, Position position, double salary) {
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public void fire() {
        this.department = null;
        this.position = null;
        this.salary = 0;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}