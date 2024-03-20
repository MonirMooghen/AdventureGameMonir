public class RangedWeapon extends Weapon {
    int ammo;
    public RangedWeapon(String shortName, String longName, int damage, int ammo) {
        super(shortName, longName, damage, true);
        this.ammo = ammo;
    }

    @Override
    public int remainingUses(){
        return ammo;
    }

    // -- betyder -1;
    @Override
    public void useWeapon() {
        ammo--;
    }
}