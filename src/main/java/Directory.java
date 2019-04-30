import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Directory {
    private String path = "";
    private final String logFile = "SysLog.txt";
    private boolean fixed;

    Directory() {
        fixed = false;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void showDialog(Filesystem filesystem) {
        filesystem.setEnabled(false);
        selectDir();
    }

    public void selectDir() {
        JFrame dialogFrame = new JFrame("myDirectory");
        JButton searchBtn = new JButton("Search");
        JButton finishBtn = new JButton("Finish");
        final JTextField pathFld = new JTextField("", 170);
        JPanel panel = new JPanel();
        JPanel panelButtons = new JPanel();
        final JFileChooser dirChooser = new JFileChooser();

        dialogFrame.setPreferredSize(new Dimension(300, 125));
        dialogFrame.setMinimumSize(new Dimension(300, 125));
        dialogFrame.setMinimumSize(new Dimension(300, 125));
        dialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dirChooser.setName("myDirectoryNavigator");
                dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                final File selectedFile = dirChooser.getSelectedFile();
                path = selectedFile.getAbsoluteFile().toString();
                pathFld.setText(path);
            }
        });

        finishBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!path.equals("")) {
                    System.exit(0);
                } else {
                    pathFld.setText("Укажите перед выходом путь к файлу.");
                }
            }
        });

        panelButtons.setLayout(new FlowLayout());
        panelButtons.add(searchBtn);
        panelButtons.add(finishBtn);

        pathFld.setEditable(false);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(pathFld);
        panel.add(panelButtons);

        dialogFrame.add(panel);
        dialogFrame.setEnabled(true);
        dialogFrame.setVisible(true);
    }
}
