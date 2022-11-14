package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemDTO {

	private Long itemId;
	private String itemName;
	private Double itemUnitPrice;
	private Integer itemQuantity;

}
