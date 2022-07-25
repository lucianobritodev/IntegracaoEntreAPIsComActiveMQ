package com.lucianobrito.pruductsactivemqconsumer.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceListener {
	
	private ProductService productService;

    @JmsListener(destination = "fila.products")
    public void onReceiverQueue(String str) {
        productService.saveProduct(str);
    }

    @JmsListener(destination = "topic.products", containerFactory = "jmsFactoryTopic")
    public void onReceiverTopic(String str) {
        System.out.println( str );
    }
	
}
