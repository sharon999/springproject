package io.sharon.demo.core.model.repository;

import io.sharon.demo.core.model.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findItemByItemCode(int itemCode);

}
