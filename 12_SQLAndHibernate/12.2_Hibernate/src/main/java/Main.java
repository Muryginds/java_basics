import java.util.List;
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
      System.out.println(course.getName());
      List<Object[]> courses = session.createNativeQuery("SELECT name, students_count FROM Courses").getResultList();
      courses.forEach(obj -> System.out.println("Course: " + obj[0] + " - students studying: " + obj[1]));
    }
  }
}
