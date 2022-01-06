package com.example.SpringDrinks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringDrinks.domain.Drink;


public interface DrinkRepo extends JpaRepository<Drink, Long>{

}
