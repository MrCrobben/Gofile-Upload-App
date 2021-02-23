import javax.swing.*;
import java.awt.*;

public class Account extends JFrame {

    public Account(){
        initGUI();
    }

    private void initGUI() {
        Container contentPane = getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        JLabel desc = new JLabel();
        desc.setText("Insert your token.");
        JTextField tokenTxt = new JTextField();
        JButton submitBtn = new JButton();
        JCheckBox isLogged = new JCheckBox();
        isLogged.setText("Logged in account");
        isLogged.setEnabled(false);
        submitBtn.setText("Submit");
        JButton getaccBtn = new JButton();
        getaccBtn.setText("Get Account");
        JTextArea resultTxt = new JTextArea();
        contentPane.add(desc);
        contentPane.add(isLogged);
        contentPane.add(tokenTxt);
        contentPane.add(submitBtn);
        contentPane.add(getaccBtn);
        contentPane.add(resultTxt);

        //position settings for elements

        //settings for label
        layout.putConstraint(SpringLayout.WEST,desc,10,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.NORTH,desc,5,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.EAST,desc,-125,SpringLayout.EAST,contentPane);

        //settings for checkbox

        layout.putConstraint(SpringLayout.WEST,isLogged,250,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.NORTH,isLogged,5,SpringLayout.NORTH,contentPane);

        //settings for email text field
        layout.putConstraint(SpringLayout.NORTH,tokenTxt,10,SpringLayout.SOUTH,desc);
        layout.putConstraint(SpringLayout.WEST,tokenTxt,10,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.EAST,tokenTxt,-125,SpringLayout.EAST,contentPane);

        //settings for submit button
        layout.putConstraint(SpringLayout.NORTH,submitBtn,5,SpringLayout.SOUTH,tokenTxt);
        layout.putConstraint(SpringLayout.WEST,submitBtn,10,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.SOUTH,submitBtn,-110,SpringLayout.SOUTH,contentPane);

        //settings for get account info button

        layout.putConstraint(SpringLayout.WEST,getaccBtn,10,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.NORTH,getaccBtn,5,SpringLayout.SOUTH,submitBtn);
        layout.putConstraint(SpringLayout.SOUTH,getaccBtn,-90,SpringLayout.SOUTH,contentPane);

        //settings for text area
        layout.putConstraint(SpringLayout.WEST,resultTxt,10,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.NORTH,resultTxt,5,SpringLayout.SOUTH,getaccBtn);
        layout.putConstraint(SpringLayout.SOUTH,resultTxt,-5,SpringLayout.SOUTH,contentPane);
        layout.putConstraint(SpringLayout.EAST,resultTxt,-5,SpringLayout.EAST,contentPane);

    }
}
