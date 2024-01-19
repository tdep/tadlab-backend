package com.tdep.tadlab.repository;

import com.tdep.tadlab.dao.UserDao;
import com.tdep.tadlab.model.User;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private EntityManager entityManager;

  @Override
  public List<User> getAll() {
    return entityManager.createQuery("SELECT * FROM users", User.class).getResultList();
  }

  @Override
  public Optional<User> getUserById(int id) {
    return Optional.ofNullable(entityManager.find(User.class, id));
  }

  @Override
  public User save(User user) {
    return entityManager.merge(user);
  }

  @Override
  public void delete(User user) {
    entityManager.remove(user);
  }
}
