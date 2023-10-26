public class Tetragon {
    private double x1, y1;
    private double x2, y2;
    private double x3, y3;
    private double x4, y4;

    Tetragon(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
    }

    public double calculatePerimeter(){
        double a = GeometricFigure.calculateDistance(x1, y1, x2, y2);
        double b = GeometricFigure.calculateDistance(x1, y1, x3, y3);
        double c = GeometricFigure.calculateDistance(x2, y2, x3, y3);
        double d = GeometricFigure.calculateDistance(x2, y2, x3, y3);
        return a + b + c;
    }

}
