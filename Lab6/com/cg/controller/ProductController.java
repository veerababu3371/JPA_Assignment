package com.cg.controller;

import java.util.List;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Product;
import com.cg.beans.ProductV1;
import com.cg.dao.IProductDao;


@CrossOrigin(origins = "http://localhost:8086")
@RestController


public class ProductController {

	@Autowired
	IProductDao dao;
	@GetMapping("/Products")
	public List<Product>getAllProduct(){
		List<Product>list=dao.getAllProducts();
	return list;
}
	@ResponseStatus
	(value =HttpStatus.NOT_FOUND,
	reason ="Product with this id ot present")
	@ExceptionHandler({Exception.class})
	public void handleException(){

}
  @GetMapping("/products/Search/{txtId}")
  public Product getProductBYOId(@PathVariable int txtId){
  return dao.getProduct(txtId);
}
  @GetMapping("/v1/product")
	public List<ProductV1>getAllProductV1(Model model){
	  return dao.getAllProductsV1();
}
}