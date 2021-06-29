package pl.ilonaptak.bean;

import org.springframework.stereotype.Component;
import pl.ilonaptak.model.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Component
public class MockDogService implements DogInterface{

    private List<Dog> dogs;
    private static Long nextId = 5L;


    public MockDogService() {
        this.dogs = new ArrayList<>();

        Dog dog1 = new Dog(1L, "Shih tzu", "small", "companion", "toy", "Tibet", 1100);
        Dog dog2 = new Dog(2L, "Old English SheepDog", "large", "pastoral", "working", "United Kingdom", 1000);
        Dog dog3 = new Dog(3L, "Russian greyhound", "large", "companion", "working", "Russia", 1200);
        Dog dog4 = new Dog(4L, "Cocker spaniel", "medium", "aporting", "gundog", "United Kingdom", 950);
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
    }

    @Override
    public List<Dog> getDogsList() {
        return dogs;
    }

    @Override
    public Dog getDogById(Long id) {
        for (Dog dog : dogs) {
            if(dog.getId() == id) {
                return dog;
            }
        }
        return null;
    }

    @Override
    public void createNewDog(Dog dog) {
        dog.setId(nextId++);
        dogs.add(dog);
    }

    @Override
    public void editDog(Dog dog) {
        for(Dog d : dogs) {
            if(d.getId() == dog.getId()) {
                d.setBreed(dog.getBreed());
                d.setClassification(dog.getClassification());
                d.setPrice(dog.getPrice());
                d.setSize(dog.getSize());
                d.setType(dog.getType());
                d.setCountryOfOrigin(dog.getCountryOfOrigin());
            }
        }
    }

    @Override
    public void deleteDog(long id) {
        boolean toDelete = false;
        for (Dog dog : dogs) {
            if (dog.getId() == id) {
                toDelete = true;
            }
        }
        if(toDelete == true) {
            ListIterator<Dog> listIterator = dogs.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().getId() == id) {
                    listIterator.remove();
                }
            }
        }
    }
}
