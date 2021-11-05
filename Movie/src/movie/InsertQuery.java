package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQuery 
{
	public void insert(int id,String MovieName,String actor,String actress,int YearOfRelease,String DirectorName) {
        String sql = "INSERT INTO Movies(id,MovieName,Actor,Actress,YearOfRelease,DirectorName) VALUES(?,?,?,?,?,?)";

        try (Connection conn = ConnectSqlite.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, MovieName);
            pstmt.setString(3, actor);
            pstmt.setString(4, actress);
            pstmt.setInt(5, YearOfRelease);
            pstmt.setString(6, DirectorName);
            pstmt.executeUpdate();
            System.out.println("Data Inserted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	public static void main(String[] args)
	{
		InsertQuery app = new InsertQuery();
        app.insert(1,"Ninnu Kori","Nani","Nivetha Thomas", 2017,"Shiva Nirvana");
        app.insert(2,"Maharshi","Mahesh Babu", "Pooja Hegde",2019,"Vamshi Paidipally");
        app.insert(3,"Most Eligible Bachelor","Akhil Akkineni","Pooja Hegde", 2021,"Bommarillu Bhaskar");
	}
}
