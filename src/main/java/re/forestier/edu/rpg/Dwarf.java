package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class Dwarf extends player{
    public Dwarf(String playerName, String avatar_name, int money, ArrayList<String> inventory) {
        super(playerName, avatar_name, money, inventory);

    }

    @Override
    public String getAvatarClass() {
        return "DWARF";
    }

    @Override
    public HashMap<String, Integer> getAvatarLevel(int level) {
        return initializeAbilitiesDwarf().get(level);
    }

    @Override
    public void majFinDeTour() {
        if(currenthealthpoints == 0) {
            System.out.println("Le joueur est KO !");
            return;
        }
        if(inventory.contains("Holy Elixir")) {
            AjoutVie(1);
        }
        AjoutVie(1);
    }


    private HashMap<Integer, HashMap<String, Integer>> initializeAbilitiesDwarf() {
        HashMap<Integer, HashMap<String, Integer>> dwarf = new HashMap<>();
        HashMap<String, Integer> dwarfLevel1 = new HashMap<>();
        dwarfLevel1.put("ALC", 4);
        dwarfLevel1.put("INT", 1);
        dwarfLevel1.put("ATK", 3);
        dwarf.put(1, dwarfLevel1);

        HashMap<String, Integer> dwarfLevel2 = new HashMap<>();
        dwarfLevel2.put("DEF", 1);
        dwarfLevel2.put("ALC", 5);
        dwarf.put(2, dwarfLevel2);

        HashMap<String, Integer> dwarfLevel3 = new HashMap<>();
        dwarfLevel3.put("ATK", 4);
        dwarf.put(3, dwarfLevel3);

        HashMap<String, Integer> dwarfLevel4 = new HashMap<>();
        dwarfLevel4.put("DEF", 2);
        dwarf.put(4, dwarfLevel4);

        HashMap<String, Integer> dwarfLevel5 = new HashMap<>();
        dwarfLevel5.put("CHA", 1);
        dwarf.put(5, dwarfLevel5);

        return dwarf;



    }

}
