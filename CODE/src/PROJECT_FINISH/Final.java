package PROJECT_FINISH;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class Final extends JFrame {

    JLabel texto;
    JLabel cuadro;
    String time;

    public Final(String time) {
        this.time = time;
        setTitle("RESULTADOS");
        setSize(350, 400);
        setIconImage(new ImageIcon(getClass().getResource("/PICTURE/fond.png")).getImage());
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        cuadro = new JLabel();
        cuadro.setBounds(0, 0, 350, 400);
        cuadro.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/resultado.jpg")).getImage().getScaledInstance(cuadro.getWidth(), cuadro.getHeight(), Image.SCALE_DEFAULT)));

        texto = new JLabel();
        texto.setBounds(0, 0, 350, 400);
        texto.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
        texto.setHorizontalAlignment(JLabel.CENTER);
        texto.setForeground(Color.black);
        texto.setBackground(new Color(0,0,0,0));

        add(texto);
        add(cuadro);

        setVisible(false);
    }

    public void tex(String time, String p1, String p2, String p3, String res) {
        res = res.replace(".", ",");
        String text = "<html><body>SU PRUEBA FINALIZO <br><br> EN EL TIEMPO : "+time+" <br><br>PREGUNTA 1: " + p1 + "<br>PREGUNTA 2: " + p2 + "<br>PREGUNTA 3: " + p3 + "<br><br>&nbsp NOTA FINAL ES: " + res + "</body></html>";
        texto.setText(text);

    }

}
