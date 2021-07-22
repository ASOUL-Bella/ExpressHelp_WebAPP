package com.wcy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wcy.domain.Order;
import com.wcy.domain.PageListRes;
import com.wcy.mapper.OrderMapper;
import com.wcy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageListRes getAllOrders() {
        /*调用mapper 查询订单 */
        Page<Object> page = PageHelper.startPage(1,10);
        List<Order> orders = orderMapper.selectAll();
        /*封装成pageList*/
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(orders);
        return pageListRes;
    }

    @Override
    public void createOrder(Order order) {
        /*新增订单*/
        orderMapper.insert(order);
    }

    @Override
    public Order selectOrderById(Integer id) {
        /*根据id查询订单*/
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }

    @Override
    public void updateOrderById(Order order) {
        /*根据id更新订单*/
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void deleteOrderById(Integer id) {
        /*根据id删除订单*/
        orderMapper.deleteByPrimaryKey(id);
    }

}
