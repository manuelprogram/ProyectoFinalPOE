package PROJECT_FINISH;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Time extends Thread {

    JLabel k;
    int i;
    Windows frame;
    String time;

    public Time(JLabel l, int h, Windows frame) {
        k = l;
        i = h;
        this.frame = frame;
        time="";
    }

    public void setI(int i) {
        this.i = i;
    }

    public void run() {
        for (i = 0; i > 0 - 1; i--) {
            for (int j = 59; j > -1; j--) {
                time=((i < 10) ? "0" + i : i + "") + (j < 10 ? ":0" + j : ":" + j);
                k.setText(time);
                try {
                    Thread.sleep(999);
                } catch (InterruptedException ex) {
                }
            }
            if (i == 0) {
                frame.Cerrar();
            }
        }
    }

}
