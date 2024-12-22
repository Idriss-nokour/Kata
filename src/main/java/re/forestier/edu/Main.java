package re.forestier.edu;
import re.forestier.edu.rpg.Archer;
import re.forestier.edu.rpg.InventoryObjet;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Archer firstPlayer = new Archer("Florian", "Ruzberg de Rivehaute", 200, new ArrayList<>(), 50);

        InventoryObjet item1 = new InventoryObjet("Scroll of Stupidity", "INT-2 when applied to an enemy", 10, 10);  // Poids = 30
        InventoryObjet item2 = new InventoryObjet("Rune Staff of Curse", "May burn your enemies... Or yourself. Who knows?", 25, 5);

        // Ajouter les objets à l'inventaire
        firstPlayer.addInventory(item1);
        firstPlayer.addInventory(item2);

        // Ajouter de l'argent et de l'XP
        firstPlayer.addMoney(400);
        firstPlayer.addXp(15);

        firstPlayer.addXp(20);

        // Affichage en Markdown
        System.out.println(firstPlayer.toMarkdown());
        //System.out.println(firstPlayer.toString());
    }

}
