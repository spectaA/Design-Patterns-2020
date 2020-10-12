package prjThermometre;

import javax.swing.*;
import java.awt.*;

public class AffichageFrm extends JFrame {

    private JTextField field;

    public AffichageFrm() {
        super("Thermo - affichage");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(150, 150);
        this.setResizable(false);

        field = new JTextField();
        field.setPreferredSize(new Dimension(100,100));

        Font font = new Font("SansSerif", Font.BOLD, 30);
        field.setFont(font);
        field.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        panel.add(field);

        this.add(panel);

        this.setVisible(true);
    }

    public void setTemp(Double t) {
        this.field.setText(t.toString());
    }
}
