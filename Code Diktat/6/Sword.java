public class Sword extends Item implements Weapon{
    
    public Sword(){
        setName("Sword");
    }

    @Override
    public int getDamage() {
        return 9;
    }

    @Override
    public void attack(GameCharacter attacker, GameCharacter enemy) {
        if(((Monster) enemy).isFlyingUnit()==true){
            System.out.println("Enemy out of range");
        }
        else{
            int damage = (int) (attacker.getCurrentStrength()*Math.floor(Math.random() * 10) + 1);
            enemy.setCurrentHealth(enemy.getCurrentHealth()-damage);
            System.out.printf("Hero do %d kepada Monster%n",damage);
        }
    }

    public String toString(){
        return String.format("%-15s%s%n",getName(),getDamage());
    }
}
