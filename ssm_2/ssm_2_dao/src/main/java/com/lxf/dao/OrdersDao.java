package com.lxf.dao;

import com.lxf.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    @Select("select * from orders")
    @Results(
            value = {
                    @Result(id=true, property = "id", column = "id"),
                    @Result(property = "orderNum", column = "orderNum"),
                    @Result(property = "orderTime", column = "orderTime"),
                    @Result(property = "peopleCount", column = "peopleCount"),
                    @Result(property = "orderDesc", column = "orderDesc"),
                    @Result(property = "payType", column = "payType"),
                    @Result(property = "orderStatus", column = "orderStatus"),
                    @Result(property = "product", column = "productId", one=@One(select = "com.lxf.dao.ProductDao.findById"))
            }
    )
    List<Orders> findAll();

    @Select("select * from orders where id = #{id}")
    @Results(
            value = {
                    @Result(id=true, property = "id", column = "id"),
                    @Result(property = "orderNum", column = "orderNum"),
                    @Result(property = "orderTime", column = "orderTime"),
                    @Result(property = "peopleCount", column = "peopleCount"),
                    @Result(property = "orderDesc", column = "orderDesc"),
                    @Result(property = "payType", column = "payType"),
                    @Result(property = "orderStatus", column = "orderStatus"),
                    @Result(property = "product", column = "productId", one=@One(select = "com.lxf.dao.ProductDao.findById")),
                    @Result(property = "member", column = "memberId", one=@One(select = "com.lxf.dao.MemberDao.findById")),
                    @Result(property = "travellers", column = "id",javaType = java.util.List.class, many=@Many(select = "com.lxf.dao.TravellerDao.findByOrdersId"))
            }
    )
    Orders findById(String id);
}
