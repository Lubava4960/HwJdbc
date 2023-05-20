package dao;

import model.Employe;

import java.sql.SQLException;
import java.util.List;

public interface EmployeDao {
    Employe findById(int id) throws SQLException;
    void create(Employe employe);
    void deleteById(Integer id);

    List<Employe>findAll();

}
