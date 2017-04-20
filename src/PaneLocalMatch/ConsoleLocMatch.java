package PaneLocalMatch;

import java.io.IOException;

public class ConsoleLocMatch {
    public static void windowLocMch() throws IOException {
        System.out.println(
                "/////////////////////////////////////////////\n" +
                        "//                                         //\n" +
                        "//                                         //\n" +
                        "//            Локальный матч               //\n" +
                        "//                                         //\n" +
                        "// 1. Игра на двоих;                       //\n" +
                        "// 2. Назад;                               //\n" +
                        "//                                         //\n" +
                        "//                                         //\n" +
                        "//                                         //\n" +
                        "//                                         //\n" +
                        "//                                         //\n" +
                        "//                                         //\n" +
                        "//                                         //\n" +
                        "//          Цифра указывает кнопку         //\n" +
                        "/////////////////////////////////////////////");
        char ch;
        int code;
        while (-1 != (code = System.in.read())) {
            ch = (char) code;
            if ('1' == ch) {
                //InitializationGame
            }
            if ('2' == ch) {
            }
        }
    }
}
