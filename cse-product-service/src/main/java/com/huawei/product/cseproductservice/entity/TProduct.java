package com.huawei.product.cseproductservice.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TProduct {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.ID
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.PROD_NAME
     *
     * @mbg.generated
     */
    private String prodName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.RESERVED
     *
     * @mbg.generated
     */
    private Boolean reserved;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.PRICE
     *
     * @mbg.generated
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.SELLER_USER_ID
     *
     * @mbg.generated
     */
    private String sellerUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.BUYER_USER_ID
     *
     * @mbg.generated
     */
    private String buyerUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.IMAGE_URL
     *
     * @mbg.generated
     */
    private String imageUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.DEACRIPTION
     *
     * @mbg.generated
     */
    private String deacription;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.ID
     *
     * @return the value of t_product.ID
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.ID
     *
     * @param id the value for t_product.ID
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.PROD_NAME
     *
     * @return the value of t_product.PROD_NAME
     *
     * @mbg.generated
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.PROD_NAME
     *
     * @param prodName the value for t_product.PROD_NAME
     *
     * @mbg.generated
     */
    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.RESERVED
     *
     * @return the value of t_product.RESERVED
     *
     * @mbg.generated
     */
    public Boolean getReserved() {
        return reserved;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.RESERVED
     *
     * @param reserved the value for t_product.RESERVED
     *
     * @mbg.generated
     */
    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.PRICE
     *
     * @return the value of t_product.PRICE
     *
     * @mbg.generated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.PRICE
     *
     * @param price the value for t_product.PRICE
     *
     * @mbg.generated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.SELLER_USER_ID
     *
     * @return the value of t_product.SELLER_USER_ID
     *
     * @mbg.generated
     */
    public String getSellerUserId() {
        return sellerUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.SELLER_USER_ID
     *
     * @param sellerUserId the value for t_product.SELLER_USER_ID
     *
     * @mbg.generated
     */
    public void setSellerUserId(String sellerUserId) {
        this.sellerUserId = sellerUserId == null ? null : sellerUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.BUYER_USER_ID
     *
     * @return the value of t_product.BUYER_USER_ID
     *
     * @mbg.generated
     */
    public String getBuyerUserId() {
        return buyerUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.BUYER_USER_ID
     *
     * @param buyerUserId the value for t_product.BUYER_USER_ID
     *
     * @mbg.generated
     */
    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId == null ? null : buyerUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.IMAGE_URL
     *
     * @return the value of t_product.IMAGE_URL
     *
     * @mbg.generated
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.IMAGE_URL
     *
     * @param imageUrl the value for t_product.IMAGE_URL
     *
     * @mbg.generated
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.DEACRIPTION
     *
     * @return the value of t_product.DEACRIPTION
     *
     * @mbg.generated
     */
    public String getDeacription() {
        return deacription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.DEACRIPTION
     *
     * @param deacription the value for t_product.DEACRIPTION
     *
     * @mbg.generated
     */
    public void setDeacription(String deacription) {
        this.deacription = deacription == null ? null : deacription.trim();
    }

}