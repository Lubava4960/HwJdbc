package dao;

import model.Employe;

import java.sql.SQLException;
import java.util.List;

public interface EmployeDao {
    void save(Employe employee);
    Employe findById(int id) ;
    void update (Employe employee);
    void deleteById(int id);
    List<Employe> findAll();
}
