import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowPsy extends JPanel implements ActionListener
{
    private JFrame frame;
    private JLabel firstLabel;
    private JButton returnButton;
    ShowPsy()
    {
        frame = new JFrame("nasze pieski");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setLocationRelativeTo(null);
        this.setLayout(null);


        firstLabel = new JLabel("Nasze pieski");
        firstLabel.setForeground(new Color(69, 13, 134));
        firstLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        firstLabel.setHorizontalAlignment(JLabel.CENTER);
        firstLabel.setVerticalAlignment(JLabel.TOP);
        firstLabel.setBounds(300, 10, 100,25);
        this.add(firstLabel);

        returnButton = new JButton("return");
        returnButton.addActionListener(this);
        returnButton.setBounds(590, 430, 100, 25);
        this.add(returnButton);

        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 13));
        ArrayList<Pies> psy = Pies.getPsy();
        int y = 50;
        for(Pies pies: psy)
        {
            g.drawString(pies.toString(), 160, y);
            y+=25;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == returnButton)
        {
            frame.dispose();
            new MainPage();
        }

    }
}
