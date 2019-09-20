package exam.service;

import exam.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);

    UserServiceModel findByID(String id);

    List<UserServiceModel> getAllUsers();





}
