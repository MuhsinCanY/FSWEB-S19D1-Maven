package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.validations.FruitValidetion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    @Override
    public Fruit save(Fruit fruit) {
        FruitValidetion.checkName(fruit.getName());
        FruitValidetion.checkPrice(fruit.getPrice());
        FruitValidetion.checkFruitType(fruit.getFruitType());
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new PlantException("Plant not found" +
                " " +
                "given id: " + id, HttpStatus.BAD_REQUEST));
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
        FruitValidetion.checkAll(fruit.getId(), fruit.getName(), fruit.getPrice(),
                fruit.getFruitType());
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
