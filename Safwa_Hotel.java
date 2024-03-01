import java.util.Scanner;

public class Safwa_Hotel {

    private static Scanner input = new Scanner(System.in);
    private static String[] single_rooms = {"101", "102", "104"};
    private static String[] double_rooms = {"201", "203", "204"};
    private static int[] Cost = {1000, 2000};
    private static String currentUser = null;
    private static String bookedRoom = null;

    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        currentUser = input.nextLine();

        int options;

        System.out.println("Welcome to Safwa Hotel, " + currentUser + "!\n");

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
        System.out.println("The Single Room bears the cost " + Cost[0]);
        System.out.println();
    }

    private static void doubleRoomsAvailable() {
        for (String room : double_rooms) {
            System.out.println("Room " + room);
        }
        System.out.println();
        System.out.println("The Double Room bears the cost " + Cost[1]);
        System.out.println();
    }

    private static void viewAllRooms() {
        System.out.println("room 101\nroom 102\nroom 103\nroom 104\nroom 105");
        System.out.println("room 201\nroom 202\nroom 203\nroom 204\nroom 205");
        System.out.println();
        System.out.println("Want to book a room? y/n");
        String answer = input.next();
        if (answer.startsWith("y")) {
            bookRoom();
        } else if (answer.startsWith("n")) {
            System.out.println("Thanks for using Safwa hotel Management system.");
        }
    }

    private static boolean isRoomAvailable(String roomNumber, String[] roomType) {
        for (String room : roomType) {
            if (room.equals(roomNumber)) {
                return true;
            }
        }
        return false;
    }

    private static void bookRoom() {
        boolean isRoomAvailable;

        do {
            System.out.println("Rooms available:");
            System.out.println("Single rooms:");
            singleRoomsAvailable();
            System.out.println("Double rooms:");
            doubleRoomsAvailable();
            System.out.println("Enter room number:");
            String roomNumber = input.next();

            isRoomAvailable = isRoomAvailable(roomNumber, single_rooms) || isRoomAvailable(roomNumber, double_rooms);

            if (isRoomAvailable) {
                bookedRoom = roomNumber;
                System.out.println("Room " + roomNumber + " booked successfully by " + currentUser + "!");
            } else {
                System.out.println();
                System.out.println("Invalid room number. Please choose a valid room.");
            }

        } while (!isRoomAvailable);

        System.out.println();
    }

    private static void listBookings() {
        if (currentUser != null && bookedRoom != null) {
            System.out.println("Your Booking: Room " + bookedRoom + " booked by " + currentUser);
        } else {
            System.out.println("You have not made any bookings yet.");
        }
        System.out.println();
    }
}
