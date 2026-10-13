package Services.UIServices.Renderer;

import Services.UIServices.ConsoleFormater;

public class MainMenu {
    // Color references from ConsoleFormater
    static String reset  = ConsoleFormater.COLOR_RESET;
    static String frame  = ConsoleFormater.COLOR_DARK_GREY;

    static String depthMain   = ConsoleFormater.COLOR_BRIGHT_CYAN;
    static String depthShadow = ConsoleFormater.COLOR_CYAN;

    static String nColor      = ConsoleFormater.COLOR_BRIGHT_YELLOW;

    static String dangerMain   = ConsoleFormater.COLOR_BRIGHT_RED;
    static String dangerShadow = ConsoleFormater.COLOR_DARK_RED;

    public static void RenderGameTitle() {
                // Frame Top
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
        System.out.println(frame + "    +============================================================+" + reset);

        // "DEPTH" (31 chars wide)
        System.out.println(depthMain   + "                    ____  _____ ____  _____ _   _ " + reset);
        System.out.println(depthMain   + "                   |  _ \\| ____|  _ \\|_   _| | | |" + reset);
        System.out.println(depthMain   + "                   | | | |  _| | |_) | | | | |_| |" + reset);
        System.out.println(depthShadow + "                   | |_| | |___|  __/  | | |  _  |" + reset);
        System.out.println(depthShadow + "                   |____/|_____|_|     |_| |_| |_|" + reset);
        // "n'"
        System.out.println();
        System.out.println(nColor + "                            -=-   n'   -=-" + reset);
        // "DANGER"
        System.out.println(dangerMain   + "               ____    / \\    _   _   ____  _____ ____ " + reset);
        System.out.println(dangerMain   + "              |  _ \\  / _ \\  | \\ | | / ___|| ____|  _ \\" + reset);
        System.out.println(dangerMain   + "              | | | |/ ___ \\ |  \\| || |  _ |  _| | |_) |" + reset);
        System.out.println(dangerShadow + "              | |_| / /   \\ \\| |\\  || |_| || |___|  _ < " + reset);
        System.out.println(dangerShadow + "              |____/_/     \\_\\_| \\_|\\_____||_____|_| \\_\\" + reset);

        // Frame Bottom
        System.out.println();
        System.out.println(frame + "    +============================================================+" + reset);
        System.out.println();
    }

    public static void RenderMenuOptions() {
        System.out.println("                     " + nColor + "-=-" + reset + "    " + depthMain + "(S)tart Game" + reset + "    " + nColor + "-=-" + reset);
        System.out.println("                     " + nColor + "-=-" + reset + "    " + depthShadow + "(L)oad Level" + reset + "    " + nColor + "-=-" + reset);
        System.out.println("                     " + nColor + "-=-" + reset + "    " + nColor + "(O)ptions" + reset + "       " + nColor + "-=-" + reset);
        System.out.println("                     " + nColor + "-=-" + reset + "    " + dangerMain + "(Q)uit" + reset + "          " + nColor + "-=-" + reset);
    }

    public static void RenderEnterLevelCode() {
        System.out.println("");
        System.out.print("                        Enter Level Code: ");
    }

    public static void RenderTryAgainLevelCode() {
        System.out.println("");
        System.out.println("                           Try Again?");
        System.out.println("                          (Y)es / (N)o");
    }
}
