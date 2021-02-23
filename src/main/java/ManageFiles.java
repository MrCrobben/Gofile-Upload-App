import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageFiles extends JFrame {
    public ManageFiles(){
        initGUI();
    }

    private void initGUI() {
        Container contentPane = getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        JButton getfilesBtn = new JButton();
        getfilesBtn.setText("Get Files");
        JLabel error = new JLabel();
        error.setText("Ovdje ide error");
        contentPane.add(getfilesBtn);
        contentPane.add(error);
        JList list = new JList(new CheckListItem[] { new CheckListItem("apple"),
                });
        list.setCellRenderer(new CheckListRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                JList list = (JList) event.getSource();
                int index = list.locationToIndex(event.getPoint());// Get index of item
                // clicked
                CheckListItem item = (CheckListItem) list.getModel()
                        .getElementAt(index);
                item.setSelected(!item.isSelected()); // Toggle selected state
                list.repaint(list.getCellBounds(index, index));// Repaint cell
            }
        });
        JScrollPane files = new JScrollPane(list);
        contentPane.add(files);



        //settings for elements

        //settings for get files button
        layout.putConstraint(SpringLayout.WEST,getfilesBtn,5,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.NORTH,getfilesBtn,5,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.SOUTH,getfilesBtn,-165,SpringLayout.SOUTH,contentPane);

        //settings for label error
        layout.putConstraint(SpringLayout.WEST,error,5,SpringLayout.EAST,getfilesBtn);

        //settings for content scroll pane
        layout.putConstraint(SpringLayout.NORTH,files , 5, SpringLayout.SOUTH,getfilesBtn);
        layout.putConstraint(SpringLayout.WEST,files,5,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.EAST,files,-5,SpringLayout.EAST,contentPane);
        layout.putConstraint(SpringLayout.SOUTH,files,-5,SpringLayout.SOUTH,contentPane);


    }
    private JList makeList(String token){
        JList list=null;
        return list;
    }
}
class CheckListItem {

    private String label;
    private boolean isSelected = false;

    public CheckListItem(String label) {
        this.label = label;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return label;
    }
}

class CheckListRenderer extends JCheckBox implements ListCellRenderer {
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean hasFocus) {
        setEnabled(list.isEnabled());
        setSelected(((CheckListItem) value).isSelected());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setText(value.toString());
        return this;
    }
}
