package com.justsystems.springboot.sample.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

@Entity
public class Item {

	@Id
	@GeneratedValue
	public Long id;

	@NotNull
	public String name;

	@NotNull
	@URL
	public String url;


}
