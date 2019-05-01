import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *  Окно выбора каталога.
 */
class Directory {
    private JFrame dialogFrame;
    private JButton searchBtn;
    private JButton finishBtn;
    private JTextField pathFld;
    private JPanel panel;
    private JPanel panelButtons;
    private JFileChooser dirChooser;

    /*
        constructor
     */
    Directory() {
        dialogFrame = new JFrame("myDirectory");
        searchBtn = new JButton("Search");
        finishBtn = new JButton("Finish");
        pathFld = new JTextField("", 125);
        panel = new JPanel();
        panelButtons = new JPanel();
        dirChooser = new JFileChooser();
    }

    /*
        отображение окна выбора католога
     */
    public void createDirectory(Filesystem filesystem) {
        filesystem.setEnabled(false);

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

        dialogFrame.add(panel);
        dialogFrame.setEnabled(true);
        dialogFrame.isFocused();
        dialogFrame.setVisible(true);

        buttonClickListener();
    }

    /*
        ожидание нажати кнопок
     */
    private void buttonClickListener() {
        // нажатие кнопки завершения
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dirChooser.setName("myDirectoryNavigator");
                dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = dirChooser.showOpenDialog(dirChooser);

                if (result == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(dirChooser, dirChooser.getSelectedFile());
                }
            }
        });

        // нажатие кнопки выбора каталога
        finishBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dirChooser.getCurrentDirectory().toString() == "") {
                    // TODO
                    //  вывод окна выбора каталога
                } else {
                    pathFld.setText("Укажите перед выходом путь к файлу.");
                }
            }
        });
    }
}
