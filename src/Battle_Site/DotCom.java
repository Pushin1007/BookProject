package Battle_Site;


import java.util.ArrayList;

public class DotCom {
    // Переменные класса DotCom
    private ArrayList<String> locationCells; //ArrayList с ячейками описывающими месторасположение
    private String name;// имя сайта

    public void setLocationCells(ArrayList<String> loc) {
        // сеттер который обновляет месторасположение сайта(случайный адрес предоставляемый методом
        //placeDotCom() из класса GameHelper).
        locationCells = loc;
    }

    public void setName(String name) { // простой сеттер
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);//Метод indexOf  из ArrayList в действии! Если ход
        // пользователя совпал с одним из элементов ArrayList, то метод вернет его месторасположение. Если нет то indexOf вернет -1
        if (index >= 0) {
            locationCells.remove(index);// Применяем метод remove() из ArrayList для удаления элемента
            if (locationCells.isEmpty()) {
                //Используем метод isEmpty(), чтобы проверить все ли адреса были разгаданы
                result = "Потопил";
                System.out.println("Ой! Вы потопили " + name + "  : (  ");
            } else {
                result = "Попал";
            }

        }
        return result;
    }
}