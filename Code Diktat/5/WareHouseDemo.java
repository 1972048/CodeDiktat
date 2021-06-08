import java.util.Scanner;

public class WareHouseDemo {
    
    public static void main(String[] args) {
        // LOCAL VARIABLES DECLARATION
		// ================================================
		int c,atti;
        String atts;
        Shirt shirt;
        Shirt.Size size;
        Shoe shoe;
        WareHouse wareHouse;
        WareHouseManager wareHouseManager;

		// ALGORITHM
		// ================================================
		Scanner scanner = new Scanner(System.in);
        wareHouse = new WareHouse();
        wareHouseManager = new WareHouseManager(wareHouse);
        do{
            System.out.printf("================================================%n1. Add shoe%n2. Add shirt%n3. View all item%n4. Exit%nChoice: ");
            c=scanner.nextInt();
            if(c==1){
                shoe = new Shoe();
                scanner.nextLine();
                System.out.print("Brand: ");
                atts = scanner.nextLine();
                shoe.setBrand(atts);
                System.out.print("Name: ");
                atts = scanner.nextLine();
                shoe.setName(atts);
                System.out.print("Color: ");
                atts = scanner.nextLine();
                shoe.setColor(atts);
                System.out.print("Size: ");
                atti = scanner.nextInt();
                shoe.setSize(atti);
                System.out.print("Price: ");
                atti = scanner.nextInt();
                shoe.setPrice(atti);
                wareHouseManager.addItemToWareHouse(shoe);
            }
            else if(c==2){
                shirt = new Shirt();
                scanner.nextLine();
                System.out.print("Brand: ");
                atts = scanner.nextLine();
                shirt.setBrand(atts);
                System.out.print("Name: ");
                atts = scanner.nextLine();
                shirt.setName(atts);
                System.out.print("Size[XS,S,M,L,XL,XXL]: ");
                atts = scanner.nextLine();
                size = null;
                if(atts.equals("XS")){
                    size=Shirt.Size.XS;
                }
                else if(atts.equals("S")){
                    size=Shirt.Size.S;
                }
                else if(atts.equals("M")){
                    size=Shirt.Size.M;
                }
                else if(atts.equals("L")){
                    size=Shirt.Size.L;
                }
                else if(atts.equals("XL")){
                    size=Shirt.Size.XL;
                }
                else if(atts.equals("XXL")){
                    size=Shirt.Size.XXL;
                }
                shirt.setSize(size);
                System.out.print("Price: ");
                atti = scanner.nextInt();
                shirt.setPrice(atti);
                wareHouseManager.addItemToWareHouse(shirt);
            }
            else if(c==3){
                wareHouseManager.viewItemInWareHouse();
            }
            else if(c==4){
                scanner.close();
            }
        }
        while(c!=4);
    }
}
