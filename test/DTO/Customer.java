/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DTO.*;

/**
 *
 * @author Admin
 */
public class Customer {
    private String cCode;
    private String cus_Name;
    private String phone;

    public Customer() {
    }

    public Customer(String cCode, String cus_Name, String phone) {
        this.cCode = cCode;
        this.cus_Name = cus_Name;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getCus_Name() {
        return cus_Name;
    }

    public void setCus_Name(String cus_Name) {
        this.cus_Name = cus_Name;
    }

    @Override
    public String toString() {
        return cCode + " | " + cus_Name + " | " + phone ;
    }
    
    
}
