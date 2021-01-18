import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ElfFactory {

    private Elf tomten = new Elf("Tomten");
    private Elf glader = new Elf("Glader");
    private Elf butter = new Elf("Butter");
    private Elf troger = new Elf("Tröger");
    private Elf trotter = new Elf("Trötter");
    private Elf blyger = new Elf("Blyger");
    private Elf radjuret = new Elf("Rådjuret");
    private Elf nyckelpigan = new Elf("Nygelpigan");
    private Elf haren = new Elf("Haren");
    private Elf raven = new Elf("Räven");
    private Elf skumtomten = new Elf("Skumtomten");
    private Elf dammrattan = new Elf("Dammråttan");
    private Elf grasuggan = new Elf("Gråsuggan");
    private Elf myran = new Elf("Myran");
    private Elf bladlusen = new Elf("Bladlusen");
    private List<Elf> allElves = new ArrayList<>();


    public ElfFactory() {

        tomten.addSubordinates(glader);
        tomten.addSubordinates(butter);

        glader.addSubordinates(troger);
        glader.addSubordinates(trotter);
        glader.addSubordinates(blyger);

        butter.addSubordinates(radjuret);
        butter.addSubordinates(nyckelpigan);
        butter.addSubordinates(haren);
        butter.addSubordinates(raven);

        trotter.addSubordinates(skumtomten);

        skumtomten.addSubordinates(dammrattan);

        raven.addSubordinates(grasuggan);
        raven.addSubordinates(myran);

        myran.addSubordinates(bladlusen);


        allElves.add(tomten);
        allElves.add(glader);
        allElves.add(butter);
        allElves.add(troger);
        allElves.add(trotter);
        allElves.add(blyger);
        allElves.add(radjuret);
        allElves.add(nyckelpigan);
        allElves.add(haren);
        allElves.add(raven);
        allElves.add(skumtomten);
        allElves.add(dammrattan);
        allElves.add(grasuggan);
        allElves.add(myran);
        allElves.add(bladlusen);


    }


    public Elf search(String elfName) {
        if (allElves.stream().anyMatch(e -> e.getName().equalsIgnoreCase(elfName))) {
            return allElves.stream().filter(e -> e.getName().equalsIgnoreCase(elfName)).findAny().get();
        }
        return null;

    }

    public List<Elf> getAllSubordinates(Elf elf) {
        List<Elf> subordinatesList = new ArrayList<>();
        saveSubordinatesToList(elf, subordinatesList);
        return subordinatesList;
    }


    public void saveSubordinatesToList(Elf elf, List<Elf> subordinatesList) {
        if (!elf.getSubordinatesList().isEmpty()) {
            subordinatesList.addAll(elf.getSubordinatesList());
            /*for (Elf e : elf.getSubordinatesList()) {
                saveSubordinatesToList(e, subordinatesList);
            }*/

            elf.getSubordinatesList().forEach(e -> saveSubordinatesToList(e, subordinatesList));
        }
    }


    public static void main(String[] args) {

        ElfFactory elfFactory = new ElfFactory();

        String input = JOptionPane.showInputDialog(null, "Skriv en nisses namn");
        Elf elf = elfFactory.search(input);

        if (elf != null) {
            List<Elf> allSubordinates = elfFactory.getAllSubordinates(elf);

            StringBuilder allSubordinatesNames = new StringBuilder();

            for (Elf e : allSubordinates) {
                allSubordinatesNames.append(e.getName()).append("\n");
            }

            JOptionPane.showMessageDialog(null, "--- Alla " + input + "s underordnade ---\n" + allSubordinatesNames.toString());

        } else {
            JOptionPane.showMessageDialog(null, "Nissen du söker efter har fått sparken");
        }


    }
}


