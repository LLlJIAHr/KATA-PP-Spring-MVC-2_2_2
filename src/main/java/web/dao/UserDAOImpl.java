package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User updatedUser, Long id) {
        entityManager.merge(updatedUser);
    }

    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("From User", User.class).getResultList();
    }
}
