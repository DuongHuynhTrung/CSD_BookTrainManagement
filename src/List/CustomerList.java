/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Customer;
import Input.Tool;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class CustomerList {

    static CustomerNode head;
    static CustomerNode tail;
    TrainList tlistList;

    public CustomerList readFile(String fileName) {
        FileReader fr = null;
        BufferedReader bf = null;
        CustomerList tList = new CustomerList();
        try {
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);
            while (bf.ready()) {
                String s = bf.readLine();
                StringTokenizer tmp = new StringTokenizer(s, " \\| ");
                Customer t = new Customer();
                if (tmp.countTokens() == 3) {
                    t.setcCode(tmp.nextToken());
                    t.setCus_Name(tmp.nextToken());
                    t.setPhone(tmp.nextToken());
                    tList.addToTail(t);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return tList;
    }

    public Customer inputCustomer() {
        String cCode;
        do {
            cCode = Tool.matchPattern("TCODE", "--> Input Code of Customer (Cxx - Number): ", "C\\d\\d");
            if (checkExist(this, cCode))
                System.out.println("    ---> THIS CUSTOMER HAS ALREADY EXIST!");
        } while (checkExist(this, cCode));
        String name = Tool.nextLine("TNname", "--> Input Name of Customer: ");
        String phone = Tool.matchPattern("Phone", "--> Input Phone of Customer (xxxx - Number): ", "\\d\\d\\d\\d");
        Customer t = new Customer(cCode, name, phone);
        return t;
    }

    public boolean addToTail(Customer value) {
        if (value == null) {
            return false;
        }
        CustomerNode n1 = new CustomerNode(value);
        if (head == null) {
            head = n1;
            tail = n1;
        } else {
            tail.next = n1;
            tail = n1;
        }
        return true;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        CustomerNode temp = head;
        while (temp != null) {
            temp.next = null;
            head = null;
            temp = temp.next;
        }
    }

    public int count() {
        int count = 0;
        CustomerNode current = head;
        if (current == null) {
            return count;
        } else {
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;
    }

    public void writeFile(String fileName, CustomerList list) {
        PrintWriter w = null;

        try {
            w = new PrintWriter(fileName);
            for (int i = 0; i < list.count(); i++) {
                w.println(list.GetNth(i).toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public Customer GetNth(int index) {
        CustomerNode current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        assert (false);
        return null;
    }

    public void traverse() {
        CustomerNode current = head;
        if (current == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {
                System.out.print(current.data);
                current = current.next;
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public boolean checkExist(CustomerList list, String xCode) {
        CustomerNode current = head;
        if (current == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {
                if (current.data.getcCode().equals(xCode)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public int searchNode(String xcode) {
        CustomerNode current = head;

        int i = 0;
        boolean flag = false;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {
                if (current.data.getcCode().equals(xcode)) {
                    flag = true;
                    break;
                }
                i++;
                current = current.next;
            }
        }
        if (flag) {
            return i;
        } else {
            return -1;
        }
    }

    public boolean deleteByTCode(String key) {
        CustomerNode temp = head;
        CustomerNode prev = null;

        if (temp != null && temp.data.getcCode().equals(key)) {
            head = temp.next;
            System.out.println("    Deleted!");
            return true;
        }
        while (temp != null && !temp.data.getcCode().equals(key)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("This value doesn't exist!");
            return false;
        }

        prev.next = temp.next;
        System.out.println("    Deleted!");
        return true;
    }
}
