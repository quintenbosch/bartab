package fact.it.drink_service.service;

import fact.it.drink_service.model.Drink;
import fact.it.drink_service.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    // Optioneel: meer methodes zoals getById, save, delete ...
}
