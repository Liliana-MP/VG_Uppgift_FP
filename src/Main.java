import javax.swing.*;
import java.util.List;

/**
 * Created by Liliana Montini Pitra
 * Date: 2021-01-18
 * Time: 13:12
 * Project: VG_Uppgift_FP
 */
public class Main {
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
