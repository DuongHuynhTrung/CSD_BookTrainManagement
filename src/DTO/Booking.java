/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


/**
 *
 * @author Admin
 */
public class Booking {

    private String tCode;
    private String cCode;
    private int seat;

    public Booking() {
    }

    public Booking(String tCode, String cCode, int seat) {
        this.tCode = tCode;
        this.cCode = cCode;
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    @Override
    public String toString() {
        return tCode + " | " + cCode + " | " + seat;
    }

   
}
