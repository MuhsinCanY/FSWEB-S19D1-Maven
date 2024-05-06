package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
//        FruitValidation.checkAll(fruit.getId(), fruit.getName(), fruit.getPrice(),
//                fruit.getFruitType());
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(Long id) {
        if (id < 0) {
            throw new PlantException("ID must be bigger than 0", HttpStatus.BAD_REQUEST);
        }
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if (fruit.isPresent()) {
            return fruit.get();
        } else {
            throw new PlantException("Plant not found given id: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }


    @Override
    public Fruit update(Fruit fruit) {
//        FruitValidation.checkAll(fruit.getId(), fruit.getName(), fruit.getPrice(),
//                fruit.getFruitType());
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit selectedFruit = getById(id);
        fruitRepository.delete(selectedFruit);
        return selectedFruit;
    }

}
