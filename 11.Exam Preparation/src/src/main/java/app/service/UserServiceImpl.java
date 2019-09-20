package app.service;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;
import app.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

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
        User user = this.modelMapper.map(userServiceModel, User.class);
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

        if (this.userRepository.save(user) == null) {
            return false;
        }

        return true;
    }

    @Override
    public UserServiceModel loginUser(UserServiceModel userServiceModel) {
        User user = this.userRepository.findByUsername(userServiceModel.getUsername());

        if (user == null || !user.getPassword().equals(DigestUtils.sha256Hex(userServiceModel.getPassword()))) {
            return null;
        }
        return this.modelMapper.map(user, UserServiceModel.class);
    }
}
