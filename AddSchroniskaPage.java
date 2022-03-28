import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddSchroniskaPage implements ActionListener {
    private JPanel panel;
    private JFrame frame;
    private JLabel firstLabel;
    private JLabel adresLabel;
    private JLabel miastoLabel;
    private JLabel emailLabel;
    private JLabel telefonLabel;
    private JLabel dodajLabel;
    private JTextField adresText;
    private JTextField miastText;
    private JTextField emailText;
    private JTextField telefonText;
    private JButton dodajButton;
    private JButton returnButton;
    AddSchroniskaPage()
    {
        panel = new JPanel();
        frame = new JFrame("dodaj schronisko");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);


        firstLabel = new JLabel("Dodaj schronisko");
        firstLabel.setForeground(new Color(69, 13, 134));
        firstLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        firstLabel.setHorizontalAlignment(JLabel.CENTER);
        firstLabel.setVerticalAlignment(JLabel.TOP);
        firstLabel.setBounds(175, 10, 150,25);
        panel.add(firstLabel);

        adresLabel = new JLabel("Adres");
        adresLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        adresLabel.setBounds(20, 40, 120, 25);
        panel.add(adresLabel);

        adresText = new JTextField(50);
        adresText.setBounds(140, 40, 200, 25);
        panel.add(adresText);

        miastoLabel = new JLabel("Miasto");
        miastoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        miastoLabel.setBounds(20, 70, 120, 25);
        panel.add(miastoLabel);

        miastText = new JTextField(50);
        miastText.setBounds(140, 70, 200, 25);
        panel.add(miastText);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        emailLabel.setBounds(20, 100, 120, 25);
        panel.add(emailLabel);

        emailText = new JTextField(50);
        emailText.setBounds(140, 100, 200, 25);
        panel.add(emailText);

        telefonLabel = new JLabel("Numer telefonu");
        telefonLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        telefonLabel.setBounds(20, 130, 120, 25);
        panel.add(telefonLabel);

        telefonText = new JTextField(50);
        telefonText.setBounds(140, 130, 200, 25);
        panel.add(telefonText);

        dodajButton = new JButton("dodaj");
        dodajButton.addActionListener(this);
        dodajButton.setBounds(195, 180, 100, 25);
        panel.add(dodajButton);

        dodajLabel = new JLabel("");
        dodajLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        dodajLabel.setBounds(175, 220, 200, 25);
        panel.add(dodajLabel);

        returnButton = new JButton("return");
        returnButton.addActionListener(this);
        returnButton.setBounds(390, 330, 100, 25);
        panel.add(returnButton);

        frame.setVisible(true);
    }

    public Schronisko goodSchronisko()
    {
        String adres ="ul." +  capitalize(adresText.getText());
        String telefon = telefonText.getText();
        String miasto = capitalize(miastText.getText());
        String email = emailText.getText();
        ArrayList<Schronisko> schroniska = Schronisko.getSchroniska();
        int id = schroniska.get(schroniska.size()-1).getId_schroniska() + 1;


        Schronisko goodSchronisko = new Schronisko(id,adres, miasto, email, telefon);
        return goodSchronisko;
    }
    boolean validateTextFields()
    {
        if(miastText.getText().isEmpty() || emailText.getText().isEmpty() || adresText.getText().isEmpty()
        || telefonText.getText().isEmpty())
        {
            return false;
        }
        int b = 0;
        for (int i = 2; i < emailText.getText().length(); i++)
        {
            if(emailText.getText().charAt(i) == '@')
            {
                b++;
            }
        }
        if(b!=1)
        {
            return false;
        }
        if(!isNumeric(telefonText.getText()) || telefonText.getText().length() !=9)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
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
            if(!validateTextFields())
            {
                dodajLabel.setText("Dane są niepoprwane");
            }
            else
            {
                Schronisko schronisko = goodSchronisko();
                schronisko.insertSchronisko();
                dodajLabel.setText("Dodano schronisko");
            }


        }
    }
}
