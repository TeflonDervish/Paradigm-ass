public class Quadrate extends GeometricFigure{

    private double x1, y1, x2, y2, x3, y3;
    private double side;

    Quadrate(double x1, double y1, double x2, double y2, double x3, double y3){
        this.x1 = x1;
        this.y1 = y2;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.side = GeometricFigure.calculateDistance(x1, y1, x2, y2);
    }

    @Override
    public double calculatePerimeter() {
        return this.side * 4;
    }
    @Override
    public double calculateArea(){
        return this.side * this.side;
    }
    @Override
    public void Move(double x, double y){
        this.x1 += x; this.x2 += x; this.x3 += x;
        this.y1 += y; this.y2 += y; this.y3 += y;
    }

    @Override
    public boolean isDoteInside(double x, double y) {
        return x - this.x1 <= side && y - this.y1 <= side;
    }

    @Override
    public boolean isExist(){
        return GeometricFigure.calculateDistance(x2, y2, x3, y3) == side;
    }

}
