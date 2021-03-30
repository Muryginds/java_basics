import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/skillbox";
    String SQLQuery = "SELECT S.course_name, CAST(S.subs/M.months AS DECIMAL(16,2)) AS avg_subs FROM"
        + "(SELECT course_name, COUNT(MONTH (subscription_date)) AS subs FROM PurchaseList GROUP BY course_name) S,"
        + "(SELECT course_name, COUNT(sub_months) as months FROM (SELECT DISTINCT course_name, MONTH (subscription_date)"
        + "AS sub_months FROM PurchaseList) X GROUP BY course_name) M "
        + "WHERE S.course_name = M.course_name";
    String user = "root";
    String pass = "test";
    try {
      Connection connecton = DriverManager.getConnection(url, user, pass);
      Statement statement = connecton.createStatement();
      ResultSet resultSet = statement.executeQuery(SQLQuery);
      while (resultSet.next()) {
        System.out.println(resultSet.getString("course_name") + " - " + resultSet.getString("avg_subs"));
      }
      resultSet.close();
      statement.close();
      connecton.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
