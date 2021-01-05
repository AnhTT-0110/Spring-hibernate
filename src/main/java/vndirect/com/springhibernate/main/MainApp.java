package vndirect.com.springhibernate.main;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vndirect.com.springhibernate.dao.CustomerDAO;
import vndirect.com.springhibernate.entities.Customer;

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

        customerDAO.save(new Customer("Anh", "Hung Yen"));
        customerDAO.save(new Customer("Trieu", "Ha Noi"));

        List<Customer> listCustomer = customerDAO.findAll();
        for (Customer customer : listCustomer) {
            System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getAddress());
        }

        context.close();
    }
}