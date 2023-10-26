public class Quadrate extends GeometricFigure{

    private double x, y;
    private double side;

    Quadrate(double x, double y, double side){
        this.x = x;
        this.y = y;
        this.side = side;
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
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean isDoteInside(double x, double y) {
        return false;
    }


}
