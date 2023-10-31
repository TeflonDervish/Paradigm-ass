public class Triangle extends GeometricFigure{

    private double x1, y1;
    private double x2, y2;
    private double x3, y3;

    Triangle(double x1, double x2, double x3, double y1, double y2, double y3){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    @Override
    public double calculatePerimeter(){
        double a = GeometricFigure.calculateDistance(x1, y1, x2, y2);
        double b = GeometricFigure.calculateDistance(x1, y1, x3, y3);
        double c = GeometricFigure.calculateDistance(x2, y2, x3, y3);
        return a + b + c;
    }

    @Override
    public double calculateArea(){
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

    @Override
    public void Move(double x, double y) {
        x1 += x; x2 += x; x3 += x;
        y1 += y; y2 += y; y3 += y;
    }

    @Override
    public boolean isDoteInside(double x, double y) {
        double a = (x1 - x) * (y2 - y1) - (x2 - x1) * (y1 - y);
        double b = (x2 - x) * (y3 - y2) - (x3 - x2) * (y2 - y);
        double c = (x3 - x) * (y1 - y3) - (x1 - x3) * (y3 - y);
        return (a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0);
    }
}
