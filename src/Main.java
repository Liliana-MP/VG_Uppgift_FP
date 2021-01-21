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
        String input;
        int choice;

        while (true) {

            input = JOptionPane.showInputDialog(null, "Skriv en nisses namn");
            if (input == null) {
                System.exit(0);
            }

            Elf elf = elfFactory.search(input);

            if (elf != null) {
                List<Elf> allSubordinates = elfFactory.getAllSubordinates(elf);

                StringBuilder allSubordinatesNames = new StringBuilder();

                for (Elf e : allSubordinates) {
                    allSubordinatesNames.append(e.getName()).append("\n");
                }

                JOptionPane.showMessageDialog(null, "--- Alla " + input + "s underordnade ---\n" + allSubordinatesNames.toString());
                choice =JOptionPane.showConfirmDialog(null, "Vill du söka igen?","Tomteverkstad", JOptionPane.YES_NO_OPTION);
                if (choice == 1){
                    System.exit(0);
                }


            } else {
                JOptionPane.showMessageDialog(null, "Nissen du söker efter har fått sparken");
                choice = JOptionPane.showConfirmDialog(null, "Vill du söka igen?","Tomteverkstad", JOptionPane.YES_NO_OPTION);
                if (choice == 1){
                    System.exit(0);
                }
            }
        }


    }
}
