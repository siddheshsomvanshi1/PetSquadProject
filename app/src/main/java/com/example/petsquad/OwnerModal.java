package com.example.petsquad;

public class OwnerModal {

    private String ownerName;
    private  String ownerEmail;
    private int id;


    public OwnerModal(String ownerName, String ownerEmail) {
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
