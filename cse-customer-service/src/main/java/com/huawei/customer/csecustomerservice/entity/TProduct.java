package com.huawei.customer.csecustomerservice.entity;

public class TProduct {
  private String id;

  private String prodName;

  private Boolean reserved;

  private Double price;

  private String sellerUserId;

  private String buyerUserId;

  private String imageUrl;

  private String deacription;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getProdName() {
    return prodName;
  }

  public void setProdName(String prodName) {
    this.prodName = prodName == null ? null : prodName.trim();
  }

  public Boolean getReserved() {
    return reserved;
  }

  public void setReserved(Boolean reserved) {
    this.reserved = reserved;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getSellerUserId() {
    return sellerUserId;
  }

  public void setSellerUserId(String sellerUserId) {
    this.sellerUserId = sellerUserId == null ? null : sellerUserId.trim();
  }

  public String getBuyerUserId() {
    return buyerUserId;
  }

  public void setBuyerUserId(String buyerUserId) {
    this.buyerUserId = buyerUserId == null ? null : buyerUserId.trim();
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl == null ? null : imageUrl.trim();
  }

  public String getDeacription() {
    return deacription;
  }

  public void setDeacription(String deacription) {
    this.deacription = deacription == null ? null : deacription.trim();
  }

  @Override
  public String toString() {
    return "TProduct{" +
        "id='" + id + '\'' +
        ", prodName='" + prodName + '\'' +
        ", reserved=" + reserved +
        ", price=" + price +
        ", sellerUserId='" + sellerUserId + '\'' +
        ", buyerUserId='" + buyerUserId + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        ", deacription='" + deacription + '\'' +
        '}';
  }
}