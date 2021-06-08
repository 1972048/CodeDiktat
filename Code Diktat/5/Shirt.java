public class Shirt extends Item {

    enum Size{
        XS,S,M,L,XL,XXL
    }

    private Size size;
    
    public Shirt(){}

    public Shirt(Size size,String brand,String name,int price){
        setSize(size);
        setBrand(brand);
        setName(name);
        setPrice(price);
    }
    
    public Size getSize(){
        return size;
    }

    public void setSize(Size size2){
        this.size=size2;
    }

    public String toString() {
        return String.format("%-30s%-5s%s%n",getName(),size,Integer.toString(getPrice()));
    }
}