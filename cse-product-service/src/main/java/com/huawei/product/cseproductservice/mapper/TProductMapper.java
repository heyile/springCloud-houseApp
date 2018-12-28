package com.huawei.product.cseproductservice.mapper;

import com.huawei.product.cseproductservice.entity.TProduct;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_product",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_product (ID, PROD_NAME, ",
        "RESERVED, PRICE, SELLER_USER_ID, ",
        "BUYER_USER_ID, IMAGE_URL, ",
        "DEACRIPTION)",
        "values (#{id,jdbcType=VARCHAR}, #{prodName,jdbcType=VARCHAR}, ",
        "#{reserved,jdbcType=BIT}, #{price,jdbcType=DECIMAL}, #{sellerUserId,jdbcType=VARCHAR}, ",
        "#{buyerUserId,jdbcType=VARCHAR}, #{imageUrl,jdbcType=VARCHAR}, ",
        "#{deacription,jdbcType=VARCHAR})"
    })
    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
        statement = "select replace(uuid(), '-', '') as id from dual")
    int insert(TProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "ID, PROD_NAME, RESERVED, PRICE, SELLER_USER_ID, BUYER_USER_ID, IMAGE_URL, DEACRIPTION",
        "from t_product",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PROD_NAME", property="prodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESERVED", property="reserved", jdbcType=JdbcType.BIT),
        @Result(column="PRICE", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="SELLER_USER_ID", property="sellerUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="BUYER_USER_ID", property="buyerUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="IMAGE_URL", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEACRIPTION", property="deacription", jdbcType=JdbcType.VARCHAR)
    })
    TProduct selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "ID, PROD_NAME, RESERVED, PRICE, SELLER_USER_ID, BUYER_USER_ID, IMAGE_URL, DEACRIPTION",
        "from t_product"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PROD_NAME", property="prodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESERVED", property="reserved", jdbcType=JdbcType.BIT),
        @Result(column="PRICE", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="SELLER_USER_ID", property="sellerUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="BUYER_USER_ID", property="buyerUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="IMAGE_URL", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEACRIPTION", property="deacription", jdbcType=JdbcType.VARCHAR)
    })
    List<TProduct> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated
     */
    @Update({
        "update t_product",
        "set PROD_NAME = #{prodName,jdbcType=VARCHAR},",
          "RESERVED = #{reserved,jdbcType=BIT},",
          "PRICE = #{price,jdbcType=DECIMAL},",
          "SELLER_USER_ID = #{sellerUserId,jdbcType=VARCHAR},",
          "BUYER_USER_ID = #{buyerUserId,jdbcType=VARCHAR},",
          "IMAGE_URL = #{imageUrl,jdbcType=VARCHAR},",
          "DEACRIPTION = #{deacription,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TProduct record);
}