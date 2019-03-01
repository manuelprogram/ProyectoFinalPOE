package PROJECT_FINISH;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Windows extends JFrame implements ActionListener, MouseListener {

    JLabel cesta;
    Pregunta[] pre;
    Time thread;
    JLabel time;
    JLabel welcome;
    JCheckBox[] che;
    JPanel ches;
    Mover mover;
    PasarI[] pasarI;
    PasarD[] pasarD;
    JLabel fondo;
    String[] son = {"/SONIDO/oprimir.wav", "/SONIDO/guardar.wav", "/SONIDO/error.wav", "/SONIDO/final.wav"};
    Sound sonido;
    Cesta cesta_h;
    Final resultado;

    public Windows() {
        setTitle("PRUEBA DE CONOCIMIENTO");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(new ImageIcon(getClass().getResource("/PICTURE/fond.png")).getImage());

        fondo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/monta.jpg")).getImage().getScaledInstance(getWidth(), 650, Image.SCALE_DEFAULT)));
        fondo.setBounds(0, 0, 700, 650);

        cesta = new JLabel();
        cesta.setBounds(220, 380, 100, 80);
        cesta.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/cesta.png")).getImage().getScaledInstance(cesta.getWidth(), cesta.getHeight(), Image.SCALE_DEFAULT)));
        cesta.setVisible(false);

        cesta_h = new Cesta(cesta);
        cesta_h.start();
        cesta_h.suspend();
//----------------------------------------------------------------------
        sonido = new Sound();
        pre = new Pregunta[3];
        int a, b, c;
        do {
            a = (int) (Math.random() * 3);
            b = (int) (Math.random() * 3);
            c = (int) (Math.random() * 3);
        } while (a == b || b == c || a == c);
        pre[a] = new Pregunta("¿ KEVIN SYSTROM & MIKE KRIEGER QUE SOFTWARE CREARON ?", 1);
        pre[b] = new Pregunta("  ¿ ES UN CONJUNTO DE HERRAMIENTAS DE DESARROLLO ?", 2);
        pre[c] = new Pregunta("   SELECCIONE LOS SISTEMAS OPERATIVOS Y DEPOSITELOS", 3);

        pasarI = new PasarI[3];
        pasarD = new PasarD[3];
        for (int i = 0; i < 3; i++) {
            pre[i].setLocation(700, 80);
            pre[i].pre.setForeground(Color.red);
            pre[i].pre.setFont(new Font("Comic Sans MS", Font.BOLD, 19));

            pasarI[i] = new PasarI(pre[i]);
            pasarI[i].start();
            pasarI[i].suspend();

            pasarD[i] = new PasarD(pre[i]);
            pasarD[i].start();
            pasarD[i].suspend();
        }
        pasarD[0].resume();
        for (int i = 0; i < pre.length; i++) {
            if (pre[i].pos == 2) {
                mover = new Mover(pre[i]);
                break;
            }
        }
        mover.start();
        mover.suspend();
        if (pre[0].pos == 3) {
            cesta.setVisible(true);
        }

        time = new JLabel();
        time.setOpaque(true);
        time.setForeground(Color.red);
        time.setBackground(new Color(95, 209, 236));
        time.setBorder(BorderFactory.createTitledBorder("TIEMPO"));
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));
        time.setBounds(380, 20, 120, 50);

        thread = new Time(time, 4, this);
        thread.start();
        thread.suspend();

        resultado = new Final(thread.time);

        welcome = new JLabel("BIENVENDO");
        welcome.setFont(new Font("Comic Sans MS", Font.ITALIC, 45));
        welcome.setBounds(35, 20, 300, 45);

        ches = new JPanel(new GridLayout(1, 5));
        ches.setBackground(new Color(95, 209, 236));
        ches.setBounds(505, 20, 180, 50);
        ches.setBorder(BorderFactory.createTitledBorder("Contestadas"));
        che = new JCheckBox[3];
        for (int i = 0; i < che.length; i++) {
            che[i] = new JCheckBox();
            che[i].setBackground(new Color(95, 209, 236));
            che[i].setEnabled(false);
            ches.add(che[i]);
        }

        add(time);
        add(ches);
        add(cesta);
        add(pre[0]);
        add(pre[1]);
        add(pre[2]);
        add(welcome);
        add(fondo);
        //----------------------------------------------------------------------
        for (int i = 0; i < 3; i++) {
            pre[i].save.addActionListener(this);
            pre[i].addMouseListener(this);
        }
        //----------------------------------------------------------------------
        setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent op) {
        for (int i = 0; i < 3; i++) {
            if (op.getSource() == pre[i].save) {
                welcome.setText("UNIAMAZONIA");
                if (Validar(pre[i])) {
                    welcome.setFont(new Font("Comic Sans MS", Font.ITALIC, 35));
                    pasarI[i].resume();
                    if (i < 2) {
                        pasarD[i + 1].resume();
                        if (pre[i + 1].pos == 2) {
                            mover.resume();
                        }
                        if (pre[i + 1].pos == 3) {
                            cesta_h.resume();
                        } else {
                            cesta.setVisible(false);
                        }
                    }
                    che[i].setSelected(true);
                    if (i == 2) {
                        Cerrar();
                    } else {
                        sonido.AbrirFichero(son[1]);
                    }
                } else {
                    sonido.AbrirFichero(son[2]);
                    if (pre[i].pos == 3) {
                        JOptionPane.showMessageDialog(null, "FAVOR ALMACENE ALGO");
                    } else {
                        JOptionPane.showMessageDialog(null, "SELECCIONE ALGO");
                    }
                }
                break;
            }
        }
    }

    public boolean Validar(Pregunta pre) {
        boolean si = false;
        switch (pre.pos) {
            case 1:
                for (int i = 0; i < pre.punto.length; i++) {
                    if (pre.punto[i].select) {
                        si = true;
                    }
                }
                return si;
            case 2:
                return true;
            default:
                for (int i = 0; i < pre.punto.length; i++) {
                    if (pre.punto[i].select) {
                        if (pre.punto[i].x >= 220 && pre.punto[i].x <= 300 && pre.punto[i].y >= 330 && pre.punto[i].y <= 375) {
                            si = true;
                        } else {
                            pre.punto[i].select = false;
                        }
                    }
                }
                return si;

        }
    }

    public String P1() {
        boolean s = false;
        boolean c = true;
        for (int i = 0; i < pre.length; i++) {
            if (pre[i].pos == 1) {
                for (int j = 0; j < pre[i].punto.length; j++) {
                    if (pre[i].punto[j].select) {
                        s = true;
                        if (!pre[i].punto[j].correct) {
                            c = false;
                        }
                    }
                }
                break;
            }
        }

        return s && c ? "1,7" : "0";
    }

    public String P2() {
        boolean s = false;
        boolean c = true;
        for (int i = 0; i < pre.length; i++) {
            if (pre[i].pos == 2) {
                for (int j = 0; j < pre[i].punto.length; j++) {
                    if (pre[i].punto[j].select) {
                        s = true;
                        if (!pre[i].punto[j].correct) {
                            c = false;
                        }
                    }
                }
                break;
            }
        }

        return s && c ? "1,7" : "0";
    }

    public String P3() {
        boolean b = false;
        boolean m = true;
        for (int i = 0; i < pre.length; i++) {
            if (pre[i].pos == 3) {
                if (pre[i].punto[0].select && pre[i].punto[3].select) {
                    b = true;
                }
                if (pre[i].punto[1].select || pre[i].punto[2].select) {
                    m = false;
                }
                break;
            }
        }

        return b && m ? "1,7" : "0";
    }

    public void Cerrar() {
        sonido.AbrirFichero(son[3]);
        dispose();
        double num = Double.parseDouble(P1().replace(",", ".")) + Double.parseDouble(P2().replace(",", ".")) + Double.parseDouble(P3().replace(",", "."));
        resultado.tex(thread.time, P1(), P2(), P3(), (num > 5) ? "5,0" : num + "");
        resultado.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        for (int i = 0; i < pre.length; i++) {
            if (me.getSource() == pre[i]) {
                if (pre[i].pos < 3) {
                    know(me, i);
                }
            }
        }
    }

    public void know(MouseEvent me, int s) {
        for (int i = 0; i < pre[s].punto.length; i++) {
            if (Math.pow(me.getX() - pre[s].punto[i].x, 2) + Math.pow(me.getY() - pre[s].punto[i].y, 2) - 900 <= 0) {
                pre[s].punto[i].select = true;
                sonido.AbrirFichero(son[0]);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
