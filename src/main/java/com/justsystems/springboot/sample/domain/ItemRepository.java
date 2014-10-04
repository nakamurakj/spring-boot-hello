package com.justsystems.springboot.sample.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.justsystems.springboot.sample.domain.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
