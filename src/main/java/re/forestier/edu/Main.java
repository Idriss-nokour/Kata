package re.forestier.edu;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.Affichage;
import re.forestier.edu.rpg.player;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Adventurer firstPlayer = new Adventurer("Florian", "Ruzberg de Rivehaute", 200, new ArrayList<>());
        firstPlayer.addMoney(400);
        firstPlayer.addXp(firstPlayer, 15);
        System.out.println(Affichage.afficherJoueur(firstPlayer));
        System.out.println("------------------");
        firstPlayer.addXp(firstPlayer, 20);
        System.out.println(Affichage.afficherJoueur(firstPlayer));
    }
}