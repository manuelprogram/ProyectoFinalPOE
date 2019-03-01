package PROJECT_FINISH;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hilo extends Thread {

    JLabel k;
    int i;
    JFrame frame;

    public Hilo(JLabel l, int h, JFrame frame) {
        k = l;
        i = h;
        this.frame = frame;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void run() {
        for (i = 4; i > 0 - 1; i--) {
            for (int j = 59; j > -1; j--) {
                k.setText(((i < 10) ? "0" + i : i + "")+(j<10?":0"+j:":"+j));
                try {
                    Thread.sleep(999);
                } catch (InterruptedException ex) {
                }
            }
            if (i==0) {
                this.stop();
            }
        }
    }

}
