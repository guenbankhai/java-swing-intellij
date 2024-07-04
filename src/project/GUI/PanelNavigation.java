package project.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class PanelNavigation extends JPanel {
    public PanelNavigation() {
        initComponents();

        String role = "Admin";
        checkRoleUser(role);
    }

    private void optionMouseEntered(MouseEvent e, JLabel option) {
        option.setBackground(new Color(0xffad85));
    }

    private void optionMouseExited(MouseEvent e, JLabel option) {
        option.setBackground(new Color(0xff9966));
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - guenbankhai
        logo = new JLabel();
        pnNavigation = new JPanel();
        option1 = new JLabel();
        option2 = new JLabel();
        option3 = new JLabel();
        option4 = new JLabel();
        option5 = new JLabel();
        option6 = new JLabel();
        option7 = new JLabel();
        option8 = new JLabel();
        option9 = new JLabel();

        //======== events ========
        option1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option1);
            }
        });
        option2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option2);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option2);
            }
        });
        option3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option3);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option3);
            }
        });
        option4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option4);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option4);
            }
        });
        option5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option5);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option5);
            }
        });
        option6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option6);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option6);
            }
        });
        option7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option7);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option7);
            }
        });
        option8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option8);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option8);
            }
        });
        option9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionMouseEntered(e, option9);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionMouseExited(e, option9);
            }
        });

        //---- logo ----
        logo.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));

        //======== pnNavigation ========
        {
            pnNavigation.setBackground(new Color(0xff9966));

            //---- option1 ----
            option1.setText("Option 1");
            option1.setHorizontalAlignment(SwingConstants.CENTER);
            option1.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option1.setForeground(Color.white);
            option1.setBackground(new Color(0xff9966));
            option1.setOpaque(true);
            option1.setVisible(false);

            //---- option2 ----
            option2.setText("Option 2");
            option2.setHorizontalAlignment(SwingConstants.CENTER);
            option2.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option2.setForeground(Color.white);
            option2.setBackground(new Color(0xff9966));
            option2.setOpaque(true);
            option2.setVisible(false);

            //---- option3 ----
            option3.setText("Option 3");
            option3.setHorizontalAlignment(SwingConstants.CENTER);
            option3.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option3.setForeground(Color.white);
            option3.setBackground(new Color(0xff9966));
            option3.setOpaque(true);
            option3.setVisible(false);

            //---- option4 ----
            option4.setText("Option 4");
            option4.setHorizontalAlignment(SwingConstants.CENTER);
            option4.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option4.setForeground(Color.white);
            option4.setBackground(new Color(0xff9966));
            option4.setOpaque(true);
            option4.setVisible(false);

            //---- option5 ----
            option5.setText("Option 5");
            option5.setHorizontalAlignment(SwingConstants.CENTER);
            option5.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option5.setForeground(Color.white);
            option5.setBackground(new Color(0xff9966));
            option5.setOpaque(true);
            option5.setVisible(false);

            //---- option6 ----
            option6.setText("Option 6");
            option6.setHorizontalAlignment(SwingConstants.CENTER);
            option6.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option6.setForeground(Color.white);
            option6.setBackground(new Color(0xff9966));
            option6.setOpaque(true);
            option6.setVisible(false);

            //---- option7 ----
            option7.setText("Option 7");
            option7.setHorizontalAlignment(SwingConstants.CENTER);
            option7.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option7.setForeground(Color.white);
            option7.setBackground(new Color(0xff9966));
            option7.setOpaque(true);
            option7.setVisible(false);

            //---- option8 ----
            option8.setText("Option 8");
            option8.setHorizontalAlignment(SwingConstants.CENTER);
            option8.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option8.setForeground(Color.white);
            option8.setBackground(new Color(0xff9966));
            option8.setOpaque(true);
            option8.setVisible(false);

            //---- option9 ----
            option9.setText("Option 9");
            option9.setHorizontalAlignment(SwingConstants.CENTER);
            option9.setFont(new Font("Segoe UI", Font.BOLD, 18));
            option9.setForeground(Color.white);
            option9.setBackground(new Color(0xff9966));
            option9.setOpaque(true);
            option9.setVisible(false);

            GroupLayout pnNavigationLayout = new GroupLayout(pnNavigation);
            pnNavigation.setLayout(pnNavigationLayout);
            pnNavigationLayout.setHorizontalGroup(
                pnNavigationLayout.createParallelGroup()
                    .addComponent(option1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(option2, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(option3, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(option4, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(option5, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(option6, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(option7, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(option8, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(option9, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            );
            pnNavigationLayout.setVerticalGroup(
                pnNavigationLayout.createParallelGroup()
                    .addGroup(pnNavigationLayout.createSequentialGroup()
                        .addComponent(option1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(option2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(option3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(option4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(option5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(option6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(option7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(option8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(option9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(25, Short.MAX_VALUE)
                    .addComponent(logo)
                    .addContainerGap(25, Short.MAX_VALUE))
                .addComponent(pnNavigation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(logo)
                    .addGap(25, 25, 25)
                    .addComponent(pnNavigation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - guenbankhai
    private JLabel logo;
    private JPanel pnNavigation;
    private JLabel option1;
    private JLabel option2;
    private JLabel option3;
    private JLabel option4;
    private JLabel option5;
    private JLabel option6;
    private JLabel option7;
    private JLabel option8;
    private JLabel option9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void checkRoleUser(String role) {
        if(role.equals("Admin")) {
            option1.setVisible(true);
            option1.setText("Quản lý điểm");
            option2.setVisible(true);
            option2.setText("Quản lý học sinh");
            option3.setVisible(true);
            option3.setText("Quản lý giáo viên");
            option4.setVisible(true);
            option4.setText("Quản lý tổ chuyên môn");
            option5.setVisible(true);
            option5.setText("Phân công giảng dạy");
            option6.setVisible(true);
            option6.setText("Quản lý lớp học");
            option7.setVisible(true);
            option7.setText("Quản lý năm học");
            option8.setVisible(true);
            option8.setText("Quản lý khối thi");
            option9.setVisible(true);
            option9.setText("Quản lý môn học");
        } else if (role.equals("HocSinh")) {
            option1.setVisible(true);
            option1.setText("Thông tin cá nhân");
            option2.setVisible(true);
            option2.setText("Bảng điểm cá nhân");
        } else {
            option1.setVisible(true);
            option1.setText("Thông tin cá nhân");
            option2.setVisible(true);
            option2.setText("Quản lý điểm");
        }

    }
}
