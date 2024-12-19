package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
<<<<<<< HEAD
import java.util.Map;

=======
>>>>>>> 619f84e (revu de jacoco et pitTest)

public abstract class Player {
    public String playerName;
    public String Avatar_name;
<<<<<<< HEAD
=======
    private String AvatarClass;
>>>>>>> 619f84e (revu de jacoco et pitTest)

    public Integer money;
    private Float __real_money__;

    public int level;
<<<<<<< HEAD
    public int healthPoints;
    public int currentHealthPoints;
    protected int xp;
    public int maxWeight;
    public int currentWeight;

    public HashMap<String, Integer> abilities;
    public ArrayList<InventoryObjet> inventory;

    public Player(String playerName, String avatar_name, int money, ArrayList<InventoryObjet> inventory, int maxWeight) {
=======
    public int healthpoints;
    public int currenthealthpoints;
    protected int xp;

    public HashMap<String, Integer> abilities;
    public ArrayList<String> inventory;

    public Player(String playerName, String avatar_name, int money, ArrayList<String> inventory) {
>>>>>>> 619f84e (revu de jacoco et pitTest)
        this.playerName = playerName;
        Avatar_name = avatar_name;
        this.money = Integer.valueOf(money);
        this.inventory = inventory;
        this.abilities = getAvatarLevel(1);
<<<<<<< HEAD
        this.currentWeight = 0;
=======
>>>>>>> 619f84e (revu de jacoco et pitTest)
    }

    public abstract String getAvatarClass();

    public abstract HashMap<String, Integer> getAvatarLevel(int level);

    public abstract void majFinDeTour();

    public void removeMoney(int amount) throws IllegalArgumentException {
        if (money - amount < 0) {
            throw new IllegalArgumentException("Player can't have a negative money!");
        }
<<<<<<< HEAD
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


=======

        money = Integer.parseInt(money.toString()) - amount;
    }

    public void addMoney(int amount) {
        var value = Integer.valueOf(amount);
        money = money + (value != null ? value : 0);
    }

    public int retrieveLevel() {
        // (lvl-1) * 10 + round((lvl * xplvl-1)/4)
        HashMap<Integer, Integer> levels = new HashMap<>();
        levels.put(2, 10); // 1*10 + ((2*0)/4)
        levels.put(3, 27); // 2*10 + ((3*10)/4)
        levels.put(4, 57); // 3*10 + ((4*27)/4)
        levels.put(5, 111); // 4*10 + ((5*57)/4)
        // TODO : ajouter les prochains niveaux

        if (xp < levels.get(2)) {
            return 1;
        } else if (xp < levels.get(3)) {
            return 2;
        }
        if (xp < levels.get(4)) {
            return 3;
        }
        if (xp < levels.get(5)) return 4;
        return 5;
    }

>>>>>>> 619f84e (revu de jacoco et pitTest)
    public int getXp() {
        return this.xp;
    }

<<<<<<< HEAD

=======
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
>>>>>>> 619f84e (revu de jacoco et pitTest)

    public boolean addXp(Player player, int xp) {
        int currentLevel = retrieveLevel();
        player.xp += xp;
        int newLevel = player.retrieveLevel();

        if (newLevel != currentLevel) {
<<<<<<< HEAD

            Random random = new Random();
            InventoryObjet randomObjet = generateRandomObjet(random);

            if (addInventory(randomObjet)) {
                System.out.println("Le joueur a obtenu un nouvel objet : " + randomObjet.getName());
            }
=======
            // Player leveled-up!
            // Give a random object
            Random random = new Random();
            player.inventory.add(objectList[random.nextInt(objectList.length)]);

>>>>>>> 619f84e (revu de jacoco et pitTest)
            // Add/upgrade abilities to player
            HashMap<String, Integer> abilities = getAvatarLevel(newLevel);
            abilities.forEach((ability, level) -> {
                player.abilities.put(ability, abilities.get(ability));
            });
            return true;
        }
        return false;
    }
<<<<<<< HEAD
    private InventoryObjet generateRandomObjet(Random random) {
        // Liste des objets disponibles
        String[] itemNames = {"Lookout Ring", "Scroll of Stupidity", "Draupnir", "Magic Charm", "Rune Staff of Curse", "Combat Edge", "Holy Elixir"};
        String[] descriptions = {
                "Prevents surprise attacks",
                "INT-2 when applied to an enemy",
                "Increases XP gained by 100%",
                "Magic +10 for 5 rounds",
                "May burn your enemies... Or yourself. Who knows?",
                "Well, that's an edge",
                "Recover your HP"
        };
        int[] weights = {1, 2, 3, 1, 4, 1, 2};  // Exemple de poids associés
        int[] values = {50, 30, 100, 60, 70, 40, 20};  // Valeurs fictives des objets

        int index = random.nextInt(itemNames.length);

        // Création d'un objet aléatoire avec un nom, une description, un poids et une valeur
        return new InventoryObjet(itemNames[index], descriptions[index], weights[index], values[index]);
    }



    protected void addHealth(int amount) {
        currentHealthPoints += amount;
        if (currentHealthPoints > healthPoints) {
            currentHealthPoints = healthPoints;
        }
    }

    public boolean addInventory(InventoryObjet inventoryObjet){
        if (currentWeight + inventoryObjet.getWeight() > maxWeight) {
            System.out.println("Cannot add item, maximum weight exceeded.");
            return false;
        }
        inventory.add(inventoryObjet);
        currentWeight += inventoryObjet.getWeight();
        return true;

    }

    public boolean sellInventory(InventoryObjet inventoryObjet){
        if (inventory.contains(inventoryObjet)) {
            inventory.remove(inventoryObjet);
            money += inventoryObjet.getValue();
            currentWeight -= inventoryObjet.getWeight();
            return true;
        }
        return false;
    }


=======

    protected void AjoutVie(int amount) {
        currenthealthpoints += amount;
        if (currenthealthpoints > healthpoints) {
            currenthealthpoints = healthpoints;
        }
    }

>>>>>>> 619f84e (revu de jacoco et pitTest)
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
