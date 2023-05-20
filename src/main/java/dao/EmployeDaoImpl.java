package dao;

import model.Employe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeDaoImpl implements EmployeDao{

    private final Connection connection;

    public EmployeDaoImpl(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Employe findById(int id)  {
        try (PreparedStatement preparedStatement=connection.prepareStatement("SELECT *FROM employe WHERE id =?")){
            preparedStatement.setInt(1,id);
            preparedStatement.setMaxRows(1);

            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                return Employe.create(resultSet);
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Employe employe) {

       try (PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO employe(first_Name,last_Name, gender,age,city_Id)VALUES (?,?,?,?,?)")){
           preparedStatement.setInt(1,employe.getId());
           preparedStatement.setString(1, employe.getFirstName());
           preparedStatement.setString(2, employe.getLastName());
           preparedStatement.setString(3, employe.getGender());
           preparedStatement.setInt(4,employe.getAge());
           preparedStatement.setInt(5, employe.getCityId());

           preparedStatement.executeUpdate();//Объединение и передача В БД

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM employe WHERE id= (?)")){

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employe> findAll() {
        try (PreparedStatement preparedStatement=connection.prepareStatement("SELECT *FROM employe ")) {
            ResultSet resultSet=preparedStatement.executeQuery();
            List<Employe> result =new ArrayList<>();
            while (resultSet.next()) {
                result.add(Employe.create(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
