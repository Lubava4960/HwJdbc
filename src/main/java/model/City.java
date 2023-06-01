package model;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@AllArgsConstructor

@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode(of="city_id")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    private String city_name;
    @OneToMany(mappedBy = "citi_id", cascade = CascadeType.ALL)
    private List<Employe> employe;


}
