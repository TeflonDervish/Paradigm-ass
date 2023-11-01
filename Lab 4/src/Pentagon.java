public class Pentagon extends GeometricFigure{
    private double x1, y1;
    private double x2, y2;
    private double x3, y3;
    private double x4, y4;
    private double x5, y5;

    Pentagon(double x1, double x2, double x3, double x4, double x5, double y1, double y2, double y3, double y4, double y5){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
        this.y5 = y5;
    }
    @Override
    public double calculatePerimeter(){
        double a = GeometricFigure.calculateDistance(x1, y1, x2, y2);
        double b = GeometricFigure.calculateDistance(x2, y2, x3, y3);
        double c = GeometricFigure.calculateDistance(x3, y3, x4, y4);
        double d = GeometricFigure.calculateDistance(x4, y4, x5, y5);
        double e = GeometricFigure.calculateDistance(x5, y5, x1, y1);
        return a + b + c + d + e;
    }
    @Override
    public double calculateArea(){
        Triangle t1 = new Triangle(x1, x2, x3, y1, y2, y3);
        Triangle t2 = new Triangle(x1, x4, x3, y1, y4, y3);
        Triangle t3 = new Triangle(x1, x4, x5, y1, y4, y5);
        return t1.calculateArea() + t2.calculateArea() + t3.calculateArea();
    }
    @Override
    public void Move(double x, double y){
        this.x1 += x; this.x2 += x; this.x3 += x; this.x4 += x; this.x5 += x;
        this.y1 += y; this.y2 += y; this.y3 += y; this.y4 += y; this.y5 += y;
    }

    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public boolean isDoteInside(double x, double y) {
        Triangle t1 = new Triangle(x1, x2, x3, y1, y2, y3);
        Triangle t2 = new Triangle(x1, x4, x3, y1, y4, y3);
        Triangle t3 = new Triangle(x1, x4, x5, y1, y4, y5);
        return t1.isDoteInside(x, y) || t2.isDoteInside(x, y) || t3.isDoteInside(x, y);
    }

    public boolean isInclude(Pentagon t1){
        return this.isDoteInside(t1.x1, t1.y1) &&
                this.isDoteInside(t1.x2, t1.y2) &&
                this.isDoteInside(t1.x3, t1.y3) &&
                this.isDoteInside(t1.x4, t1.y4) &&
                this.isDoteInside(t1.x4, t1.y4);
    }
    public boolean isIntersect(Pentagon t1) {
        return (this.isDoteInside(t1.x1, t1.y1) ||
                this.isDoteInside(t1.x2, t1.y2) ||
                this.isDoteInside(t1.x3, t1.y3) ||
                this.isDoteInside(t1.x4, t1.y4) ||
                this.isDoteInside(t1.x5, t1.y5)) &&
                !this.isInclude(t1);
    }

}
