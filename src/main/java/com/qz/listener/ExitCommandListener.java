package com.qz.listener;

import com.qz.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2018/4/23.
 */
public class ExitCommandListener implements ActionListener {

    String exitCommand = "quit";

    public void actionPerformed(ActionEvent e) {
        final String res = CommandListener.getNetTelnet().sendCommand(exitCommand);
        System.out.println(res);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CommandListener.getNetTelnet().disconnect();
                MainFrame.mainFrame.removeAll();
                System.exit(0);
            }
        });
    }
}
