package com.tdep.tadlab.dao;

import com.tdep.tadlab.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {

  List<User> getAll();

  Optional<User> getUserById(int id);

  User save(User user);

  void delete(User user);
}
