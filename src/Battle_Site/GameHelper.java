package Battle_Site;
import java.io.*;
import java.util.*;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase(Locale.ROOT);
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize]; //Хранит координаты типа f6
        String temp = null; // Временная строка для конкатенации
        int[] coords = new int[comSize];//координаты текущего сайта
        int attempts = 0;//счетчик текущих попыток
        boolean success = false;//нашли подходящее местоположение?
        int location = 0;//текущее начальное местоположение

        comCount++;// энный сайт для размещения
        int incr = 1; //устанавливаем горизонтальный инкремент
        if ((comCount % 2) == 1) {// если нечетный (размещаем вертикально)
            incr = gridLength;// устанавливаем вертикальный инкремент
        }

        while (!success & attempts++ < 200) { //главный поисковый цикл
            location = (int) (Math.random() * gridSize); //получаем стартовую точку
            int x = 0; //Энная позиция на сайте который нужно разместить
            success = true; //предполагаем успешный исход
            while (success && x < comSize) {//ищем соседнюю неиспользованную ячейку
                if (grid[location] == 0) { //если не используется
                    coords[x++] = location; //сохраняем местоположение
                    location += incr; // пробуем следующую соседнюю ячейку
                    if (location >= gridSize) {// вышли за рамки - ни
                        success = false; //неудача
                    }
                    if (x > 0 && (location % gridLength == 0)) {// вышли за рамки - правый край
                        success = false;//неудача
                    }
                } else {//ашли уже использующееся местоположение
                    //System.out.println("Используется " + location);
                    success = false;//неудача
                }
            }
        }// Конец while

        int y = 0; //переводим местоположение в символьные координаты
        int row = 0;
        int column = 0;
        while (y < comSize) {
            grid[coords[y]] = 1;// помечаем ячейки на главной сетке как использованные
            row = (int) (coords[y] / gridLength);// получаем значение строки
            column = coords[y] % gridLength; //получаем числовое значение столбца
            temp = String.valueOf(alphabet.charAt(column));//преобразуем его в строковый символ
            alphaCells.add(temp.concat(Integer.toString(row)));
            y++;
            //System.out.println(" coord " + y + " =" + alphaCells.get(y - 1));// это выражение говорит о том где именно находится сайт
        }
        //System.out.println(" \n");
        return alphaCells;
    }
}

