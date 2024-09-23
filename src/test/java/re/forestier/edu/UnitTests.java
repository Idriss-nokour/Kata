package re.forestier.edu;

import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.player;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

public class UnitTests {

    @Test
    @DisplayName("Sample test")
    void testPlayerName() {
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
        assertThat(player.playerName, is("Florian"));

    }

    @Test
    @DisplayName("Sample test")
    void testAvatar_name() {
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
        assertThat(player.Avatar_name, is("Grognak le barbare"));

    }

    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {
        player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());

        try {
            p.removeMoney(200);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    @DisplayName("test add money")
    void testAddMoney(){
        player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());

        p.addMoney(20);
        assertEquals(120, p.money);
    }

    @Test
    @DisplayName("test de recuperation de niveau")
    void testRetrieveLevel(){
        player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
        assertEquals(1, p.retrieveLevel());

        UpdatePlayer.addXp(p,11);
        assertEquals(2, p.retrieveLevel());

        UpdatePlayer.addXp(p,20);
        assertEquals(3, p.retrieveLevel());


        UpdatePlayer.addXp(p,40);
        assertEquals(4, p.retrieveLevel());


        UpdatePlayer.addXp(p,100);
        assertEquals(5, p.retrieveLevel());

    }


}
