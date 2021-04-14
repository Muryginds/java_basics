import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Courses")
@Data
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private int duration;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum", name = "type")
  private CourseType courseType;

  private String description;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Teacher teacher;

  @Column(name = "students_count")
  private int studentsCount;

  private int price;

  @Column(name = "price_per_hour")
  private float pricePerHour;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "Subscriptions",
        joinColumns = {@JoinColumn(name = "course_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")})
  List<Student> students;
}
