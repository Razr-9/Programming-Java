/**
 * Circle
 */
public class Circle extends Shape {

    Circle(double r){
        setRadius(r);
    }

    public double perimeter() {
        return 2*getRadius()*Math.PI;
    }
    public double area() {
        return getRadius()*getRadius()*Math.PI;
    }
    public String toString() {
        return "Circle" + "(" + getRadius() + ")";
    }
    
}