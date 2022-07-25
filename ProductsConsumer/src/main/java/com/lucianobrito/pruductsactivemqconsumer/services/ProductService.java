package com.lucianobrito.pruductsactivemqconsumer.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianobrito.pruductsactivemqconsumer.entities.Product;
import com.lucianobrito.pruductsactivemqconsumer.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private ProductRepository repository;
	
	public void saveProduct(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			repository.save(mapper.readValue(json, Product.class));
		} catch (JsonProcessingException  e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
