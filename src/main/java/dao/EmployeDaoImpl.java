package dao;

import model.Employe;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtils;

import java.util.List;

public class EmployeDaoImpl implements EmployeDao{

    @Override
    public void save(Employe employe) {
        try ( Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(employe);
            transaction.commit();

        }

    }

    @Override
    public Employe findById(int id) {
        try(Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.get(Employe.class, id);

        }
    }

    @Override
    public void update(Employe employe) {
        try (Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employe);
            transaction.commit();
        }
}

    @Override
    public void deleteById(int id) {
        try(Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query query=session.createNativeQuery("DELETE FROM employe WHERE id = :id");
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        }

    }

    @Override
    public List<Employe> findAll() {
        try(Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
        return session.createQuery("FROM Employe").list();

    }
}

}