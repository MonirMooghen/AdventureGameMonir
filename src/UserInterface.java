import java.util.Scanner;

public class UserInterface {
    //our scanner and other attributes
    Scanner scanner = new Scanner(System.in);
    //private Scanner scanner;
    private Adventure adventure;
    private Item item;

    //constructor Set the initial value for the class attributes.
    public UserInterface() {
        //this.scanner = new Scanner(System.in);
        this.scanner.useDelimiter("\n"); //Så vi ikke skal bruge dummy bugs
        this.adventure = new Adventure();
        //this.isRunning = true;
        //this.Player = this.adventure.getPlayer();
    }

    boolean isRunning = false;

    //start program - menu to the user
    public void startProgram() {

        while (true) {
            if (!isRunning) {
                introduction();
                menuText();
                isRunning = true;
            }
            else {
                userInput();
            }
        }
    }

    //movement packaged.
//    public void move() {
//        System.out.println("Enter direction (North, South, East, West): ");
//        String input = scanner.next();
//        adventure.move(input);
//    }


    public void introduction() {
        System.out.println("Hello, and welcome to .....");

        System.out.println("  ______               ___            _ _   _                             ");
        System.out.println(" |  ____|             / _ \\          | | | | |                            ");
        System.out.println(" | |__ ___  __ _ _ __/ /_\\ \\_ __   __| | |_| |_   _ _ __   __ _  ___ _ __ ");
        System.out.println(" |  __/ _ \\/ _` | '__|  _  | '_ \\ / _` |  _  | | | | '_ \\ / _` |/ _ \\ '__|");
        System.out.println(" | | |  __/ (_| | |  | | | | | | | (_| | | | | |_| | | | | (_| |  __/ |   ");
        System.out.println(" |_|  \\___|\\__,_|_|  \\_| |_|_| |_|\\__,_|_| |_|\\__,_|_| |_|\\__, |\\___|_|   ");
        System.out.println("                                                           __/ |          ");
        System.out.println("                                                          |___/           ");

        System.out.println("This is a horror survival game");
        System.out.println("Try and survive while discovering the secrets of the tomb");
        System.out.println("▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔\n");
        System.out.println("You find yourself at the entrance of a dark tomb. You don't remember anything");
    }


    //Split metode med UI
    public void userInput() {
        String input = scanner.nextLine().trim().toLowerCase();
        String[] commands = input.split("\\s+");
        String command = commands[0];


        if (commands.length == 1) {
            switch (command) {
                //-> lambda expression  og gør så der ikke skal break; på.
                case "help", "h" -> {
                    System.out.println("Commands:");
                    System.out.println("GO <direction>  - Move in the specified direction (e.g., 'go north', 'go west'). You can also use N, S, E, and W.");
                    System.out.println("LOOK            - Take another look around the room.");
                    System.out.println("TAKE <item>     - Pick up an object from a room (e.g., 'take club').");
                    System.out.println("DROP <item>     - Drop an item inside a room (e.g., 'drop club').");
                    System.out.println("EAT <item>      - Consume an item in your inventory for health (e.g., 'eat apple').");
                    System.out.println("EQUIP <weapon>  - Equips a weapon from your inventory (e.g., 'equip AK-47");
                    System.out.println("INVENTORY       - View items in your inventory.");
                    System.out.println("EXIT            - Exit the program.");
                }
                case "look" -> {
                    System.out.println("On the floor you see: ");
                    adventure.printItemList();

                }
                case "inventory" -> {
                    System.out.println(adventure.getPlayer().getInventory());
                }
                case "exit" -> {
                    System.exit(0);
                }
                default -> System.out.println("Invalid input");
            }
        }
        if (commands.length == 2) {
            switch (commands[0]) {

                case "go" -> {
                    switch (commands[1]) {
                        case "north", "n" -> {
                            adventure.goNorth();
                        }
                        case "south", "s" -> {
                            adventure.goSouth();
                        }
                        case "east", "e" -> {
                            adventure.goEast();
                        }
                        case "west", "w" -> {
                            adventure.goWest();
                        }
                        default -> System.out.println("Invalid input");
                    }
                }

                case "take" -> {
                    Item pickItem = adventure.takeItem(commands[1]);
                    if (pickItem != null) {
                        System.out.println("Picked up '" + pickItem + "'");
                    } else {
                        System.out.println("There is no " + commands[1] + " in this room.");
                    }
                }

                case "drop" -> {
                    Item dropItem = adventure.dropItem(commands[1]);
                    if (dropItem != null) {
                        System.out.println("Dropped '" + dropItem + "'");
                    } else {
                        System.out.println("There is no " + commands[1] + " in your inventory");
                    }
                }
                case "eat" -> {
                    ReturnMessage result = adventure.eatItem(commands[1]);
                    switch (result) {
                        case OK -> {
                            System.out.println("Eating " + commands[1] + "!");
                            System.out.println("Om nom nom...");
                            System.out.println("You now have " + adventure.getPlayer().getHealth() + " hp");
                        }
                        case NOT_OK -> {
                            System.out.println("You can't eat " + commands[1]);

                        }
                        case NOT_FOUND -> {
                            System.out.println("No " + commands[1] + " was found in your inventory or the room");
                        }
                    }
//                    case "equip" -> { //Skal rettes til at være en rigtig command
//                        ReturnMessage result = adventure.eatItem(commands[1]);
//                        switch (result) {
//                            case OK -> {
//                                System.out.println("Eating " + commands[1] + "!");
//                                System.out.println("Om nom nom...");
//                                System.out.println("You now have " + adventure.getPlayer().getHealth() + " hp");
//                            }
//                            case NOT_OK -> {
//                                System.out.println("You can't eat " + commands[1]);
//
//                            }
//                            case NOT_FOUND -> {
//                                System.out.println("No " + commands[1] + " was found in your inventory or the room");
//
//                            }
//                        }
//                    }
            }
        }
    }

    public void menuText() {
        System.out.println("***** Menu *****");
        System.out.println("Commands:");
        System.out.println("GO <direction>  - Move in the specified direction (e.g., 'go north', 'go west'). You can also use N, S, E, and W.");
        System.out.println("LOOK            - Take another look around the room.");
        System.out.println("TAKE <item>     - Pick up an object from a room (e.g., 'take club').");
        System.out.println("DROP <item>     - Drop an item inside a room (e.g., 'drop club').");
        System.out.println("INVENTORY       - View items in your inventory.");
        System.out.println("EXIT            - Exit the program.");
        System.out.println("HELP            - Press 'Help' or 'H' to see all controls.");
    }

    public void exit() {
        System.out.println("Exiting game, thanks for playing...");
        isRunning = false;
    }
}