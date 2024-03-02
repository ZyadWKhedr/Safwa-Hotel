/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hoteladmin;

/**
 *
 * @author mar3y
 */
    import java.util.Scanner;
    public class Hoteladmin {
    private static final Scanner input = new Scanner(System.in);
    private static final String[] firstfloor = {"101", "102", "103", "104", "105"};
    private static String[] ffavailability = {"available","available","occupied","available","occupied"};
    private static final String[] secondfloor = {"201", "202", "203", "204", "205"};
    private static String[] sfavailability = {"available","available","occupied","available","occupied"};
    private static final String available="available";
    private static final String occupied="occupied";

    //************************************************************************************************************
        public static void main(String[] args) { 
          admin();
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
         }while(ch!=1&&ch!=2);}while(ch==1);}
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
     if (choice>=0&&choice<5){System.out.println("room "+firstfloor[choice]+" is "+ffavailability[choice]+"\nchange room status?\n1)yes\n2)no");
              int ch1=input.nextInt();
               if(ffavailability[choice].equals(available) && ch1==1){ffavailability[choice]="occupied";}
              else if(ffavailability[choice].equals(occupied) && ch1==1){ffavailability[choice]="available";}}
               
         else {System.out.println("wrong choice please choose again");
                   f=false;}}while(f==false);
                }
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
     if (choice>=0&&choice<5){System.out.println("room "+secondfloor[choice]+" is "+sfavailability[choice]+"\nchange room status?\n1)yes\n2)no");
              int ch1=input.nextInt();
               if(sfavailability[choice].equals("available") && ch1==1){sfavailability[choice]="occupied";}
             else  if(sfavailability[choice].equals("occupied") && ch1==1){sfavailability[choice]="available";}}             
         else {System.out.println("wrong choice please choose again");
                   f=false;}}while(f==false);
         }    
    }

