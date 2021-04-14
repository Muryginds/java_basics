import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable {
  @Id
  @ManyToOne(cascade = CascadeType.ALL)
  @Getter
  @Setter
  private Student student;

  @Id
  @ManyToOne(cascade = CascadeType.ALL)
  @Getter
  @Setter
  private Course course;

  @Column(name = "subscription_date")
  @Getter
  @Setter
  private Date subscriptionDate;
}
