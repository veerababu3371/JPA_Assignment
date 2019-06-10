package com.cg.staticdb;

import java.util.HashMap;

import com.cg.beans.Product;

public class ProductDB 
{
static HashMap<Integer, Product> productIdMap =getProductIdMap();
static{
	if(productIdMap ==null)
	{
		productIdMap =new HashMap<Integer,Product>();
		Product indiaProduct = new Product(1,"Pen",10000);
		Product chinaProduct =new Product(4,"pencil", 20000);
		
		productIdMap.put(1, indiaProduct);
		productIdMap.put(4, chinaProduct);
	}
}
public static HashMap<Integer,Product>getProductIdMap(){

return productIdMap;

}
}
