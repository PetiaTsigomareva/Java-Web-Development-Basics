package casebook.repository;

import casebook.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User save(User entity) {
        User result;
        this.entityManager.getTransaction().begin();
        try {
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();

            result = entity;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());

            result = null;
        }
        return result;
    }

    @Override
    public User update(User entity) {
        User result;
        this.entityManager.getTransaction().begin();
        try {
            User updatedUser = this.entityManager.merge(entity);
            this.entityManager.getTransaction().commit();

            result = updatedUser;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            result = null;
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        this.entityManager.getTransaction().begin();
        List<User> users = this.entityManager
                .createQuery("SELECT u FROM User u ", User.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return users;
    }

    @Override
    public User findById(String id) {
        User result;
        this.entityManager.getTransaction().begin();
        try {
            User user = this.entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class).setParameter("id", id).getSingleResult();
            this.entityManager.getTransaction().commit();

            result = user;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            result = null;
        }
        return result;
    }

    @Override
    public User findByUserName(String userName) {
        User result;
        this.entityManager.getTransaction().begin();
        try {
            User user = this.entityManager.createQuery("SELECT u FROM User u WHERE u.username = :userName", User.class).setParameter("userName", userName).getSingleResult();
            this.entityManager.getTransaction().commit();

            result = user;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            result = null;
        }
        return result;
    }
}
