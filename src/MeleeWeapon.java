public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String shortName, String longName, int damage) {
        super(shortName, longName, damage);
    }

    public boolean hasAmmo(){
        return true;
    }

    @Override
    public int getAmmo() {
        return 0;
    }
}
