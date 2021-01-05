package vndirect.com.springhibernate.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vndirect.com.springhibernate.entities.Customer;

@Repository(value = "customerDAO")
public class CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(customer);
        tx.commit();
        session.close();
    }

    public void update(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(customer);
        tx.commit();
        session.close();
    }

    public List<Customer> findAll() {
        Session session = this.sessionFactory.openSession();
        List<Customer> result = session.createQuery("FROM Customer", Customer.class).getResultList();
        return result;
    }

    public Customer findById(int id) {
        Session session = this.sessionFactory.openSession();
        return session.find(Customer.class, id);
    }
    public void delete(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(customer);
        tx.commit();
        session.close();
    }
}