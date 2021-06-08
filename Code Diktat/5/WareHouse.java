import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    
    private List <Item> items;

    public WareHouse(){
        items = new ArrayList <Item>();
    }

    public void addItemToList(Item item) {
        items.add(item);
    }

    public void showAllData(){
        for (Item item : items){
            if(item instanceof Shirt){
                System.out.printf(item.toString());
            }
        }
        for (Item item : items){
            if(item instanceof Shoe){
                System.out.printf(item.toString());
            }
        }
    }
}