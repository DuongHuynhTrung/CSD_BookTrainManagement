/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Menu.*;
import Input.Tool;
import List.CustomerList;
import List.CustomerNode;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CustomerMenu {

    static Scanner sc = new Scanner(System.in);
    static CustomerNode head;

    public CustomerList Menu(CustomerList list) {

        boolean check = false;
        do {
            System.out.println("**************** WELCOME TO CUSTOMER LIST *****************");
            System.out.println("            1. LOAD DATA FROM FILE. ");
            System.out.println("            2. INPUT NEW CUSTOMER. ");
            System.out.println("            3. DISPLAY DATA. ");
            System.out.println("            4. SAVE CUSTOMER LIST TO FILE. ");
            System.out.println("            5. SEARCH BY CCODE. ");
            System.out.println("            6. DELETE BY CCODE. ");
            System.out.println("            7. BACK TO MAIN MENU. ");
            System.out.println("***********************************************************");
            int choice = Tool.nextInt("Choice", "Input your choice: ", 1, 7);
            switch (choice) {
                case 1: {
                    boolean isKeep = false;
                    if (list.count() != 0) {
                        System.out.println("    ---> TRAIN LIST IS NOT EMPTY!");
                        System.out.print("DO YOU WANT TO KEEP THE EXIST DATA?");
                        isKeep = Tool.yesNoQuestion();
                        System.out.println("");

                    }
                    if (!isKeep) {
                        list.clear();
                    }
                    String FileName = Tool.inputChoice("FileName", "--> Input your FileName: ", "Customer.txt", "", "");
                    list.readFile(FileName);
                    System.out.println("\nYour file have information above: ");
                    list.traverse();
                    System.out.println("        ---> PRESS ENTER TO CONTINUE! ");
                    sc.nextLine();
                    check = true;
                    break;
                }

                case 2: {
                    System.out.println("        PLEASE INPUT INFORMATION ABOUT CUSTOMER BELOW! ");
                    list.addToTail(list.inputCustomer());
                    check = true;
                    break;
                }

                case 3: {
                    if (list.count() == 0) {
                        check = true;
                        break;
                    }

                    System.out.println("    INFORMATION ABOUT CUSTOMER: ");
                    list.traverse();
                    System.out.println("        --> PRESS ENTER TO CONTINUE!");
                    sc.nextLine();
                    check = true;
                    break;

                }

                case 4: {
                    String FileName = Tool.inputChoice("FileName", "--> Input your FileName: ", "Customer.txt", "", "");
                    list.writeFile(FileName, list);
                    System.out.println("        ---> WRITTED!");
                    check = true;
                    break;
                }

                case 5: {
                    String xCode = Tool.matchPattern("TCODE", "--> Input Code of Customer (Cxx): ", "C\\d\\d");
                    int checkExist = list.searchNode(xCode);
                    if (checkExist == -1) {
                        System.out.println("        ---> NOT FOUND!");
                    } else {
                        System.out.println("        ---> FOUND AT = " + checkExist);
                    }
                    check = true;
                    break;
                }

                case 6: {
                    String xCode = Tool.matchPattern("TCODE", "--> Input Code of Customer (Cxx): ", "C\\d\\d");
                    int checkExist = list.searchNode(xCode);
                    if (checkExist == -1) {
                        System.out.println("        ---> TCODE DOESN'T EXIST!");
                        System.out.println("        ---> DELETE FAIL!");
                    } else {
                        list.deleteByTCode(xCode);
                        System.out.println("        ---> DELETED!");
                    }
                    check = true;
                    break;
                }

                case 7: {
                    check = false;
                    break;
                }
            }
        } while (check);

        return list;
    }
}
