public class Food extends Item {
    private int HP;

    public Food(String shortName, String longName, int HP) {
        super(shortName, longName);
        this.HP = HP;
    }
    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
