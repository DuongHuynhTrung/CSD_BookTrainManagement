/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Booking;
import Input.Tool;
import List.BookingList;
import List.CustomerList;
import List.TrainList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BookingMenu {

    public BookingList Menu(BookingList list, TrainList tList, CustomerList cList) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        do {
            System.out.println("**************** WELCOME TO BOOKING LIST *****************");
            System.out.println("            1. INPUT NEW CUSTOMER. ");
            System.out.println("            2. DISPLAY DATA. ");
            System.out.println("            3. SORT BY CCODE & TCODE. ");
            System.out.println("            4. BACK TO MAIN MENU. ");
            System.out.println("***********************************************************");
            int choice = Tool.nextInt("Choice", "Input your choice: ", 1, 7);
            switch (choice) {
                case 1: {
                    if (tList.isEmpty()) {
                        System.out.println("    ---> TRAIN LIST IS EMPTY!");
                        check = true;
                        break;
                    }
                    if (cList.isEmpty()) {
                        System.out.println("    ---> CUSTOMER LIST IS EMPTY!");
                        check = true;
                        break;
                    }

                    do {
                        System.out.println("    PLEASE INPUT INFORMATION BELOW: ");
                        Booking b = list.inputBooking(tList, cList);
                        boolean checkTrue = list.addToTail(b);
                        if (!checkTrue) {
                            System.out.println("    ---> ADD FAIL!\n");
                        } else {
                            System.out.println("    ---> ADDED!\n");
                        }
                        System.out.print("DO YOU WANT TO CONTINUE BOOKING?");
                        check = Tool.yesNoQuestion();
                    } while (check);

                    check = true;
                    break;
                }

                case 2: {
                    list.traverse();
                    System.out.println("    PLEASE ENTER TO CONTINUE!");
                    sc.nextLine();
                    check = true;
                    break;
                }

                case 3: {
                    System.out.println("    LIST BEFORE SORT!");
                    list.traverse();
                    System.out.println("    LIST AFTER SORT!");
                    list.sortBookingList();
                    list.traverse();
                    System.out.println("    PLEASE PRESS ENTER TO CONTINUE!");
                    sc.nextLine();
                    check = true;
                    break;
                }

                case 4: {
                    System.out.println("\n   ***** GO BACK TO MAIN MENU *****\n");
                    check = false;
                }
            }
        } while (check);

        return list;
    }
}
