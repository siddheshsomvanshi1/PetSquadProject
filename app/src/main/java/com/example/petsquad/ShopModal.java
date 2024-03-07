package com.example.petsquad;

public class ShopModal {

    private String shopName;
    private String shopAddress;
    private String shopEmail;
    private int pid;


    public ShopModal(String shopName, String shopAddress, String shopEmail) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopEmail = shopEmail;
    }


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
