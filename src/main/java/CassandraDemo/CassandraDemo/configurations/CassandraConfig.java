package CassandraDemo.CassandraDemo.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories(basePackages = "CassandraDemo.CassandraDemo.reactiverepository")
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

  @Value("${spring.data.cassandra.keyspace-name}")
  private String keySpace;

  @Override
  protected String getKeyspaceName() {
    return keySpace;
  }

  @Override
  protected boolean getMetricsEnabled() {
    return false;
  }

}
