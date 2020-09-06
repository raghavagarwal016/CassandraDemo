package CassandraDemo.CassandraDemo.service.impl;

import java.time.Duration;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CassandraDemo.CassandraDemo.entity.User;
import CassandraDemo.CassandraDemo.reactiverepository.UserReactiveRepository;
import CassandraDemo.CassandraDemo.repository.UserRepository;
import CassandraDemo.CassandraDemo.service.UserService;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserReactiveRepository userReactiveRepository;

  @PostConstruct
  public void  initDb() {
    userRepository.deleteAll();
    IntStream.range(1,101).mapToObj(i -> new User("id" + i, "name" + i, "addess" + i, i)).forEach(user -> userRepository.save(user));
  }

  @Override
  public String addUser(User user) {
    return userRepository.save(user).getId();
  }

  @Override
  public User getUserById(String id) {
    Optional<User> user = userRepository.findById(id);
    return user.isPresent() ? user.get() : new User();
  }

  @Override
  @Transactional
  public User updateUser(User user) {
    User savedUser = getUserById(user.getId());
    BeanUtils.copyProperties(user, savedUser, "id");
    return userRepository.save(savedUser);
  }

  @Override
  @Transactional
  public String deleteUser(String id) {
    userRepository.deleteById(id);
    return id;
  }

  //reactive service method impl

  @Override
  public Flux<User> getAllusers() {
   return userReactiveRepository.findAll();
  }


}
