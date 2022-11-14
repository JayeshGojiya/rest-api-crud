package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;
import com.example.demo.services.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/")
@Slf4j
public class OrderController {

	@Autowired
	private OrderService productService;
	
	@GetMapping(value = "order")
	public List<Order> getProduct(){
		return productService.getAllProduct();
	} 
	
	@PostMapping(value = "order/create")
	public ResponseEntity<String> createProduct(@RequestBody List<OrderDTO> order){
		try {
			productService.createOrder(order);
			return ResponseEntity.ok("order created");
		} catch (Exception e){
			log.error("Error while create order -> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
