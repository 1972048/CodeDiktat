public class WareHouseManager {

    private WareHouse wareHouse;
    
    public WareHouseManager(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }

    public void addItemToWareHouse(Item item){
        this.wareHouse.addItemToList(item);
    }

    public void viewItemInWareHouse() {
        this.wareHouse.showAllData();
    }

}
