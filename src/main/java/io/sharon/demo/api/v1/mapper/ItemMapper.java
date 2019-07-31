package io.sharon.demo.api.v1.mapper;

import io.sharon.demo.api.v1.dto.ItemDTO;
import io.sharon.demo.core.model.domain.Item;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface ItemMapper {

    ItemDTO toDTO(Item source);

    Item toEntity(ItemDTO source);

    List<ItemDTO> toDTO(List<Item> source);
}
