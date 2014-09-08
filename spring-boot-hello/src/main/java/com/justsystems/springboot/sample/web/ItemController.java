package com.justsystems.springboot.sample.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.justsystems.springboot.sample.domain.entity.Item;
import com.justsystems.springboot.sample.service.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	private ItemService service;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Item> all() {
		return new ArrayList<>();
	}

	 @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public @ResponseBody Item find(@PathVariable Long id) {
		return service.find(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Item create(@RequestBody @Valid final Item item) {
		return service.save(item);
	}

}
