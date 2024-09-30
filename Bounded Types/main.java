public class main{
public static void main(String args[]){
Circle circle = new Circle(5);
Rectangle rectangle = new Rectangle(4,6);

ShapeBox<Circle> circleBox = new ShapeBox<>(circle);
ShapeBox<Rectangle> rectangleBox = new ShapeBox<>(rectangle);

System.out.println("Area of Circle: "+ circleBox.calculateArea());
System.out.println("Area of Rectangle: "+ rectangleBox.calculateArea());
}
}

interface Shape{
double area();
}

class Circle implements Shape{
private double radius;

public Circle(double radius){
this.radius = radius;
}

public double area(){
return Math.PI * radius * radius;
}
}

class Rectangle implements Shape{
private double width;
private double height;

public Rectangle(double width, double height){
this.width = width;
this.height = height;
}

public double area(){
return width * height;
}
}

class ShapeBox<T extends Shape>{
private T shape;

public ShapeBox(T shape){
this.shape = shape;
}

public double calculateArea(){
return shape.area();
}
}

