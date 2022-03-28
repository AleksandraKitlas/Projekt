import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddPsyPage implements ActionListener {
    private JPanel panel;
    private JFrame frame;
    private JLabel firstLabel;
    private JLabel idLabel;
    private JLabel imieLabel;
    private JLabel plecLabel;
    private JLabel rasaLabel;
    private JLabel data_urLabel;
    private JLabel dodajLabel;
    private JTextField imieText;
    private JTextField rasaText;
    private JComboBox idBox;
    private JComboBox plecBox;
    private JComboBox rokBox;
    private JComboBox miesiacBox;
    private JComboBox dzienBox;
    private JButton dodajButton;
    private JButton returnButton;

    AddPsyPage()
    {
        panel = new JPanel();
        frame = new JFrame("dodaj pieski");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);


        firstLabel = new JLabel("Dodaj pieska");
        firstLabel.setForeground(new Color(69, 13, 134));
        firstLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        firstLabel.setHorizontalAlignment(JLabel.CENTER);
        firstLabel.setVerticalAlignment(JLabel.TOP);
        firstLabel.setBounds(200, 10, 100,25);
        panel.add(firstLabel);

        idLabel = new JLabel("Id schroniska");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        idLabel.setBounds(20, 40, 200, 25);
        panel.add(idLabel);

        String[] id_schronisk = id_schronisk();
        idBox = new JComboBox(id_schronisk);
        idBox.setBounds(200, 40, 100, 25);
        panel.add(idBox);

        imieLabel = new JLabel("Imie");
        imieLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        imieLabel.setBounds(20, 70, 200, 25);
        panel.add(imieLabel);

        imieText = new JTextField(50);
        imieText.setBounds(140, 70, 200, 25);
        panel.add(imieText);

        plecLabel = new JLabel("Płeć");
        plecLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        plecLabel.setBounds(20, 100, 120, 25);
        panel.add(plecLabel);

        String[] plec = {"pies", "suczka"};
        plecBox = new JComboBox(plec);
        plecBox.setBounds(200, 100, 100, 25);
        panel.add(plecBox);

        rasaLabel = new JLabel("Rasa (opcjonalnie)");
        rasaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        rasaLabel.setBounds(20, 130, 120, 25);
        panel.add(rasaLabel);

        rasaText = new JTextField(50);
        rasaText.setBounds(140, 130, 200, 25);
        panel.add(rasaText);

        data_urLabel = new JLabel("Data urodzenia");
        data_urLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        data_urLabel.setBounds(20, 160, 120, 25);
        panel.add(data_urLabel);

        String[] rok = {"2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014",
                        "2013", "2012", "2011", "2010"};
        rokBox = new JComboBox(rok);
        rokBox.setBounds(137, 160, 90, 25);
        panel.add(rokBox);

        String[] miesiac = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        miesiacBox = new JComboBox(miesiac);
        miesiacBox.setBounds(227, 160, 70, 25);
        panel.add(miesiacBox);

        String[] dzien = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                        "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                        "28", "29", "30", "31"};
        dzienBox = new JComboBox(dzien);
        dzienBox.setBounds(297, 160, 70, 25);
        panel.add(dzienBox);

        dodajButton = new JButton("dodaj");
        dodajButton.addActionListener(this);
        dodajButton.setBounds(195, 200, 100, 25);
        panel.add(dodajButton);

        dodajLabel = new JLabel("");
        dodajLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        dodajLabel.setBounds(190, 230, 200, 25);
        panel.add(dodajLabel);

        returnButton = new JButton("return");
        returnButton.addActionListener(this);
        returnButton.setBounds(390, 330, 100, 25);
        panel.add(returnButton);


        frame.setVisible(true);
    }

    public String[] id_schronisk()
    {
        ArrayList<Schronisko> schroniska = Schronisko.getSchroniska();
        String[] id_schronisk = new String[schroniska.size()];
        int i = 0;
        for (Schronisko schronisko : schroniska)
        {
            id_schronisk[i] = String.valueOf(schronisko.getId_schroniska());
            i++;
        }
        return id_schronisk;
    }

    public boolean validateFields()
    {
        if(imieText.getText().isEmpty())
        {
            return false;
        }

        if (miesiacBox.getSelectedItem().toString().equals("2") &&
                Integer.parseInt( dzienBox.getSelectedItem().toString()) > 27  )
        {
            return false;
        }
        else if(miesiacBox.getSelectedItem().toString().equals("4") &&
                Integer.parseInt( dzienBox.getSelectedItem().toString()) > 30 )
        {
            return false;
        }
        else if(miesiacBox.getSelectedItem().toString().equals("6") &&
                Integer.parseInt( dzienBox.getSelectedItem().toString()) > 30 )
        {
            return false;
        }
        else if(miesiacBox.getSelectedItem().toString().equals("9") &&
                Integer.parseInt( dzienBox.getSelectedItem().toString()) > 30 )
        {
            return false;
        }
        else if(miesiacBox.getSelectedItem().toString().equals("11") &&
                Integer.parseInt( dzienBox.getSelectedItem().toString()) > 30 )
        {
            return false;
        }

        if(rokBox.getSelectedItem().toString().equals("2022")
                && Integer.parseInt(miesiacBox.getSelectedItem().toString()) > 3 )
        {
            return false;
        }

        return true;
    }
    public Pies goodPies()
    {
        int id_schroniska = Integer.parseInt(idBox.getSelectedItem().toString());
        ArrayList<Pies> psy = Pies.getPsy();
        int id = psy.get(psy.size()-1).getId_psa() + 1;
        String imie = capitalize(imieText.getText());
        String plec;
        if(plecBox.getSelectedItem().toString().equals("pies"))
        {
            plec = "male";
        }
        else
        {
            plec = "female";
        }
        String rasa;
        if(rasaText.getText().isEmpty() || rasaText.getText().equals("nieznana"))
        {
            rasa = null;
        }
        else
        {
            rasa = rasaText.getText();
        }

        String data_ur = rokBox.getSelectedItem() + "-" + miesiacBox.getSelectedItem()+ "-" + dzienBox.getSelectedItem();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String data_przyj = simpleDateFormat.format(new Date());

        Pies goodPies = new Pies(id, id_schroniska, imie, plec, rasa, data_ur, data_przyj);
        return goodPies;
    }
    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == returnButton)
        {
            frame.dispose();
            new MainPage();
        }
        else if(e.getSource() == dodajButton)
        {
            if(!validateFields())
            {
                dodajLabel.setText("Dane są niepoprwane");
            }
            else
            {
                Pies pies = goodPies();
                pies.insertPies();

                dodajLabel.setText("Dodano schronisko");
            }
        }
    }
}
