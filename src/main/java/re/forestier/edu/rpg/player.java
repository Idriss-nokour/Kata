package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;


public abstract class Player {
    public String playerName;
    public String Avatar_name;
    private String AvatarClass;

    public Integer money;
    private Float __real_money__;

    public int level;
    public int healthpoints;
    public int currenthealthpoints;
    protected int xp;

    public HashMap<String, Integer> abilities;
    public ArrayList<String> inventory;

    public Player(String playerName, String avatar_name, int money, ArrayList<String> inventory) {
        this.playerName = playerName;
        Avatar_name = avatar_name;
        this.money = Integer.valueOf(money);
        this.inventory = inventory;
        this.abilities = getAvatarLevel(1);
    }

    public abstract String getAvatarClass();

    public abstract HashMap<String, Integer> getAvatarLevel(int level);

    public abstract void majFinDeTour();

    public void removeMoney(int amount) throws IllegalArgumentException {
        if (money - amount < 0) {
            throw new IllegalArgumentException("Player can't have a negative money!");
        }
        money -= amount;
    }
    
    public void addMoney(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive to add money!");
        }
        money += amount;
    }
    





    public int retrieveLevel() {
        // Calculer dynamiquement les niveaux basés sur une HashMap
        HashMap<Integer, Integer> levels = new HashMap<>();
        levels.put(2, 10);  // Niveau 1 à 2
        levels.put(3, 27);  // Niveau 2 à 3
        levels.put(4, 57);  // Niveau 3 à 4
        levels.put(5, 111); // Niveau 4 à 5
        // TODO : Ajouter les niveaux suivants
    
        // On boucle sur les niveaux et on trouve celui auquel l'XP correspond
        for (Map.Entry<Integer, Integer> entry : levels.entrySet()) {
            if (xp < entry.getValue()) {
                return entry.getKey() - 1; // Retourner le niveau juste avant le seuil
            }
        }
    
        // Si l'XP est supérieur à tous les seuils dans la HashMap, retourner le dernier niveau
        return levels.size() + 1; // Dernier niveau connu
    }
    

    public int getXp() {
        return this.xp;
    }

    /*
    Ингредиенты:
        Для теста:

            250 г муки
            125 г сливочного масла (холодное)
            70 г сахара
            1 яйцо
            1 щепотка соли
     */

    private final static String[] objectList = {
            "Lookout Ring : Prevents surprise attacks",
            "Scroll of Stupidity : INT-2 when applied to an enemy",
            "Draupnir : Increases XP gained by 100%",
            "Magic Charm : Magic +10 for 5 rounds",
            "Rune Staff of Curse : May burn your ennemies... Or yourself. Who knows?",
            "Combat Edge : Well, that's an edge",
            "Holy Elixir : Recover your HP"
    };

    public boolean addXp(Player player, int xp) {
        int currentLevel = retrieveLevel();
        player.xp += xp;
        int newLevel = player.retrieveLevel();

        if (newLevel != currentLevel) {
            // Player leveled-up!
            // Give a random object
            Random random = new Random();
            player.inventory.add(objectList[random.nextInt(objectList.length)]);

            // Add/upgrade abilities to player
            HashMap<String, Integer> abilities = getAvatarLevel(newLevel);
            abilities.forEach((ability, level) -> {
                player.abilities.put(ability, abilities.get(ability));
            });
            return true;
        }
        return false;
    }

    protected void AjoutVie(int amount) {
        currenthealthpoints += amount;
        if (currenthealthpoints > healthpoints) {
            currenthealthpoints = healthpoints;
        }
    }

    @Override
    public String toString() {
        final String[] finalString = {"Joueur " + Avatar_name + " joué par " + playerName};
        finalString[0] += "\nNiveau : " + retrieveLevel() + " (XP totale : " + xp + ")";
        finalString[0] += "\n\nCapacités :";
        abilities.forEach((name, level) -> {
            finalString[0] += "\n   " + name + " : " + level;
        });
        finalString[0] += "\n\nInventaire :";
        inventory.forEach(item -> {
            finalString[0] += "\n   " + item;
        });

        return finalString[0];
    }
}
