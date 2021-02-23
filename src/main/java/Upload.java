import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.net.http.HttpClient;

class Upload extends JFrame {
    public Upload(){
        initGUI();
    }
    private void initGUI(){
        Container contentPane = getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        JButton brwsBtn = new JButton("Browse");
        JButton uploadBtn = new JButton("Upload");
        JCheckBox anonCheck = new JCheckBox();
        JCheckBox emailCheck = new JCheckBox();
        anonCheck.setText("Anonymous");
        emailCheck.setText("Save on account");
        JTextArea pathTxt = new JTextArea();
        JTextArea resultTxt = new JTextArea();
        JProgressBar progressBar = new JProgressBar();
        contentPane.add(brwsBtn);
        contentPane.add(pathTxt);
        contentPane.add(uploadBtn);
        contentPane.add(anonCheck);
        contentPane.add(emailCheck);
        contentPane.add(progressBar);
        contentPane.add(resultTxt);

        //action listeners for the buttons

        //button browse
        brwsBtn.addActionListener(e->{
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(this);
            if(returnVal ==JFileChooser.APPROVE_OPTION){
                File file = fc.getSelectedFile();
                String path = file.getPath().toString();
                pathTxt.setText(path);
            }else{
                pathTxt.setText("Choosing file canceled ");
            }
        });

        uploadBtn.addActionListener(e->{
            File uploadFile = new File(pathTxt.getText());
            HttpClient client = HttpClient.newHttpClient();

        });

        //position settings for elements

        //setting position of the button Browse
        layout.putConstraint(SpringLayout.NORTH,brwsBtn,5,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.WEST,brwsBtn,5,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.SOUTH,brwsBtn,-163,SpringLayout.SOUTH,contentPane);

        //setting for textfiled
        layout.putConstraint(SpringLayout.NORTH,pathTxt,5,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.WEST,pathTxt,5,SpringLayout.EAST,brwsBtn);
        layout.putConstraint(SpringLayout.EAST,pathTxt,-20,SpringLayout.EAST,contentPane);

        //setting for upload button
        layout.putConstraint(SpringLayout.WEST,uploadBtn,5,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.NORTH,uploadBtn,7,SpringLayout.SOUTH,brwsBtn);
        layout.putConstraint(SpringLayout.SOUTH,uploadBtn,-135,SpringLayout.SOUTH,contentPane);

        //setting for anonymous checkbox

        layout.putConstraint(SpringLayout.WEST,anonCheck,10,SpringLayout.EAST,uploadBtn);
        layout.putConstraint(SpringLayout.NORTH,anonCheck,7,SpringLayout.SOUTH,brwsBtn);

        //setting for upload with emailcheckbox

        layout.putConstraint(SpringLayout.WEST,emailCheck,10,SpringLayout.EAST,anonCheck);
        layout.putConstraint(SpringLayout.NORTH,emailCheck,7,SpringLayout.SOUTH,brwsBtn);

        //setting for progressbar
        layout.putConstraint(SpringLayout.NORTH,progressBar,7,SpringLayout.SOUTH,uploadBtn);
        layout.putConstraint(SpringLayout.WEST,progressBar,13,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.EAST,progressBar,-13,SpringLayout.EAST,contentPane);
        layout.putConstraint(SpringLayout.SOUTH,progressBar,-118,SpringLayout.SOUTH,contentPane);

        //setting for result text
        layout.putConstraint(SpringLayout.NORTH,resultTxt,12,SpringLayout.SOUTH,progressBar);
        layout.putConstraint(SpringLayout.WEST,resultTxt,7,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.EAST,resultTxt,-7,SpringLayout.EAST,contentPane);
        layout.putConstraint(SpringLayout.SOUTH,resultTxt,-7,SpringLayout.SOUTH,contentPane);

    }
}