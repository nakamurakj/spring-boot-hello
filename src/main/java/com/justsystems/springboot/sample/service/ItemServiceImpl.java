package com.justsystems.springboot.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.justsystems.springboot.sample.domain.ItemRepository;
import com.justsystems.springboot.sample.domain.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Qualifier("itemRepository")
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Item find(Long id) {
		return itemRepository.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

}
