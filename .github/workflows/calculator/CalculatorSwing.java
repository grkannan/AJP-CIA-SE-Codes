import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorSwing extends JFrame implements ActionListener {
    int val = 0, r, op = 0;
    JButton[] b = new JButton[10];
    JButton clr, add, sub, mul, div, equal;
    JTextField t = new JTextField(10);

    public CalculatorSwing() {
        setTitle("Swing Calculator");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 300);

        // Text Field
        add(t);

        // Number Buttons (0-9)
        for (int i = 0; i < 10; i++) {
            b[i] = new JButton("" + i);
            add(b[i]);
            b[i].addActionListener(this);
        }

        // Operator Buttons
        clr = new JButton("Clear");
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        equal = new JButton("=");

        add(clr);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(equal);

        // Add action listeners
        clr.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        equal.addActionListener(this);

        setVisible(true);
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
                case 1 -> r = val + newVal;
                case 2 -> r = val - newVal;
                case 3 -> r = val * newVal;
                case 4 -> {
                    if (newVal == 0) {
                        t.setText("Error: Div by 0");
                        return;
                    }
                    r = val / newVal;
                }
                default -> {
                    t.setText("Error");
                    return;
                }
            }
            t.setText("" + r);
        }
    }

    public static void main(String[] args) {
        new CalculatorSwing();
    }
}
