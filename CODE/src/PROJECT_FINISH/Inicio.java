package PROJECT_FINISH;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Inicio extends JFrame implements ActionListener {

    JLabel cuadro;
    JButton iniciar;
    JButton ins;
    Windows s;
    Sound sonido;
    Instruccion ver;

    public Inicio() {
        setTitle("BIENVENIDOS AL EXAMEN");
        setIconImage(new ImageIcon(getClass().getResource("/PICTURE/fond.png")).getImage());
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(500, 400);
        setLocationRelativeTo(null);

        sonido = new Sound();
        sonido.AbrirFichero("/SONIDO/peli.wav");
        
        s = new Windows();

        ver = new Instruccion();

        cuadro = new JLabel();
        cuadro.setBounds(0, 0, 500, 300);
        cuadro.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/final.jpg")).getImage().getScaledInstance(cuadro.getWidth(), cuadro.getHeight(), Image.SCALE_DEFAULT)));

        iniciar = new JButton();
        iniciar.setBounds(180, 310, 50, 50);
        iniciar.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/pinchar.png")).getImage().getScaledInstance(iniciar.getHeight(), iniciar.getWidth(), Image.SCALE_DEFAULT)));
        iniciar.setFocusable(false);
        iniciar.setContentAreaFilled(false);
        iniciar.setBorder(null);

        ins = new JButton();
        ins.setBounds(250, 310, 50, 50);
        ins.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/help.png")).getImage().getScaledInstance(ins.getHeight(), ins.getWidth(), Image.SCALE_DEFAULT)));
        ins.setFocusable(false);
        ins.setContentAreaFilled(false);
        ins.setBorder(null);

        add(cuadro);
        add(iniciar);
        add(ins);
        iniciar.addActionListener(this);
        ins.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent op) {
        if (op.getSource() == iniciar) {
            dispose();
            if (s.pre[0].pos==2) {
                s.mover.resume();
            }
            s.setVisible(true);
            sonido.player.stop();
            s.thread.resume();
        }
        if (op.getSource() == ins) {
            ver.setVisible(true);
        }
    }
}
