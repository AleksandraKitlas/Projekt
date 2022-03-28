import java.sql.*;
import java.util.ArrayList;

public class Schronisko
{
    private int id_schroniska;
    private String adres;
    private String miasto;
    private String email;
    private String nr_telefonu;

    public Schronisko(int id_schroniska, String adres, String miasto, String email, String nr_telefonu) {
        this.id_schroniska = id_schroniska;
        this.adres = adres;
        this.miasto = miasto;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
    }

    public String getAdres() {
        return adres;
    }

    public String getEmail() {
        return email;
    }

    public int getId_schroniska() {
        return id_schroniska;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    @Override
    public String toString() {
        return  "Adres: " + adres + " " + miasto + " ,kontakt: " + nr_telefonu + ", " + email;

    }

    public void insertSchronisko()
    {
        ResultSet rs = null;
        String sql = "INSERT INTO schroniska(id_schroniska, adres, miasto, email, nr_telefonu)" + "VALUES(?,?,?,?,?)";
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "passwd"); PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)
        {
            preparedStatement.setInt(1, this.id_schroniska);
            preparedStatement.setString(2, this.adres);
            preparedStatement.setString(3, this.miasto);
            preparedStatement.setString(4, this.email);
            preparedStatement.setString(5, this.nr_telefonu);

            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected ==1)
            {
                System.out.println("success");
            }

        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Schronisko> getSchroniska()
    {
        ArrayList<Schronisko> schroniska = new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "passwd");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from schroniska");
            while (resultSet.next())
            {
                Schronisko tmp = new Schronisko(resultSet.getInt("id_schroniska"), resultSet.getString("adres"), resultSet.getString("miasto"), resultSet.getString("email"), resultSet.getString("nr_telefonu"));
                schroniska.add(tmp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return schroniska;
    }
}
