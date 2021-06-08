// Code super class dari Square
public abstract class TwoDimensionalShape extends Shape {
    
    public abstract Double getArea() {}

    public abstract Double getCircumference() {}

    public void showDetail() {
        System.out.println("Area of "+ toString()+" is: "+getArea());
        System.out.println("Circumference of "+ toString()+" is: "+ getCircumference());
    }
}