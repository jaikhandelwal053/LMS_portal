package com.lms_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms_portal.entity.Cart;
import com.lms_portal.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	@GetMapping("/")
	public List<Cart> getall(){
		return cartService.allCartList();
	}

	@PostMapping("/")
	public List<Cart> postdata(@RequestBody Cart carts){
		return cartService.addcart(carts);
	}
	@PutMapping("/")
	public List<Cart> putdata(@RequestBody Cart carts){
		return cartService.updatecart(carts);
	}
}
