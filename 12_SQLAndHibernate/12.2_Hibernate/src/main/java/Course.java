import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Courses")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private int id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private int duration;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum", name = "type")
  @Getter
  @Setter
  private CourseType courseType;

  @Getter
  @Setter
  private String description;

  @ManyToOne(cascade = CascadeType.ALL)
  @Getter
  @Setter
  private Teacher teacher;

  @Column(name = "students_count")
  @Getter
  @Setter
  private int studentsCount;

  @Getter
  @Setter
  private int price;

  @Column(name = "price_per_hour")
  @Getter
  @Setter
  private float pricePerHour;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "Subscriptions",
        joinColumns = {@JoinColumn(name = "course_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")})
  @Getter
  @Setter
  List<Student> students;
}
