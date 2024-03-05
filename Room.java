import java.util.Scanner;
class Room {
    private String[] roomNumbers;
    private String[] availability;

    public Room(String[] roomNumbers) {
        this.roomNumbers = roomNumbers;
        this.availability = new String[roomNumbers.length];
        initializeAvailability();
    }

    private void initializeAvailability() {
        for (int i = 0; i < availability.length; i++) {
            availability[i] = "available";
        }
    }

    public void displayRooms() {
        int i = 1;
        for (String room : roomNumbers) {
            System.out.println(i + ") Room " + room);
            i++;
        }
    }

    public void manageRoomStatus(int choice) {
        choice--; // Adjusting to 0-based index
        if (choice >= 0 && choice < roomNumbers.length) {
            System.out.println("Room " + roomNumbers[choice] + " is " + availability[choice] +
                    "\nChange room status?\n1) Yes\n2) No");
            int ch1 = Safwa_Main.input.nextInt();
            if (availability[choice].equals(Safwa_Main.AVAILABLE) && ch1 == 1) {
                availability[choice] = Safwa_Main.OCCUPIED;
            } else if (availability[choice].equals(Safwa_Main.OCCUPIED) && ch1 == 1) {
                availability[choice] = Safwa_Main.AVAILABLE;
            }
        } else {
            System.out.println("Wrong choice. Please choose again.");
        }
    }

    public boolean isRoomAvailable(String roomNumber) {
        for (int i = 0; i < roomNumbers.length; i++) {
            if (roomNumbers[i].equals(roomNumber) && availability[i].equals(Safwa_Main.AVAILABLE)) {
                return true;
            }
        }
        return false;
    }
}