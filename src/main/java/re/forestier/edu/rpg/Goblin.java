package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class Goblin extends Player {

    public Goblin(String playerName, String avatarName, int money, ArrayList<InventoryObjet> inventory, int maxWeight) {
        super(playerName, avatarName, money, inventory, maxWeight);
    }

    @Override
    public String getAvatarClass() {
        return "GOBLIN";
    }

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
