package com.producedaily.productivityapp.dao;

import com.producedaily.productivityapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {

        Query theQuery =
                entityManager.createQuery("from User");

        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User theUser) {

        User dbUser = entityManager.merge(theUser);

        theUser.setId(dbUser.getId());

    }

    @Override
    public void deleteById(int id) {

        Query theQuery = entityManager.createQuery(
                "delete from User where id=:userId");

        theQuery.setParameter("userId", id);

        theQuery.executeUpdate();
    }
}
