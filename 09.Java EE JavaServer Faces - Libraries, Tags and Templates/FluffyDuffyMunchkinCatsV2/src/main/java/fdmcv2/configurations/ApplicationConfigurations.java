package fdmcv2.configurations;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationConfigurations {
    @Produces
    public EntityManager entityManager() {

        return Persistence.createEntityManagerFactory("fdmcv2").createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
