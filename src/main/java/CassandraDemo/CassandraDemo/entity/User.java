package CassandraDemo.CassandraDemo.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user")
public class User implements Serializable {

  @PrimaryKey
  private String id;

  private String name;

  private String address;

  private int age;


}
