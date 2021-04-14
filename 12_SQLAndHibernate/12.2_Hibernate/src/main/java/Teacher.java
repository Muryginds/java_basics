import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Teachers")
@Data
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int salary;

  private int age;

  private String name;
}
