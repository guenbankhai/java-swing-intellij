package project.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogNotification extends JDialog {

    private String content;
    private int type;

    public final static int ERROR_DIALOG = 1;
    public final static int SUCCESS_DIALOG = 2;
    public final static int INFO_DIALOG = 3;
    public final static int WARNING_DIALOG = 4;

    public DialogNotification(String content, int type) {

        this.content = content;
        this.type = type;

        DialogControls();
        DialogEvents();
        DialogShow();
    }

    JPanel pnHeader = new JPanel();
    JPanel pnMain = new JPanel();
    JPanel pnIcon = new JPanel();
    JPanel pnContent = new JPanel();
    JPanel pnButton = new JPanel();
    JPanel pnFooter = new JPanel();

    JLabel lblClose = new JLabel(new ImageIcon("img/icon/icon-close.png"));
    JLabel lblIcon = new JLabel();
    JLabel lblContent = new JLabel(content);
    JLabel lblCopy = new JLabel();

    JButton btnOK = new JButton("OK");
    JButton btnCancel = new JButton("Cancel");

    final ImageIcon iconError = new ImageIcon("img/icon/icon-error.png");
    final ImageIcon iconSuccess = new ImageIcon("img/icon/icon-success.png");
    final ImageIcon iconInfo = new ImageIcon("img/icon/icon-info.png");
    final ImageIcon iconWarning = new ImageIcon("img/icon/icon-warning.png");

    private void DialogControls() {
        Container con = getContentPane();

        pnHeader.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnHeader.setPreferredSize(new Dimension(400, 25));

        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        pnMain.setBackground(Color.WHITE);

        pnIcon.setLayout(new FlowLayout());
        pnIcon.setBackground(Color.WHITE);

        pnContent.setLayout(new FlowLayout());
        pnContent.setBackground(Color.WHITE);

        pnButton.setLayout(new FlowLayout());
        pnButton.setBackground(Color.WHITE);

        pnFooter.setPreferredSize(new Dimension(400, 20));

        lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblContent.setFont(new Font("", Font.PLAIN, 18));
        lblContent.setHorizontalAlignment(JTextField.CENTER);
        lblContent.setForeground(Color.BLACK);
        lblContent.setText("<html>" +
                "<div style='text-align: justify; width:250px';>" +
                content +
                "</div></html>");

        lblCopy.setFont(new Font("", Font.PLAIN, 12));
        lblCopy.setHorizontalAlignment(JTextField.CENTER);
        lblCopy.setForeground(Color.LIGHT_GRAY);
        lblCopy.setText("<html>" +
                "<div style='text-align: center;'>" +
                "Make by GuenBanKhai" +
                "</div></html>");

        btnOK.setPreferredSize(new Dimension(60, 30));
        btnOK.setBorder(BorderFactory.createEmptyBorder());
        btnOK.setFocusPainted(false);
        btnOK.setBackground(Color.LIGHT_GRAY);

        btnCancel.setPreferredSize(new Dimension(60, 30));
        btnCancel.setBorder(BorderFactory.createEmptyBorder());
        btnCancel.setFocusPainted(false);
        btnCancel.setBackground(Color.LIGHT_GRAY);

        pnHeader.add(lblClose);
        pnIcon.add(lblIcon, BorderLayout.CENTER);
        pnContent.add(lblContent);
        pnButton.add(btnOK);
        pnFooter.add(lblCopy);

        pnMain.add(pnHeader);
        pnMain.add(pnIcon);
        pnMain.add(pnContent);
        pnMain.add(pnButton);
        pnMain.add(pnFooter);

        con.add(pnMain);

        Color backgroundHeader = new Color(0);
        switch (type) {
            case ERROR_DIALOG:
                backgroundHeader = new Color(220, 53, 69);
                lblIcon.setIcon(iconError);
                break;
            case SUCCESS_DIALOG:
                backgroundHeader = new Color(40, 167, 69);
                lblIcon.setIcon(iconSuccess);
                break;
            case INFO_DIALOG:
                backgroundHeader = new Color(0, 123, 255);
                lblIcon.setIcon(iconInfo);
                break;
            case WARNING_DIALOG:
                backgroundHeader = new Color(255, 193, 7);
                lblIcon.setIcon(iconWarning);
                pnButton.add(btnCancel);
                break;
        }

        pnHeader.setBackground(backgroundHeader);

    }

    private void DialogEvents() {
        lblClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeDialog();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        btnOK.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnOK.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnOK.setBackground(Color.LIGHT_GRAY);
            }
        });

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDialog();
                action = OK_OPTION;
            }
        });

        btnCancel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnCancel.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCancel.setBackground(Color.LIGHT_GRAY);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDialog();
                action = CANCEL_OPTION;
            }
        });
        pnMain.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                Move(x, y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });
    }

    int xMouse, yMouse;

    private void Move(int x, int y) {
        this.setLocation(x - xMouse, y - yMouse);
    }

    private int action;
    public final static int OK_OPTION = 1;
    public final static int CANCEL_OPTION = 2;

    private void closeDialog() {
        this.setVisible(false);
    }

    public int getAction() {
        return action;
    }

    private void DialogShow() {
        this.setUndecorated(true);
        this.pack();
        this.setSize(Math.max(this.getWidth(), 400), Math.max(this.getHeight(), 250));
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setModal(true);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        getRootPane().setDefaultButton(btnOK);
    }
}
