/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fullhotel;

/**
 *
 * @author mar3y
 */
import java.util.Scanner;
public class Fullhotel {
    public static final Scanner input = new Scanner(System.in);
    public static final String[] firstfloor = {"101", "102", "103", "104", "105"};
    public static String[] ffavailability = {"available","available","occupied","available","occupied"};
    public static final String[] secondfloor = {"201", "202", "203", "204", "205"};
    public static String[] sfavailability = {"available","available","occupied","available","occupied"};
    public static final String available="available";
    public static final String occupied="occupied";
    public static String[] single_rooms = {"101", "102", "104"};
    public static String[] double_rooms = {"201", "203", "204"};
    public static int[] Cost = {1000, 2000};
    public static String currentUser = null;
    public static String bookedRoom = null;
    public static int totalcost=0;
    public static int nights;
    //************************************************************************************************************
        public static void main(String[] args) { 
          boolean c;
            do{c=true;
              System.out.println("do you want to continue as a customer or as an admin?\n1)customer\n2)admin");
              int ch= input.nextInt();
              switch (ch) {
                  case 1 -> customer();
                  case 2 -> admin();
                  default -> {
                      System.out.println("wrong choice please tryagain");
                      c=false;}}}while(c==false);
         }
      //************************************************************************************************************
        public static void admin(){
          String loggeduser =adminlogin();
          int ch;
          do{ boolean f;
          do{f = true;
              System.out.print("1)first floor\n2)second floor\nchoose the floor you want to view:");
          int floorchoice= input.nextInt();
             switch (floorchoice) {
                 case 1 -> {firstfloor();}
                 case 2 -> {secondfloor();}
                 default -> {
                   System.out.println("wrong choice please choose again");
                   f=false;}}
            }while(f==false);
            do{ System.out.println("do you want to continue?\n1)yes\n2)no");
             ch=input.nextInt();
             if(ch!=1&&ch!=2){System.out.println("wrong choice please try again!!");}
         }while(ch!=1&&ch!=2);}while(ch==1);
            System.out.println("thank you for using safwa hotels administration system!!!");  }
        
       //************************************************************************************************************
    public static String adminlogin(){
          String user1 = "safwa" ;
          int password1 = 1234;
          boolean login;
          do{ System.out.print("enter your username :");
            String userin = input.next();
            System.out.print("enter your password :");
            int passwordin = input.nextInt();
          if(userin.equals(user1)&&passwordin==password1){
              System.out.println("logged in successfully as "+userin);
              return userin;}  
          else{
         System.out.println("the information you have entered is incorrect please tryagain");
            login = false;}
           }while(login==false);
        return null;}
    //***********************************************************************************************************************
       public static void firstfloor(){
         boolean f;
           do{ f = true;
           int i=1;
           for (String room : firstfloor ) {
                System.out.println(i+")Room " + room);
                i++;}
         System.out.print("choose the room you want to manage:");
          int choice= input.nextInt();
             choice--;
     if (choice>=0&&choice<5){
     do{  f=true;   
             System.out.println("room "+firstfloor[choice]+" is "+ffavailability[choice]+"\nchange room status?\n1)yes\n2)no");
              int ch1=input.nextInt();
               if(ffavailability[choice].equals(available) && ch1==1){ffavailability[choice]=occupied;}
               else if(ffavailability[choice].equals(occupied) && ch1==1){ffavailability[choice]=available;}
               else if(ch1==2){break;}
               else{System.out.println("wrong choice please choose again");
                 f=false;  }}while(f==false);}           
         else {System.out.println("wrong choice please choose again");
                   f=false;}}while(f==false); }
    //**********************************************************************************************************************
       public static void secondfloor(){
        boolean f;
           do{ f = true;
         int i=1;
           for (String room : secondfloor ) {
                System.out.println(i+")Room " + room);
                i++;}
        System.out.print("choose the room you want to manage:");
        int choice= input.nextInt();
           choice--;
     if (choice>=0&&choice<5){
         do{ f=true;   
             System.out.println("room "+secondfloor[choice]+" is "+sfavailability[choice]+"\nchange room status?\n1)yes\n2)no");
              int ch1=input.nextInt();
               if(sfavailability[choice].equals(available) && ch1==1){sfavailability[choice]=occupied;}
               else if(sfavailability[choice].equals(occupied) && ch1==1){sfavailability[choice]=available;}
               else if(ch1==2){break;}
               else{System.out.println("wrong choice please choose again");
                 f=false;  }}while(f==false);}           
         else {System.out.println("wrong choice please choose again");
                   f=false;}}while(f==false);} 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public static void customer(){
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
                case 1 -> exploreRooms();

                case 2 -> viewAllRooms();

                case 3 -> bookRoom();

                case 4 -> listBookings();

                case 5 -> System.out.println("Thank you for using Safwa Hotel. Goodbye!");

                default -> System.out.println("Invalid choice. Please choose one of the provided options.");
            }
        } while (options != 5);
       }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public static void displayMenu() {
        System.out.println("Choose one of the following options");
        System.out.println("1-Explore rooms available\n2-View all rooms\n3-Book a room\n4-List of bookings made previously\n5-Exit\n");}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public static void exploreRooms() {
        int roomType;

        do {
            System.out.println("Choose room type:\n1-Single rooms\n2-Double rooms\n");
            System.out.print("choice :");
            roomType = input.nextInt();

            switch (roomType) {
                case 1 -> singleRoomsAvailable();
                case 2 -> doubleRoomsAvailable();
                default -> System.out.println("Invalid choice. Please choose one of the provided options.");
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
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public static void singleRoomsAvailable() {
        for (String room : single_rooms) {
            System.out.println("Room " + room);
        }
        System.out.println();
        System.out.println("The Single Room bears the cost " + Cost[0]);
        System.out.println();
    }

public static void doubleRoomsAvailable() {
        for (String room : double_rooms) {
            System.out.println("Room " + room);
        }
        System.out.println();
        System.out.println("The Double Room bears the cost " + Cost[1]);
        System.out.println();
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 public static void viewAllRooms() {
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
 //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 public static boolean isRoomAvailable(String roomNumber, String[] roomType) {
        for (String room : roomType) {
            if (room.equals(roomNumber)) {
                return true;
            }
        }
        return false;
    }
 //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 public static void bookRoom() {
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
                    nights(input);
                    System.out.println();
                System.out.println("Room " + roomNumber + " booked successfully by " + currentUser + " for " +nights+" nights!");
                    System.out.println();
                System.out.println("Total Cost = "+receipt());

            } else {
                System.out.println();
                System.out.println("Invalid room number. Please choose a valid room.");
            }

        } while (!isRoomAvailable);

        System.out.println();
    }
 //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 public static void listBookings() {
        if (currentUser != null && bookedRoom != null) {
            System.out.println("Your Booking: Room " + bookedRoom + " booked by " + currentUser);
        } else {
            System.out.println("You have not made any bookings yet.");
        }
        System.out.println();

    }
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void nights(Scanner input){
        System.out.println("How many night do you want to spend?");
        nights = input.nextInt();
        }
    public static int receipt(){
        for(int i=0;i<3;i++){
    if(bookedRoom.equals(single_rooms[i])) totalcost+= nights*Cost[0];
    if(bookedRoom.equals(double_rooms[i])) totalcost+=nights*Cost[1];
    }
        return totalcost;
    }
    
}