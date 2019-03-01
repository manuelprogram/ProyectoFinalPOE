package PROJECT_FINISH;

import javax.swing.JToggleButton;

public class Boton extends JToggleButton {

    boolean bien = false;

    public Boton() {
        setSize(60, 60);
    }

    public boolean getBien() {
        return bien;
    }

    public void setBien(boolean bien) {
        this.bien = bien;
    }
}
