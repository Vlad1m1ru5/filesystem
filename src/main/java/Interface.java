import java.awt.*;
import javax.swing.*;

class Interface extends JFrame{
    /*
        constructor
     */
    Interface() {
        super("myFileSystem");

        JTextArea textArea;
        JMenuBar menuBar;

        setPreferredSize(new Dimension(600, 250));
        setMaximumSize(new Dimension(600, 200));
        setMinimumSize(new Dimension(600, 200));

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
    public void createEdit(JTextArea textArea) {
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
    public void createMenu(JMenuBar menuBar) {
        JMenu menuFile;
        JMenuItem fileOpen;
        JMenuItem fileClose;
        JMenuItem fileEdit;

        try {
            menuFile = new JMenu("File");
            fileOpen = new JMenuItem("Open");
            fileEdit = new JMenuItem("Edit");
            fileClose = new JMenuItem("Close");

            setJMenuBar(menuBar);
            menuBar.add(menuFile);
            menuFile.add(fileOpen);
            menuFile.add(fileEdit);
            menuFile.add(fileClose);
        } catch (NullPointerException e) {
            System.out.println("-- Failed at menu bar creation --");
        }
    }
}
