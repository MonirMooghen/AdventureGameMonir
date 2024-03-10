import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;

    //constructor that sets the room where the player spawns.
    public Player (Room firstRoom){
        this.currentRoom = firstRoom;
        this.inventory = new ArrayList<>();
    }

    // methods so the player can move to different rooms
    public void goNorth(){
        if (currentRoom.getNorth() !=null){
            currentRoom = currentRoom.getNorth();
            System.out.println("going north");
            currentRoomPrint();
        } else {
            notPossible();
        }
    }
    public void goSouth(){
        if (currentRoom.getSouth() !=null){
            currentRoom = currentRoom.getSouth();
            System.out.println("going south");
            currentRoomPrint();
        } else {
            notPossible();
        }
    }
    public void goEast(){
        if (currentRoom.getEast() !=null){
            currentRoom = currentRoom.getEast();
            System.out.println("going east");
            currentRoomPrint();
        } else {
            notPossible();
        }
    }
    public void goWest(){
        if (currentRoom.getWest() !=null){
            currentRoom = currentRoom.getWest();
            System.out.println("going west");
            currentRoomPrint();
        } else {
            notPossible();
        }
    }
    //current room name and description
    public void currentRoomPrint() {
        System.out.println(currentRoom.getName() + " " + currentRoom.getDescription());
    }

    public void notPossible() {
        System.out.println("You cannot go there");
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    private Item findItemInInventory(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }
    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }
    public Item dropItem(String shortName) {
        Item pickedItem = findItemInInventory(shortName);
        if (pickedItem != null) {
            removeItem(pickedItem);
            getCurrentRoom().addItem(pickedItem);
        }
        return pickedItem;
    }

    public Item takeItem(String shortName) {
        Item pickedItem = getCurrentRoom().removeItem(shortName);
        addItem(pickedItem);
        return pickedItem;
    }

    //makes the move methods work with string input.
    public void move(String input) {
        switch (input.toLowerCase()) {
            case "go north":
            case "north":
            case "n":
                goNorth();
                break;
            case "go south":
            case "south":
            case "s":
                goSouth();
                break;
            case "go west":
            case "west":
            case "w":
                goWest();
                break;
            case "go east":
            case "east":
            case "e":
                goEast();
                break;
        }
    }

}
