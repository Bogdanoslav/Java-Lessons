package block_9.modelShape;

import block_9.abstractClasses.Shape;

public class Rectangle extends Shape {
    private double a, b;


    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calcPerimeter() {
        return (a + b) * 2;
    }

    @Override
    public double calcArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", p = " + this.calcPerimeter()+
                ", s = " + this.calcArea()+
                "}";
    }
}
