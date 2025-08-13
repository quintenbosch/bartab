package fact.it.drink_service.repository;

import fact.it.drink_service.model.Drink;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends MongoRepository<Drink, String> {
    // Hier kan je later zelf extra query methoden toevoegen
}
