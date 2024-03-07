package com.example.petsquad;

public class TreatmentModal {

    private String treatmentName;
    private String treatmentDescription;
    private String treatmentCost;
    private int id;

    public String gettreatmentName() {
        return treatmentName;
    }

    public void settreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String gettreatmentDescription() {
        return treatmentDescription;
    }

    public void settreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public String gettreatmentCost() {
        return treatmentCost;
    }

    public void settreatmentCost(String treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreatmentModal(String treatmentName, String treatmentDescription, String treatmentCost) {
        this.treatmentName = treatmentName;
        this.treatmentDescription = treatmentDescription;
        this.treatmentCost = treatmentCost;
    }
}
