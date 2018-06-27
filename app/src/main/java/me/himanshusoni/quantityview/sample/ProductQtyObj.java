package me.himanshusoni.quantityview.sample;

import me.himanshusoni.quantityview.QuantityView;

import static me.himanshusoni.quantityview.sample.MainActivity.toTwoPlaces;

public class ProductQtyObj {
    private QuantityView quantityView;
    private String productName;
    private int productQty;
    private float productPrice;

    public ProductQtyObj(String productName, QuantityView quantityView, float productPrice){
        this.quantityView = quantityView;
        this.productName = productName;
        this.productQty = quantityView.getQuantity();
        this.productPrice = productPrice;
    }

    public QuantityView getQuantityView() {
        return quantityView;
    }

    public void setQuantityView(QuantityView quantityView) {
        this.quantityView = quantityView;
    }

    public double getTotal() {
        return toTwoPlaces(productPrice*productQty);
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQty() {
        return productQty;
    }
}