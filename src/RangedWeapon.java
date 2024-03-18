public class RangedWeapon extends Weapon {
    int ammo;
    public RangedWeapon(String shortName, String longName, int damage, int ammo) {
        super(shortName, longName, damage, true);
        this.ammo = ammo;
    }
    @Override
    public int getAmmo() {
        return ammo;
    }
    public boolean hasAmmo(){
        if (ammo<0) {
            return false;
        } else {
            return true;
        }
    }

    // -- betyder -1;
    @Override
    public void useWeapon() {
        ammo--;
    }
}