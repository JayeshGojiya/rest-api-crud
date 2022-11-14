package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.orderenum.OrderStatus;
import com.example.demo.repository.ItemRepo;
import com.example.demo.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	
	public List<Order> getAllProduct(){
		return orderRepo.findAll();
	}
	
	public void createOrder(List<OrderDTO> orderDTOList){
	
		List<Order> orderList = new ArrayList<>();
		for(OrderDTO orderDTO: orderDTOList) {
			Order order = new Order();
			order.setOrderStatus(OrderStatus.NEW);
			order.setOrderDate(orderDTO.getOrderDate());
			
			List<Item> itemList = new ArrayList<>();
			for(ItemDTO itemDTO : orderDTO.getItems()) {
				Item item = new Item();
				BeanUtils.copyProperties(itemDTO, item);
				itemList.add(item);
			}
//			itemList = itemRepo.saveAll(itemList);
			
			order.setItems(itemList);
			orderList.add(order);
		}
		
		orderList = orderRepo.saveAll(orderList);
		System.out.println("orderList =>" + orderList.toString());
	}
}
