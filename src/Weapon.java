public abstract class Weapon extends Item {
    public int damage;

    public Weapon(String shortName, String longName, int damage, boolean hasAmmo){
        super(shortName, longName);
        this.damage = damage;
        this.hasAmmo = hasAmmo;
    }
    public int getDamage() {
        return damage;
    }
    public abstract int remainingUses();

    public abstract void useWeapon();
}