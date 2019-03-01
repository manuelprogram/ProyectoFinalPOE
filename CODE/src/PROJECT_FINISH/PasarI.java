package PROJECT_FINISH;

public class PasarI extends Thread {

    Pregunta panel;
    Windows frame;

    public PasarI(Pregunta panel) {
        this.panel = panel;
    }

    public void run() {
        while (panel.getLocation().x > -675) {
            try {
                panel.setLocation(panel.getLocation().x - 1, panel.getLocation().y);
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
    }
}
