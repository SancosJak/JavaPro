package lesson4_hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalService {

    @Autowired
    private List<Animal> animals;

    @Autowired
    @Qualifier("lion")
    private Animal lion;

    public List<Animal> getAnimals() {
        return animals;
    }

    public Animal getLion() {
        return lion;
    }
}