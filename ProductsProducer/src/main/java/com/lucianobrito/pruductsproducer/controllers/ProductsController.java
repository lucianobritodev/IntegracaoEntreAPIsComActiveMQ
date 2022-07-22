package com.lucianobrito.pruductsproducer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lucianobrito.pruductsproducer.entities.Product;
import com.lucianobrito.pruductsproducer.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsService service;
	
	@PostMapping
	public ResponseEntity<Void> getProducts(@RequestBody Product product) {
		try {
			service.sendProduct(product);
		} catch (JmsException | JsonProcessingException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
}
