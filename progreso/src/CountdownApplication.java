
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CountdownApplication extends JFrame implements ActionListener {
    private JProgressBar progressBar;
    private JLabel timeLabel;
    private Timer timer;
    private int seconds;

    public CountdownApplication() {
        setLayout(new FlowLayout());

        timeLabel = new JLabel();
        add(timeLabel);

        progressBar = new JProgressBar();
        add(progressBar);

        JButton startButton = new JButton("Empezar");
        startButton.addActionListener(this);
        add(startButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(this);
        add(cancelButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Empezar")) {
            String input = JOptionPane.showInputDialog(this, "Introduzca segundos:");
            try {
                seconds = Integer.parseInt(input);
                progressBar.setMaximum(seconds);
                timeLabel.setText(seconds + " seconds");
                timer = new Timer(1000, new TimerListener());
                timer.start();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Entrada Invalida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (command.equals("Cancel")) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Regresiva Cancelada", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            progressBar.setValue(progressBar.getMaximum() - seconds);
            timeLabel.setText(seconds + " seconds");
            if (seconds == 0) {
                timer.stop();
                JOptionPane.showMessageDialog(CountdownApplication.this, "Finalizo Tiempo!", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new CountdownApplication();
    }
}
