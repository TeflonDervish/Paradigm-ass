public abstract class GeometricFigure {
    public abstract double calculatePerimeter();
    public abstract double calculateArea();
    public abstract void Move(double x, double y);
    public abstract boolean isDoteInside(double x, double y);

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }



}
