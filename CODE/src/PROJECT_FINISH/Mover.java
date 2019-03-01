package PROJECT_FINISH;

public class Mover extends Thread {

    Pregunta panel;

    public Mover(Pregunta panel) {
        this.panel = panel;
    }

    public void run() {
        while (panel.punto[0].y!=-60) {
            try {
                Thread.sleep(20);
                panel.Mover();
                panel.repaint();
            } catch (InterruptedException ex) {
            }
        }
    }
}
