package service;

import model.Image;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ImageService implements ImageServiceInterface {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    private static Logger logger = LogManager.getLogger(ImageService.class);

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
//            sessionFactory.close();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public Image saveComment(Image image) {
        logger.trace("Vao saveComment");
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Image newImage = new Image();
            newImage.setMark(image.getMark());
            newImage.setAuthor(image.getAuthor());
            newImage.setFeedback(image.getFeedback());
            logger.info(newImage.toString());
            session.save(newImage);
            transaction.commit();
            logger.trace("Thoat saveComment");
            return image;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        logger.trace("Thoat saveComment");
        return null;
    }

    @Override
    public List<Image> findAll() {
        String queryStr = "select i from Image as i";
        TypedQuery<Image> query = entityManager.createQuery(queryStr, Image.class);
        return query.getResultList();
    }
}