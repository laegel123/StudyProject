package com.example.designpattern.observer.example2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {
    JFrame jFrame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        jFrame = new JFrame();

        JButton button = new JButton("할까? 말까?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
    }

    class AngelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("안돼. 하지마");
        }
    }

    class DevilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("저질러버려!");
        }
    }



}
