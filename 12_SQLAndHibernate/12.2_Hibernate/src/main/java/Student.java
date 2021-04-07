import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Students")
public class Student {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private int id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private int age;

  @Column(name = "registration_date")
  @Getter
  @Setter
  private Date registrationDate;

  @OneToMany(mappedBy = "student")
  @Getter
  @Setter
  private List<Subscription> subscriptions;
}
