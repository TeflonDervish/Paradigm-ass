public abstract class GeometricFigure {
    public abstract double calculatePerimeter();
    public abstract double calculateArea();
    public abstract void Move(double x, double y);
    public abstract boolean isDoteInside(double x, double y);

    public static double calculateDistance(double x1, double y1,
                                           double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


    public static int Compare(GeometricFigure g1, GeometricFigure g2){
        double area1 = g1.calculateArea();
        double area2 = g2.calculateArea();

        if (area1 > area2) return 1;
        else if (area1 < area2) return -1;
        else return 0;
    }

    public static boolean IsIntersect(GeometricFigure ob1, GeometricFigure ob2) {
        return ob1.calculateArea() > 0 && ob2.calculateArea() > 0;
    }

    public static boolean IsInclude(GeometricFigure ob1, GeometricFigure ob2) {
        return ob1.calculateArea() > ob2.calculateArea();
    }


}
