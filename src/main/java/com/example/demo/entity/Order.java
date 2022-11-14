package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.orderenum.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date orderDate;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;
    
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items;
	
}
