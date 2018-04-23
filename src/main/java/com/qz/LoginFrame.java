package com.qz;

import com.qz.listener.LoginListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2018/4/23.
 */
public class LoginFrame extends JFrame {

    private JPanel titlePanel = new JPanel();
    private JLabel titleLabel = new JLabel("telnet管理");

    private JPanel ipPanel = new JPanel();
    private JLabel ipLabel = new JLabel("ip：");
    public static JTextField ipField = new JTextField(10);

    private JPanel portPanel = new JPanel();
    private JLabel portLabel = new JLabel("port：");
    public static JTextField portField = new JTextField("23",10);

    private JPanel usernamePanel = new JPanel();
    private JLabel usernameLabel = new JLabel("username：");
    public static JTextField usernameField = new JTextField(10);

    private JPanel passwordPanel = new JPanel();
    private JLabel passwordLabel = new JLabel("password：");
    public static JPasswordField passwordField = new JPasswordField(10);

    private JPanel loginPanel = new JPanel();
    private JButton loginButton = new JButton("登录");


    public LoginFrame() {

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 1));
        setLocationRelativeTo(null);

        titlePanel.add(titleLabel);
        // 标题
        add(titlePanel);

        // ip框
        ipPanel.add(ipLabel);
        ipPanel.add(ipField);
        add(ipPanel);

        // port框
        portPanel.add(portLabel);
        portPanel.add(portField);
        add(portPanel);

        // 用户名框
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        add(usernamePanel);

        // 密码框
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        add(passwordPanel);

        // 登录按钮
        loginButton.addActionListener(new LoginListener());
        loginPanel.add(loginButton);
        add(loginButton);

        setVisible(true);
    }

    public static LoginFrame loginFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                loginFrame = new LoginFrame();
            }
        });
    }
}
