import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        JTabbedPane wind = new JTabbedPane();
        wind.addTab("Upload",new Upload().getContentPane());
        wind.addTab("Account",new Account().getContentPane());
        wind.addTab("Manage files",new ManageFiles().getContentPane());
        frame.add(wind);
        SwingUtilities.invokeLater(()->{
           frame.setVisible(true);

        });
    }

}
