package Javaproject;
import java.awt.*;
import java.awt.event.*;

public class AWTAllComponentsGridDemo extends Frame
        implements ActionListener, AdjustmentListener {

    TextField nameField;
    TextArea msgArea;
    Button submitBtn, clearBtn, dialogBtn;

    Checkbox javaCB, pythonCB, cCB;
    CheckboxGroup genderGroup;
    Checkbox maleRB, femaleRB;

    Choice courseChoice;
    List skillList;
    Scrollbar scroll;

    Dialog infoDialog;

    public AWTAllComponentsGridDemo() {

        setTitle("AWT Components Full Demo");
        setSize(700, 550);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Title =====
        Label title = new Label("AWT Components Full Demo", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        add(title, gbc);

        gbc.gridwidth = 1;

        // ===== Name =====
        gbc.gridx = 0; gbc.gridy = 1;
        add(new Label("Name:"), gbc);

        nameField = new TextField(20);
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 2;
        add(nameField, gbc);
        gbc.gridwidth = 1;

        // ===== Gender =====
        gbc.gridx = 0; gbc.gridy = 2;
        add(new Label("Gender:"), gbc);

        genderGroup = new CheckboxGroup();
        maleRB = new Checkbox("Male", genderGroup, true);
        femaleRB = new Checkbox("Female", genderGroup, false);

        gbc.gridx = 1; gbc.gridy = 2;
        add(maleRB, gbc);
        gbc.gridx = 2; gbc.gridy = 2;
        add(femaleRB, gbc);

        // ===== Course =====
        gbc.gridx = 0; gbc.gridy = 3;
        add(new Label("Course:"), gbc);

        courseChoice = new Choice();
        courseChoice.add("B.Tech");
        courseChoice.add("BCA");
        courseChoice.add("MCA");
        courseChoice.add("MBA");

        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2;
        add(courseChoice, gbc);
        gbc.gridwidth = 1;

        // ===== Languages =====
        gbc.gridx = 0; gbc.gridy = 4;
        add(new Label("Languages:"), gbc);

        javaCB = new Checkbox("Java");
        pythonCB = new Checkbox("Python");
        cCB = new Checkbox("C");

        gbc.gridx = 1; gbc.gridy = 4;
        add(javaCB, gbc);
        gbc.gridx = 2; gbc.gridy = 4;
        add(pythonCB, gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        add(cCB, gbc);

        // ===== Skills List =====
        gbc.gridx = 0; gbc.gridy = 6;
        add(new Label("Skills:"), gbc);

        skillList = new List(4, true);
        skillList.add("Communication");
        skillList.add("Problem Solving");
        skillList.add("Leadership");
        skillList.add("Team Work");

        gbc.gridx = 1; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(skillList, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Message =====
        gbc.gridx = 0; gbc.gridy = 7;
        add(new Label("Message:"), gbc);

        msgArea = new TextArea(4, 20);
        gbc.gridx = 1; gbc.gridy = 7; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(msgArea, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Rating Scrollbar =====
        gbc.gridx = 0; gbc.gridy = 8;
        add(new Label("Rating:"), gbc);

        scroll = new Scrollbar(Scrollbar.HORIZONTAL, 5, 1, 0, 11);
        scroll.addAdjustmentListener(this);

        gbc.gridx = 1; gbc.gridy = 8; gbc.gridwidth = 2;
        add(scroll, gbc);
        gbc.gridwidth = 1;

        // ===== Buttons =====
        submitBtn = new Button("Submit");
        clearBtn = new Button("Clear");
        dialogBtn = new Button("Show Dialog");

        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        dialogBtn.addActionListener(this);

        gbc.gridx = 0; gbc.gridy = 9;
        add(submitBtn, gbc);
        gbc.gridx = 1; gbc.gridy = 9;
        add(clearBtn, gbc);
        gbc.gridx = 2; gbc.gridy = 9;
        add(dialogBtn, gbc);

        // ===== Dialog =====
        infoDialog = new Dialog(this, "About", true);
        infoDialog.setLayout(new FlowLayout());
        infoDialog.setSize(300, 150);
        infoDialog.add(new Label("AWT Demo Program"));
        infoDialog.add(new Label("Created by Ajju 😊"));
        Button closeBtn = new Button("Close");
        infoDialog.add(closeBtn);
        closeBtn.addActionListener(e -> infoDialog.setVisible(false));

        // ===== Window Close =====
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitBtn) {

            String skills = "";
            if (javaCB.getState()) skills += "Java ";
            if (pythonCB.getState()) skills += "Python ";
            if (cCB.getState()) skills += "C ";

            msgArea.setText(
                    "Name: " + nameField.getText() +
                    "\nGender: " + genderGroup.getSelectedCheckbox().getLabel() +
                    "\nCourse: " + courseChoice.getSelectedItem() +
                    "\nLanguages: " + skills +
                    "\nRating: " + scroll.getValue()
            );
        }

        if (e.getSource() == clearBtn) {
            nameField.setText("");
            msgArea.setText("");
        }

        if (e.getSource() == dialogBtn) {
            infoDialog.setLocationRelativeTo(this);
            infoDialog.setVisible(true);
        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        setTitle("Rating: " + scroll.getValue());
    }

    public static void main(String[] args) {
        new AWTAllComponentsGridDemo();
    }
}