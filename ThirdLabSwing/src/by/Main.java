package by;

/**
 * <h1>Second Lab</h1>
 * The Second lab implements an application that
 * realise task variant 9
 * @author Viachaslau Pratasenia
 * @version 1.0
 * @since 2018-03-20
 */

import by.graphicInterface.Gui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui();
            }
        });
    }
}

