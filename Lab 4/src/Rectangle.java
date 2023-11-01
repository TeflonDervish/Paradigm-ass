public class Rectangle  extends GeometricFigure{
    private double x1, y1, x2, y2, x3, y3;
    private double SideA, SideB;

    Rectangle(double x1, double y1, double x2, double y2, double x3, double y3){
        this.x1 = x1; this.x2 = x2; this.x3 = x3;
        this.y1 = y1; this.y2 = y2; this.y3 = y3;
        this.SideA = GeometricFigure.calculateDistance(x1, y1, x2, y2);
        this.SideB = GeometricFigure.calculateDistance(x2, y2, x3, y3);
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
        this.x1 += x; this.x2 += x; this.x3 += x;
        this.y1 += y; this.y2 += y; this.y3 += y;
    }

    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public boolean isDoteInside(double x, double y) {
        return x - this.x1 <= SideA && y - this.y1 <= SideB;
    }

}
