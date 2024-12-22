package re.forestier.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.*;


import static java.lang.Integer.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;



public class PlayerTest {


    @Test
    @DisplayName("Sample test")

    void testPlayerAttributs() {

        Player player = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>(),50);

        assertThat(player.playerName, is("Florian"));
        assertThat(player.Avatar_name, is("Grognak le barbare"));
        assertEquals(player.money, 100);
        assertThat(player.getAvatarClass(), is("ADVENTURER"));



    }



    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {

        Player p = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>(),50);

        try {
            p.removeMoney(200);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }


    @Test
    @DisplayName("test remove money")
    void testRemoveMoney(){
        Player p = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>(),60);

        p.removeMoney(20);
        assertEquals(80, p.money);
    }

    @Test
    @DisplayName("test add money")
    void testAddMoney(){
        Player p = new Adventurer("Florian", "Grognak le barbare",  100, new ArrayList<>(), 60);

        p.addMoney(20);
        assertEquals(120, p.money);
    }

    @Test
    public void testAddNullMoney() {
        Player p = new Adventurer("Florian", "Grognak le barbare",  100, new ArrayList<>(), 60);

        p.addMoney(valueOf(0));
        assertEquals(100, p.money);
    }

    @Test
    @DisplayName("test de recuperation de niveau")
    void testRetrieveLevel(){

        Player p = new Adventurer("Florian", "Grognak le barbare",  100, new ArrayList<>(), 60);

        assertEquals(1, p.retrieveLevel());


        System.out.println("valeur XP"+ p.getXp());

        p.addXp(11);
        assertEquals(11, p.getXp());

        assertEquals(2, p.retrieveLevel());

        p.addXp(20);
        assertEquals(3, p.retrieveLevel());


        p.addXp(40);
        assertEquals(4, p.retrieveLevel());


        p.addXp(100);
        assertEquals(5, p.retrieveLevel());

    }

    @Test
    public void testRetrieveLevelStandard() {

        Player p = new Archer("Florian", "Grognak le barbare", 10, new ArrayList<InventoryObjet>(),60);

        p.addXp(10);
    
        assertEquals(2, p.retrieveLevel());
    }
    
    @Test
    public void testRetrieveLevelHigherThan5() {

        Player p = new Adventurer("Florian", "Grognak le barbare", 10, new ArrayList<InventoryObjet>(), 50);
        p.addXp(150);  // XP = 150
    
        assertEquals(5, p.retrieveLevel());  // XP supérieur à 111, donc le niveau devrait être 5
    }



    @Test
    void testAddMoneyThrowsExceptionForNegativeAmount() {
        // Arrange
        Player player = new Adventurer("Florian", "Grognak le barbare", 10, new ArrayList<InventoryObjet>(), 50);


        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            player.addMoney(-10); // Provoque une exception avec une valeur négative.
        });

        // Vérifie que le message de l'exception est correct.
        assertEquals("Amount must be positive to add money!", exception.getMessage(),
                "The exception message should be as expected for negative amounts.");
    }


        
    @Test
    @DisplayName("Vérifie que le message est correctement affiché lorsque l'objet est ajouté à l'inventaire")
    void testAddInventoryLogsCorrectMessage() {
        // Arrange
        Player player = new Adventurer("Florian", "Grognak le barbare", 10, new ArrayList<>(), 50);
        InventoryObjet randomObjet = new InventoryObjet("Magic Charm", "Magic +10 for 5 rounds", 10, 100);

        // Rediriger la sortie standard pour capturer le message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            if (player.addInventory(randomObjet)) { // Appel direct de la méthode
                System.out.println("Le joueur a obtenu un nouvel objet : " + randomObjet.getName());
            }

        } finally {
            // Restaurer la sortie standard
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("test de addxp sans changement de level")
    void testAddXp(){

        Player player = new Dwarf("Florian", "Ruzberg de Rivehaute", 200, new ArrayList<>(),50);
        player.addMoney(400);

        assertEquals(0, player.getXp());

        // le joueur ne doit pas changer de niveau
        boolean level0 = player.addXp( 0);
        assertEquals(1, player.retrieveLevel());

        assertFalse(level0);

        // le joueur doit changer de niveau
        boolean level1 = player.addXp(11);
        assertEquals(2, player.retrieveLevel());
        assertTrue(level1);

        boolean level2 = player.addXp(20);
        assertEquals(3, player.retrieveLevel());
        assertTrue(level2);


    }


    //testunitaires pour goblin

    private Goblin goblin;

    @BeforeEach
    void setUp() {
        ArrayList<InventoryObjet> inventory = new ArrayList<>();
        goblin = new Goblin("Gob", "GreenGoblin", 100, inventory, 50);
        goblin.currenthealthPoints = 10; // Set initial health points
    }

    @Test
    void testGetAvatarClass() {
        assertEquals("GOBLIN", goblin.getAvatarClass(), "Avatar class should be GOBLIN.");
    }

    @Test
    void testGetAvatarLevel_ValidLevel() {
        HashMap<String, Integer> levelAbilities = goblin.getAvatarLevel(1);
        assertNotNull(levelAbilities, "Level 1 abilities should not be null.");
        assertEquals(2, levelAbilities.get("INT"), "Level 1 INT should be 2.");
        assertEquals(2, levelAbilities.get("ATK"), "Level 1 ATK should be 2.");
        assertEquals(1, levelAbilities.get("ALC"), "Level 1 ALC should be 1.");
    }

    @Test
    void testGetAvatarLevel_InvalidLevel() {
        HashMap<String, Integer> levelAbilities = goblin.getAvatarLevel(99);
        assertNull(levelAbilities, "Invalid level should return null.");
    }

    @Test
    void testMajFinDeTour_HealthRegeneration() {
        goblin.currenthealthPoints = 5;
        goblin.healthPoints = 2;
        goblin.majFinDeTour();
        assertEquals(2, goblin.currenthealthPoints, "Health points should increase by 1 at end of turn.");
    }

    @Test
    void testMajFinDeTour_KnockedOut() {
        goblin.currenthealthPoints = 0;
        Exception exception = assertThrows(IllegalStateException.class, goblin::majFinDeTour);
        assertEquals(0, goblin.currenthealthPoints, "Health points should remain 0 if Goblin is KO.");
    }

    @Test
    void testInitializeGoblinAbilities() {
        HashMap<Integer, HashMap<String, Integer>> abilities = goblin.initializeGoblinAbilities();
        assertNotNull(abilities, "Abilities map should not be null.");
        //assertEquals(5, abilities.size(), "Abilities map should have 5 levels."); // à verifier 

        // Test specific levels
        HashMap<String, Integer> level1 = abilities.get(1);
        assertNotNull(level1, "Level 1 abilities should not be null.");
        assertEquals(2, level1.get("INT"), "Level 1 INT should be 2.");
        assertEquals(2, level1.get("ATK"), "Level 1 ATK should be 2.");
        assertEquals(1, level1.get("ALC"), "Level 1 ALC should be 1.");

        HashMap<String, Integer> level4 = abilities.get(4);
        assertNotNull(level4, "Level 4 abilities should not be null.");
        assertEquals(2, level4.get("DEF"), "Level 4 DEF should be 2.");
        assertEquals(4, level4.get("ATK"), "Level 4 ATK should be 4.");
    }


    @Test
    void testSellInventorySuccess() {
        // Création d'un joueur
        ArrayList<InventoryObjet> inventory = new ArrayList<>();
        InventoryObjet item = new InventoryObjet("Shield", "A sturdy shield", 5, 30);
        inventory.add(item);

        Player player = new Adventurer("Florian", "Grognak le barbare", 100, inventory, 50);
        player.currentWeight = 5;

        // Vente d'inventaire avec succès
        boolean result = player.sellInventory(item);

        // Assertions
        assertTrue( result);
        assertEquals(0, player.inventory.size());
        assertEquals(130, player.money);
        assertEquals(0, player.currentWeight);
    }

    @Test
    void testSellInventoryFail() {
        // Création d'un joueur
        Player player = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<InventoryObjet>(), 50);
        InventoryObjet item = new InventoryObjet("Shield", "A sturdy shield", 5, 30);

        // Vente échouée (objet non présent dans l'inventaire)
        boolean result = player.sellInventory(item);

       
        assertFalse(result);
        assertEquals(0, player.inventory.size());
        assertEquals(100, player.money);
        assertEquals(0, player.currentWeight);
    }

    @Test
    public void testAddInventoryEdgeCaseWeightLimit() {
        Player player = new Adventurer("Florian", "Grognak", 100, new ArrayList<>(), 50); // maxWeight = 50
        InventoryObjet item1 = new InventoryObjet("Item1", "Description", 30, 10);  // Poids = 30
        InventoryObjet item2 = new InventoryObjet("Item2", "Description", 25, 5);   // Poids = 25, dépasse le poids maximal total


        assertEquals(0,player.currentWeight);

        // Ajouter le premier objet, devrait réussir
        boolean addedItem1 = player.addInventory(item1);
        assertTrue(addedItem1);  // S'attendre à ce que le premier objet soit ajouté

        assertEquals(30,player.currentWeight);

        // Ajouter le second objet, ne devrait pas être possible car le poids total dépasserait 50
        boolean addedItem2 = player.addInventory(item2);
        assertFalse(addedItem2);  // Le second objet ne devrait pas être ajouté


    }


}





    