package CassandraDemo.CassandraDemo.reactiverepository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import CassandraDemo.CassandraDemo.entity.User;

public interface UserReactiveRepository extends ReactiveCassandraRepository<User, String> {
}
