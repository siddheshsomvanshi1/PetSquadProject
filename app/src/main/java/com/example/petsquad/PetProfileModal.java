package com.example.petsquad;

public class PetProfileModal {
    private String petName;
    private String petAge;
    private String petBreed;
    private int id;

    public PetProfileModal(String petName, String petAge, String petBreed) {
        this.petName = petName;
        this.petAge = petAge;
        this.petBreed = petBreed;
    }


    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }


    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
