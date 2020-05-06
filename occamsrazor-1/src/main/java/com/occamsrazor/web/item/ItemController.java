package com.occamsrazor.web.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired ItemService itemService;
	@GetMapping("")
	public List<Item> list(){
		return itemService.findAll();
	}
}
