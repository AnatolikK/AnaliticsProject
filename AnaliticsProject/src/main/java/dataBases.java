import java.sql.*;

public class dataBases {
    private static Connection conn = null;
    private static final String URL = "jdbc:sqlite:D:/Учёба/Прога/Java/sqlite/db/dataBasa.db";

    public static void connect() {
        try{
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void createTableStudents() {
        String sql = "CREATE TABLE IF NOT EXISTS students (\n"
                + " id integer PRIMARY KEY, \n"
                + " nameAndSurname text NOT NULL, \n"
                + " city text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'stydents' created.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void insertStudent(String nameAndSurname, String city) {
        String sql = "INSERT INTO students(nameAndSurname, city) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nameAndSurname);
            pstmt.setString(2, city);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nameAndSurname = rs.getString("nameAndSurname");
                String city = rs.getString("city");

                System.out.println("ID: " + id + ", Имя: " + nameAndSurname + ", Город: " + city);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clearTableStudents() {
        String sql = "DELETE FROM students";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("Table 'students' cleared.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
