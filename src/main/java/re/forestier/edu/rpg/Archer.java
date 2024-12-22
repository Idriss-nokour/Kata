package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class Archer extends Player{
    public Archer(String playerName, String avatar_name, int money, ArrayList<InventoryObjet> inventory, int maxWeight) {
        super(playerName, avatar_name, money, inventory,maxWeight);
    }

    @Override
    public String getAvatarClass() {
        return "ARCHER";
    }

    @Override
    public HashMap<String, Integer> getAvatarLevel(int level) {
        return initializeAbilitiesArcher().get(level);
    }

    @Override
    public void majFinDeTour() {
        checkIfKO();
        addHealth(1);
        for (InventoryObjet objet : inventory) {
            if (objet.getName().equals("Magic Bow")) {
                addHealth(currenthealthPoints/8-1);
            }break;
        }

    }


    public HashMap<Integer, HashMap<String, Integer>> initializeAbilitiesArcher() {
        HashMap<Integer, HashMap<String, Integer>> archerMap = new HashMap<>();
        HashMap<String, Integer> archerLevel1 = new HashMap<>();
        archerLevel1.put("INT", 1);
        archerLevel1.put("ATK", 3);
        archerLevel1.put("CHA", 1);
        archerLevel1.put("VIS", 3);
        archerMap.put(1, archerLevel1);

        HashMap<String, Integer> archerLevel2 = new HashMap<>();
        archerLevel2.put("DEF", 1);
        archerLevel2.put("CHA", 2);
        archerMap.put(2, archerLevel2);

        HashMap<String, Integer> archerLevel3 = new HashMap<>();
        archerLevel3.put("ATK", 3);
        archerMap.put(3, archerLevel3);

        HashMap<String, Integer> archerLevel4 = new HashMap<>();
        archerLevel4.put("DEF", 2);
        archerMap.put(4, archerLevel4);

        HashMap<String, Integer> archerLevel5 = new HashMap<>();
        archerLevel5.put("ATK", 4);
        archerMap.put(5, archerLevel5);

        return archerMap;

    }


}
