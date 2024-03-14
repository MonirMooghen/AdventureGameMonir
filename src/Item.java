public class Item {
    protected String longName;
    protected String shortName;

    //****CONSTRUCTOR***** (Opskriften på objektet)
    public Item(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    //****SETTER**** (Gør så man kan overskrive data)
//    public void setLongName(String longName) {
//        this.longName = longName;
//    }

//    public void setShortName(String shortName) {
//        this.shortName = shortName;
//    }

    //****GETTER**** (Henter privat data, så du kan aflæse det)
    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }
    @Override
    public String toString() {
        return longName;
    }
}
