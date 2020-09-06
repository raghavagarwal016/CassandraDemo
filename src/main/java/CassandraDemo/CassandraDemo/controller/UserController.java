package CassandraDemo.CassandraDemo.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CassandraDemo.CassandraDemo.entity.User;
import CassandraDemo.CassandraDemo.service.UserService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/addUser")
  public ResponseEntity addUser(@RequestBody User user) {
    return new ResponseEntity(userService.addUser(user), HttpStatus.OK);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") String id) {
    return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    return new ResponseEntity(userService.updateUser(user), HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteUser(@PathVariable("id") String id) {
    return new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
  }

  //Reactive end points

  @GetMapping("/reactive/getAll")
  public ResponseEntity<Flux<User>> getAllUsers() {
    return new ResponseEntity(userService.getAllusers(), HttpStatus.OK);
  }

}
