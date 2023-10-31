public class Rectangle  extends GeometricFigure{
    private double x, y;
    private double SideA, SideB;

    Rectangle(double x, double y, double SideA, double SideB){
        this.x = x;
        this.y = y;
        this.SideA = SideA;
        this.SideB = SideB;
    }
    @Override
    public double calculatePerimeter() {
        return this.SideA * 2 + this.SideB * 2;
    }
    @Override
    public double calculateArea(){
        return this.SideA * this.SideB;
    }

    @Override
    public void Move(double x, double y){
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean isDoteInside(double x, double y) {
        return x - this.x <= SideA && y - this.y <= SideB;
    }

    @Override
    public boolean IsBigger(GeometricFigure figure) {
        return this.calculateArea() > figure.calculateArea();
    }
}
