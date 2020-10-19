package com.queststore.repository;

import com.queststore.model.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAll();

    @Transactional
    @Modifying
    @Query(
            value =
                    "INSERT into ITEMS_CODECOOLERS (item_id,codecooler_id) VALUES (:item_id,:codecooler_id)",
            nativeQuery = true)
    void insertItemIntoTable(@Param("item_id") Long item_id, @Param("codecooler_id") Long codecooler_id);
}
