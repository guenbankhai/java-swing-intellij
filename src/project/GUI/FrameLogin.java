/*
 * Created by JFormDesigner on Thu Jun 20 15:27:16 ICT 2024
 */

package project.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class FrameLogin extends JFrame {
    private boolean showPass = false;

    public FrameLogin() {
        initComponents();
    }

    private void logoPasswordMouseClicked(MouseEvent e) {
        if(showPass) {
            txtPassword.setEchoChar((char)0);
            logoPassword.setIcon(new ImageIcon(getClass().getResource("/img/icon/icon-eye.png")));
            showPass = false;
        }
        else {
            txtPassword.setEchoChar((char)8226);
            logoPassword.setIcon(new ImageIcon(getClass().getResource("/img/icon/icon-hide.png")));
            showPass = true;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - guenbankhai
        pnLeft = new JPanel();
        pnIntroduction = new JPanel();
        lblLogo = new JLabel();
        lblType = new JLabel();
        lblLevel = new JLabel();
        lblCredit = new JLabel();
        pnRight = new JPanel();
        pnForm = new JPanel();
        lblTitle = new JLabel();
        lblUsername = new JLabel();
        logoUsername = new JLabel();
        txtUsername = new JTextField();
        pnLine1 = new JPanel();
        lblPassword = new JLabel();
        logoPassword = new JLabel();
        pnLine2 = new JPanel();
        cbxRemember = new JCheckBox();
        btnLogin = new JButton();
        txtPassword = new JPasswordField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== pnLeft ========
        {
            pnLeft.setBackground(Color.white);
            pnLeft.setMaximumSize(new Dimension(400, 65769));
            pnLeft.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,pnLeft. getBorder( )) ); pnLeft. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //======== pnIntroduction ========
            {
                pnIntroduction.setBackground(Color.white);
                pnIntroduction.setPreferredSize(new Dimension(200, 269));

                //---- lblLogo ----
                lblLogo.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));

                //---- lblType ----
                lblType.setText("QU\u1ea2N L\u00dd \u0110I\u1ec2M");
                lblType.setFont(new Font("Segoe UI", Font.BOLD, 26));
                lblType.setHorizontalAlignment(SwingConstants.CENTER);

                //---- lblLevel ----
                lblLevel.setText("TRUNG H\u1eccC PH\u1ed4 TH\u00d4NG");
                lblLevel.setFont(new Font("Segoe UI", Font.BOLD, 16));
                lblLevel.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout pnIntroductionLayout = new GroupLayout(pnIntroduction);
                pnIntroduction.setLayout(pnIntroductionLayout);
                pnIntroductionLayout.setHorizontalGroup(
                    pnIntroductionLayout.createParallelGroup()
                        .addComponent(lblLogo)
                        .addComponent(lblType, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                );
                pnIntroductionLayout.setVerticalGroup(
                    pnIntroductionLayout.createParallelGroup()
                        .addGroup(pnIntroductionLayout.createSequentialGroup()
                            .addComponent(lblLogo)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblType)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblLevel)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            //---- lblCredit ----
            lblCredit.setText("Make by GuenBanKhai");
            lblCredit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
            lblCredit.setForeground(Color.lightGray);
            lblCredit.setBackground(Color.black);

            GroupLayout pnLeftLayout = new GroupLayout(pnLeft);
            pnLeft.setLayout(pnLeftLayout);
            pnLeftLayout.setHorizontalGroup(
                pnLeftLayout.createParallelGroup()
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addGroup(pnLeftLayout.createParallelGroup()
                            .addComponent(pnIntroduction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCredit, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))
            );
            pnLeftLayout.setVerticalGroup(
                pnLeftLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, pnLeftLayout.createSequentialGroup()
                        .addContainerGap(130, Short.MAX_VALUE)
                        .addComponent(pnIntroduction, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(lblCredit)
                        .addContainerGap())
            );
        }

        //======== pnRight ========
        {
            pnRight.setBackground(new Color(0xff9966));

            //======== pnForm ========
            {
                pnForm.setMaximumSize(new Dimension(400, 32767));
                pnForm.setBackground(new Color(0xff9966));
                pnForm.setPreferredSize(new Dimension(298, 300));

                //---- lblTitle ----
                lblTitle.setText("\u0110\u0102NG NH\u1eacP");
                lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
                lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
                lblTitle.setForeground(Color.white);

                //---- lblUsername ----
                lblUsername.setText("T\u00ean \u0111\u0103ng nh\u1eadp:");
                lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 16));
                lblUsername.setForeground(Color.white);

                //---- logoUsername ----
                logoUsername.setPreferredSize(new Dimension(30, 30));
                logoUsername.setBackground(new Color(0xff9966));
                logoUsername.setOpaque(true);
                logoUsername.setIcon(new ImageIcon(getClass().getResource("/img/icon/icon-user.png")));

                //---- txtUsername ----
                txtUsername.setBorder(null);
                txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                txtUsername.setOpaque(true);
                txtUsername.setBackground(new Color(0xff9966));
                txtUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                txtUsername.setForeground(Color.white);
                txtUsername.setCaretColor(Color.white);

                //======== pnLine1 ========
                {
                    pnLine1.setPreferredSize(new Dimension(298, 1));

                    GroupLayout pnLine1Layout = new GroupLayout(pnLine1);
                    pnLine1.setLayout(pnLine1Layout);
                    pnLine1Layout.setHorizontalGroup(
                        pnLine1Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    pnLine1Layout.setVerticalGroup(
                        pnLine1Layout.createParallelGroup()
                            .addGap(0, 1, Short.MAX_VALUE)
                    );
                }

                //---- lblPassword ----
                lblPassword.setText("M\u1eadt kh\u1ea9u:");
                lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
                lblPassword.setForeground(Color.white);

                //---- logoPassword ----
                logoPassword.setPreferredSize(new Dimension(30, 30));
                logoPassword.setBackground(new Color(0xff9966));
                logoPassword.setOpaque(true);
                logoPassword.setIcon(new ImageIcon(getClass().getResource("/img/icon/icon-hide.png")));
                logoPassword.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        logoPasswordMouseClicked(e);
                    }
                });

                //======== pnLine2 ========
                {
                    pnLine2.setPreferredSize(new Dimension(298, 1));

                    GroupLayout pnLine2Layout = new GroupLayout(pnLine2);
                    pnLine2.setLayout(pnLine2Layout);
                    pnLine2Layout.setHorizontalGroup(
                        pnLine2Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    pnLine2Layout.setVerticalGroup(
                        pnLine2Layout.createParallelGroup()
                            .addGap(0, 1, Short.MAX_VALUE)
                    );
                }

                //---- cbxRemember ----
                cbxRemember.setText("Ghi nh\u1edb \u0111\u0103ng nh\u1eadp");
                cbxRemember.setFont(new Font("Segoe UI", Font.BOLD, 12));
                cbxRemember.setForeground(Color.white);
                cbxRemember.setBackground(new Color(0xff9966));
                cbxRemember.setBorder(null);
                cbxRemember.setFocusable(false);
                cbxRemember.setFocusPainted(false);

                //---- btnLogin ----
                btnLogin.setText("X\u00c1C NH\u1eacN");
                btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 18));
                btnLogin.setBorder(new LineBorder(Color.white, 5));
                btnLogin.setBackground(new Color(0xff9966));
                btnLogin.setForeground(Color.white);

                //---- txtPassword ----
                txtPassword.setForeground(Color.white);
                txtPassword.setBackground(new Color(0xff9966));
                txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                txtPassword.setBorder(null);
                txtPassword.setCaretColor(Color.white);

                GroupLayout pnFormLayout = new GroupLayout(pnForm);
                pnForm.setLayout(pnFormLayout);
                pnFormLayout.setHorizontalGroup(
                    pnFormLayout.createParallelGroup()
                        .addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, pnFormLayout.createSequentialGroup()
                            .addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(logoUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(pnLine1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(pnLine2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, pnFormLayout.createSequentialGroup()
                            .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(logoPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnFormLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnFormLayout.createParallelGroup()
                                .addComponent(cbxRemember, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.TRAILING, pnFormLayout.createSequentialGroup()
                                    .addGap(0, 83, Short.MAX_VALUE)
                                    .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 83, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                pnFormLayout.setVerticalGroup(
                    pnFormLayout.createParallelGroup()
                        .addGroup(pnFormLayout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblUsername)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(logoUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUsername))
                            .addGap(5, 5, 5)
                            .addComponent(pnLine1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblPassword)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(logoPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPassword))
                            .addGap(5, 5, 5)
                            .addComponent(pnLine2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxRemember)
                            .addGap(18, 18, 18)
                            .addComponent(btnLogin))
                );
            }

            GroupLayout pnRightLayout = new GroupLayout(pnRight);
            pnRight.setLayout(pnRightLayout);
            pnRightLayout.setHorizontalGroup(
                pnRightLayout.createParallelGroup()
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(pnForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(50, Short.MAX_VALUE))
            );
            pnRightLayout.setVerticalGroup(
                pnRightLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, pnRightLayout.createSequentialGroup()
                        .addContainerGap(95, Short.MAX_VALUE)
                        .addComponent(pnForm, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(95, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(pnLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)
                    .addComponent(pnRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(pnLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - guenbankhai
    private JPanel pnLeft;
    private JPanel pnIntroduction;
    private JLabel lblLogo;
    private JLabel lblType;
    private JLabel lblLevel;
    private JLabel lblCredit;
    private JPanel pnRight;
    private JPanel pnForm;
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JLabel logoUsername;
    private JTextField txtUsername;
    private JPanel pnLine1;
    private JLabel lblPassword;
    private JLabel logoPassword;
    private JPanel pnLine2;
    private JCheckBox cbxRemember;
    private JButton btnLogin;
    private JPasswordField txtPassword;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
