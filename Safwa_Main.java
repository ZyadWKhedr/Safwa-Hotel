import java.util.Scanner;

public class Safwa_Main {
    public static final Scanner input = new Scanner(System.in);
    public static final String AVAILABLE = "available";
    public static final String OCCUPIED = "occupied";
    private static final Hotel hotel = new Hotel();

    public static void main(String[] args) {
        hotel.start();
    }
}
