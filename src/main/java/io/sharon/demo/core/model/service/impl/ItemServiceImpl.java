package io.sharon.demo.core.model.service.impl;


import io.sharon.demo.core.exceptions.ResourceNotFoundException;
import io.sharon.demo.core.model.domain.Item;
import io.sharon.demo.core.model.repository.ItemRepository;
import io.sharon.demo.core.model.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Service
@AllArgsConstructor
class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	@Override
	public List<Item> fetchCatalog() {
		return itemRepository.findAll();
	}

	@Override
	public Item findById(Long id){

		return itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("general.NotFound.resource", "id", id));

	}

	@Transactional
	@Override
	public void delete(Item item) {
		itemRepository.delete(item);
	}

	@Transactional
	@Override
	public void save(Item item) {
		 itemRepository.save(item);
	}
}
