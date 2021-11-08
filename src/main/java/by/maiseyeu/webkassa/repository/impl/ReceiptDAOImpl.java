package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.Receipt;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("receiptDAOBean")
public class ReceiptDAOImpl implements BaseDAO<Long, Receipt> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Receipt receipt) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(receipt);
    }

    @Override
    public void update(Receipt receipt) {
        Session session = sessionFactory.getCurrentSession();
        session.update(receipt);
    }

    @Override
    public void delete(Receipt receipt) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(receipt);
    }

    @Override
    public Receipt getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Receipt.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Receipt> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Receipt").list();
    }
}
