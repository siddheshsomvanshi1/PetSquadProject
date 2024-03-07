package com.example.petsquad;

public class ProductModal {

    private String productName;
    private String productDescription;
    private String productCost;
    private int pid;

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public String getproductDescription() {
        return productDescription;
    }

    public void setproductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getproductCost() {
        return productCost;
    }

    public void setproductCost(String productCost) {
        this.productCost = productCost;
    }

    public int getId() {
        return pid;
    }

    public void setId(int pid) {
        this.pid = pid;
    }

    public ProductModal(String productName, String productDescription, String productCost) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
    }

}
