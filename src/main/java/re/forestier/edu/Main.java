package re.forestier.edu;
import re.forestier.edu.rpg.Archer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Archer firstPlayer = new Archer("Florian", "Ruzberg de Rivehaute", 200, new ArrayList<>(), 50);
        firstPlayer.addMoney(400);
        firstPlayer.addXp(firstPlayer, 15);

        System.out.println(firstPlayer.toString());

        //System.out.println("--------------partie cool----------");
        //System.out.println(Affichage.afficherJoueur(firstPlayer));
        //System.out.println("--------------Fin du partie cool----------");

        System.out.println("------------------");
        firstPlayer.addXp(firstPlayer, 20);
        System.out.println(firstPlayer.toString());
        //System.out.println(Affichage.afficherJoueur(firstPlayer));
    }
}