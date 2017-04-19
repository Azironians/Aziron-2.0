package Main;

import java.io.IOException;

import static InitializationGame.Initialization.windowInitialization;
import static Menu.ConsoleMenu.windowMenu;
import static PaneLocalMatch.ConsoleLocMatch.windowLocMch;

/**
 * Created by мсиайнина on 19.04.2017.
 */
public class AzironLauncher implements AzironGameLauncher {
    public static byte paneTrigger = 0; //0 - menu; 1 - locMch;
    //14 методов:
    public static void main(String[] args) throws IOException {
        windowInitialization();
        switch (paneTrigger){
            case 0:windowMenu();
            break;
            case 1: windowLocMch();
            break;
        }


        boolean inGame = true;
//        while (inGame){
//            while (paneTrigger == 0){
//
//            }
//
//        }


























    }



}
