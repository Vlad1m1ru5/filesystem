import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *  Окно выбора каталога.
 */
class UserDirectory {
    private JFrame _dialogFrame;
    private JButton _searchBtn;
    private JButton _finishBtn;
    private JTextField _pathFld;
    private JPanel _panel;
    private JPanel _panelButtons;
    private JFileChooser _dirChooser;
    private String _directoryPath;

    /*
        constructor
     */
    UserDirectory() {
        _dialogFrame = new JFrame("myDirectory");
        _searchBtn = new JButton("Search");
        _finishBtn = new JButton("Finish");
        _pathFld = new JTextField("", 125);
        _panel = new JPanel();
        _panelButtons = new JPanel();
        _dirChooser = new JFileChooser();
        _directoryPath = "";
    }

    /*
        отображение окна выбора католога
     */
    void setUserDirectory(UserInterface userInterface) {

        _dialogFrame.setUndecorated(true);
        _dialogFrame.setPreferredSize(new Dimension(300, 50));
        _dialogFrame.setMinimumSize(new Dimension(300, 50));
        _dialogFrame.setMinimumSize(new Dimension(300, 50));

        _dialogFrame.setLocationRelativeTo(userInterface);

        _panelButtons.setLayout(new FlowLayout());
        _panelButtons.add(_searchBtn);
        _panelButtons.add(_finishBtn);

        _pathFld.setEditable(false);

        _panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));
        _panel.add(_pathFld);
        _panel.add(_panelButtons);

        _dialogFrame.add(_panel);
        _dialogFrame.setEnabled(true);
        _dialogFrame.isFocused();
        _dialogFrame.setVisible(true);

        _buttonClickListener(userInterface);
    }

    /*
        ожидание нажати кнопок
     */
    private void _buttonClickListener(final UserInterface userInterface) {
        userInterface.setEnabled(false);

        // нажатие кнопки выбора каталога
        _searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _dirChooser.setName("myDirectoryNavigator");
                _dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = _dirChooser.showOpenDialog(_dirChooser);

                if (result == JFileChooser.APPROVE_OPTION) {
                    _directoryPath = _dirChooser.getSelectedFile().toString();
                }
                _pathFld.setText(_directoryPath);
            }
        });

        // нажатие кнопки завершения
        _finishBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(_pathFld.getText().equals("") || _pathFld.getText().equals("Укажите путь к каталогу."))) {
                    _dialogFrame.setEnabled(false);
                    _dialogFrame.setVisible(false);
                    userInterface.setEnabled(true);
                    userInterface.setVisible(true);
                } else {
                    _pathFld.setText("Укажите путь к каталогу.");
                }
            }
        });
    }

    /*
        выбор пользовательского каталога
     */
    public String getUserDirectory() {
        return _directoryPath;
    }

}
