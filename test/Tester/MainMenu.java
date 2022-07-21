/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import Input.Tool;
import List.CustomerList;
import Menu.CustomerMenu;

/**
 *
 * @author Admin
 */
public class MainMenu {
    public static void main(String[] args) {
        boolean check = true;
        CustomerList cList = new CustomerList();
        do {            
            System.out.println("************** MAIN MENU **************");
            System.out.println("        1. Train list Menu. ");
            System.out.println("        2. Customer list Menu. ");
            System.out.println("        3. Booking list Menu. ");
            System.out.println("        4. Quit. ");
            System.out.println("****************************************");
            int choice = Tool.nextInt("Choice", "--> Input your choice: ", 1, 4);
            switch (choice){
//                case 1: {
//                    TrainMenu menu = new TrainMenu();
//                    tList = menu.Menu(tList);
//                    check = true;
//                    break;
//                }
//                
                case 2: {
                    CustomerMenu menu = new CustomerMenu();
                    cList = menu.Menu(cList);
                    check = true;
                    break;
                }
//                
//                case 3: {
//                    BookingMenu menu = new BookingMenu();
//                    bList = menu.Menu(bList, tList, cList);
//                    check = true;
//                    break;
//                }
//                
                case 4: {
                    System.out.println("\n    **************** See you later ****************\n");
                    check = false;
                }
            }
        } while (check);
    }
}
