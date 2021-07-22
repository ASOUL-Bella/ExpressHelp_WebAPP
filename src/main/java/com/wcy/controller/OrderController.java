package com.wcy.controller;

import com.wcy.domain.AjaxRes;
import com.wcy.domain.Order;
import com.wcy.domain.PageListRes;
import com.wcy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    /*注入业务层*/
    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Order getOrderById(@PathVariable("id") Integer id) {
        /*调用业务层根据id查询订单*/
        Order order = orderService.selectOrderById(id);
        return order;
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    public PageListRes getAllOrders() {
        /*调用业务层获取所有订单*/
        PageListRes pageListRes = orderService.getAllOrders();
        return pageListRes;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public AjaxRes createOrder(@RequestBody Order order) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存订单*/
            orderService.createOrder(order);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
        }
        return ajaxRes;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public AjaxRes updateOrder(@RequestBody Order order) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,更新订单*/
            orderService.updateOrderById(order);
            ajaxRes.setMsg("更新成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("更新失败");
        }
        return ajaxRes;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public AjaxRes deleteOrder(Integer id) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,删除订单*/
            orderService.deleteOrderById(id);
            ajaxRes.setMsg("删除成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("删除失败");
        }
        return ajaxRes;
    }

}
