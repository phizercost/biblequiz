package com.phizercost.biblequiz.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Counter {
	int seconds = 100;
	public Counter(JFrame frame) {
		
        JPanel panel = new JPanel();
        final JLabel label = new JLabel();
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds--;
                int day = (int) TimeUnit.SECONDS.toDays(seconds);
                long hours = TimeUnit.SECONDS.toHours(seconds) - (day * 24);
                long minute = TimeUnit.SECONDS.toMinutes(seconds)
                        - (TimeUnit.SECONDS.toHours(seconds) * 60);
                long second = TimeUnit.SECONDS.toSeconds(seconds)
                        - (TimeUnit.SECONDS.toMinutes(seconds) * 60);
                label.setText(hours + " Hour(s), " + minute + " Minute(s) and "
                        + second + " Second(s)");
                if (seconds == 0) {
                	label.setText("done");
                }
            }
        });
        timer.start();
	}

}
