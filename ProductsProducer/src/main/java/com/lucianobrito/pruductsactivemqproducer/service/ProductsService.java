package com.lucianobrito.pruductsactivemqproducer.service;

import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianobrito.pruductsactivemqproducer.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductsService {
	
	private JmsTemplate jmsTemplate;
    private ObjectMapper mapper;

	public void sendProduct(Product product) throws JmsException, JsonProcessingException {
		 jmsTemplate.convertAndSend("fila.products", mapper.writeValueAsString(product));
	}
	
}
