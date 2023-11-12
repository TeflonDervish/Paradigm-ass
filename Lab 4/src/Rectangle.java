public class Rectangle  extends GeometricFigure{
    private double x1, y1, x2, y2, x3, y3, x4, y4;
    private double SideA, SideB;

    Rectangle(double x1, double y1, double x2, double y2, double x3, double y3){
        this.x1 = x1; this.x2 = x2; this.x3 = x3;
        this.y1 = y1; this.y2 = y2; this.y3 = y3;
        this.x4 = x3 + (x1 - x2);
        this.y4 = y4 + (y1 - y2);
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
    public boolean isDoteInside(double x, double y){
        Triangle t1 = new Triangle(x1, x2, x3, y1, y2, y3);
        Triangle t2 = new Triangle(x1, x4, x3, y1, y4, y3);
        return t1.isDoteInside(x, y) || t2.isDoteInside(x, y);
    }
    public boolean isInclude(Rectangle t1){
        return this.isDoteInside(t1.x1, t1.y1) &&
                this.isDoteInside(t1.x2, t1.y2) &&
                this.isDoteInside(t1.x3, t1.y3) &&
                this.isDoteInside(t1.x4, t1.y4);
    }
    public boolean isIntersect(Rectangle t1) {
        return (this.isDoteInside(t1.x1, t1.y1) ||
                this.isDoteInside(t1.x2, t1.y2) ||
                this.isDoteInside(t1.x3, t1.y3) ||
                this.isDoteInside(t1.x4, t1.y4)) &&
                !this.isInclude(t1);
    }
    @Override
    public boolean isExist() {
        return true;
    }

}
