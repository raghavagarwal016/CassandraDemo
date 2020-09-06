package CassandraDemo.CassandraDemo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import CassandraDemo.CassandraDemo.entity.User;

public interface UserRepository extends CassandraRepository<User, String> {

}
