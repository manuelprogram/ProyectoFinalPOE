package PROJECT_FINISH;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Pregunta extends JPanel implements MouseMotionListener {

    JButton save;
    Punto punto[];
    JLabel pre;
    JLabel fondo;
    Image[] ima1 = {(new ImageIcon(getClass().getResource("/PICTURE/youtube.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/dropox.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/google.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/instagram.png"))).getImage()};
    Image[] ima2 = {(new ImageIcon(getClass().getResource("/PICTURE/whatsapp.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/visual.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/google+.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/skype.png"))).getImage()};
    Image[] ima3 = {(new ImageIcon(getClass().getResource("/PICTURE/linux.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/line.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/utorrent.png"))).getImage(), (new ImageIcon(getClass().getResource("/PICTURE/apple.png"))).getImage()};

    boolean ban = true;
    boolean atras = false;
    boolean arriba = false;

    int pos;

    public Pregunta(String cad, int pos) {
        this.pos = pos;

        setSize(675, 300);
        setBorder(BorderFactory.createBevelBorder(0));
        setLayout(null);
        fondo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/bonita.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
        fondo.setBounds(0, 0, 675, 300);

        punto = new Punto[4];

        int cn1 = 70;
        for (int i = 0; i < punto.length; i++) {
            punto[i] = new Punto();
            if (pos == 2) {
                punto[i].move(cn1, 400);
            } else if (pos == 3) {
                if (i % 2 == 0) {
                    punto[i].move(cn1, 110);
                } else {
                    punto[i].move(cn1, 70);
                }

            }
            cn1 += 160;
        }

        pre = new JLabel(cad);
        pre.setOpaque(true);
        pre.setBackground(new Color(0, 150, 150, 0));
        pre.setBounds(25, 5, 660, 30);

        save = new JButton();
        save.setBounds(567, 243, 50, 50);
        save.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/PICTURE/disk.png")).getImage().getScaledInstance(save.getHeight(), save.getWidth(), Image.SCALE_DEFAULT)));
        save.setFocusable(false);
        save.setContentAreaFilled(false);
        save.setBorder(null);
        switch (pos) {
            case 3:
                addMouseMotionListener(this);
                break;
            default:

        }
        add(pre);
        add(save);
        add(fondo);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (ban) {
            pinto(g);
        }
    }

    public void pinto(Graphics g) {
        if (ban) {
            switch (pos) {
                case 1:
                    punto[3].correct = true;
                    int cn1 = 70;
                    for (int i = 0; i < ima1.length; i++) {
                        if (i % 2 == 0) {
                            g.drawImage(ima1[i], cn1, 90, 60, 60, this);
                            punto[i].move(cn1 + 30, 120);
                        } else {
                            g.drawImage(ima1[i], cn1, 120, 60, 60, this);
                            punto[i].move(cn1 + 30, 150);
                        }
                        cn1 += 160;
                    }
                    break;
                case 2:
                    punto[1].correct = true;
                    int cn3 = 70;
                    for (int i = 0; i < punto.length; i++) {
                        g.drawImage(ima2[i], punto[i].x - 30, punto[i].y - 30, 60, 60, this);
                        cn3 += 160;
                    }
                    break;
                case 3:
                    punto[0].correct = true;
                    punto[3].correct = true;
                    int cn4 = 70;
                    for (int i = 0; i < punto.length; i++) {
                        g.drawImage(ima3[i], punto[i].x - 30, punto[i].y - 30, 60, 60, this);
                        cn4 += 160;
                    }
                    break;
                default:
            }
        }
    }

    public void Mover() {
        int cn3 = 70;
        for (int i = 0; i < punto.length; i++) {
            punto[i].move(cn3, punto[i].y - 1);
            cn3 += 160;
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        for (int i = 0; i < punto.length; i++) {
            if (Math.pow(me.getX() - punto[i].x, 2) + Math.pow(me.getY() - punto[i].y, 2) - 900 <= 0) {
                punto[i].select = true;
                punto[i].x = me.getX();
                punto[i].y = me.getY();
                repaint();
            }
        }
        me.consume();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}
