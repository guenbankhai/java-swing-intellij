package project.DAO;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import project.GUI.DialogNotification;

import javax.management.Notification;
import java.io.*;
import java.sql.Connection;
import java.util.Properties;

public class Connect {

    public static Connection conn = null;
    private String severName;
    private String databaseName;
    private String userName;
    private String password;

    public Connect() {
        readTextFile();

        String connectString =  "jdbc:sqlserver://" + severName +
                                ";databaseName=" + databaseName +
                                ";useUnicode=true;characterEncoding=utf-8;trustServerCertificate=true";

        Properties pro = new Properties();
        pro.put("user", userName);
        pro.put("password", password);

        try {
            SQLServerDriver driver = new SQLServerDriver();
            conn = driver.connect(connectString, pro);
        } catch (SQLServerException e) {
            new DialogNotification("Kết nối cơ sở dữ liệu thất bại!", DialogNotification.ERROR_DIALOG);
            System.exit(0);
        }
    }

    private void readTextFile() {
        severName = "";
        databaseName = "";
        userName = "";
        password = "";

        try {
            FileInputStream fis = new FileInputStream("Connect.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            severName = br.readLine();
            databaseName = br.readLine();
            userName = br.readLine();
            password = br.readLine();

        } catch (Exception e) {
            new DialogNotification("Đọc file Connect.txt thất bại!", DialogNotification.ERROR_DIALOG);
        }
    }

}
