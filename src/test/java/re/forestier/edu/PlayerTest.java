package re.forestier.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.Archer;
import re.forestier.edu.rpg.Dwarf;
import re.forestier.edu.rpg.Player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.Archer;
import re.forestier.edu.rpg.Dwarf;
import re.forestier.edu.rpg.Player;

import static java.lang.Integer.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import re.forestier.edu.rpg.InventoryObjet;  // Ajoute cette ligne
import java.util.ArrayList;



public class PlayerTest {


    

    @Test
    public void testRetrieveLevelStandard() {

        Player p = new Archer("Florian", "Grognak le barbare", 10, new ArrayList<InventoryObjet>(),60);

        p.addXp(p, 10);  // XP = 10
    
        assertEquals(2, p.retrieveLevel());  // XP est inférieur à 27, donc le niveau devrait être 2
    }
    
    @Test
    public void testRetrieveLevelHigherThan5() {

        Player p = new Adventurer("Florian", "Grognak le barbare", 10, new ArrayList<InventoryObjet>(), 50);
        p.addXp(p, 150);  // XP = 150
    
        assertEquals(5, p.retrieveLevel());  // XP supérieur à 111, donc le niveau devrait être 5
    }
    

}
