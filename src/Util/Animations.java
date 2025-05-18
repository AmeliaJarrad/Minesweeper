package Util;

public class Animations {

public static void playWinAnimation() {
    String winMessage = "!!! Congratulations! You Won! !!!";
    String[] colors = {
        Colours.GREEN, Colours.CYAN, Colours.YELLOW, Colours.PURPLE, Colours.BRIGHT_RED
    };

    try {
        for (int i = 0; i < 6; i++) {
            String color = colors[i % colors.length];
            System.out.print(color + winMessage + Colours.RESET + "\r");
            Thread.sleep(300);
            System.out.print(" ".repeat(winMessage.length()) + "\r");
            Thread.sleep(300);
        }
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // Preserve interrupt status
        System.out.println("Interrupted during animation.");
    }

    System.out.println(Colours.GREEN + winMessage + Colours.RESET);
    }   

    public static void playGameOverAnimation() {
        String message = "!!! BOOM! Bad Luck! Game Over! !!!";

        try {
            for (int i = 0; i < 6; i++) {
                System.out.print(Colours.RED + message + Colours.RESET + "\r");
                Thread.sleep(300);
                System.out.print(" ".repeat(message.length()) + "\r");
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted during game over animation.");
        }

        System.out.println(Colours.RED + message + Colours.RESET);
    }
}
