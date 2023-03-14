package com.zensar.SB_by_Sharad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.SB_by_Sharad.Entity.Product;
import com.zensar.SB_by_Sharad.service.ProductServiceImpl;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;

	@GetMapping("/he")
	public String he() {
		return "<h2>hello</h2>";
	}

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public void insertProduct(@RequestBody Product product, @RequestHeader("Authorization") String authorization) {
		productServiceImpl.insertProduct(product, authorization);

	}

	@GetMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllProduct() {
		return productServiceImpl.getAllProduct();
	}

	@GetMapping(value = "/products/{productId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Product getProductByid(@PathVariable("productId") int productId) {
		return productServiceImpl.getProductByid(productId);
	}

	@DeleteMapping("/products/{productId}")
	public void deleteProductById(@PathVariable int productId) {
		productServiceImpl.deleteProductById(productId);
	}

	@PutMapping("/products/{productId}")
	public void updateProduct(@PathVariable("productId") int pid, @RequestBody Product p) {

		productServiceImpl.updateProduct(pid, p);
	}

}
