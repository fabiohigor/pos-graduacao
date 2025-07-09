package br.com.fabiohigor.events.service;

import br.com.fabiohigor.events.model.User;

import java.util.List;

public interface IUserService {

    public User addUser(User user);
    public User getUserById(Integer userId);
    public User getUserByEmail(String email);
    public List<User> getAllUsers();
}
