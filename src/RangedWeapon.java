public class RangedWeapon extends Weapon {
    int ammo;
    public RangedWeapon(String shortName, String longName, int damage, int ammo) {
        super(shortName, longName, damage);
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
}