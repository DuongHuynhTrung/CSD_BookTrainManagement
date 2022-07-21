/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Tool {

    static Scanner ip = new Scanner(System.in);

    public static boolean yesNoQuestion() {
        String answer = null;
        System.out.print("(Y/N):");
        boolean check = true;
        while (check) {
            try {
                ip = new Scanner(System.in);
                answer = ip.nextLine();
                if (!answer.equalsIgnoreCase("n") && !answer.equalsIgnoreCase("y")) {
                    throw new Exception("   --->Y(y) for yes or N(n) for no!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return answer.equalsIgnoreCase("y");
    }

    public static String nextLine(String target, String content) {
        String inputString = null;
        boolean check = true;
        while (check) {
            try {
                if (!content.isEmpty()) {
                    System.out.print(content);
                }
                ip = new Scanner(System.in);
                inputString = ip.nextLine();
                inputString = inputString.trim();
                if (inputString.isEmpty()) {
                    throw new Exception("   --->NOT EMPTY STRING!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return inputString;
    }

    public static int nextInt(String target, String content, int from, int to) {
        int inputInt = 0;
        boolean check = true;
        while (check) {
            try {
                if (!content.isEmpty()) {
                    System.out.print(content);
                }
                ip = new Scanner(System.in);
                inputInt = ip.nextInt();
                if (inputInt < 0) {
                    throw new Exception("   --->NOT NEGATIVE NUMBER!");
                }
                if (inputInt < from || inputInt > to) {
                    throw new Exception("   --->NUMBER MUST BE IN RANGE(" + from + " - " + to + ")!");
                }
                check = false;
            } catch (Exception e) {
                if (e instanceof InputMismatchException) {
                    System.out.println("   --->WRONG NUMBER FORMAT!");
                } else {
                    System.out.println(e.getMessage());
                }
            }
        }
        return inputInt;
    }

    public static float nextFloat(String target, String content, int from, int to) {
        float inputFloat = 0;
        boolean check = true;
        while (check) {
            try {
                if (!content.isEmpty()) {
                    System.out.print(content);
                }
                ip = new Scanner(System.in);
                inputFloat = ip.nextFloat();
                if (inputFloat < 0) {
                    throw new Exception("   --->NOT NEGATIVE NUMBER!");
                }
                if (from < to) {
                    if (inputFloat < from || inputFloat > to) {
                        throw new Exception("   --->NUMBER MUST BE IN RANGE(" + from + " - " + to + ")!");
                    }
                } else if (from > to) {
                    throw new Exception("   --->ERROR NUMBER RANGE! Please check code in method inputting float!");
                }
                check = false;
            } catch (Exception e) {
                if (e instanceof InputMismatchException) {
                    System.out.println("   --->WRONG NUMBER FORMAT!");
                } else {
                    System.out.println(e.getMessage());
                }
                check = true;
            }
        }
        return inputFloat;
    }

    public static double nextDouble(String target, String content, double from, double to) {
        double inputDouble = 0;
        boolean check = true;
        while (check) {
            try {
                if (!content.isEmpty()) {
                    System.out.print(content);
                }
                ip = new Scanner(System.in);
                inputDouble = ip.nextDouble();
                if (inputDouble < 0) {
                    throw new Exception("   --->NOT NEGATIVE NUMBER!");
                }
                if (from < to) {
                    if (inputDouble < from || inputDouble > to) {
                        throw new Exception("   --->NUMBER MUST BE IN RANGE(" + from + " - " + to + ")!");
                    }
                } else if (from > to) {
                    throw new Exception("   --->ERROR NUMBER RANGE! Please check code in method inputting Double!");
                }
                check = false;
            } catch (Exception e) {
                if (e instanceof InputMismatchException) {
                    System.out.println("   --->WRONG NUMBER FORMAT!");
                } else {
                    System.out.println(e.getMessage());
                }
                check = true;
            }
        }
        return inputDouble;
    }

    public static String inputChoice(String target, String content, String choice1, String choice2, String choice3) {
        String inputChoice = null;
        boolean check = true;
        while (check) {
            try {
                if (!content.isEmpty()) {
                    System.out.print(content);
                }
                ip = new Scanner(System.in);
                inputChoice = ip.nextLine();
                if (inputChoice.isEmpty()) {
                    throw new Exception("   --->NOT EMPTY STRING!");
                }
                if (!inputChoice.equalsIgnoreCase(choice1) && !inputChoice.equalsIgnoreCase(choice2) && !inputChoice.equalsIgnoreCase(choice3)) {
                    throw new Exception("   ---> " + target + " HAS ONLY ABOUT " + choice1 + "/" + choice2 + "/" + choice3);
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return inputChoice;
    }

    public static Date inputdate(String target, String content) {
        Date date = null;
        Date today = new Date();
        do {
            try {
                if (!content.isEmpty()) {
                    System.out.print(content);
                }
                ip = new Scanner(System.in);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);
                String dateInput = ip.nextLine();
                date = formatter.parse(dateInput);
                if (date.before(today)) {
                    throw new Exception("   ---> EXPRIED DATE MUST GREATER THAN CURRENT DATE!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (date == null || date.before(today));

        return date;
    }

    public static void writeFile(ArrayList<Object> list) throws IOException {
        FileOutputStream fos = new FileOutputStream("Food.txt");
        ObjectOutputStream oOT = new ObjectOutputStream(fos);
        for (Object object : list) {
            oOT.writeObject(object);
        }

        oOT.close();
        fos.close();
    }

    public static String matchPattern(String target, String content, String pattern) {
        String inputString = null;
        boolean check = true;
        while (check) {
            try {
                if (content != null) {
                    System.out.print(content);
                }
                ip = new Scanner(System.in);
                inputString = ip.nextLine();
                if (inputString.isEmpty()) {
                    throw new Exception("       ---> NOT EMPTY STRING!");
                }
                if (!inputString.matches(pattern)) {
                    throw new Exception("       ---> WRONG FORMAT CODE!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return inputString;
    }
}
