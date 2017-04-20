package Main;

import java.io.IOException;

import static InitializationGame.Initialization.windowInitialization;
import static Menu.ConsoleMenu.windowMenu;
import static PaneLocalMatch.ConsoleLocMatch.windowLocMch;

public class AzironLauncher implements AzironGameLauncher {
    public static byte paneTrigger = 0; //0 - menu; 1 - locMch;
    //14 методов:
    public static void main(String[] args) throws IOException {
        windowInitialization();
            windowMenu();
            
        }



























    }

