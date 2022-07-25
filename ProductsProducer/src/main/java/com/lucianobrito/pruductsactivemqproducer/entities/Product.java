package com.lucianobrito.pruductsactivemqproducer.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	
	private UUID id;
	private String name;
	private Double value;

}
