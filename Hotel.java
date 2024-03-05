import java.util.Scanner;
class Hotel {
    private Admin admin;
    private Customer customer;
    private Room firstFloorRoom;
    private Room secondFloorRoom;

    public Hotel() {
        admin = new Admin();
        String[] firstFloorRooms = {"101", "102", "103", "104", "105"};
        String[] secondFloorRooms = {"201", "202", "203", "204", "205"};
        firstFloorRoom = new Room(firstFloorRooms);
        secondFloorRoom = new Room(secondFloorRooms);
    }

    public void start() {
        boolean continueFlag;
        do {
            continueFlag = true;
            System.out.println("Do you want to continue as a customer or as an admin?\n1) Customer\n2) Admin");
            int choice = Safwa_Main.input.nextInt();
            switch (choice) {
                case 1 -> {
                    customer = new Customer(getCustomerName());
                    customerActions();
                }
                case 2 -> adminActions();
                default -> {
                    System.out.println("Wrong choice. Please try again.");
                    continueFlag = false;
                }
            }
        } while (!continueFlag);
    }

    private String getCustomerName() {
        System.out.print("Enter your name: ");
        Safwa_Main.input.nextLine(); // Consume the newline character
        return Safwa_Main.input.nextLine();
    }

    private void customerActions() {
        int options;
        do {
            displayMenu();
            System.out.print("Choice: ");
            options = Safwa_Main.input.nextInt();
            System.out.println();

            switch (options) {
                case 1 -> exploreRooms();
                case 2 -> viewAllRooms();
                case 3 -> bookRoom();
                case 4 -> listBookings();
                case 5 -> System.out.println("Thank you for using Safwa Hotel. Goodbye!");
                default -> System.out.println("Invalid choice. Please choose one of the provided options.");
            }
        } while (options != 5);
    }

    private void singleRoomsAvailable() {
        System.out.println("Single rooms available.");
    }
    
    private void doubleRoomsAvailable() {
        System.out.println("Double rooms available.");
    }
    

    private void adminActions() {
        boolean loginFlag;
        do {
            loginFlag = true;
            System.out.print("Enter your username: ");
            String userIn = Safwa_Main.input.next();
            System.out.print("Enter your password: ");
            int passwordIn = Safwa_Main.input.nextInt();
            if (admin.login(userIn, passwordIn)) {
                System.out.println("Logged in successfully as " + userIn);
                adminManagement();
            } else {
                System.out.println("Incorrect information. Please try again.");
                loginFlag = false;
            }
        } while (!loginFlag);
    }

    private void adminManagement() {
        boolean floorChoiceFlag;
        do {
            floorChoiceFlag = true;
            System.out.print("1) First floor\n2) Second floor\nChoose the floor you want to view: ");
            int floorChoice = Safwa_Main.input.nextInt();
            switch (floorChoice) {
                case 1 -> firstFloorManagement();
                case 2 -> secondFloorManagement();
                default -> {
                    System.out.println("Wrong choice. Please choose again.");
                    floorChoiceFlag = false;
                }
            }
        } while (!floorChoiceFlag);

        int ch;
        do {
            System.out.println("Do you want to continue?\n1) Yes\n2) No");
            ch = Safwa_Main.input.nextInt();
            if (ch != 1 && ch != 2) {
                System.out.println("Wrong choice. Please try again!!");
            }
        } while (ch != 1 && ch != 2);

        if (ch == 1) {
            adminManagement();
        } else {
            System.out.println("Thank you for using Safwa Hotels Administration System!");
        }
    }

    private void firstFloorManagement() {
        firstFloorRoom.displayRooms();
        System.out.print("Choose the room you want to manage: ");
        int choice = Safwa_Main.input.nextInt();
        firstFloorRoom.manageRoomStatus(choice);
    }

    private void secondFloorManagement() {
        secondFloorRoom.displayRooms();
        System.out.print("Choose the room you want to manage: ");
        int choice = Safwa_Main.input.nextInt();
        secondFloorRoom.manageRoomStatus(choice);
    }

    private void exploreRooms() {
        int roomType;

        do {
            System.out.println("Choose room type:\n1-Single rooms\n2-Double rooms\n");
            System.out.print("Choice: ");
            roomType = Safwa_Main.input.nextInt();

            switch (roomType) {
                case 1 -> singleRoomsAvailable();
                case 2 -> doubleRoomsAvailable();
                default -> System.out.println("Invalid choice. Please choose one of the provided options.");
            }
        } while (roomType > 2 || roomType < 1);

        System.out.println();
        System.out.println("Want to book a room? y/n");
        String answer = Safwa_Main.input.next();
        if (answer.startsWith("y")) {
            bookRoom();
        } else if (answer.startsWith("n")) {
            System.out.println("Thanks for using Safwa Hotel Management system.");
        }
        System.out.println();
    }

    private void viewAllRooms() {
        System.out.println("Room 101\nRoom 102\nRoom 103\nRoom 104\nRoom 105");
        System.out.println("Room 201\nRoom 202\nRoom 203\nRoom 204\nRoom 205");
        System.out.println();
        System.out.println("Want to book a room? y/n");
        String answer = Safwa_Main.input.next();
        if (answer.startsWith("y")) {
            bookRoom();
        } else if (answer.startsWith("n")) {
            System.out.println("Thanks for using Safwa Hotel Management system.");
        }
    }

    private void bookRoom() {
        boolean isRoomAvailable;

        do {
            System.out.println("Rooms available:");
            System.out.println("Single rooms:");
            firstFloorRoom.displayRooms();
            System.out.println("Double rooms:");
            secondFloorRoom.displayRooms();
            System.out.println("Enter room number:");
            String roomNumber = Safwa_Main.input.next();

            isRoomAvailable = firstFloorRoom.isRoomAvailable(roomNumber) || secondFloorRoom.isRoomAvailable(roomNumber);

            if (isRoomAvailable) {
                customer.bookRoom(roomNumber, Safwa_Main.input);
                System.out.println();
                System.out.println("Room " + roomNumber + " booked successfully by " + customer.getName() +
                        " for " + customer.getNights() + " nights!");
                System.out.println();
                System.out.println("Total Cost = " + customer.getReceipt());
            } else {
                System.out.println();
                System.out.println("Invalid room number. Please choose a valid room.");
            }
        } while (!isRoomAvailable);

        System.out.println();
    }

    private void listBookings() {
        customer.listBookings();
    }

    private void displayMenu() {
        System.out.println("Choose one of the following options");
        System.out.println("1-Explore rooms available\n2-View all rooms\n3-Book a room\n4-List of bookings made previously\n5-Exit\n");
    }
}

