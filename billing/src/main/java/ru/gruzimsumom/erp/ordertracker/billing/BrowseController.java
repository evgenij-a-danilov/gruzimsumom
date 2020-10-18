package ru.gruzimsumom.erp.ordertracker.billing;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static java.lang.Math.toIntExact;


import org.springframework.beans.factory.annotation.Autowired;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.journaldev.jackson.model.Address;
//import com.journaldev.jackson.model.Employee;
//import com.example2.demo2.LocationDAO;
//import com.example2.demo2.LocationTransactionException;
//import com.example2.demo2.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.util.MimeType;
import org.springframework.http.MediaType;

@RestController
//@Controller
@RequestMapping("browse")

public class BrowseController {



    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/showAllOrders")
    public List<Order> getOrder() {
        List<Order> orderList = orderDAO.getOrders();

        return orderList;
    }

    @GetMapping("/showLastOrderID")
    public String getLastOrderId() {
        String orderList = orderDAO.getOrderByID(new String("1"));

        return orderList;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
