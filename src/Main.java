import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.XMLFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Создание викторины!\nВведите название викторины:");
        String name = scan.nextLine();
        game g = new game(name);
        g.creatre_game();
        g.start_game();




    }
}