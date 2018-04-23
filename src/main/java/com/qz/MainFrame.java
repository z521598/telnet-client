package com.qz;

import com.qz.listener.CommandListener;
import com.qz.listener.ExitCommandListener;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/23.
 */
public class MainFrame extends JFrame {

    private JPanel commandPanel = new JPanel();

    private JPanel consolePanel = new JPanel();
    public static JTextArea consoleTextArea = new JTextArea(25, 39);

    private JPanel exitPanel = new JPanel();
    private JButton exitButton = new JButton("退出");
    public static MainFrame mainFrame;

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setName("telnet管理中心");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // 命令区域
        commandPanel.setLayout(new GridLayout(3, 3));

        for (Map.Entry<String, String> button : CommandListener.getCommandMap().entrySet()) {
            String buttonName = button.getKey();
            JButton commandButton = new JButton(buttonName);
            commandButton.addActionListener(new CommandListener());
            commandPanel.add(commandButton);
        }
        add(commandPanel, BorderLayout.NORTH);
        // 控制台区域
        consolePanel.add(new JScrollPane(consoleTextArea), JFrame.CENTER_ALIGNMENT);
        add(consolePanel, BorderLayout.CENTER);


        exitButton.addActionListener(new ExitCommandListener());
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

}
