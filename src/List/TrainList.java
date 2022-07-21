/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Train;
import Input.Tool;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class TrainList {

    static TrainNode head;
    static TrainNode tail;

    public TrainList readFile(String fileName) {
        FileReader fr = null;
        BufferedReader bf = null;
        TrainList tList = new TrainList();
        try {
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);
            while (bf.ready()) {
                String s = bf.readLine();
                StringTokenizer tmp = new StringTokenizer(s, " \\| ");
                Train t = new Train();
                if (tmp.countTokens() == 6) {
                    t.settCode(tmp.nextToken());
                    t.settName(tmp.nextToken());
                    t.setSeat(Integer.parseInt(tmp.nextToken()));
                    t.setBooked(Integer.parseInt(tmp.nextToken()));
                    t.setDepart_time(Double.parseDouble(tmp.nextToken()));
                    t.setDepart_place(tmp.nextToken());
                    tList.addToTail(t);
                }
                if (tmp.countTokens() == 7) {
                    t.settCode(tmp.nextToken());
                    t.settName(tmp.nextToken());
                    t.setSeat(Integer.parseInt(tmp.nextToken()));
                    t.setBooked(Integer.parseInt(tmp.nextToken()));
                    t.setDepart_time(Double.parseDouble(tmp.nextToken()));
                    t.setDepart_place(tmp.nextToken());
                    t.setAvailable_seat(Integer.parseInt(tmp.nextToken()));
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

    public void clear() {
        TrainNode temp = head;
        while (temp != null) {
            temp.next = null;
            head = null;
            temp = temp.next;
        }
    }

    public int count() {
        int count = 0;
        TrainNode current = head;
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

    public boolean isEmpty() {
        return head == null;
    }

    public void writeFile(String fileName, TrainList list) {
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

    public Train inputTrain(TrainList list) {
        String tcode;
        do {
            tcode = Tool.matchPattern("TCODE", "--> Input Code of Train (Bxx - Number): ", "B\\d\\d");
            if (checkExist(list, tcode)) {
                System.out.println("    ---> THIS TRAIN HAS ALREADY EXIST!");
            }
        } while (checkExist(list, tcode));

        String name = Tool.nextLine("TNname", "--> Input Name of Train: ");
        int seat = Tool.nextInt("Seat", "--> Input Seat of Train (1-100): ", 1, 100);
        int booked = 100;
        do {
            booked = Tool.nextInt("TBOOKED", "--> Input Booked of Train (1-100): ", 1, 100);
            if (booked > seat) {
                System.out.println("        ---> BOOKED CAN'T GREATER THAN SEAT!");
            }
        } while (booked > seat);
        double depart_time = Tool.nextDouble("Time", "--> Input Depart_Time of Train: ", 0, 23.59);
        String depart_placce = Tool.matchPattern("Place", "--> Input Place of Train (Px): ", "P\\w");
        Train t = new Train(tcode, name.toUpperCase(), seat, booked, depart_time, depart_placce.toUpperCase());
        return t;
    }

    public Train GetNth(int index) {
        TrainNode current = head;
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

    public boolean addToTail(Train value) {
        if (value == null) {
            return false;
        }
        TrainNode n1 = new TrainNode(value);
        if (head == null) {
            head = n1;
            tail = n1;
        } else {
            tail.next = n1;
            tail = n1;
        }
        return true;
    }

    public void insertAfter(int prev_position, Train new_data) {
        if (GetNth(prev_position) == null) {
            System.out.println("    ---> THIS POSITION DOESN'T EXIST!");
            return;
        }
        TrainNode prev_node = new TrainNode(GetNth(prev_position));

        TrainNode current = head;
        while (current != prev_node) {
            current = current.next;
        }
        prev_node = current;

        TrainNode new_node = new TrainNode(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;

        //return true;
    }

    public void traverse() {
        TrainNode current = head;
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

    public boolean checkExist(TrainList list, String xCode) {
        TrainNode current = head;
        if (current == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {
                if (current.data.gettCode().equals(xCode)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public int searchNode(String xcode) {

        TrainNode current = head;

        int i = 0;
        boolean flag = false;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {
                if (current.data.gettCode().equals(xcode)) {
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

    public void sortList() {
        TrainNode current = head;
        TrainNode index = null;
        Train temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.data.gettCode().compareTo(index.data.gettCode()) > 0) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    } else {
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public boolean deleteByTCode(String key) {
        TrainNode temp = head;
        TrainNode prev = null;

        if (temp != null && temp.data.gettCode().equals(key)) {
            head = temp.next;
            System.out.println("    Deleted!");
            return true;
        }
        while (temp != null && !temp.data.gettCode().equals(key)) {
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

    public void insertAfter(Train data, int position) {
        TrainNode node = new TrainNode();
        node.data = data;
        node.next = null;
        position++;
        if (this.head == null) {
            if (position != 0) {
                return;
            } else {
                this.head = node;
            }
        }
        if (head != null && position == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }
        TrainNode current = this.head;
        TrainNode previous = null;
        int i = 0;
        while (i < position) {
            previous = current;
            current = current.next;

            if (current == null) {
                break;
            }
            i++;
        }
        node.next = current;
        previous.next = node;
    }

    TrainNode GetNode(Train data) {
        return new TrainNode(data);
    }

    public void removeBefore(TrainNode p) {

        TrainNode to_delete = p;
        to_delete = to_delete.next;

        if (to_delete != null) {
            if (to_delete.next != null) {
                to_delete.next.prev = to_delete.prev;
            }
            if (to_delete.prev != null) {
                to_delete.prev.next = to_delete.next;
            }

            if (to_delete == head) {
                head = to_delete.next;
            }

        }

    }

    public boolean deleteBeforeNode(String xCode) {
        
        if (head == null) {
            return false;
        }
        int position = searchNode(xCode);
        
        if (position == 0) {
            return false;
        }

        if (position == -1)
            return false;
        else
            position--;
        
        TrainNode temp = head;

        if (position == 0){
            head = temp.next;
        }
        
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            return false;
        }

        TrainNode next = temp.next.next;

        temp.next = next;  
        return true;
    }
}
