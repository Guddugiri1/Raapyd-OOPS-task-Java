// Main.java

public class Main {

    public static void main(String[] args) {
        // Creating objects of different shapes
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(3, 4);
        Shape triangle = new Triangle(3, 4, 5);

        // Displaying the area and perimeter of each shape
        displayShapeInfo("Circle", circle);
        displayShapeInfo("Rectangle", rectangle);
        displayShapeInfo("Triangle", triangle);
    }

    public static void displayShapeInfo(String shapeName, Shape shape) {
        System.out.println("Shape: " + shapeName);
        System.out.println("Area: " + shape.area());
        System.out.println("Perimeter: " + shape.perimeter());
        System.out.println();
    }
}
