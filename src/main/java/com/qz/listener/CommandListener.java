package com.qz.listener;

import com.qz.MainFrame;
import com.qz.telnet.NetTelnet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/23.
 */
public class CommandListener implements ActionListener {
    public static Map<String, String> commandMap = new HashMap<String, String>();
    public static NetTelnet netTelnet;

    static {
        commandMap.put("显示设备版本", "display version");
        commandMap.put("显示延迟", "display timeout");
        commandMap.put("显示系统信息", "display sysinfo");
        commandMap.put("显示mac地址", "display macaddress");
        commandMap.put("设备自检", "get testself");
        commandMap.put("获取mac老化时间", "get mac agingtime");
        commandMap.put("查询光功率", "display optic");
        commandMap.put("查看SN", "display sn");
    }


    public static Map<String, String> getCommandMap() {
        return commandMap;
    }

    public static Integer getCommandSize() {
        return commandMap.size();
    }

    public static void setCommandMap(Map<String, String> commandMap) {
        CommandListener.commandMap = commandMap;
    }

    public static NetTelnet getNetTelnet() {
        return netTelnet;
    }

    public static void setNetTelnet(NetTelnet netTelnet) {
        CommandListener.netTelnet = netTelnet;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = ((JButton) e.getSource());
        String buttonName = clickedButton.getText();
        final String command = commandMap.get(buttonName);
        try {
            final String res = netTelnet.sendCommand(command);
            checkSupport(res);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MainFrame.consoleTextArea.setText(res);
                }
            });
        } catch (final Exception ex) {
            ex.printStackTrace();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
                }
            });

        }


    }

    private void checkSupport(String res) {
        if (res.contains("command not found")) {
            throw new RuntimeException("该设备不支持此命令");
        }
    }
}
