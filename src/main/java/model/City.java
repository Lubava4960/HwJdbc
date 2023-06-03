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
    @Column(name="city_id")
    private int cityId;
    @Column(name="city_name")
    private String cityName;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employe> employe;


}
