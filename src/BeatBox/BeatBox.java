package BeatBox;

import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.*;
import java.util.ArrayList;

public class BeatBox {
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxlist; // Мы храним флажки в массиве  ArrayList
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;

    /*
    Это названия инструментов в виде строкового массива, предназназнченные
    для создания меток в пользовательском интерфейсе(на каждый ряд)
     */
    String[] instrumentName = {"Bass drum", "Closed Hi-Hat", "Open Hi-Hat", "Acustic Snare", "Crash Cymbal",
            "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom",
            "High Agolo", "Open Hi Conga"};
    /*
    Эти числа представляют собой фактические барабанные клавиши.
    Канал барабана - это что-то вроде пиаино, где каждая клавиша на нем - отдельный барабан.
    Номер 35 - это клавиша для  Bass drum,а 42 -Closed Hi-Hat  и т.д.
     */
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }
    public void buildGUI(){

    }


}
