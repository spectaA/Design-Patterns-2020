package prjThermometre;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleFrm extends JFrame {

    private JTextField result = new JTextField();
    private JButton inc = new JButton("+");
    private JButton dec = new JButton("-");
    private JButton valide = new JButton("Valider");

    private  AffichageFrm affichage;
    private Double temp;

    public ControleFrm(AffichageFrm a) {
        super("Thermo - contrôle");

        this.affichage = a;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(200, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel pnlroot = new JPanel();
        JPanel pnlresult = new JPanel();
        JPanel pnlbtn = new JPanel();
        JPanel pnlvalide = new JPanel();

        this.add(pnlroot);
        pnlresult.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlroot.setLayout(new BoxLayout(pnlroot, BoxLayout.Y_AXIS));
        pnlbtn.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlvalide.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlroot.add(pnlresult);
        pnlroot.add(pnlbtn);
        pnlroot.add(pnlvalide);

        this.result.setPreferredSize(null);
        this.inc.setText("+");
        this.inc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOne();
            }
        });

        this.dec.setText("-");
        this.dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeOne();
            }
        });

        this.valide.setText("Valider");
        this.valide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateTemp();
            }
        });

        result.setPreferredSize(new Dimension(75,75));
        Font font = new Font("SansSerif", Font.BOLD, 20);
        result.setFont(font);
        result.setHorizontalAlignment(SwingConstants.CENTER);

        pnlresult.add(this.result);
        pnlbtn.add(this.inc);
        pnlbtn.add(this.dec);
        pnlvalide.add(this.valide);

        result.getDocument().addDocumentListener(new DocumentListener() {
            private void changed() {
                try {
                    Double val = Double.parseDouble(result.getText());
                    setTemp(val);
                } catch (NumberFormatException ex) {}
            }
            @Override
            public void insertUpdate(DocumentEvent e) { changed(); }
            @Override
            public void removeUpdate(DocumentEvent e) { changed(); }
            @Override
            public void changedUpdate(DocumentEvent e) { changed(); }
        });

        this.setVisible(true);
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public void addOne() {
        this.temp += 1;
        this.result.setText(this.temp.toString());
    }

    public void removeOne() {
        this.temp -= 1;
        this.result.setText(this.temp.toString());
    }

    public void validateTemp() {
        this.affichage.setTemp(temp);
    }
}
