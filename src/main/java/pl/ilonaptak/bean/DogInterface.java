package pl.ilonaptak.bean;

import pl.ilonaptak.model.Dog;

import java.util.List;

public interface DogInterface {

    List<Dog> getDogsList();

    Dog getDogById(Long id);

    void createNewDog(Dog dog);

    void editDog(Dog dog);

    void deleteDog(long id);


}
