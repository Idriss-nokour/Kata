package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class Adventurer extends player{
    public ArrayList<String> inventory;
    public Adventurer(String playerName, String avatar_name, int money, ArrayList<String> inventory) {
        super(playerName, avatar_name, money, inventory);
        this.inventory = inventory;
    }

    @Override
    public String getAvatarClass() {
        return "ADVENTURER";
    }




    @Override
    public void majFinDeTour() {
        if(currenthealthpoints == 0) {
            System.out.println("Le joueur est KO !");
            return;
        }
        AjoutVie(2);
        if(retrieveLevel() < 3) {
            currenthealthpoints-=1;
        }
    }

    @Override
    public HashMap<String, Integer> getAvatarLevel(int level) {
        return initializeAbilitiesAdventurer().get(level);
    }




    public HashMap<Integer, HashMap<String, Integer>> initializeAbilitiesAdventurer() {
        HashMap<Integer, HashMap<String, Integer>> adventurerMap = new HashMap<>();
        HashMap<String, Integer> adventurerLevel1 = new HashMap<>();
        adventurerLevel1.put("INT", 1);
        adventurerLevel1.put("DEF", 1);
        adventurerLevel1.put("ATK", 3);
        adventurerLevel1.put("CHA", 2);
        adventurerMap.put(1, adventurerLevel1);

        HashMap<String, Integer> adventurerLevel2 = new HashMap<>();

        adventurerLevel2.put("INT", 2);
        adventurerLevel2.put("CHA", 3);
        adventurerMap.put(2, adventurerLevel2);

        HashMap<String, Integer> adventurerLevel3 = new HashMap<>();
        adventurerLevel3.put("ATK", 5);
        adventurerLevel3.put("ALC", 1);
        adventurerMap.put(3, adventurerLevel3);

        HashMap<String, Integer> adventurerLevel4 = new HashMap<>();
        adventurerLevel4.put("DEF", 3);
        adventurerMap.put(4, adventurerLevel4);

        HashMap<String, Integer> adventurerLevel5 = new HashMap<>();
        adventurerLevel5.put("VIS", 1);
        adventurerLevel5.put("DEF", 4);
        adventurerMap.put(5, adventurerLevel5);


        return adventurerMap;


    }



}
