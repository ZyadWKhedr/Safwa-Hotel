import java.util.Scanner;

public class Safwa_Hotel {

    public static void main(String[] args) {

        System.out.println("Welcome to Safwa Hotel \n");

        Scanner input = new Scanner(System.in);
        
        System.out.println("Choose one of the following options");
        System.out.println("1-Explore rooms available\n2-View all rooms\n3-Book a room\n4-List of bookings made previously\n");
        System.out.print("choice :");
        int options = input.nextInt();
        System.out.println();
        

        switch (options) {
            case 1:
                exploreRooms(input);
                break;

            case 2:
                viewAllRooms();
                break;

            case 3:
                bookRoom(input);
                break;

            default:
                System.out.println("Invalid choice. Please choose one of the provided options.");
        }
    }

    private static void exploreRooms(Scanner input) {
        int roomType;
        do {
            System.out.println("Choose room type:\n1-Single rooms\n2-Double rooms\n");
            System.out.print("choice :");
            roomType = input.nextInt();
            if (roomType == 1) {
                singleRoomsAvailable();
            } else if (roomType == 2) {
                doubleRoomsAvailable();
            } else {
                System.out.println("Invalid choice. Please choose one of the provided options.");
            }
        } while (roomType > 2 || roomType < 1);
    }

    private static void singleRoomsAvailable() {
        System.out.println("room 105\nroom 106\nroom 107");
        System.out.println();
    }

    private static void doubleRoomsAvailable() {
        System.out.println("room 203\nroom 204\nroom 209");
        System.out.println();
    }

    private static void viewAllRooms() {
        singleRoomsAvailable();
        doubleRoomsAvailable();
        System.out.println("room 100\nroom 101\nroom 102\nroom 103\nroom 104");
        System.out.println("room 200\nroom 201\nroom 202\nroom 205\nroom 206\nroom 207\nroom 208");
        System.out.println();
    }

    private static void bookRoom(Scanner input) {
        System.out.println("Rooms available:");
        System.out.println("Single rooms:");
        singleRoomsAvailable();
        System.out.println("Double rooms:");
        doubleRoomsAvailable();
        System.out.println("Enter room number:");
        int roomNumber = input.nextInt();

        System.out.println("Room " + roomNumber + " booked successfully!");
    }
}
