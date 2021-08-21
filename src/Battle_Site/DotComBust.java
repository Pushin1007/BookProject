package Battle_Site;
import java.util.*;

public class DotComBust {
    // О
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>(); //Create ArrayList for DotCom objects only
    private int numOfGuesses = 0;

    private void setUpGame() {
        //Create three objects DotCom and give them names and put them into ArrayList
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        //display brief instructions for the user//Выводим краткие инструкции для пользователя
        System.out.println("Ваша цель - потопить 3 сайта");
        System.out.println("Pets.com, eToys.com,Go2.com");
        System.out.println("Потытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComToSet : dotComList) {// Повторяем с каждым объектом DotCom в списке
            ArrayList<String> newLocation = helper.placeDotCom(3);//Запрашиваем у вспомогательного объекта адрес "сайта"
            dotComToSet.setLocationCells(newLocation); // Вызываем сеттре из объекта DotCom чтобы передать ему
            // местоположение которое только что получилии от вспомогательного объекта
        }
    }

    private void startPlaing() {
        while (!dotComList.isEmpty()) { //До тех пор пока список объектов не станет пустым
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame(); //Вызываем метод  finishGame
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++; //Инкрементируем количество попыток которые сделал пользователь
        String result = "Мимо"; //подразумеваем промах пока не доказали обратного
        for (DotCom dotComToTest : dotComList) {//ППовторяем с каждым объектом DotCom в списке
            result = dotComToTest.checkYourself(userGuess); //Просим проверит ход пользователя, ищем опадание или потопление
            if (result.equals("Попал")) {
                break;// Выбираемся из цикла раньше времени. Нет смысла проверять другие сайты
            }
            if (result.equals("Потопил")) {
                dotComList.remove(dotComToTest);// Ему пришел конец, так что удаляем его из списка сайто и выходим из цикла
                break;
            }
        }
        System.out.println(result);//Выводим для пользователя результат
    }

    private void finishGame() { //Выводим сообщение о том как пользователь прошел игру
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничео не стоят");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у Вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули");
        } else {
            System.out.println("Это заняло у Вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг Ваших вложений");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust(); //Создаем игровой объект
        game.setUpGame(); //Говорим игровому объекту подготовить игру
        game.startPlaing(); //Говорим игровому объекту начать главный игровой цикл (продолжаем запрашивать пользовательский ввод и проверять полученные данные)
    }
}

