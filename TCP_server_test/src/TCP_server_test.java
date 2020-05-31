import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TCP_server_test {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QLSinhVien;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sa";

    public static void main(String[] args) {
        System.out.println("qlstudent.ConnectSQLServerExample.main()");
        // TODO code application logic here
        try {
            // connnect to database 'QLSinhVien'
            System.out.println("1");

            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            System.out.println("2");
            Statement stmt = conn.createStatement();

            System.out.println("2");

            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from SinhVien");
            // show data
            System.out.println("3");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3)+rs.getInt(4));
            }
            // close connection
            conn.close();
        } catch (Exception e) {
            System.out.println("aaassd");
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String dbURL, String userName, String password) throws Exception {
        System.out.println("getConnection");
        Connection conn = null;
        conn = DriverManager.getConnection(dbURL, userName, password);
        System.out.println("connect successfully!");
        return conn;
    }

}
