import dao.CityDao;
import dao.CityDaoImpl;
import dao.EmployeDao;
import dao.EmployeDaoImpl;

import model.City;
import model.Employe;

import java.util.ArrayList;


public class Application {

        public static void main(String[] args) {
            EmployeDao employeDao = new EmployeDaoImpl();
            CityDao cityDao = new CityDaoImpl();

                City city = new City();
                city.setCity_name("TestTownes");
                city.setEmploye(new ArrayList<>());

                System.out.println(city);

                Employe employe = new Employe();

                employe.setCity(city);
                employe.setFirstName("Keyt");
                employe.setLastName("Ivanova");
                employe.setGender("woman");
                employe.setAge(33);
                employe.setCityId(2);
                System.out.println(employe);
                employeDao.save(employe);


                 City byId=cityDao.findByIdCity(1);
                 byId.setCity_name("Volokolamsk");
                 cityDao.updateCity(byId);
                 cityDao.updateCity(city);
                 System.out.println(cityDao.findByIdCity(1));

                 cityDao.findAllCity().forEach(System.out::println);
                 cityDao.deleteById((0));

                 System.out.println(cityDao.findByIdCity(26));
                 System.out.println(city);

                //System.out.println(employe);

                // System.out.println(employeDao.findById(30));
                //  employeDao.deleteById((30));
                //  System.out.println(employeDao.findById(30));

                // Employe byId=employeDao.findById(27);
                // byId.setFirstName("Jack");
                // byId.setLastName("Fill");
                // employeDao.update(byId);
                //System.out.println(employeDao.findById(27));

                //employeDao.findAll().forEach(System.out::println);


        }
}


