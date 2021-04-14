import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PurchaseList")
@ToString
public class Purchase implements Serializable {
  @Id
  @Column(name = "student_name")
  @Getter
  @Setter
  private String studentName;

  @Id
  @Column(name = "course_name")
  @Getter
  @Setter
  private String courseName;

  @Getter
  @Setter
  private int price;

  @Column(name = "subscription_date")
  @Getter
  @Setter
  private Date subscriptionDate;
}
