package re.forestier.edu;


import java.util.HashMap;

import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.Archer;
import re.forestier.edu.rpg.Dwarf;
import re.forestier.edu.rpg.Player;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

public class UpdatePlayerTest {


    /*private static HashMap<String, HashMap<Integer, HashMap<String, Integer>>> abilitiesPerTypeAndLevelTest;

    @BeforeAll
    static void setUp(){
        abilitiesPerTypeAndLevelTest = UpdatePlayer.abilitiesPerTypeAndLevel();
        System.out.println("Abilities: " + abilitiesPerTypeAndLevelTest);
        assertNotNull(abilitiesPerTypeAndLevelTest);

    }*/

    @Test
    void testAbilitiesAdventurer() {

        Adventurer player = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>(), int );


        HashMap<Integer, HashMap<String, Integer>> adventurerTest = player.initializeAbilitiesAdventurer();
        assertNotNull(adventurerTest);

        HashMap<String, Integer> adventurerLevel1Test = adventurerTest.get(1);
        assertNotNull(adventurerLevel1Test);


        //verification du level 1;
        assertEquals(1, adventurerLevel1Test.get("INT"));
        assertEquals(1, adventurerLevel1Test.get("DEF"));
        assertEquals(3, adventurerLevel1Test.get("ATK"));
        assertEquals(2, adventurerLevel1Test.get("CHA"));


        HashMap<String, Integer> adventurerLevel2Test = adventurerTest.get(2);
        assertNotNull(adventurerLevel2Test);

        // verification du level 2
        assertEquals(2,adventurerLevel2Test.get("INT"));
        assertEquals(3,adventurerLevel2Test.get("CHA"));

        //verification du level 3

        HashMap<String, Integer> adventurerLevel3Test = adventurerTest.get(3);
        assertNotNull(adventurerLevel3Test);

        assertEquals(5,adventurerLevel3Test.get("ATK"));
        assertEquals(1,adventurerLevel3Test.get("ALC"));

        // verification du level 4 de ADVENTURER

        HashMap<String, Integer> adventurerLevel4Test = adventurerTest.get(4);
        assertNotNull(adventurerLevel4Test);

        assertEquals(3,adventurerLevel4Test.get("DEF"));

        //verification du level 5


    }
    
    @Test
    @DisplayName("verification du HashMap ADVENTURER")
    void testAbilitiesArcher() {

        Archer player = new Archer("Florian", "Grognak le barbare", 100, new ArrayList<>());

        HashMap<Integer, HashMap<String, Integer>> archerTest = player.initializeAbilitiesArcher() ;
        assertNotNull(archerTest);


        // verification du level 1

        assertEquals(1,archerTest.get(1).get("INT"));
        assertEquals(3,archerTest.get(1).get("ATK"));
        assertEquals(1,archerTest.get(1).get("CHA"));
        assertEquals(3,archerTest.get(1).get("VIS"));

        // verification du level 2

        assertEquals(1,archerTest.get(2).get("DEF"));
        assertEquals(2,archerTest.get(2).get("CHA"));

        //verification du level 3

        assertEquals(3,archerTest.get(3).get("ATK"));

        // verification du level 4

        assertEquals(2,archerTest.get(4).get("DEF"));

        // verification du level 5

        assertEquals(4,archerTest.get(5).get("ATK"));
        
    }

    @Test
    @DisplayName("verification du HashMap Dwarf")
    void testAbilitiesDwarf() {
        Dwarf player = new Dwarf("Florian", "Grognak le barbare", 100, new ArrayList<>());

        HashMap<Integer, HashMap<String, Integer>> dwarfTest = player.initializeAbilitiesDwarf();
        assertNotNull(dwarfTest);


        // verification du level 1

        assertEquals(4, dwarfTest.get(1).get("ALC"));
        assertEquals(1, dwarfTest.get(1).get("INT"));
        assertEquals(3, dwarfTest.get(1).get("ATK"));

        // verification du level 2
        assertEquals(1, dwarfTest.get(2).get("DEF"));
        assertEquals(5, dwarfTest.get(2).get("ALC"));

        // verification du level 3
        assertEquals(4, dwarfTest.get(3).get("ATK"));

        // verification du level 4
        assertEquals(2, dwarfTest.get(4).get("DEF"));

        // verification du level 5
        assertEquals(1, dwarfTest.get(5).get("CHA"));
    }


    @Test
    @DisplayName("test de addxp sans changement de level")
    void testAddXp(){
        Player player = new Dwarf("Florian", "Ruzberg de Rivehaute", 200, new ArrayList<>());
        player.addMoney(400);

        assertEquals(0, player.getXp());

        // le joueur ne doit pas changer de niveau
        boolean level0 = player.addXp(player, 0);
        assertEquals(1, player.retrieveLevel());

        assertFalse(level0);

        // le joueur doit changer de niveau
        boolean level1 = player.addXp(player, 11);
        assertEquals(2, player.retrieveLevel());
        assertTrue(level1);

        boolean level2 = player.addXp(player, 20);
        assertEquals(3, player.retrieveLevel());
        assertTrue(level2);


    }

    @Test
    @DisplayName("test de mise à jour des point de vie du jouer")
    void testMajFinDeTour(){
        Dwarf testPlayer = new Dwarf("Florian", "Gnognak le Barbare", 200, new ArrayList<>(),50);
        assertEquals(0, testPlayer.currentHealthPoints);
        testPlayer.majFinDeTour();

        testPlayer.currentHealthPoints = 3;
        testPlayer.currentHealthPoints = 10 ;
        testPlayer.majFinDeTour();
        assertEquals(4, testPlayer.currentHealthPoints);
        testPlayer.currentHealthPoints = 4;
        testPlayer.inventory.add();
        testPlayer.majFinDeTour();
        assertEquals(6, testPlayer.currentHealthPoints);

        Player testPlayerArcher = new Archer("Florian", "Gnognak le Barbare", 200, new ArrayList<>(), 50);
        testPlayerArcher.currentHealthPoints = 3;
        testPlayerArcher.healthPoints = 10 ;

        testPlayerArcher.majFinDeTour();
        assertEquals(4, testPlayerArcher.currentHealthPoints);
        testPlayerArcher.inventory.add("Magic Bow");
        testPlayerArcher.majFinDeTour();
        assertEquals(4, testPlayerArcher.currentHealthPoints);




        testPlayer.currenthealthpoints = 11;
        testPlayer.healthpoints = 10 ;
        assertEquals(11, testPlayer.currenthealthpoints);
        assertEquals(10, testPlayer.healthpoints);

        testPlayer.majFinDeTour();
        assertEquals(testPlayer.healthpoints, testPlayer.currenthealthpoints);

        Adventurer testPlayerAdventure = new Adventurer("Florian", "Gnognak le Barbare", 200, new ArrayList<>());
        testPlayerAdventure.currenthealthpoints = 3;
        testPlayerAdventure.healthpoints = 10 ;
        testPlayerAdventure.majFinDeTour();
        assertEquals(4, testPlayerAdventure.currenthealthpoints);

        testPlayerAdventure.addXp(testPlayerAdventure, 120);
        System.out.println("affiche de Xp"+ testPlayerAdventure.getXp());
        testPlayerAdventure.majFinDeTour();
        assertEquals(6, testPlayerAdventure.currenthealthpoints);







    }



}
