import java.io.*;
import java.sql.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;


public class Main {
    public static void main(String[] args) throws IOException {

        List<String> title = new ArrayList<>();
        List<String> genre = new ArrayList<>();

        File filmlist = new File("src\\movilineOK.csv");
        FileReader fileReader = new FileReader(filmlist);

        BufferedReader br = new BufferedReader(fileReader);

        String movieline =null;
        int linecounter = 0;


        while(( movieline = br.readLine()) != null /*&& linecounter < 100*/) {
            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(movieline.split(";")));
            System.out.println(movieline);
            title.add(temp.get(0));
            try {
                genre.add(temp.get(13));
            } catch (IndexOutOfBoundsException e){
                genre.add("NA");
            }


            linecounter++;
        }
        for (String ele :title) {
            System.out.println(ele);
        }

        for (String ele :genre) {
            System.out.println(ele);
        }
        System.out.println(title.size());
        System.out.println(genre.size());
/*
        FilmDetails filmdatabank = new FilmDetails(title,genre);

        System.out.println(filmdatabank.getTitles());
*/
        try{
            for (int i = 0; i < title.size(); i++) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FilmDataBase","root", "Ubuntu");
                PreparedStatement stmt = con.prepareStatement("insert into Films (title, genre) values (?,?)");
                stmt.setString(1, title.get(i));
                stmt.setString(2,genre.get(i));
                stmt.execute();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
