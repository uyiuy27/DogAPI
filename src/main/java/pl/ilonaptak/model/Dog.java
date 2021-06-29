package pl.ilonaptak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dog {

    private Long id;
    private String breed;
    private String size;
    private String classification;
    private String type;
    private String countryOfOrigin;
    private double price;

}
