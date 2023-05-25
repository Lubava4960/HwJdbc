import dao.EmployeDao;
import dao.EmployeDaoImpl;
import model.Employe;

public class Application {
        public static void main(String[] args) {
                EmployeDao employeDao = new EmployeDaoImpl();
                Employe employe = new Employe();

                employe.setFirst_Name("Klim");
                employe.setLast_Name("Iven");
                employe.setGender("man");
                employe.setAge(31);
                employe.setCity_Id(2);
                System.out.println(employe);
                employeDao.save(employe);
                System.out.println(employe);

                System.out.println(employeDao.findById(21));
                employeDao.deleteById((21));
                System.out.println(employeDao.findById(21));

                Employe byId=employeDao.findById(20);
                byId.setFirst_Name("Jack");
                byId.setLast_Name("Fill");
                employeDao.update(byId);
                System.out.println(employeDao.findById(20));

                employeDao.findAll().forEach(System.out::println);




        }
}


