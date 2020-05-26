package com.lxf.service.impl;

import com.github.pagehelper.PageHelper;
import com.lxf.dao.OrdersDao;
import com.lxf.domain.Orders;
import com.lxf.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) {
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
