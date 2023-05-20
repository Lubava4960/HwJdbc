package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@AllArgsConstructor

@NoArgsConstructor

public class Employe {
    private  Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private Integer cityId;



    public static Employe create(ResultSet resultSet) throws SQLException {
        Employe employe = new Employe();
        employe.setId(resultSet.getInt("id"));
        employe.setFirstName(resultSet.getString("first_Name"));
        employe.setLastName(resultSet.getString("last_Name"));
        employe.setGender(resultSet.getString("gender"));//названия колонок
        employe.setAge(resultSet.getInt("age"));
        employe.setCityId(resultSet.getInt("city_id"));
        return employe;
    }


}
