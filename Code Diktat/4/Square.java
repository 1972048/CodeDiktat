public class Square extends TwoDimensionalShape {
    
    private Double lenghtOfSide;

    public Double getLenghtOfSide() {
        return this.lenghtOfSide;
    }

    public void setLenghtOfSide(Double lenghtOfSide) {
        this.lenghtOfSide = lenghtOfSide;
    }
    // Contoh overide
    @Override
    public Double getArea() {
        Double Area = this.base * this.height;
        Area = (double) (Math.round(Area*100))/100;
        return Area;
    }

    @Override
    public Double getCircumference() {
        Double Circumference = (this.base + this.height) * 2;
        Circumference = (double) (Math.round(Circumference*100))/100;
        return Circumference;
    }

    public String toString() {
        return getClass().getName();
    }
}