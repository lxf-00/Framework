package com.lxf.dao;

import com.lxf.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
/*
 ID                                        NOT NULL VARCHAR2(32)
 PRODUCTNUM                                NOT NULL VARCHAR2(50)
 PRODUCTNAME                                        VARCHAR2(50)
 CITYNAME                                           VARCHAR2(50)
 DEPARTURETIME                                      TIMESTAMP(6)
 PRODUCTPRICE                                       NUMBER
 PRODUCTDESC                                        VARCHAR2(500)
 PRODUCTSTATUS
 */

public interface ProductDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * 保存功能
     * @param product
     */
    @Update("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)values(" +
            "#{productNum}, #{productName},#{cityName}, #{departureTime}, #{productPrice}, #{productDesc}" +
            ",#{productStatus})")
    void save(Product product);

    @Select("select * from product where id = #{id}")
    Product findById(String id);
}
