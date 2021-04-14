import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Students")
@Data
public class Student {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private int age;

  @Column(name = "registration_date")
  private Date registrationDate;

  @OneToMany(mappedBy = "student")
  private List<Subscription> subscriptions;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "LinkedPurchaseList",
      joinColumns = {@JoinColumn(name = "student_id")},
      inverseJoinColumns = {@JoinColumn(name = "course_id")})
  List<Course> purchases;

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", registrationDate=" + registrationDate +
        ", subscriptionsSize=" + subscriptions.size() +
        ", purchasesSize=" + purchases.size() + "\n" +
        '}';
  }
}
