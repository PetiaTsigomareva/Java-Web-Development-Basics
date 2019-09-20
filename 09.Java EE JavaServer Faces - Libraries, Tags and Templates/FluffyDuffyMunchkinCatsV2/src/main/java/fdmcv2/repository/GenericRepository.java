package fdmcv2.repository;

import java.util.List;

public interface GenericRepository<E, ID> {

    E save(E entity);

    List<E> findAll();

    E findByID(ID id);




}
