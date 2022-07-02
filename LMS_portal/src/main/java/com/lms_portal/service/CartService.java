package com.lms_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lms_portal.entity.Cart;
import com.lms_portal.repo.CartRepo;

@Service
public class CartService {
	@Autowired
	private CartRepo cartrepo;
	
	public List<Cart> allCartList(){
		return cartrepo.findAll();
	}
	
	public List<Cart> addcart(@RequestBody Cart cartlist){
		cartrepo.save(cartlist);
		return cartrepo.findAll();
	}
	
	public List<Cart> updatecart(@RequestBody Cart cartlist){
		cartrepo.save(cartlist);
		return cartrepo.findAll();
	}

}
