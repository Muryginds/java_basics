import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  public static void main(String[] args) {
    //copyAndInsertData();
    try (StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).getMetadataBuilder().build()
            .getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession()) {
//      Course course = session.get(Course.class, 1);
//      course.getStudents().forEach(student -> System.out.println(student.getName()));

//      Student student = session.get(Student.class, 5);
//      student.getSubscriptions()
//          .forEach(subscription -> System.out.println(subscription.getCourse().getName()));
//
//      List<Object[]> courses = session.createNativeQuery("SELECT name, students_count FROM Courses").getResultList();
//      courses.forEach(obj -> System.out.println("Course: " + obj[0] + " - students studying: " + obj[1]));

//      CriteriaBuilder builder = session.getCriteriaBuilder();
//      CriteriaQuery<Course> query = builder.createQuery(Course.class);
//      Root<Course> root = query.from(Course.class);
//      query.select(root).where(builder.greaterThan(root.get("price"), 100000))
//          .orderBy(builder.desc(root.get("price")));
//      List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();
//      courseList.forEach(course -> System.out.println(course.getName() + " - " + course.getPrice()));
//
//      String hql = "FROM " + Course.class.getSimpleName() + " WHERE price > 120000 ORDER BY price DESC";
//      List<Course> courses = session.createQuery(hql).setMaxResults(3).getResultList();
//      courses.forEach(course -> System.out.println(course.getName() + " - " + course.getPrice()));

      Subscription subscription = session.get(Subscription.class, new Subscription.Key(1, 10));
      System.out.println(subscription);
    }
  }

  private static void copyAndInsertData() {
    try (StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).getMetadataBuilder().build()
            .getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      //transaction.begin();
      List<Object[]> purchases = session
          .createNativeQuery("SELECT Courses.id AS CourseId, Students.id AS StudentId,"
              + " PurchaseList.price, subscription_date FROM PurchaseList\n"
              + "JOIN Courses ON Courses.name = PurchaseList.course_name\n"
              + "JOIN Students ON Students.name = PurchaseList.student_name"
              ).getResultList();
      purchases.forEach(obj -> {
        LinkedPurchaseList entry = new LinkedPurchaseList();
        entry.setId(new LinkedPurchaseList.Key((Integer)obj[0],(Integer)obj[0]));
        entry.setCourse(session.get(Course.class, (Integer)obj[0]));
        entry.setStudent(session.get(Student.class, (Integer)obj[1]));
        entry.setPrice((Integer)obj[2]);
        entry.setSubscriptionDate(new Date(((Timestamp) obj[3]).getTime()));
        session.saveOrUpdate(entry);
      });
      transaction.commit();
    }
  }
}

