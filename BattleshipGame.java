import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleshipGame {

    public static void main(String[] args) {
        boolean playAgain;
        do {
            Ocean ocean = new Ocean();
            ocean.placeAllShipsRandomly();
            ocean.debugPrint();

            Scanner scanner = new Scanner(System.in);

            while (!ocean.isGameOver()) {
                ocean.print();
                System.out.print("Enter row and column (e.g., 3 5): ");
                try {
                    if (!scanner.hasNextInt()) {
                        System.out.println("No more input. Ending game...");
                        break;
                    }
                    int row = scanner.nextInt();

                    if (!scanner.hasNextInt()) {
                        System.out.println("No more input. Ending game...");
                        break;
                    }
                    int col = scanner.nextInt();


                    boolean hit = ocean.shootAt(row, col);
                    if (hit) {
                        Ship s = ocean.getShipArray()[row][col];
                        if (s.isSunk()) {
                            System.out.println("You just sunk a " + s.getShipType());
                        } else {
                            System.out.println("hit");
                        }
                    } else {
                        System.out.println("miss");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter integers for row and column.");
                    scanner.nextLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid coordinates. Please enter values between 0 and 9.");
                }
            }


            ocean.print();
            System.out.println("Game over. You required " + ocean.getShotsFired() + " shots.");

            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");

        } while (playAgain);
    }
}
