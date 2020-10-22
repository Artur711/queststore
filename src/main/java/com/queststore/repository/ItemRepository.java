package com.queststore.repository;

import com.queststore.model.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAll();

    Optional<Item> findById(Long itemId);

    @Transactional
    @Modifying
    @Query(
            value =
                    "INSERT INTO items_codecoolers (item_id,codecooler_id) VALUES (:item_id,:codecooler_id)",
            nativeQuery = true)
    void insertItemIntoTable(@Param("item_id") Long item_id, @Param("codecooler_id") Long codecooler_id);

    @Transactional
    @Modifying
    @Query(
            value = "SELECT * FROM items_codecoolers WHERE codecooler_id= :codecooler_id",
            nativeQuery = true)
    List<Long> getUserItems(@Param("codecooler_id") Long codecooler_id);

    @Transactional
    @Modifying
    @Query(
            value = "SELECT item_id FROM items",
            nativeQuery = true)
    List<Long> getAllItemsId(@Param("codecooler_id") Long codecooler_id);


   /* @Transactional
    @Modifying
    @Query(
            value = "UPDATE items_codecoolers SET used = 2 WHERE item_id= : itemId",
            nativeQuery = true)
    List<Long> markUsedItem(@Param("item_id") Long itemId);*/
}
