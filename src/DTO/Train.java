/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Train implements Serializable {

    private String tCode;
    private String tName;
    private int seat;
    private int booked;
    private double depart_time;
    private String depart_place;
    private int available_seat;

    public Train() {
    }

    public Train(String tCode, String tName, int seat, int booked, double depart_time, String depart_place) {
        this.tCode = tCode;
        this.tName = tName;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.depart_place = depart_place;
    }

    public Train(String tCode, String tName, int seat, int booked, double depart_time, String depart_place, int available_seat) {
        this.tCode = tCode;
        this.tName = tName;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.depart_place = depart_place;
        this.available_seat = available_seat;
    }

    public String getDepart_place() {
        return depart_place;
    }

    public void setDepart_place(String depart_place) {
        this.depart_place = depart_place;
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(double depart_time) {
        this.depart_time = depart_time;
    }

    @Override
    public String toString() {
        return tCode + " | " + tName + " | " + seat + " | " + booked + " | " + depart_time + " | " + depart_place + " | " + getAvailable_seat();
    }

    public int getAvailable_seat() {
        return seat - booked;
    }

    public void setAvailable_seat(int available_seat) {
        this.available_seat = available_seat;
    }

    
}
