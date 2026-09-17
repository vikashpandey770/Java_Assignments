package com.foodorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodorder.dao.OrderDAO;
import com.foodorder.model.Order;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listOrders() {
        ModelAndView mv = new ModelAndView("orders-list");
        mv.addObject("orders", orderDAO.getAllOrders());
        return mv;
    }

    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public ModelAndView placeOrder(Order order) {
        orderDAO.insertOrder(order);
        return new ModelAndView("redirect:/orders/list");
    }
}
