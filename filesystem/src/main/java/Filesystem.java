

/**
 *
 *  Главное приложение.
 */
public class Filesystem {

    /*
        инициализация файловой системы
     */
    private static void createFilesystem(String directoryPath) {

    }

    /*
        главный метод
     */
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        UserDirectory userDirectory = new UserDirectory();

        userDirectory.setUserDirectory(userInterface);
        createFilesystem(userDirectory.getUserDirectory());
    }
}
