import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage implements ActionListener
{
    private JPanel panel;
    private JFrame frame;
    private JLabel firstLabel;
    private JButton showPsyButton;
    private JButton showSchroniskaButton;
    private JButton addPsyButton;
    private JButton addSchroniskaButton;

    MainPage()
    {
        panel = new JPanel();
        frame = new JFrame("schroniska polska");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);

        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(null);
        firstLabel = new JLabel("Witamy!");
        firstLabel.setForeground(new Color(69, 13, 134));
        firstLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        firstLabel.setHorizontalAlignment(JLabel.CENTER);
        firstLabel.setVerticalAlignment(JLabel.TOP);
        firstLabel.setBounds(160, 10, 80,25);
        panel.add(firstLabel);


        showPsyButton = new JButton("Nasze Pieski");
        showPsyButton.addActionListener(this);
        showPsyButton.setBounds(100, 50, 200, 25);
        showPsyButton.setHorizontalTextPosition(JButton.CENTER);
        showPsyButton.setVerticalTextPosition(JButton.BOTTOM);
        panel.add(showPsyButton);


        showSchroniskaButton = new JButton("Nasze Schroniska");
        showSchroniskaButton.addActionListener(this);
        showSchroniskaButton.setBounds(100, 90, 200, 25);
        showSchroniskaButton.setHorizontalTextPosition(JButton.CENTER);
        showSchroniskaButton.setVerticalTextPosition(JButton.BOTTOM);
        panel.add(showSchroniskaButton);

        addPsyButton = new JButton("Dodaj pieska");
        addPsyButton.addActionListener(this);
        addPsyButton.setBounds(100, 130, 200, 25);
        addPsyButton.setHorizontalTextPosition(JButton.CENTER);
        addPsyButton.setVerticalTextPosition(JButton.BOTTOM);
        panel.add(addPsyButton);

        addSchroniskaButton = new JButton("Dodaj schronisko");
        addSchroniskaButton.addActionListener(this);
        addSchroniskaButton.setBounds(100, 170, 200, 25);
        addSchroniskaButton.setHorizontalTextPosition(JButton.CENTER);
        addSchroniskaButton.setVerticalTextPosition(JButton.BOTTOM);
        panel.add(addSchroniskaButton);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== showPsyButton)
        {
            frame.dispose();
            new ShowPsy();
        }
        else if(e.getSource() == showSchroniskaButton)
        {
            frame.dispose();
            new ShowSchroniska();
        }
        else if(e.getSource() == addPsyButton)
        {
            frame.dispose();
            new AddPsyPage();
        }
        else if(e.getSource() == addSchroniskaButton)
        {
            frame.dispose();
            new AddSchroniskaPage();
        }
    }
}
