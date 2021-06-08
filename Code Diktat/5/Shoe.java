public class Shoe extends Item {
    
    private int size;
    private String color;

    public Shoe(){}

    public Shoe(int size,String color,String brand,String name,int price){
        setSize(size);
        setColor(color);
        setBrand(brand);
        setName(name);
        setPrice(price);
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return String.format("%-30s%-5s%s%n",getName(),Integer.toString(getSize()),Integer.toString(getPrice()));
    }
}
