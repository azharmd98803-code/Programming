package Javaproject;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Cutie extends JFrame {

    JButton startBtn, yesBtn, noBtn;
    JLabel textLabel, teddyLabel, questionLabel;
    JPanel card;

    String[] lines = {
            "Kutty… I tried many times to stay strong without saying this 🥺",
            "But my heart never stopped choosing you, every single day 💔❤️",
            "Even when I smile outside, inside I only think about you 🤍",
            "So today I can’t hide it anymore… I need to ask you this 🫶"
    };

    int line = 0, charIndex = 0;
    Timer typingTimer;

    String[] noMsgs = {
            "Please think again naaa 🥺",
            "My teddy is crying now 💔",
            "Don’t break my heart, Kutty 🧸💞",
            "Remember how much I care about you 😭💖"
    };

    int noCount = 0;
    Random rand = new Random();

    public Cutie() {
        setTitle("For Kutty 💖");
        setSize(450, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 170, 190));

        startBtn = new JButton("Click Me 💖");
        startBtn.setBounds(150, 20, 150, 40);
        add(startBtn);

        card = new JPanel(null);
        card.setBounds(25, 80, 390, 470);
        card.setBackground(Color.white);
        card.setVisible(false);
        add(card);

        teddyLabel = new JLabel(new ImageIcon("teddy-normal.gif"));
        teddyLabel.setBounds(110, 10, 160, 160);
        card.add(teddyLabel);

        textLabel = new JLabel("<html></html>");
        textLabel.setBounds(30, 180, 330, 120);
        textLabel.setForeground(new Color(255, 50, 100));
        card.add(textLabel);

        questionLabel = new JLabel("Do you love me? 😍", SwingConstants.CENTER);
        questionLabel.setBounds(60, 300, 260, 40);
        questionLabel.setFont(new Font("Serif", Font.BOLD, 22));
        questionLabel.setForeground(new Color(255, 50, 100));
        questionLabel.setVisible(false);
        card.add(questionLabel);

        yesBtn = new JButton("Yes 💕");
        yesBtn.setBounds(80, 360, 100, 35);
        yesBtn.setVisible(false);
        card.add(yesBtn);

        noBtn = new JButton("No 🙈");
        noBtn.setBounds(210, 360, 100, 35);
        noBtn.setVisible(false);
        card.add(noBtn);

        startBtn.addActionListener(e -> startFlow());
        yesBtn.addActionListener(e -> yesClicked());
        noBtn.addActionListener(e -> noClicked());

        setVisible(true);
    }

    void startFlow() {
        startBtn.setVisible(false);
        card.setVisible(true);
        startTyping();
    }

    void startTyping() {
        typingTimer = new Timer(60, e -> {
            if (line < lines.length) {
                if (charIndex < lines[line].length()) {
                    textLabel.setText("<html>" +
                            textLabel.getText().replaceAll("<html>|</html>", "")
                            + lines[line].charAt(charIndex++) +
                            "</html>");
                } else {
                    textLabel.setText(textLabel.getText() + "<br>");
                    line++;
                    charIndex = 0;
                }
            } else {
                typingTimer.stop();
                questionLabel.setVisible(true);
                yesBtn.setVisible(true);
                noBtn.setVisible(true);
            }
        });
        typingTimer.start();
    }

    void noClicked() {
        teddyLabel.setIcon(new ImageIcon("teddy-sad.gif"));

        questionLabel.setText(noMsgs[Math.min(noCount, noMsgs.length - 1)]);
        noCount++;

        if (noCount >= noMsgs.length) {
            makeNoRun();
        }
    }

    void makeNoRun() {
        noBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int x = rand.nextInt(card.getWidth() - 100);
                int y = rand.nextInt(card.getHeight() - 50);
                noBtn.setLocation(x, y);
            }
        });
    }

    void yesClicked() {
        teddyLabel.setIcon(new ImageIcon("teddy-happy.gif"));

        card.removeAll();

        JLabel msg = new JLabel(
                "<html><center>" +
                        "<h1 style='color:#ff2f68'>I Love You So Much Kutty 💖😭</h1>" +
                        "<p>You are my safe place 🤍</p>" +
                        "<p>No matter what, my heart will always choose you 🫶</p>" +
                        "</center></html>",
                SwingConstants.CENTER
        );
        msg.setBounds(20, 120, 350, 250);
        card.add(msg);

        card.repaint();
    }

    public static void main(String[] args) {
        new Cutie();
    }
}