public class Map {
    private Room starterRoom;

    //toString maybe, if there is time
    // 9 instances of rooms, with established connections, designated room 1 to the starter room
    public void mapCreator() {
        Room room1 = new Room("Room 1", "You find yourself at the entrance to a tomb. There are two doors.");
        Room room2 = new Room("Room 2", "You enter a maze. The light is dim.");
        Room room3 = new Room("Room 3", "You're in a basement with different torture instruments. In the back, there is a door.");
        Room room4 = new Room("Room 4", "You're in a big library, lit by candles");
        Room room5 = new Room("Room 5", "You enter a gallery with statues and paintings. You can't see a way out.");
        Room room6 = new Room("Room 6", "You go down a few steps, and step on a crunchy bone. It looks like a mass grave.");
        Room room7 = new Room("Room 7", "You're in a slim foyer. There's a latch visible. ");
        Room room8 = new Room("Room 8", "You slide down to a big dining hall. There are fresh meals on the table.");
        Room room9 = new Room("Room 9", "You're in a big laboratory. You hear screaming coming from the walls");

        //items som går igen
        Item apple = new Item("Apple", "A good looking apple");

        // room 1
        room1.setEast(room2);
        room1.setSouth(room4);
        //adder et item direkte
        room1.addItem(new Item("torch", "A long torch"));
        room1.addItem(new Food("banana", "A healthy looking banana", 10));
        room1.addItem(new RangedWeapon("AK-47", "An AK-47, a military level machine gun with a few rounds of ammo left", -15, 6));
        room1.addItem(new MeleeWeapon("sword", "a long sword with a golden handle", -20));

        // room 2
        room2.setEast(room3);
        room2.setWest(room1);
        room2.addItem(new Food("potion", "A magical potion with a strange substance in it", -10));

        // room 3
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItem(new MeleeWeapon("knife", "A dull knife with a rusty blade", -10));

        // room 4
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.addItem(new Item("book", "A book with magical spells in it"));

        // room 5
        room5.setSouth(room8);


        // room 6
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.addItem(new Item ("skull", "A skull with golden teeth"));

        // room 7
        room7.setNorth(room4);
        room7.setEast(room8);

        // room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room8.addItem(apple);

        // room 9
        room9.setNorth(room6);
        room9.setWest(room8);
        room9.addItem(new Item ("key", "A golden key"));

        //the starter room
        starterRoom = room1;

    }
    public Room getStarterRoom() {
        return starterRoom;
    }
}