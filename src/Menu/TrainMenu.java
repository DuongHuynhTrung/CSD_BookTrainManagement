/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Train;
import Input.Tool;
import List.TrainNode;
import List.TrainList;
import java.util.Scanner;
import javafx.scene.Node;

/**
 *
 * @author Admin
 */
public class TrainMenu {

    static Scanner sc = new Scanner(System.in);
    static TrainNode head;

    public TrainList Menu(TrainList list) {
        
        boolean check = false;
        do {
            System.out.println("****************** WELCOME TO TRAIN LIST ******************");
            System.out.println("            1. LOAD DATA FROM FILE. ");
            System.out.println("            2. INPUT NEW TRAIN. ");
            System.out.println("            3. DISPLAY DATA. ");
            System.out.println("            4. SAVE TRAIN LIST TO FILE. ");
            System.out.println("            5. SEARCH BY TCODE. ");
            System.out.println("            6. DELETE BY TCODE. ");
            System.out.println("            7. SORT BY TCODE. ");
            System.out.println("            8. ADD AFTER POSITION K");
            System.out.println("            9. DELETE TRAIN BEFORE THE TRAIN HAVING TCODE. ");
            System.out.println("            10. BACK TO MAIN MENU. ");
            System.out.println("***********************************************************");
            int choice = Tool.nextInt("Choice", "Input your choice: ", 1, 10);
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
                    String FileName = Tool.inputChoice("FileName", "--> Input your FileName: ", "Train.txt", "", "");
                    list.readFile(FileName);
                    System.out.println("\nYour file have information above: ");
                    list.traverse();
                    System.out.println("        ---> PRESS ENTER TO CONTINUE! ");
                    sc.nextLine();
                    check = true;
                    break;

                }
                case 2: {
                    System.out.println("        PLEASE INPUT INFORMATION ABOUT TRAIN BELOW! ");
                    list.addToTail(list.inputTrain(list));
                    check = true;
                    break;
                }

                case 3: {
                    if (list.count() == 0) {
                        check = true;
                        break;
                    }

                    System.out.println("    INFORMATION ABOUT TRAIN: ");
                    list.traverse();
                    System.out.println("        --> PRESS ENTER TO CONTINUE!");
                    sc.nextLine();
                    check = true;
                    break;

                }

                case 4: {
                    String FileName = Tool.inputChoice("FileName", "--> Input your FileName: ", "Train.txt", "", "");
                    list.writeFile(FileName, list);
                    System.out.println("        ---> WRITTED!");
                    check = true;
                    break;
                }

                case 5: {
                    String xCode = Tool.matchPattern("TCODE", "--> Input Code of Train (Bxx): ", "B\\d\\d");
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
                    String xCode = Tool.matchPattern("TCODE", "--> Input Code of Train (Bxx): ", "B\\d\\d");
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
                    System.out.println("    LIST BEFORE SORT!");
                    list.traverse();
                    System.out.println("    LIST AFTER SORT BY TCODE!");
                    list.sortList();
                    list.traverse();
                    System.out.println("    ---> PRESS ENTER TO CONTINUE!");
                    sc.nextLine();
                    check = true;
                    break;
                }

                case 8: {
                    System.out.println("        PLEASE INPUT INFORMATION ABOUT TRAIN BELOW! ");
                    Train t = list.inputTrain(list);
                    boolean checkExist = false;
                    int k = 0;
                    do {
                        System.out.print("--> Input Position you want to Add new Train After: ");
                        k = sc.nextInt();
                        if (list.GetNth(k) == null) {
                            System.out.println("    ---> POSITION DOESN'T EXIST!");
                            System.out.print("DO YOU WANT TO CONTINUE?");
                            checkExist = Tool.yesNoQuestion();
                            if (checkExist == false) {
                                check = true;
                                break;
                            }
                        } else {
                            list.insertAfter(t, k);
                            checkExist = false;
                        }
                    } while (checkExist);

                    check = true;
                    break;
                }

                case 9: {
                    String xCode = Tool.matchPattern("TCODE", "--> Input Train Code you want to delete before: ", "B\\d\\d");
                    if (list.deleteBeforeNode(xCode)){
                        System.out.println("        ---> DELETED!\n");
                    } else {
                        System.out.println("        ---> DELETE FAIL!\n");
                    }
                    check = true;
                    break;
                }

                case 10: {
                    check = false;
                    break;
                }
            }
        } while (check);

        return list;
    }
}
