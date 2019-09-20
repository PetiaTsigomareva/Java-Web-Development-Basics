package app.repository;

import app.domain.entities.Job;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobRepositoryImpl implements JobRepository {

    private final EntityManager entityManager;

    @Inject
    public JobRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Job save(Job entity) {
        this.entityManager.getTransaction().begin();
        try{
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();
            return entity;
        }catch (Exception e ){
            this.entityManager.getTransaction().rollback();
            return null;
        }

    }

    @Override
    public List<Job> findAll() {
        this.entityManager.getTransaction().begin();
        List<Job>jobs = this.entityManager.createQuery("SELECT j FROM Job j",Job.class).getResultList();
        this.entityManager.getTransaction().commit();
        return jobs;
    }

    @Override
    public Job findById(String id) {
        this.entityManager.getTransaction().begin();
        try {
            Job job = this.entityManager
                    .createQuery("SELECT j FROM Job j WHERE j.id = :id", Job.class)
                    .setParameter("id", id
                    ).getSingleResult();
            this.entityManager.getTransaction().commit();
            return job;

        }catch (Exception e){
            this.entityManager.getTransaction().rollback();
            return null;
        }

    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM Job j WHERE j.id = :id").setParameter("id",id).executeUpdate();
        this.entityManager.getTransaction().commit();
    }
}
