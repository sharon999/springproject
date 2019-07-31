package io.sharon.demo.core.model.service;

import io.sharon.demo.core.model.domain.Item;

import java.util.List;


public interface ItemService {

	List<Item> fetchCatalog();

	Item findById(Long id);

	void delete(Item item);

	void save(Item item);
}
