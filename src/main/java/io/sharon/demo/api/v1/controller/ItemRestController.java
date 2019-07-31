package io.sharon.demo.api.v1.controller;

import io.sharon.demo.api.v1.dto.ItemDTO;
import io.sharon.demo.api.v1.mapper.ItemMapper;
import io.sharon.demo.api.v1.response.RestResponse;
import io.sharon.demo.core.model.domain.Item;
import io.sharon.demo.core.model.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/catalog")
@Api(value = "Item Rest Controller", description = "Operations pertaining to catalog in Demos")
public class ItemRestController {

	private  final ItemService itemService;

	private final ItemMapper itemMapper;

	@NewSpan
    @PostMapping(value = "/")
    @ApiOperation(value = "add item", notes = "add item", response = Long.class)
    public ResponseEntity<Long> addItem(@ApiParam @Validated @RequestBody ItemDTO itemDTO) {

		final Item item = itemMapper.toEntity(itemDTO);

		itemService.save(item);

		return new ResponseEntity<>(item.getId(),HttpStatus.CREATED);

	}

	@NewSpan
	@GetMapping(value = "/{id}")
    @ApiOperation(value = "find item in catalog by id", notes = "get find by id", response = RestResponse.class)
    public ResponseEntity<RestResponse<ItemDTO>> findById(@PathVariable("id") Long id) {

        final Item item = itemService.findById(id);

        final ItemDTO itemDTO = itemMapper.toDTO(item);


        return new ResponseEntity<>(RestResponse.of(itemDTO), HttpStatus.OK);

	}


	@NewSpan
	@GetMapping
	public ResponseEntity<RestResponse<List<ItemDTO>>> findAll() {

		final List<Item> mycatalog = itemService.fetchCatalog();
		final List<ItemDTO> itemDTOS = itemMapper.toDTO(mycatalog);

		return new ResponseEntity<>(RestResponse.of(itemDTOS), HttpStatus.OK);

	}

	@NewSpan
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "delete item from catalog by id", notes = "delete item from catalog by id", response = RestResponse.class)

    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {

        final var item = itemService.findById(id);

		itemService.delete(item);

		return new ResponseEntity<>("Deleted",HttpStatus.OK);


	}
	@NewSpan
	  @PutMapping(value = "/{id}")
		@ApiOperation(value = "change quantity amoumt", notes = "change quantity amount", response = RestResponse.class)

	   public ResponseEntity<String> putById(@PathVariable("id")  Long id,  @Validated @RequestBody ItemDTO item1)
	   {

	        Item item = itemService.findById(id);
	        item.setQuantity(item1.getQuantity());
	        itemService.save(item);
			return new ResponseEntity<>("Save",HttpStatus.OK);
	   }


}
