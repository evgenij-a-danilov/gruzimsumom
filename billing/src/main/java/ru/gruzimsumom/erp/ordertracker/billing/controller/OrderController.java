package ru.gruzimsumom.erp.ordertracker.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gruzimsumom.erp.ordertracker.billing.Order;
import ru.gruzimsumom.erp.ordertracker.billing.OrderDAO;

import java.util.List;

//import com.journaldev.jackson.model.Address;
//import com.journaldev.jackson.model.Employee;
//import com.example2.demo2.LocationDAO;
//import com.example2.demo2.LocationTransactionException;
//import com.example2.demo2.Location;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping()
    public List<Order> getOrders() {
        List<Order> orderList = orderDAO.getOrders();
        return orderList;
    }

    @GetMapping("/showLastOrderID")
    public long getLastOrderId() {
        long orderList = orderDAO.getOrderByID("1");

        return orderList;
    }

}

//    @RequestMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }


