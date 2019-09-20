package casebook.service;

import casebook.domain.entities.GenderEnum;
import casebook.domain.entities.User;
import casebook.domain.models.service.UserServiceModel;
import casebook.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        boolean result = true;
        User user = this.modelMapper.map(userServiceModel, User.class);
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));


        if (this.userRepository.save(user) == null) {
            result = false;
        }

        return result;
    }

    @Override
    public UserServiceModel loginUser(UserServiceModel userServiceModel) {

        User user = this.userRepository.findByUserName(userServiceModel.getUsername());

        if (user == null || !DigestUtils.sha256Hex(userServiceModel.getPassword()).equals(user.getPassword())) {
            return null;
        }

        return this.modelMapper.map(user, UserServiceModel.class);
    }



    @Override
    public List<UserServiceModel> getAllUsers() {
        List<UserServiceModel> allUsers = this.userRepository.findAll().stream().map(u -> this.modelMapper.map(u, UserServiceModel.class)).collect(Collectors.toList());

        return allUsers;
    }


    @Override
    public UserServiceModel findByID(String id) {
        User user = this.userRepository.findById(id);

        if (user == null) {
            return null;
        }

        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public boolean addFriend(UserServiceModel userServiceModel) {
        User user = this.userRepository.update(this.modelMapper.map(userServiceModel, User.class));

        if (user != null) {
            return true;
        }

        return false;
    }

    @Override
    public void unFriend(UserServiceModel userServiceModel) {

        User user = this.userRepository.update(this.modelMapper.map(userServiceModel, User.class));

        if(user==null){
            throw new IllegalArgumentException("The transaction was rolling back");

        }

    }
}
