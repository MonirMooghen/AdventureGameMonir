public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String shortName, String longName, int damage) {
        super(shortName, longName, damage, false);
    }

    @Override
    public int remainingUses(){
        return 1;
    }
    @Override
    public void useWeapon() {
    }
}