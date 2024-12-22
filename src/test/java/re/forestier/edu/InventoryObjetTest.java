package re.forestier.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.Archer;
import re.forestier.edu.rpg.Dwarf;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.InventoryObjet; 
import re.forestier.edu.rpg.Goblin;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;


class InventoryObjetTest {

    private InventoryObjet inventoryObjet;

    @BeforeEach
    void setUp() {
        inventoryObjet = new InventoryObjet("Sword", "A sharp blade", 5, 100);
    }

    @Test
    void testGetName() {
        assertEquals("Sword", inventoryObjet.getName(), "The name should be 'Sword'.");
    }

    @Test
    void testSetName() {
        inventoryObjet.setName("Shield");
        assertEquals("Shield", inventoryObjet.getName(), "The name should be updated to 'Shield'.");
    }

    @Test
    void testGetDescription() {
        assertEquals("A sharp blade", inventoryObjet.getDescription(), "The description should be 'A sharp blade'.");
    }

    @Test
    void testSetDescription() {
        inventoryObjet.setDescription("A sturdy shield");
        assertEquals("A sturdy shield", inventoryObjet.getDescription(), "The description should be updated to 'A sturdy shield'.");
    }

    @Test
    void testGetWeight() {
        assertEquals(5, inventoryObjet.getWeight(), "The weight should be 5.");
    }

    @Test
    void testSetWeight() {
        inventoryObjet.setWeight(10);
        assertEquals(10, inventoryObjet.getWeight(), "The weight should be updated to 10.");
    }

    @Test
    void testGetValue() {
        assertEquals(100, inventoryObjet.getValue(), "The value should be 100.");
    }

    @Test
    void testSetValue() {
        inventoryObjet.setValue(200);
        assertEquals(200, inventoryObjet.getValue(), "The value should be updated to 200.");
    }
}
