public class Enemy { //Parametre - fields?
    private int health;
    private String shortName;
    private String longName;
    private boolean isEnemyDead;
    private Weapon weapon;

    public Enemy(String shortName, String longName, int health, Weapon weapon) { //Argumenter
        this.health = health; //parametre
        this.shortName = shortName;
        this.longName = longName;
        isEnemyDead = false;
        this.weapon = weapon;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isEnemyDead() {
        if(getHealth() <= 0){
            return true;
        } else {
         return false;
        }
    }

    //Samme som ovenstående, men simplere
//    public boolean isEnemyDead() {
//        return getHealth() <= 0;
    }
