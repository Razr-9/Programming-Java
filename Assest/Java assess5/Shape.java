/**
 * Shape
 */
public abstract class Shape {
    private double radius;
    private double width;
    private double height;

    Shape() {

    }

    public void setRadius(double r) {
        this.radius = r;
    }
    public void setWidth(double w) {
        this.width = w;
    }
    public void setHeight(double h){
        this.height = h;
    }
    public double getRadius() {
        return radius;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    
    public double perimeter() {
        return 0;
    }

    public double area() {
        return 0;
    }

    public String toString() {
        return "Shape" + "()";
    }
}