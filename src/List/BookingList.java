/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Booking;
import Input.Tool;

/**
 *
 * @author Admin
 */
public class BookingList {

    static BookingNode head;
    static BookingNode tail;

    public Booking inputBooking(TrainList tList, CustomerList cList) {
        String tcode;
        String ccode;
        int seat = 0;
        boolean flag = false;
        Booking b = null;

        do {
            try {
                tList.traverse();
                tcode = Tool.matchPattern("TCODE", "--> Input Code of Train (Bxx): ", "B\\d\\d");

                if (tList.searchNode(tcode) == -1) {
                    throw new Exception("    ---> TRAIN CODE DOESN'T EXIST!");
                }
                if (tList.GetNth(tList.searchNode(tcode)).getBooked() == tList.GetNth(tList.searchNode(tcode)).getSeat()) {
                    throw new Exception("    ---> TRAIN IS EXHAUTED!");
                }
                cList.traverse();
                ccode = Tool.matchPattern("TCODE", "--> Input Code of Customer (Cxx): ", "C\\d\\d");
                if (cList.searchNode(ccode) == -1) {
                    throw new Exception("    ---> CUSTOMER CODE DOESN'T EXIST!");
                }
                if (!isEmpty()) {
                    if (searchBooking(tcode, ccode) != -1) {
                        throw new Exception("    ---> TRAIN AND CUSTOMER ALREADY BOOKED!");
                    }
                }
                System.out.println(tList.GetNth(tList.searchNode(tcode)));
                seat = Tool.nextInt("Seat", "--> Input Seat of Train (1-100): ", 1, 100);

                if (tList.GetNth(tList.searchNode(tcode)).getAvailable_seat() < seat) {
                    throw new Exception("    ---> NOT ENOUGHT AVAILABLE SEAT FOR YOUR BOOKED!");
                }
                b = new Booking(tcode, ccode, seat);
                flag = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("DO YOU WANT TO BOOKING AGAIN?");
                flag = Tool.yesNoQuestion();
            }

        } while (flag);

        return b;
    }

    public boolean addToTail(Booking value) {
        if (value == null) {
            return false;
        }
        BookingNode n1 = new BookingNode(value);
        if (head == null) {
            head = n1;
            tail = n1;
        } else {
            tail.next = n1;
            tail = n1;
        }
        return true;
    }

    public int searchBooking(String tcode, String ccode) throws Exception {

        BookingNode current = head;

        int i = 0;
        boolean flag = false;
        if (head == null) {
            throw new Exception("   ---> BOOKING LIST IS EMPTY!");
        } else {
            while (current != null) {
                if (current.data.gettCode().equals(tcode) && current.data.getcCode().equals(ccode)) {
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

    public boolean isEmpty() {
        return head == null;
    }

    public void traverse() {
        BookingNode current = head;
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

    public void sortBookingList() {
        BookingNode current = head;
        BookingNode index = null;
        Booking temp;

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
                        index = index.next;
                    }
                }

                current = current.next;
            }

            current = head;
            index = null;

            while (current != null) {
                index = current.next;

                while (index != null) {

                    if (current.data.gettCode().equals(index.data.gettCode())) {
                        if (current.data.getcCode().compareTo(index.data.getcCode()) > 0) {
                            temp = current.data;
                            current.data = index.data;
                            index.data = temp;
                        }
                        index = index.next;
                    } else {
                        index = index.next;
                    }
                }
                current = current.next;
            }
        }
    }

}
