import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PurchaseList")
@Data
public class PurchaseList implements Serializable {
  @Id
  @Column(name = "student_name")
  private String studentName;

  @Id
  @Column(name = "course_name")
  private String courseName;

  private int price;

  @Column(name = "subscription_date")
  private Date subscriptionDate;
}
