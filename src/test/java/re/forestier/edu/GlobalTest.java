package re.forestier.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.InventoryObjet;
import re.forestier.edu.rpg.Player;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

public class GlobalTest {

    @Test
    public void testToMarkdown() {
        ArrayList<InventoryObjet> inventory = new ArrayList<>();
        Player player = new Adventurer("Florian", "Ruzberg", 200, inventory, 50);

        player.addMoney(100);
        player.addInventory(new InventoryObjet("Holy Elixir", "Recovers 1 HP", 2, 50));

        // Ajout de capacités pour tester
        player.abilities.put("ATK", 5);
        player.abilities.put("DEF", 3);


        String markdown = player.toMarkdown();


        assertTrue(markdown.contains("# Joueur Ruzberg joué par Florian"));

        assertTrue(markdown.contains("**Niveau :** 1 (**XP totale :** 0)"));

        assertTrue(markdown.contains("* **ATK** : 5"));
        assertTrue(markdown.contains("* **DEF** : 3"));

        assertTrue(markdown.contains("Liste des objets :"));
        assertTrue(markdown.contains("* Holy Elixir"));
    }

    @Test
    public void testToMarkdownEmptyInventory() {
        ArrayList<InventoryObjet> inventory = new ArrayList<>();
        Player player = new Adventurer("Florian", "Ruzberg", 200, inventory, 50);

        String markdown = player.toMarkdown();

        assertTrue(markdown.contains("Aucun objet dans l'inventaire."));
    }

    @Test
    @DisplayName("test de la méthode toString")
    void testToString() {
        Player p = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<InventoryObjet>(), 60);
        p.addXp(50); // Ajout d'XP pour augmenter le niveau

        // Accès direct à l'inventaire et aux capacités
        p.abilities.put("Attaque", 5);
        p.abilities.put("Défense", 3);


        // Création des objets InventoryObjet
        InventoryObjet epee = new InventoryObjet("Épée", "Une épée tranchante", 1, 50);
        InventoryObjet bouclier = new InventoryObjet("Bouclier", "Bouclier solide", 1, 100);

        // Ajout des objets dans l'inventaire du joueur
        p.inventory.add(epee);
        p.inventory.add(bouclier);

        // Récupération de la chaîne renvoyée par toString
        String result = p.toString();

        // Vérification que la chaîne contient les bonnes informations
        assertThat(result, containsString("Joueur Grognak le barbare joué par Florian"));
        assertThat(result, containsString("Niveau : 3 (XP totale : 50)"));
        assertThat(result, containsString("Capacités :"));
        assertThat(result, containsString("   Attaque : 5"));
        assertThat(result, containsString("   Défense : 3"));
        assertThat(result, containsString("Inventaire :"));
        assertThat(result, containsString("   Épée"));
        assertThat(result, containsString("   Bouclier"));
    }


}
