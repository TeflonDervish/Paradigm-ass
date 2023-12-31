public class Position {
    private String title;

    public Position(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
class StaffPosition extends Position {
    private Department department;

    public StaffPosition(String title) {
        super(title);
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}