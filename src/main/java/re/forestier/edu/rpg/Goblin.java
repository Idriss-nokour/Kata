package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class Goblin extends Player {

<<<<<<< HEAD
    public Goblin(String playerName, String avatarName, int money, ArrayList<InventoryObjet> inventory, int maxWeight) {
        super(playerName, avatarName, money, inventory, maxWeight);
    }

=======
    // Constructeur de la classe Goblin
    public Goblin(String playerName, String avatar_name, int money, ArrayList<String> inventory) {
        super(playerName, avatar_name, money, inventory);
        /*this.level = 1; // Niveau de départ
        this.xp = 0; // XP de départ
        this.healthpoints = 50; // Points de vie initiaux
        this.currenthealthpoints = this.healthpoints;
        this.abilities = getAvatarLevel(1); // Initialiser les capacités au niveau 1*/
    }

    // Retourner la classe de l'avatar
>>>>>>> 2eed3af (ajout de la classe de goblin)
    @Override
    public String getAvatarClass() {
        return "GOBLIN";
    }

<<<<<<< HEAD
    @Override
    public HashMap<String, Integer> getAvatarLevel(int level) {
        return initializeGoblinAbilities().get(level);
    }

    @Override
    public void majFinDeTour() {
        if (currentHealthPoints == 0) {
            System.out.println("The Goblin is KO!");
            return;
        }
        addHealth(1);
    }



    public HashMap<Integer, HashMap<String, Integer>> initializeGoblinAbilities() {
        HashMap<Integer, HashMap<String, Integer>> goblinMap = new HashMap<>();

        HashMap<String, Integer> goblinLevel1 = new HashMap<>();
        goblinLevel1.put("INT", 2);
        goblinLevel1.put("ATK", 2);
        goblinLevel1.put("ALC", 1);
        goblinMap.put(1, goblinLevel1);

        HashMap<String, Integer> dwarfLevel2 = new HashMap<>();
        dwarfLevel2.put("ATK", 3);
        dwarfLevel2.put("ALC", 4);
        goblinMap.put(2, dwarfLevel2);

        HashMap<String, Integer> goblinLevel3 = new HashMap<>();
        goblinLevel3.put("ATK", 1);
        goblinMap.put(3, goblinLevel3);

        HashMap<String, Integer> goblinLevel4 = new HashMap<>();
        goblinLevel4.put("DEF", 1);
        goblinMap.put(4, goblinLevel4);

        HashMap<String, Integer> goblinLevel5 = new HashMap<>();
        goblinLevel5.put("DEF", 2);
        goblinLevel5.put("ATK", 4);
        goblinMap.put(4, goblinLevel5);

        return goblinMap;
    }


}
=======
    // Retourner les capacités selon le niveau
    @Override
    public HashMap<String, Integer> getAvatarLevel(int level) {
        HashMap<String, Integer> levelAbilities = new HashMap<>();
        switch (level) {
            case 1:
                levelAbilities.put("INT", 2);
                levelAbilities.put("ATK", 2);
                levelAbilities.put("ALC", 1);
                break;
            case 2:
                levelAbilities.put("ATK", 3);
                levelAbilities.put("ALC", 4);
                break;
            case 3:
                levelAbilities.put("VIS", 1);
                break;
            case 4:
                levelAbilities.put("DEF", 1);
                break;
            case 5:
                levelAbilities.put("DEF", 2);
                levelAbilities.put("ATK", 4);
                break;
            default:
                levelAbilities.put("DEFAULT", 0); // Gestion des cas par défaut
                break;
        }
        return levelAbilities;
    }

    // Mettre à jour les effets de fin de tour
    @Override
    public void majFinDeTour() {
        // Exemple : régénérer un point de vie si possible
        System.out.println("Fin du tour pour le Goblin : " + Avatar_name);
        AjoutVie(1);
        System.out.println("Régénération de 1 HP. HP actuel : " + currenthealthpoints + "/" + healthpoints);
    }
}


>>>>>>> 2eed3af (ajout de la classe de goblin)
