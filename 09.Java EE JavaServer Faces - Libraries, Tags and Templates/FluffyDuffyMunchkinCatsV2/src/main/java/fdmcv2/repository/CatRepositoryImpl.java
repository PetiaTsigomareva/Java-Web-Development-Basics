package fdmcv2.repository;

import fdmcv2.domain.entities.Cat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CatRepositoryImpl implements CatRepository {
    private final EntityManager entityManager;

    @Inject
    public CatRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Cat save(Cat entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Cat> findAll() {
        List<Cat> cats;
        try {
            cats = this.entityManager.createQuery("SELECT c FROM Cat c", Cat.class).getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            cats = null;

        }

        return cats;
    }

    @Override
    public Cat findByID(String id) {
        Cat cat;
        try {
            cat = this.entityManager.createQuery("SELECT c FROM Cat c WHERE c.id=:id", Cat.class).setParameter("id", id).getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            cat = null;
        }

        return cat;
    }
}
