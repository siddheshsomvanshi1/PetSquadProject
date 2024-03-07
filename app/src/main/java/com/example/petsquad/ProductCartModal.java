package com.example.petsquad;

public class ProductCartModal {


    private String prodName;
    private String quantity;
    private String shopName;


    public ProductCartModal(String prodName, String quantity, String shopName) {
        this.prodName = prodName;
        this.quantity = quantity;
        this.shopName = shopName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}