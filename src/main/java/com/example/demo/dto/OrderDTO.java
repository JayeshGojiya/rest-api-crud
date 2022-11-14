package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.orderenum.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long orderId;
    
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date orderDate;
    
    private OrderStatus orderStatus;
    
    private List<ItemDTO> items;

}

