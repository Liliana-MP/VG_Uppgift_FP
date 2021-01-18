import java.util.ArrayList;
import java.util.List;

public class Elf {
    private String name;
    private List<Elf> subordinates = new ArrayList<>();
    private Elf boss;

    public Elf(String name){
        this.name = name;
    }

    public Elf(){

    }


    public List<Elf> getSubordinatesList() {
        return subordinates;
    }

    public String getName() {
        return name;
    }

    public void addSubordinates(Elf elf){
        subordinates.add(elf);
    }


    public void addBoss(Elf elf){
        boss = elf;
    }


}
