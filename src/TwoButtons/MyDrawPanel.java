package TwoButtons;
import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {// метод панели вызывается при каждом нажитии кнопки
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);

        GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);
        g2d.setPaint(gradient);//назначаем виртуальной кисти градиет вместо сплошного цвета
        g2d.fillOval(70,70,100,100);// метод позволяет закрасить овал тем что  находится на кисти
    }

}