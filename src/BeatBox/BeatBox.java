package BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public void buildGUI() {
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));// Пустая граница позволяет создать поля между краями панели для размещения компонентов

        checkboxlist = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        start.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        start.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        start.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);


        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentName[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);
/*
Создаем флажки, присваеиваем им значения false (чтобы они были пустые), а затем жлбавляем из в массив ArrayList и на панель
 */
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxlist.add(c);
            mainPanel.add(c);

            setUpMidi();

            theFrame.setBounds(50, 50, 300, 300);
            theFrame.pack();
            theFrame.setVisible(true);
        }
    }

    public void setUpMidi() {
        /*
        Обычный Midi код для получения синтезатора, секвенсора и дорожки
         */
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Вот здесь мы преобразуем состояния флажков в Midi события и добавляем их на дорожку
     */
    public void buildTrackAndStert() {
        int[] trackList = null; //Создаем массив из 16 элементов чтобы хранить значения для каждого инструмента на  все 16 тактов

        sequence.deleteTrack(track);// избавляемся от старой дорожки
        track = sequence.createTrack(); // создаем новую дорожку

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            int key = instruments[i];

            for (int j = 0; j < 16; j++) {

                JCheckBox jc = (JCheckBox) checkboxlist.get(j + (16 * 1));

                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            } // Закрываем внутренний цикл
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }// Закрываем внешний цикл

    }

    public class MyStartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
