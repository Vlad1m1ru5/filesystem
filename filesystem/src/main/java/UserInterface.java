import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

class UserInterface extends JFrame{
    private JMenuBar _menuBar;
    private JMenu _menuFile;
    private JMenu _menuEdit;
    private JMenu _menuLog;
    private JMenuItem _fileOpen;
    private JMenuItem _fileClose;
    private JMenuItem _editSave;
    private JMenuItem _editCancel;
    private JMenuItem _logShow;
    private JTextArea _textArea;

    /*
        constructor
     */
    UserInterface() {
        super("myFileSystem");

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        setPreferredSize(new Dimension(600, 250));
        setMaximumSize(new Dimension(600, 200));
        setMinimumSize(new Dimension(600, 200));

        setLocation(dimension.width / 2 - getPreferredSize().width / 2,
                    dimension.height / 2 - getPreferredSize().height / 2);

        _menuBar = new JMenuBar();
        _textArea = new JTextArea();

        _createMenu();
        _createEdit();

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _menuItemClickListener();
    }

    /*
        Ожидание выбора элментов меню
     */
    public void _menuItemClickListener() {
        _fileOpen.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        });
    }

    /*
        отображение главного окна приложения
     */
    private void _createEdit() {
        try {
            _textArea.setLineWrap(true);
            _textArea.setWrapStyleWord(true);

            this.add(_textArea);
        } catch (NullPointerException e) {
            System.out.println("-- Failed at text area creation --");
        }
    }

    /*
        создание маню
     */
    private void _createMenu() {


        try {
            _menuFile = new JMenu("File");
            _fileOpen = new JMenuItem("Open");
            _fileClose = new JMenuItem("Close");

            _menuEdit = new JMenu("Edit");
            _editSave = new JMenuItem("Save");
            _editCancel = new JMenuItem("Cancel");

            _menuLog = new JMenu("Log");
            _logShow = new JMenuItem("Show");

            _menuFile.add(_fileOpen);
            _menuFile.add(_fileClose);
            _menuEdit.add(_editSave);
            _menuEdit.add(_editCancel);
            _menuLog.add(_logShow);

            _menuBar.add(_menuFile);
            _menuBar.add(_menuEdit);
            _menuBar.add(_menuLog);
            setJMenuBar(_menuBar);
        } catch (NullPointerException e) {
            System.out.println("-- Failed at menu bar creation --");
        }
    }

    /*
        сообщение в лог
     */
    public String createLog(String filePath, int code) {
        DateFormat time = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String massage = "-- " + time.toString();
        switch (code) {
            case 0:
                massage += "-- Успешное открытие файла -- " + filePath + " --\n";
                code = -1;
                break;
            case 1:
                massage += "-- Ошибка открытия файла -- " + filePath + " --\n";
                code = -1;
                break;
            case 2:
                massage += "-- Успешное закрытие файла -- " + filePath + " --\n";
                code = -1;
                break;
            case 3:
                massage += "-- Ошибка закрытия файла -- " + filePath + " --\n";
                code = -1;
                break;
            case 4:
                massage += "-- Успешное сохрание файла -- " + filePath + " --\n";
                code = -1;
                break;
            case 5:
                massage += "-- Ошибка сохраниения файла -- " + filePath + " --\n";
                code = -1;
                break;
            case 6:
                massage += "-- Успешно отменено исзенение файла -- " + filePath + " --\n";
                code = -1;
                break;
            default:
                if (code != -1) {
                    massage += "-- Прерываение работы файла -- " + filePath + " --\n";
                }
        }

        return massage;
    }
}
