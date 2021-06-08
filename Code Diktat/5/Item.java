public abstract class Item {
    
    private String brand,name;
    private int  price;

    public Item(){}

    public Item(String brand,String name,int price){
        setBrand(brand);
        setName(name);
        setPrice(price);
    }

    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String toString(){
        return null;
    }
}
