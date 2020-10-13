package com.queststore.repository;

import com.queststore.model.CodeCooler;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CodeCoolerRepository extends CrudRepository<CodeCooler, Long> {

    CodeCooler save(CodeCooler codeCooler);

    List<CodeCooler> findAll();

    void delete (CodeCooler codeCooler);

    @Transactional
    @Modifying
    @Query(
            value =
                    "UPDATE CODE_COOLERS SET CODE_COOLER_COINS  = :coins WHERE USER_ID = :user_id",
            nativeQuery = true)
    void updateCoinsBalance(@Param("coins") int coins, @Param("user_id") Long user_id);
}
