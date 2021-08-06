import java.io.IOException;
import java.util.Scanner;

public class Housekeeping {

    private static boolean MainMenu = true;
    private static boolean SubMenu = true;

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        Room[] hKeeping = new Room[10];
        hKeeping[0] = new Room();
        hKeeping[1] = new Room();
        hKeeping[2] = new Room();
        hKeeping[3] = new Room();
        hKeeping[4] = new Room();
        hKeeping[5] = new Room();
        hKeeping[6] = new Room();
        hKeeping[7] = new Room();
        hKeeping[8] = new Room();
        hKeeping[9] = new Room();
        int roomNum = 0;
        initialise(hKeeping);
        while (MainMenu) {
            while (SubMenu) {
                System.out.println("Please select one of the options.");
                System.out.println("A: Book A New Room.");
                System.out.println("------------------------------------");
                System.out.println("E: Display Empty Rooms.");
                System.out.println("------------------------------------");
                System.out.println("V: View all Rooms.");
                String Selection = input.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookARoom(hKeeping, roomNum);
                        break;
                    case "E":
                        CheckIfEmpty(hKeeping);
                        break;
                    case "V":
                        ViewAllRooms(hKeeping);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }

                System.out.println("------------------------------------------------------");
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                System.out.println("------------------------------------------------------");
                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;
            System.out.println("------------------------------------------------------");
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            System.out.println("------------------------------------------------------");
            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }

    }

    private static void initialise(Room[] hKeeping) {
        for (int x = 0; x < hKeeping.length; x++) {
            hKeeping[x].setName("nobody");
        }
    }

    private static void CheckIfEmpty(Room[] hKeeping) {
        for (int x = 0; x < hKeeping.length; x++) {
            if (hKeeping[x].getName().equals("nobody")) {
                System.out.println("room " + (x + 1) + " occupied");
            }
        }
    }

    private static void BookARoom(Room[] hKeeping, int roomNum) {
        String roomName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (1-10):");
        roomNum = input.nextInt() - 1;
        System.out.println("Enter name for room " + (roomNum + 1) + " :");
        roomName = input.next();
        hKeeping[roomNum].setName(roomName);
    }

    private static void ViewAllRooms(Room[] hKeeping) {
        for (int x = 0; x < hKeeping.length; x++) {
            System.out.println("room " + (x + 1) + " occupied by " + hKeeping[x].getName());
        }
    }


    public static class Room {

        //protected String mainName;
        private String mainName;
        int guestsInRoom;

        public Room() {
            mainName = "k";

        }

        public void setName(String aName) {
            //  System.out.println("add name class method ");
            mainName = aName;
        }

        public String getName() {
            return mainName;
        }
    }
}
