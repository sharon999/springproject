package io.sharon.demo.core.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "item")
public class Item implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;


	@Column(name = "item_code")
	private int itemCode;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = " inventory_code")
	private String  inventory_code;

	@Column(name = "quantity")
	private int quantity;

	public int getQuantity() {
	    return this.quantity;
	  }

  public void setQuantity(int quantity) {

   this.quantity =quantity;
  }

}
