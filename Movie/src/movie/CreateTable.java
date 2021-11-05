package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable 
{
	public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:F:/Sqlite3/db/Movies.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE Movies (\n"
                + "	id integer PRIMARY KEY,\n"
        		+ " MovieName text NOT NULL,\n"
                + "	Actor text NOT NULL,\n"
                + "	Actress text NOT NULL,\n"
                + " YearOfRelease integer NOT NULL,\n"
                + " DirectorName text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Table Created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }
}
