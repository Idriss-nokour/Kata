package re.forestier.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.Archer;
import re.forestier.edu.rpg.Dwarf;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.InventoryObjet; 

import static java.lang.Integer.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;



public class UnitTests {

    @Test
    @DisplayName("Sample test")

    void testPlayerAttributs() {
        Player player = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>(), 60);
        assertThat(player.playerName, is("Florian"));
        assertThat(player.Avatar_name, is("Grognak le barbare"));
        assertEquals(player.money, 100);
        assertThat(player.getAvatarClass(), is("ADVENTURER"));

    }



    /*@Test
    @DisplayName("AvatarClass Invalide")
    void testAvatarClassInvalid(){
        try {
        player player = new player("Florian", "Grognak le barbare", "INVALIDE_AVATAR", 100, new ArrayList<>());

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }*/


    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {
        Player p = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>(), 60);

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

        p.addXp(p,11);
        assertEquals(11, p.getXp());

        assertEquals(2, p.retrieveLevel());

        p.addXp(p,20);
        assertEquals(3, p.retrieveLevel());


        p.addXp(p,40);
        assertEquals(4, p.retrieveLevel());


        p.addXp(p,100);
        assertEquals(5, p.retrieveLevel());

    }


    @Test
    @DisplayName("Test de la méthode getAvatarClass dans Archer")
    void testGetAvatarClass() {
        // Création d'un joueur de type Archer

        Player p = new Archer("Florian", "Grognak le barbare", 100, new ArrayList<>(), 60);

        // Test de la méthode getAvatarClass
        assertEquals("ARCHER", p.getAvatarClass(), "La classe du joueur doit être ARCHER");
    }


    @Test
    @DisplayName("Test de la méthode getAvatarClass dans Dwarf")
    void testGetAvatarClassDwarf() {
        // Création d'un joueur de type Archer
        Player p = new Dwarf("Florian", "Grognak le barbare", 100, new ArrayList<>(), 60);

        // Test de la méthode getAvatarClass
        assertEquals("DWARF", p.getAvatarClass(), "La classe du joueur doit être ARCHER");
    }


    @Test
    @DisplayName("Test de la méthode getAvatarClass dans Adventurer")
    void testGetAvatarClassAdventurer() {
        // Création d'un joueur de type Archer
        Player p = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>(), 50);

        // Test de la méthode getAvatarClass
        assertEquals("ADVENTURER", p.getAvatarClass(), "La classe du joueur doit être ARCHER");
    }


    
    @Test
    @DisplayName("Test de la méthode majFinDeTour dans Adventurer")
    void testMajFinDeTourAdventurer() {
        // Création d'un joueur avec des points de vie à 0
        Player p = new Adventurer("Florian", "Grognak le barbare", 0, new ArrayList<>(), 60);
    
        // Redirection de la sortie console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Sauvegarder la sortie console originale
        System.setOut(new PrintStream(outContent)); // Rediriger la sortie vers outContent
    
        try {
            p.majFinDeTour();
    
            // Vérification du message affiché
            assertTrue(outContent.toString().contains("Le joueur est KO !"), 
                    "Le message 'Le joueur est KO !' devrait être affiché lorsque les points de vie sont à 0");
        } finally {
            // Restauration de la sortie console standard
            System.setOut(originalOut); 
        }
    }


    @Test
    @DisplayName("Test de la méthode majFinDeTour dans Archer")
    void testMajFinDeTourArcher() {
        // Création d'un joueur avec des points de vie à 0
        Player p = new Archer("Florian", "Grognak le barbare", 0, new ArrayList<>(), 60);
    
        // Redirection de la sortie console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Sauvegarder la sortie console originale
        System.setOut(new PrintStream(outContent)); // Rediriger la sortie vers outContent
    
        try {
            p.majFinDeTour();
    
            // Vérification du message affiché
            assertTrue(outContent.toString().contains("Le joueur est KO !"), 
                    "Le message 'Le joueur est KO !' devrait être affiché lorsque les points de vie sont à 0");
        } finally {
            // Restauration de la sortie console standard
            System.setOut(originalOut); 
        }
    }


    @Test
    @DisplayName("Test de la méthode majFinDeTour dans Dwarf")
    void testMajFinDeTourDwarf() {
        // Création d'un joueur avec des points de vie à 0
        Player p = new Dwarf("Florian", "Grognak le barbare", 0, new ArrayList<>(), 60);
    
        // Redirection de la sortie console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Sauvegarder la sortie console originale
        System.setOut(new PrintStream(outContent)); // Rediriger la sortie vers outContent
    
        try {
            p.majFinDeTour();
    
            // Vérification du message affiché
            assertTrue(outContent.toString().contains("Le joueur est KO !"), 
                    "Le message 'Le joueur est KO !' devrait être affiché lorsque les points de vie sont à 0");
        } finally {
            // Restauration de la sortie console standard
            System.setOut(originalOut); 
        }
    }
    
    




    @Test
    @DisplayName("test de la méthode toString")
    void testToString() {
        // Création d'un joueur avec un avatar et de l'XP
        Player p = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<InventoryObjet>(), 60);
        p.addXp(p, 50); // Ajout d'XP pour augmenter le niveau
    
        // Accès direct à l'inventaire et aux capacités
        p.abilities.put("Attaque", 5);   // Ajout d'une capacité
        p.abilities.put("Défense", 3);   // Ajout d'une capacité


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









// pour les mutation 

    @Test
    public void testMajFinDeTour_levelUnder3Archer() {
        Player p = new Archer("Florian", "Grognak le barbare", 10, new ArrayList<>(), 60);
        
        // le niveau initial doit etre est inférieur à 3
        p.addXp(p, 10); // Ajouter de l'XP pour augmenter le niveau si nécessaire
        assertTrue(p.retrieveLevel() < 3);
        p.majFinDeTour();
        
    }

    @Test
    public void testMajFinDeTour_levelAbove3Archer() {
        Player p = new Archer("Florian", "Grognak le barbare", 10, new ArrayList<>(), 60);
        
        // Ajouter suffisamment d'XP pour que le niveau atteigne 3 ou plus
        p.addXp(p, 50); 
        
        assertTrue(p.retrieveLevel() >= 3);
        p.majFinDeTour();

    }

    @Test
    public void testMajFinDeTour_levelUnder3_Adventurer() {
        // Création d'un joueur d'aventure avec un niveau inférieur à 3
        Player p = new Adventurer("Florian", "Grognak le barbare", 10, new ArrayList<InventoryObjet>(), 60);
        p.currenthealthPoints = 10;
        p.healthPoints = 5;

        p.addXp(p, 10);
        assertTrue(p.retrieveLevel() < 3);
        p.majFinDeTour();
    
        // Vérification que les points de vie ont diminué de 1 si le niveau est inférieur à 3
        assertEquals(4, p.currenthealthPoints);  // Points de vie diminués de 1 après le tour
    }
    
    @Test
    public void testMajFinDeTour_levelAbove3_Adventurer() {
        // Création d'un joueur d'aventure avec un niveau supérieur ou égal à 3
        Player p = new Adventurer("Florian", "Grognak le barbare", 10, new ArrayList<>(), 60);
        // Ajouter suffisamment d'XP pour que le niveau soit supérieur ou égal à 3
        p.currenthealthPoints = 10;
        p.healthPoints = 5;
        p.addXp(p, 50);
        assertTrue(p.retrieveLevel() >= 3);
   
        // Appel de la méthode majFinDeTour
        p.majFinDeTour();


    
        // Vérification que les points de vie ne sont pas diminués si le niveau est supérieur ou égal à 3
        assertEquals(5, p.currenthealthPoints);  // 10 + 2 points de vie ajoutés, car niveau >= 3
    }
    


    // Test lorsque le joueur n'a pas assez d'argent pour retirer
    @Test
    public void testremoveMoneyInsuffisant() {
        Player p = new Archer("Florian", "Grognak le barbare",  100, new ArrayList<>(), 60);  
        
        // Essayer de retirer plus d'argent que ce que le joueur possède
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            p.removeMoney(150);
        });

        // Vérifier que l'exception est bien lancée avec le bon message
        assertEquals("Player can't have a negative money!", exception.getMessage(), 
            "Le message d'exception ne correspond pas.");
    }







    


}