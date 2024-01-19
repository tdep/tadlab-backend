package com.tdep.tadlab.controller;

import com.tdep.tadlab.dao.UserDao;
import com.tdep.tadlab.model.User;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  private UserDao userDao;

  @GetMapping
  public List<User> getAllUsers() {
    return userDao.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable int id) {
    Optional<User> user = userDao.getUserById(id);
    return user.map(ResponseEntity::ok)
        .orElseGet(() ->
            ResponseEntity.notFound()
                .build());
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userDao.save(user);
    return ResponseEntity.created(URI.create("/users/" + savedUser.getId())).body(savedUser);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
    Optional<User> existingUser = userDao.getUserById(id);
    if (existingUser.isPresent()) {
      user.setId(id);
      User savedUser = userDao.save(user);
      return ResponseEntity.ok(savedUser);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable int id) {
    Optional<User> user = userDao.getUserById(id);
    if (user.isPresent()) {
      userDao.delete(user.get());
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
