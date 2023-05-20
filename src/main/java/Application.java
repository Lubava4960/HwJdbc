import dao.EmployeDaoImpl;


import java.sql.*;

public class Application {
    public Application() {
    }

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "123456";

        //int query = 2;

        //try (Connection connection = DriverManager.getConnection(url, user, password);
         //    PreparedStatement statement = connection.prepareStatement("SELECT*FROM employe WHERE id=  (?)")
       // ) {
        //    statement.setInt(1,query);
        //    ResultSet resultSet = statement.executeQuery();
        //    while (resultSet.next()) {
         //       System.out.print("id: "+resultSet.getInt("id")+";first_name: "+resultSet.getString("first_name")
          //      +"; last_name: "+resultSet.getString("last_name")+"; gender: "+resultSet.getString("gender")+"; age: "+resultSet.getInt("age")+"; city: "
          //      +resultSet.getInt("city_id"));
          //      System.out.println();


         //   }

       // } catch (SQLException e) {
       //     throw new RuntimeException(e);

        Connection conn= DriverManager.getConnection(url,user, password);
        EmployeDaoImpl employeDao =new EmployeDaoImpl(conn);//создание экземпляра класса PostDaoImpl и в конструкор передается connection
        System.out.println(employeDao.findById(5));

       // employeDao.create(new Employe(6, "Pier","Petrov", "man", 30,2));
        System.out.println(employeDao.findById(9));

        //employeDao.deleteById(9);
        //System.out.println(employeDao.findById(9));

       employeDao.findAll().forEach(System.out::println);








        }


    }
