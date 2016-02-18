/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoo.finance;

/**
 *
 * @author 200240927
 */
public class Manufacturer {
    
    private final int id;
    private String name, address, phone, contact;

    public Manufacturer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Manufacturer(int id, String name, String address, String phone, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public Manufacturer setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Manufacturer setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Manufacturer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public Manufacturer setContact(String contact) {
        this.contact = contact;
        return this;
    }
    
}
