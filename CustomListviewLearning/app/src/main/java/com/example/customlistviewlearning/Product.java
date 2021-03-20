package com.example.customlistviewlearning;

public class Product {
    private boolean isSale;
    private String product,img,price,des;

    public Product(boolean isSale, String product, String img, String price, String des) {
        this.isSale = isSale;
        this.product = product;
        this.img = img;
        this.price = price;
        this.des = des;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
