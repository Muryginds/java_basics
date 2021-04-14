import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "LinkedPurchaseList")
@Data
public class LinkedPurchaseList {

  @EmbeddedId
  private Key id;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("studentId")
  private Student student;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("courseId")
  private Course course;

  private int price;

  @Column(name = "subscription_date")
  private Date subscriptionDate;

  @Embeddable
  @Data
  public static class Key implements Serializable {

    public Key (){}
    public Key (int studentId, int courseId) {
      this.studentId = studentId;
      this.courseId = courseId;
    }

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;
    }
}
