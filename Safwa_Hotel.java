import java.util.Scanner;

public class Safwa_Hotel {

    private static Scanner input = new Scanner(System.in);
    private static String[] single_rooms = {"100", "102", "104"};
    private static String[] double_rooms = {"201", "203", "204"};

    public static void main(String[] args) {
        int options;

        System.out.println("Welcome to Safwa Hotel \n");

        do {
            
            displayMenu();
            System.out.print("choice: ");
            options = input.nextInt();
            System.out.println();

            switch (options) {
                case 1:
                    exploreRooms();
                    break;

                case 2:
                    viewAllRooms();
                    break;

                case 3:
                    bookRoom();
                    break;

                case 4:
                    listBookings();
                    break;

                case 5:
                    System.out.println("Thank you for using Safwa Hotel. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose one of the provided options.");
            }
        } while (options != 5);
    }

    private static void displayMenu() {
        System.out.println("Choose one of the following options");
        System.out.println("1-Explore rooms available\n2-View all rooms\n3-Book a room\n4-List of bookings made previously\n5-Exit\n");
    }

    private static void exploreRooms() {
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
        System.out.println();
        System.out.println("Want to book a room? y/n");
        String answer = input.next();
        if (answer.startsWith("y")) {
            bookRoom();
        } else if (answer.startsWith("n")) {
            System.out.println("Thanks for using Safwa hotel Management system.");
        }
        System.out.println();
    }
    

    private static void singleRoomsAvailable() {
        for (String room : single_rooms) {
            System.out.println("Room " + room);
        }
        System.out.println();
    }

    private static void doubleRoomsAvailable() {
        for (String room : double_rooms) {
            System.out.println("Room " + room);
        }
        System.out.println();
    }

    private static void viewAllRooms() {
        System.out.println("room 100\nroom 101\nroom 102\nroom 103\nroom 104");
        System.out.println("room 200\nroom 201\nroom 202\nroom 203\nroom 204");
        System.out.println();
        System.out.println("Want to book a room? y/n");
        String answer = input.next();
        if (answer.startsWith("y")) {
            bookRoom();
        } else if (answer.startsWith("n")) {
            System.out.println("Thanks for using Safwa hotel Management system.");
        }
    }

    private static void bookRoom() {
        System.out.println("Rooms available:");
        System.out.println("Single rooms:");
        singleRoomsAvailable();
        System.out.println("Double rooms:");
        doubleRoomsAvailable();
        System.out.println("Enter room number:");
        String roomNumber = input.next();

        boolean isRoomAvailable = false;

        for (String room : single_rooms) {
            if (room.equals(roomNumber)) {
                isRoomAvailable = true;
                break;
            }
        }

        for (String room : double_rooms) {
            if (room.equals(roomNumber)) {
                isRoomAvailable = true;
                break;
            }
        }

        if (isRoomAvailable) {
            System.out.println("Room " + roomNumber + " booked successfully!");
            System.out.println();
        } else {
            System.out.println("Invalid room number");
            System.out.println();
        }
    }

    private static void listBookings() {
        System.out.println("No bookings made previously."); 
        System.out.println();
    }
}
