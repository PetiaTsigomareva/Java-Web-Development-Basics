package registerapp.configurations;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationConfigurations {
    @Produces
    public EntityManager entityManager() {

        return Persistence.createEntityManagerFactory("registerPU").createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
