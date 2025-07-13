package br.com.fabiohigor.events.service.impl;

import br.com.fabiohigor.events.exception.NotFoundException;
import br.com.fabiohigor.events.model.User;
import br.com.fabiohigor.events.repository.UserRepository;
import br.com.fabiohigor.events.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return repository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        return repository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
    }

    @Override
    public User getUserByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found with email: " + email));
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
