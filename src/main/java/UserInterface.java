import javafx.stage.Screen;

import java.awt.*;
import javax.swing.*;

class UserInterface extends JFrame{

    /*
        constructor
     */
    UserInterface() {
        super("myFileSystem");

        JTextArea textArea;
        JMenuBar menuBar;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        setPreferredSize(new Dimension(600, 250));
        setMaximumSize(new Dimension(600, 200));
        setMinimumSize(new Dimension(600, 200));

        setLocation(dimension.width / 2 - getPreferredSize().width / 2,
                    dimension.height / 2 - getPreferredSize().height / 2);

        menuBar = new JMenuBar();
        textArea = new JTextArea();

        createMenu(menuBar);
        createEdit(textArea);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*
        отображение главного окна приложения
     */
    private void createEdit(JTextArea textArea) {
        try {
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            this.add(textArea);
        } catch (NullPointerException e) {
            System.out.println("-- Failed at text area creation --");
        }
    }

    /*
        создание маню
     */
    private void createMenu(JMenuBar menuBar) {
        JMenu menuFile;
        JMenu menuEdit;
        JMenu menuLog;
        JMenuItem fileOpen;
        JMenuItem fileClose;
        JMenuItem editSave;
        JMenuItem editCancel;
        JMenuItem logShow;

        try {
            menuFile = new JMenu("File");
            fileOpen = new JMenuItem("Open");
            fileClose = new JMenuItem("Close");

            menuEdit = new JMenu("Edit");
            editSave = new JMenuItem("Save");
            editCancel = new JMenuItem("Cancel");

            menuLog = new JMenu("Log");
            logShow = new JMenuItem("Show");

            menuFile.add(fileOpen);
            menuFile.add(fileClose);
            menuEdit.add(editSave);
            menuEdit.add(editCancel);
            menuLog.add(logShow);
            menuBar.add(menuFile);
            menuBar.add(menuEdit);
            menuBar.add(menuLog);
            setJMenuBar(menuBar);
        } catch (NullPointerException e) {
            System.out.println("-- Failed at menu bar creation --");
        }
    }
}
