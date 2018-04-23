package com.qz.listener;

import com.qz.LoginFrame;
import com.qz.MainFrame;
import com.qz.common.Config;
import com.qz.telnet.NetTelnet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2018/4/23.
 */
public class LoginListener implements ActionListener {


    public void actionPerformed(ActionEvent e) {
        String ip = LoginFrame.ipField.getText();
        Integer port = Integer.parseInt(LoginFrame.portField.getText());
        String username = LoginFrame.usernameField.getText();
        String password = LoginFrame.passwordField.getText();
        Config.setIp(ip);
        Config.setUsername(username);
        Config.setPassword(password);
        Config.setPort(port);

        try {
            NetTelnet telnet = new NetTelnet(Config.getIp(), Config.getPort(), Config.getUsername(), Config.getPassword());
            CommandListener.setNetTelnet(telnet);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    LoginFrame.loginFrame.dispose();
                    MainFrame.mainFrame = new MainFrame();
                }
            });
        } catch (Exception ex) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "连接失败", "警告", JOptionPane.ERROR_MESSAGE);
                }
            });

        }

    }

}
