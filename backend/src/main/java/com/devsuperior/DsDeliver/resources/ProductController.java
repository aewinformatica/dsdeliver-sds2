package com.devsuperior.DsDeliver.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DsDeliver.dto.ProductDTO;
import com.devsuperior.DsDeliver.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		
		List<ProductDTO> list = productService.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
