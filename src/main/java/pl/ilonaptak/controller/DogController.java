package pl.ilonaptak.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.ilonaptak.bean.DogInterface;
import pl.ilonaptak.model.Dog;

import java.util.List;

@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor
public class DogController {
    private final DogInterface dogInterface;

    @GetMapping("")
    public List<Dog> allDogsList() {
        return dogInterface.getDogsList();
    }

    @GetMapping("/{id}")
    public Dog dokInfo(@PathVariable("id") long id) {
        if (dogInterface.getDogById(id) != null) {
            return dogInterface.getDogById(id);
        }
        return null;
    }

    @PostMapping("")
    public List<Dog> addNewDog(@RequestBody Dog dog) {
        dogInterface.createNewDog(dog);
        return dogInterface.getDogsList();
    }

    @PutMapping("")
    public List<Dog> editDog(@RequestBody Dog dog) {
        dogInterface.editDog(dog);
        return dogInterface.getDogsList();
    }

    @DeleteMapping("/{id}")
    public List<Dog> deleteDog(@PathVariable("id") long id) {
        dogInterface.deleteDog(id);
        return dogInterface.getDogsList();
    }

}
