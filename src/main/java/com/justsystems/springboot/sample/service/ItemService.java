package com.justsystems.springboot.sample.service;

import java.util.List;

import com.justsystems.springboot.sample.domain.entity.Item;


public interface ItemService {
	Item save(Item item);

	Item find(Long id);

	List<Item> findAll();
}
