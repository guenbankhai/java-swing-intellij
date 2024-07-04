package main;

import project.DAO.Connect;
import project.GUI.FrameLogin;
import project.GUI.FrameMain;

public class main {

    public static void main(String[] args) {

        new Connect();

        FrameLogin login = new FrameLogin();
        FrameMain main = new FrameMain();
        main.setVisible(true);
    }
}
