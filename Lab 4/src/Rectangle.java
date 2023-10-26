public class Rectangle {
    private double x, y;
    private double SideA, SideB;

    Rectangle(double x, double y, double SideA, double SideB){
        this.x = x;
        this.y = y;
        this.SideA = SideA;
        this.SideB = SideB;
    }

    public double calculatePerimeter() {
        return this.SideA * 2 + this.SideB * 2;
    }

    public double calculateArea(){
        return this.SideA * this.SideB;
    }
}
