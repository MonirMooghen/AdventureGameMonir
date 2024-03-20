public abstract class Weapon extends Item {
    public int damage;
    private int remainingUses;
    private int useWeapon;
    protected boolean isRangedWeapon;

    public Weapon(String shortName, String longName, int damage, boolean isRangedWeapon){
        super(shortName, longName);
        this.damage = damage;
        this.isRangedWeapon = isRangedWeapon;
    }
    public int getDamage() {
        return damage;
    }
    public abstract int remainingUses();

    public abstract void useWeapon();
}