package JTextAreaExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaExample implements ActionListener {

    JTextArea text;

    public static void main(String[] args) {
        JTextAreaExample gui = new JTextAreaExample();
        gui.go();

    }

    private void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton button = new JButton("Just click me");

        button.addActionListener(this); //добавляем слушателя this к кнопке
        text = new JTextArea(10,20); // компонент с 10 стоками и 20 столбцами
        text.setLineWrap(true); // включаем перенос текста

        JScrollPane scroller  = new JScrollPane(text);
        /*
        Указываем панель прокрутки использовать только вертикальную полосу
         */
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        /*
        Важно! Присваеиваем объекту  JScrollPane текстовую область( с помощью конструктора JScrollPane).
        А затем добавляем область прокрутки на панель. Мы не добавляем мекстовуб область непосредственно на панель!
         */
        panel.add(scroller); //


        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(300,300);
        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        text.append("button clicked \n");
    }


}
