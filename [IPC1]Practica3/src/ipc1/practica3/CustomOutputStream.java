/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica3;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author 201612174 <Alberto Gabriel Reyes Ning>
 */
public class CustomOutputStream extends OutputStream {

    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char) b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
