import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  public static void main(String[] args) {
    try (StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).getMetadataBuilder().build()
            .getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession()) {
      Course course = session.get(Course.class, 1);
      course.getStudents().forEach(student -> System.out.println(student.getName()));

      Student student = session.get(Student.class, 5);
      student.getSubscriptions()
          .forEach(subscription -> System.out.println(subscription.getCourse().getName()));

      CriteriaQuery<Purchase> criteriaQuery = session.getCriteriaBuilder()
          .createQuery(Purchase.class);
      criteriaQuery.from(Purchase.class);
      List<Purchase> list = session.createQuery(criteriaQuery).getResultList();
      list.forEach(System.out::println);

      List<Object[]> courses = session.createNativeQuery("SELECT name, students_count FROM Courses").getResultList();
      courses.forEach(obj -> System.out.println("Course: " + obj[0] + " - students studying: " + obj[1]));
    }
  }
}

