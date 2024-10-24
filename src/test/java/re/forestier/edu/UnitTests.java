package re.forestier.edu;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.Adventurer;
import re.forestier.edu.rpg.player;

import static java.lang.Integer.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;



import java.util.ArrayList;

public class UnitTests {

    @Test
    @DisplayName("Sample test")

    void testPlayerAttributs() {
        player player = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>());
        assertThat(player.playerName, is("Florian"));
        assertThat(player.Avatar_name, is("Grognak le barbare"));
        assertEquals(player.money, 100);
        assertThat(player.getAvatarClass(), is("ADVENTURER"));

    }



    @Test
    @DisplayName("AvatarClass Invalide")
    void testAvatarClassInvalid(){
        try {
        player player = new Adventurer("Florian", "Grognak le barbare", "INVALIDE_AVATAR", 100, new ArrayList<>());

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }


    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {
        player p = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>());

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
        player p = new Adventurer("Florian", "Grognak le barbare", 100, new ArrayList<>());

        p.removeMoney(20);
        assertEquals(80, p.money);


    }

    @Test
    @DisplayName("test add money")
    void testAddMoney(){
        player p = new Adventurer("Florian", "Grognak le barbare",  100, new ArrayList<>());

        p.addMoney(20);
        assertEquals(120, p.money);
    }

    @Test
    public void testAddNullMoney() {
        player p = new Adventurer("Florian", "Grognak le barbare",  100, new ArrayList<>());

        p.addMoney(valueOf(0));
        assertEquals(100, p.money);
    }



    @Test
    @DisplayName("test de recuperation de niveau")
    void testRetrieveLevel(){
        player p = new Adventurer("Florian", "Grognak le barbare",  100, new ArrayList<>());
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



}
