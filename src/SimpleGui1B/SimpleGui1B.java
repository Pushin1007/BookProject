package SimpleGui1B;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1B  implements ActionListener {
    JButton button;//создаем кнопку
    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }
    public void go(){
        JFrame frame = new JFrame(); //создаем фрейм
        button = new  JButton("Click me");
        button.addActionListener(this);
        frame.getContentPane().add(button); //добавляем кнопку на панель фрейма
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// эта строка завершает работу программы при закрытии окна. Если ее не добавить то она будет висеть вечно
        frame.setSize(300,300); //присваиваем фрейму размер в пикселях
        frame.setVisible(true);// делаем фрейм видимым
    }
    public  void actionPerformed(ActionEvent event){
        button.setText("I've been clicked");
    }






}
