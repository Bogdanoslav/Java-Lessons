package block_9.modelShape;

import block_9.abstractClasses.Shape;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public  double calcPerimeter() {
        return  a + b + c;
    }

    @Override
    public  double calcArea() {
        double p = calcPerimeter()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", p = " + this.calcPerimeter()+
                ", s = " + this.calcArea()+
                "}";
    }
}
