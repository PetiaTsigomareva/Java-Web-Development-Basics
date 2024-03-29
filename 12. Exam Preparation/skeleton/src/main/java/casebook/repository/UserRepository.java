package casebook.repository;

import casebook.domain.entities.User;

public interface UserRepository extends GenericRepository<User, String> {

    User findByUserName(String userName);

    
}
