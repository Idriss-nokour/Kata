package re.forestier.edu;

import org.junit.jupiter.api.Test;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.InventoryObjet; 

import java.util.ArrayList;

import static org.approvaltests.Approvals.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

public class GlobalTest {

    @Test
    void testAffichageBase() {
Adventurer player = new Adventurer("Florian", "Gnognak le Barbare", 200, new ArrayList<InventoryObjet>(), 50);
        player.addXp(player, 20);
        player.inventory = new ArrayList<>();

       // verify(Affichage.afficherJoueur(player));
    }
}
