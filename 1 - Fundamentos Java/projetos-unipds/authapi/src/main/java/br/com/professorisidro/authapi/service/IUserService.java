package br.com.professorisidro.authapi.service;

import br.com.professorisidro.authapi.model.User;
import br.com.professorisidro.authapi.security.MyToken;

public interface IUserService {
	public User addUser(User user);
	public User getByUsername(String username);
	public MyToken userLogin(User user);
}
