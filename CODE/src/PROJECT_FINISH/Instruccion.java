package PROJECT_FINISH;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class Instruccion extends JFrame implements ActionListener {

    JLabel cuadro;
    JButton close;

    public Instruccion() {
        setTitle("INTRUCCIONES");
        setIconImage(new ImageIcon(getClass().getResource("/PICTURE/fond.png")).getImage());
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(500, 400);
        setLocationRelativeTo(null);

        cuadro = new JLabel();
        cuadro.setBounds(0, 0, 500, 400);
        cuadro.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/Intrucciones.jpg")).getImage().getScaledInstance(cuadro.getWidth(), cuadro.getHeight(), Image.SCALE_DEFAULT)));

        close = new JButton();
        close.setBounds(220, 320, 50, 50);
        close.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/bien.png")).getImage().getScaledInstance(close.getHeight(), close.getWidth(), Image.SCALE_DEFAULT)));
        close.setFocusable(false);
        close.setContentAreaFilled(false);
        close.setBorder(null);

        add(close);
        add(cuadro);

        close.addActionListener(this);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent op) {
        setVisible(false);
    }

}
