package FinalProjekt.chapters;

import java.awt.*;
import java.util.Hashtable;

import FinalProjekt.GUI.MainGUI;
import FinalProjekt.chapterTexts.ChapterTexts;
import FinalProjekt.item_stuff.*;
import FinalProjekt.riddles.*;
import javafx.scene.paint.Color;

public abstract class Chapter1 {

    private static int countInsideChapter = 0;
    public static boolean chapterSolved = false;

    public static void start() {
        if (countInsideChapter == 0) {
            MainGUI.setBackgroundImageNum(2);
            MainGUI.setTypingText(ChapterTexts.chapter1part1, Color.RED);
            countInsideChapter++;
        } else if (countInsideChapter == 1) {
            MainGUI.setBackgroundImageNum(4);
            MainGUI.setKeyboardImageNumber(1);
            MainGUI.setTypingText(ChapterTexts.chapter1part2 , Color.BLACK);
            countInsideChapter++;
        } else if (countInsideChapter == 2) {
            MainGUI.setTypingText("Wenn ihr mich umdreht, bin ich genau das Gegenteil von dem, was ich war. Wer bin ich? (Verwende das Symbol oben rechts, um eine Antwort einzugeben)", Color.BLACK);
            countInsideChapter++;
        } else if (countInsideChapter == 3) {
            if (MainGUI.textField.getText().equals("6") || MainGUI.textField.getText().equals("9")) {
                MainGUI.setTypingText("Richtig", Color.BLACK);
                MainGUI.textField.setVisible(false);
                countInsideChapter++;
                chapterSolved = true;
                MainGUI.setKeyboardImageNumber(0);
                Story.countChapter++;
            } else {
                MainGUI.setTypingText("Falsch", Color.BLACK);
                countInsideChapter = 2;
            }
        }
    }
}
