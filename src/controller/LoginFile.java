package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoginFile {

    private static boolean login = false;
    private static List<LoginChangeListener> loginChangeListeners = new ArrayList<>();
    private static final String LOGIN_FILE = "login.properties";
    private static final String USER_ID_FILE = "userid.txt";
    private static String userIDL, passwordL;

    public static boolean readLoginFromFile() {

        try {

            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(LOGIN_FILE);
            properties.load(fileInputStream);
            fileInputStream.close();

            if (properties.containsKey("login")) {

                login = Boolean.parseBoolean(properties.getProperty("login"));
                return login;

            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return false;
    }

    public static boolean isLogin() {

        return login;
    }

    public static void setLogin(boolean loggedIn) {

        login = loggedIn;
        notifyLoginChangeListeners(loggedIn);

        try {

            Properties properties = new Properties();
            properties.setProperty("login", String.valueOf(loggedIn));
            FileOutputStream fileOutputStream = new FileOutputStream(LOGIN_FILE);
            properties.store(fileOutputStream, null);
            fileOutputStream.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void addLoginChangeListener(LoginChangeListener listener) {

        loginChangeListeners.add(listener);
    }

    private static void notifyLoginChangeListeners(boolean loggedIn) {

        for (LoginChangeListener listener : loginChangeListeners) {

            listener.onLoginStateChanged(loggedIn);
        }
    }

    public static void setUserID(String userID) {

        try {

            FileWriter fileWriter = new FileWriter(USER_ID_FILE);
            fileWriter.write(userID);
            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
            System.err.println("Erro ao definir o UserID no arquivo: " + e.getMessage());
        }
    }

    public static String readUserIDFromFile() {

        String userIDFromTextFile = null;

        try {

            FileReader fileReader = new FileReader(USER_ID_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            userIDFromTextFile = bufferedReader.readLine();
            bufferedReader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        if (userIDFromTextFile != null)
            return userIDFromTextFile;

        else
            return "";
    }

}
