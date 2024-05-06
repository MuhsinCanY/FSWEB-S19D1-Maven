package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {

    Fruit save(Fruit fruit);

    Fruit getById(Long id);

    List<Fruit> getByPriceDesc();

    List<Fruit> getByPriceAsc();

    Fruit update(Fruit fruit);

    List<Fruit> searchByName(String name);

    Fruit delete(Long id);

}
