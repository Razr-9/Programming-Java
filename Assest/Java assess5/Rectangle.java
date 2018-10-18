/**
 * Rectangle
 */
public class Rectangle extends Shape{

    Rectangle(double w,double h){
        setWidth(w);
        setHeight(h);
    }

    public double perimeter() {
        return 2*(getWidth()+getHeight());
    }
    public double area() {
        return getWidth()*getHeight();
    }
    public String toString() {
        return "Rectangle" + "(" + getWidth() + "," + getHeight() + ")";
    }
}