package CassandraDemo.CassandraDemo.service;

import CassandraDemo.CassandraDemo.entity.User;
import reactor.core.publisher.Flux;

public interface UserService {
  String addUser(User user);
  User getUserById(String id);
  User updateUser(User user);
  String deleteUser(String id);

  //Reactive service call
  Flux<User> getAllusers();

}
