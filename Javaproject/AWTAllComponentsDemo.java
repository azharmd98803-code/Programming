package Javaproject;

import java.awt.*;
import java.awt.event.*;

public class AWTAllComponentsDemo extends Frame
        implements ActionListener, ItemListener, AdjustmentListener {

    // Components
    Label title, nameLbl, genderLbl, courseLbl, skillLbl, msgLbl, scrollLbl;
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

    public AWTAllComponentsDemo() {

        setTitle("AWT All Components Demo - Ajju");
        setSize(800, 600);
        setLayout(null);
        setBackground(new Color(230, 240, 250));

        // ===== Menu Bar =====
        MenuBar mb = new MenuBar();
        Menu file = new Menu("File");
        Menu help = new Menu("Help");

        MenuItem exitItem = new MenuItem("Exit");
        MenuItem aboutItem = new MenuItem("About");

        file.add(exitItem);
        help.add(aboutItem);

        mb.add(file);
        mb.add(help);
        setMenuBar(mb);

        exitItem.addActionListener(e -> System.exit(0));
        aboutItem.addActionListener(e -> showDialog());

        // ===== Labels =====
        title = new Label("AWT Components Full Demo", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(250, 40, 300, 30);
        add(title);

        nameLbl = new Label("Name:");
        nameLbl.setBounds(80, 100, 80, 25);
        add(nameLbl);

        genderLbl = new Label("Gender:");
        genderLbl.setBounds(80, 140, 80, 25);
        add(genderLbl);

        courseLbl = new Label("Course:");
        courseLbl.setBounds(80, 180, 80, 25);
        add(courseLbl);

        skillLbl = new Label("Skills:");
        skillLbl.setBounds(80, 220, 80, 25);
        add(skillLbl);

        msgLbl = new Label("Message:");
        msgLbl.setBounds(80, 300, 80, 25);
        add(msgLbl);

        scrollLbl = new Label("Rating:");
        scrollLbl.setBounds(80, 430, 80, 25);
        add(scrollLbl);

        // ===== TextField =====
        nameField = new TextField();
        nameField.setBounds(180, 100, 200, 25);
        add(nameField);

        // ===== Radio Buttons =====
        genderGroup = new CheckboxGroup();
        maleRB = new Checkbox("Male", genderGroup, true);
        femaleRB = new Checkbox("Female", genderGroup, false);

        maleRB.setBounds(180, 140, 70, 25);
        femaleRB.setBounds(260, 140, 80, 25);

        add(maleRB);
        add(femaleRB);

        // ===== Choice =====
        courseChoice = new Choice();
        courseChoice.add("B.Tech");
        courseChoice.add("BCA");
        courseChoice.add("MCA");
        courseChoice.add("MBA");
        courseChoice.setBounds(180, 180, 200, 25);
        add(courseChoice);

        // ===== Checkbox =====
        javaCB = new Checkbox("Java");
        pythonCB = new Checkbox("Python");
        cCB = new Checkbox("C");

        javaCB.setBounds(180, 220, 60, 25);
        pythonCB.setBounds(250, 220, 80, 25);
        cCB.setBounds(340, 220, 50, 25);

        add(javaCB);
        add(pythonCB);
        add(cCB);

        // ===== List =====
        skillList = new List(4, true);
        skillList.add("Communication");
        skillList.add("Problem Solving");
        skillList.add("Leadership");
        skillList.add("Team Work");
        skillList.setBounds(180, 260, 200, 80);
        add(skillList);

        // ===== TextArea =====
        msgArea = new TextArea();
        msgArea.setBounds(180, 300, 300, 100);
        add(msgArea);

        // ===== Scrollbar =====
        scroll = new Scrollbar(Scrollbar.HORIZONTAL, 5, 1, 0, 11);
        scroll.setBounds(180, 430, 300, 20);
        add(scroll);
        scroll.addAdjustmentListener(this);

        // ===== Buttons =====
        submitBtn = new Button("Submit");
        clearBtn = new Button("Clear");
        dialogBtn = new Button("Show Dialog");

        submitBtn.setBounds(180, 480, 80, 30);
        clearBtn.setBounds(280, 480, 80, 30);
        dialogBtn.setBounds(380, 480, 100, 30);

        add(submitBtn);
        add(clearBtn);
        add(dialogBtn);

        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        dialogBtn.addActionListener(this);

        // ===== Dialog =====
        infoDialog = new Dialog(this, "About", true);
        infoDialog.setSize(300, 150);
        infoDialog.setLayout(new FlowLayout());
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

    // ===== Button Events =====
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitBtn) {

            String name = nameField.getText();
            String gender = genderGroup.getSelectedCheckbox().getLabel();
            String course = courseChoice.getSelectedItem();

            String skills = "";
            if (javaCB.getState()) skills += "Java ";
            if (pythonCB.getState()) skills += "Python ";
            if (cCB.getState()) skills += "C ";

            String rating = String.valueOf(scroll.getValue());

            msgArea.setText(
                    "Name: " + name +
                    "\nGender: " + gender +
                    "\nCourse: " + course +
                    "\nLanguages: " + skills +
                    "\nRating: " + rating
            );
        }

        if (e.getSource() == clearBtn) {
            nameField.setText("");
            msgArea.setText("");
            javaCB.setState(false);
            pythonCB.setState(false);
            cCB.setState(false);
        }

        if (e.getSource() == dialogBtn) {
            showDialog();
        }
    }

    void showDialog() {
        infoDialog.setLocationRelativeTo(this);
        infoDialog.setVisible(true);
    }

    // ===== Scrollbar Event =====
    public void adjustmentValueChanged(AdjustmentEvent e) {
        setTitle("Rating: " + scroll.getValue());
    }

    // ===== Main =====
    public static void main(String[] args) {
        new AWTAllComponentsDemo();
    }
}