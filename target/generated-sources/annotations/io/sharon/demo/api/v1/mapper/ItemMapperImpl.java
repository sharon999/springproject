package io.sharon.demo.api.v1.mapper;

import io.sharon.demo.api.v1.dto.ItemDTO;
import io.sharon.demo.core.model.domain.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDTO toDTO(Item source) {
        if ( source == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId( source.getId() );
        itemDTO.setItemCode( source.getItemCode() );
        itemDTO.setItemName( source.getItemName() );
        itemDTO.setInventory_code( source.getInventory_code() );
        itemDTO.setQuantity( source.getQuantity() );

        return itemDTO;
    }

    @Override
    public Item toEntity(ItemDTO source) {
        if ( source == null ) {
            return null;
        }

        Item item = new Item();

        item.setQuantity( source.getQuantity() );
        item.setItemCode( source.getItemCode() );
        item.setItemName( source.getItemName() );
        item.setInventory_code( source.getInventory_code() );

        return item;
    }

    @Override
    public List<ItemDTO> toDTO(List<Item> source) {
        if ( source == null ) {
            return null;
        }

        List<ItemDTO> list = new ArrayList<ItemDTO>( source.size() );
        for ( Item item : source ) {
            list.add( toDTO( item ) );
        }

        return list;
    }
}
