public class Quadrate {

    private double DoteX, DoteY;
    private double Side;

    Quadrate(double DoteX, double DoteY, double Side){
        this.DoteX = DoteX;
        this.DoteY = DoteY;
        this.Side = Side;
    }

    public double calculatePerimeter() {
        return this.Side * 4;
    }

    public double calculateArea(){
        return this.Side * this.Side;
    }

}
