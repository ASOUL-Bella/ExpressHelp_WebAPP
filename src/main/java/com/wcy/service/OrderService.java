package com.wcy.service;

import com.wcy.domain.Order;
import com.wcy.domain.PageListRes;

public interface OrderService {

    /*查询所有订单*/
    PageListRes getAllOrders();

    /*新增订单*/
    void createOrder(Order order);

    /*根据id查询订单*/
    Order selectOrderById(Integer id);

    /*根据id更新订单*/
    void updateOrderById(Order order);

    /*根据id删除订单*/
    void deleteOrderById(Integer id);
}
