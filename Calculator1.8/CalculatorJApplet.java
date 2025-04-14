import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
/*
    <applet code="CalculatorJApplet.class" width="300" height="300"></applet>
*/ 
public class CalculatorJApplet extends JApplet implements ActionListener {
    int op = 0, val = 0, r;
    JButton[] b = new JButton[10];
    JButton clr, add, sub, mul, div, equal;
    JTextField t = new JTextField(10);

    public void init() {
        initComponents();
    }

    private void initComponents() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // Create Buttons
        clr = new JButton("Clear");
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        equal = new JButton("=");

        // Text Field
        c.add(t);

        // Number Buttons (0-9)
        for (int i = 0; i < 10; i++) {
            b[i] = new JButton("" + i);
            c.add(b[i]);
            b[i].addActionListener(this);
        }

        // Add Operator Buttons
        c.add(clr);
        c.add(add);
        c.add(sub);
        c.add(mul);
        c.add(div);
        c.add(equal);

        // Add action listeners
        clr.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        equal.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle Number Buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == b[i]) {
                t.setText(t.getText() + i);
            }
        }

        // Handle Clear Button
        if (e.getSource() == clr) {
            t.setText("");
            val = 0;
        }
        // Handle Operators
        else if (e.getSource() == add) {
            val = Integer.parseInt(t.getText());
            t.setText("");
            op = 1;
        } else if (e.getSource() == sub) {
            val = Integer.parseInt(t.getText());
            t.setText("");
            op = 2;
        } else if (e.getSource() == mul) {
            val = Integer.parseInt(t.getText());
            t.setText("");
            op = 3;
        } else if (e.getSource() == div) {
            val = Integer.parseInt(t.getText());
            t.setText("");
            op = 4;
        } 
        // Handle Equals Button
        else if (e.getSource() == equal) {
            int newVal = Integer.parseInt(t.getText());
            switch (op) {
                case 1:
                    r = val + newVal;
                    break;
                case 2:
                    r = val - newVal;
                    break;
                case 3:
                    r = val * newVal;
                    break;
                case 4:
                    if (newVal == 0) {
                        t.setText("Error: Div by 0");
                        return;
                    }
                    r = val / newVal;
                    break;
                default:
                    t.setText("Error");
                    return;
            }
            t.setText("" + r);
        }
    }
}
