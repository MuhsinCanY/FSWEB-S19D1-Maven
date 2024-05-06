package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    @Query("select f from Fruit f order by f.price desc")
    List<Fruit> getByPriceDesc();

    @Query("select f from Fruit f order by f.price")
    List<Fruit> getByPriceAsc();

    @Query("select f from Fruit f where f.name like %:input%")
    List<Fruit> searchByName(@Param("input") String input);

}
