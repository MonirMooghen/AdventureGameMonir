public abstract class Weapon extends Item {
    public int damage;

    public Weapon(String shortName, String longName, int damage) {
        super(shortName, longName);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    abstract int getAmmo();

}
