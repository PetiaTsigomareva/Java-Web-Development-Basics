package exam.repository;

import exam.domain.entities.Document;
import org.modelmapper.ModelMapper;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class DocumentRepositoryImpl implements DocumentRepository {
    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Inject
    public DocumentRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public Document save(Document entity) {
        Document result;
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
    public Document update(Document entity) {
        return null;
    }

    @Override
    public List<Document> findAll() {
        this.entityManager.getTransaction().begin();
        List<Document> documents = this.entityManager.createQuery("SELECT d FROM Document d ", Document.class).getResultList();
        this.entityManager.getTransaction().commit();

        return documents;

    }

    @Override
    public Document findById(String id) {
        Document result;
        this.entityManager.getTransaction().begin();
        try {
            Document document = this.entityManager.createQuery("SELECT d FROM Document d WHERE d.id = :id", Document.class).setParameter("id", id).getSingleResult();
            this.entityManager.getTransaction().commit();

            result = document;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();

            result = null;
        }
        return result;
    }


    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM Document d WHERE d.id = :id").setParameter("id", id).executeUpdate();
        this.entityManager.getTransaction().commit();
    }


}
