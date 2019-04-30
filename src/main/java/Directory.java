import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class Directory {
    private String path;
    private boolean fixed;

    private JFrame dialogFrame;
    private JButton searchBtn;
    private JButton finishBtn;
    private JTextField pathFld;
    private JPanel panel;
    private JPanel panelButtons;
    private JFileChooser dirChooser;

    Directory() {
        fixed = false;
        path = "";
        dialogFrame = new JFrame("myDirectory");
        searchBtn = new JButton("Search");
        finishBtn = new JButton("Finish");
        pathFld = new JTextField("", 125);
        panel = new JPanel();
        panelButtons = new JPanel();
        dirChooser = new JFileChooser();
    }

    public boolean isFixed() {
        return fixed;
    }

    public void showDialog(Filesystem filesystem) {
        filesystem.setEnabled(false);
        selectDir();
    }

    public void selectDir() {
        dialogFrame.setPreferredSize(new Dimension(300, 90));
        dialogFrame.setMinimumSize(new Dimension(300, 90));
        dialogFrame.setMinimumSize(new Dimension(300, 90));
        dialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelButtons.setLayout(new FlowLayout());
        panelButtons.add(searchBtn);
        panelButtons.add(finishBtn);

        pathFld.setEditable(false);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(pathFld);
        panel.add(panelButtons);

        fileChooserListener();

        dialogFrame.add(panel);
        dialogFrame.setEnabled(true);
        dialogFrame.isFocused();
        dialogFrame.setVisible(true);
    }

    private void fileChooserListener() {
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dirChooser.setName("myDirectoryNavigator");
                dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = dirChooser.showOpenDialog(dirChooser);

                if (result == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(dirChooser, dirChooser.getSelectedFile());
                }
                pathFld.setText(path);
            }
        });

        finishBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!path.equals("")) {
                    fixed = true;

                } else {
                    pathFld.setText("Укажите перед выходом путь к файлу.");
                }
            }
        });
    }
}
