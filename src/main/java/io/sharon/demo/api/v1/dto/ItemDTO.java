package io.sharon.demo.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;



@Data
@NoArgsConstructor

public class ItemDTO  {
	private Long id;
	private int itemCode;
    @NotBlank(message = "demo.validation.NotNull.item.name")
    private String itemName;

	private String  inventory_code;

	private int quantity;
	 public int getQuantity() {
		    return this.quantity;
		  }
	public long getID() {
 	    return this.id;
 			  }
	
    public ItemDTO(Long id, int itemCode, String itemName, String  inventory_code, int quantity) {
	this.id=id;
        this.itemCode =itemCode;
        this.itemName = itemName;
        this.inventory_code =  inventory_code;
        this.quantity = quantity;
    }
}
