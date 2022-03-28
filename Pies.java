import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Pies
{
    private int id_psa;
    private int id_schroniska;
    private String imie;
    private String plec;
    private String rasa;
    private String data_urodzenia;
    private String data_przyjecia;

    public Pies(int id_psa, int id_schroniska, String imie, String plec,  String rasa, String data_urodzenia, String data_przyjecia) {
        this.id_psa = id_psa;
        this.id_schroniska = id_schroniska;
        this.imie = imie;
        this.plec = plec;
        this.data_urodzenia = data_urodzenia;
        this.data_przyjecia = data_przyjecia;
        this.rasa = rasa;
    }

    public Pies(int id_psa, int id_schroniska, String imie, String plec, String data_urodzenia, String data_przyjecia) {
        this.id_psa = id_psa;
        this.id_schroniska = id_schroniska;
        this.imie = imie;
        this.plec = plec;
        this.data_urodzenia = data_urodzenia;
        this.data_przyjecia = data_przyjecia;
        this.rasa = "nieznana";
    }

    public String getData_przyjecia() {
        return data_przyjecia;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public int getId_psa() {
        return id_psa;
    }

    public int getId_schroniska() {
        return id_schroniska;
    }

    public String getImie() {
        return imie;
    }

    public String getPlec() {
        return plec;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    @Override
    public String toString() {
        if(plec.equals("female"))
        {
            return  imie + ": płeć suczka, rasa " + rasa + ", data urodzenie: " + data_urodzenia;
        }
        else
            return  imie + ": płeć pies, rasa " + rasa + ", data urodzenie: " + data_urodzenia;

    }

    public void insertPies() {
        ResultSet rs = null;
        String sql = "INSERT INTO psy(id_psa, id_schroniska, imie, plec, rasa, data_urodzenia, data_przyjecia)" + "VALUES(?,?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "passwd"); PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setInt(1, this.id_psa);
            preparedStatement.setInt(2, this.id_schroniska);
            preparedStatement.setString(3, this.imie);
            preparedStatement.setString(4, this.plec);
            if(this.rasa == null || this.rasa.equals("") || this.rasa.equals("nieznana"))
            {
                preparedStatement.setString(5, "");
            }
            else
            {
                preparedStatement.setString(5, this.rasa);
            }

            preparedStatement.setDate(6, Date.valueOf(this.data_urodzenia));
            preparedStatement.setDate(7, Date.valueOf(this.data_przyjecia));

//            int rowAffected = preparedStatement.executeUpdate();
//            if (rowAffected == 1) {
//                System.out.println("success");
//            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Pies> getPsy()
    {
        ArrayList<Pies> psy = new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "passwd");
            Statement statement = connection.createStatement();
            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");



            ResultSet resultSet = statement.executeQuery("select * from psy");
            while (resultSet.next())
            {
                Pies tmp = new Pies(resultSet.getInt("id_psa"), resultSet.getInt("id_schroniska"),
                        resultSet.getString("imie"), resultSet.getString("plec"), resultSet.getString("rasa"),
                        dateFormat.format(resultSet.getDate("data_urodzenia")), dateFormat.format(resultSet.getDate("data_przyjecia")));
                if(tmp.getRasa().equals(null) || tmp.getRasa().equals(""))
                {
                    tmp.setRasa("nieznana");
                }
                psy.add(tmp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return psy;
    }


}
