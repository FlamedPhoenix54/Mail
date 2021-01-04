package me.Mythical83.Mail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[]args) {
        JFrame f = new JFrame();
        f.setSize(316, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);

        Container content = f.getContentPane();
        content.setLayout(null);

        JTextField subject = new JTextField("subject");
        subject.setBounds(0, 0, 300, 25);
        subject.setForeground(Color.GRAY);

        JTextField recipient = new JTextField();
        recipient.setBounds(0, 25, 300, 25);

        JTextArea body = new JTextArea();

        JScrollPane pane = new JScrollPane(body);
        pane.setBounds(0, 50, 300, 85);

        JButton send = new JButton("Send");
        send.setBounds(0, 136, 300, 25);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SendEmail.subject = subject.getText();
                SendEmail.body = body.getText();
                SendEmail.main(args);
            }
        });

        subject.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (subject.getForeground() == Color.GRAY) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        subject.setText("");
                        subject.setForeground(Color.BLACK);
                    }
                }
            }
        });

        subject.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (subject.getForeground() == Color.GRAY) {
                    String s = subject.getText().substring(1, 1);
                    subject.setText(s);
                    subject.setForeground(Color.BLACK);
                }
            }
        });

        content.add(recipient);
        content.add(subject);
        content.add(pane);
        content.add(send);

        f.setVisible(true);
    }
}
