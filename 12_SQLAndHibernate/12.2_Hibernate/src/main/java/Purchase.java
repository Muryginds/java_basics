import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PurchaseList")
public class Purchase implements Serializable {
  @Id
  @Column(name = "student_name")
  private String studentName;
  @Id
  @Column(name = "course_name")
  private String courseName;
  private int price;
  @Column(name = "subscription_date")
  private Date subscriptionDate;

  @Override
  public String toString() {
    return "Purchase{" +
        "studentName='" + studentName + '\'' +
        ", courseName='" + courseName + '\'' +
        ", price=" + price +
        ", subscriptionDate=" + subscriptionDate +
        '}';
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Date getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(Date subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }
}
