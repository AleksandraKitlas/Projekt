import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowSchroniska extends JPanel implements ActionListener
{
    private JFrame frame;
    private JLabel firstLabel;
    private JButton returnButton;
    ShowSchroniska()
    {
        frame = new JFrame("nasze schroniska");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setLocationRelativeTo(null);
        this.setLayout(null);


        firstLabel = new JLabel("Nasze schroniska w Polsce");
        firstLabel.setForeground(new Color(69, 13, 134));
        firstLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        firstLabel.setHorizontalAlignment(JLabel.CENTER);
        firstLabel.setVerticalAlignment(JLabel.TOP);
        firstLabel.setBounds(250, 10, 190,25);
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
        ArrayList<Schronisko> schroniska = Schronisko.getSchroniska();
        int y = 60;
        for(Schronisko schronisko: schroniska)
        {
            g.drawString(schronisko.toString(), 100, y);
            y+=25;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == returnButton)
        {
            frame.dispose();
            new MainPage();
        }
    }
}
