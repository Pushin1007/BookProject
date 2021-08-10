package TwoButtons;

import SimpleGui3C.SimpleGui3C;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons  {// В данный момент класс GUI не реализует интерфейс ActionListener

    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener()); //передаем  экземпляр соответствующего класса слушателя

        JButton colorButton = new JButton("Change Color");
        colorButton.addActionListener(new ColorListener()); //передаем  экземпляр соответствующего класса слушателя

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();


        frame.getContentPane().add(BorderLayout.SOUTH , colorButton); //Добавляем виджет кнопки  в область  SOUTH фрейма
        frame.getContentPane().add(BorderLayout.CENTER , drawPanel);  //Добавляем виджет  панели для рисования  в область  SOUTH фрейма
        frame.getContentPane().add(BorderLayout.EAST , labelButton);
        frame.getContentPane().add(BorderLayout.WEST , label);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    // теперь у нас будут два ActionListener в одном классе
    class LabelListener implements ActionListener { //Внутренний класс знает о label
        public void actionPerformed(ActionEvent event) {
            label.setText("Ouch!");

        }
    }
    class ColorListener implements ActionListener { //Внутренний класс использует переменную экземпляра без явной ссылки на обьект внешнего класса
        public void actionPerformed(ActionEvent event) {
            frame.repaint();

        }
    }

}

