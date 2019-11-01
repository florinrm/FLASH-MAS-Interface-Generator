import expression.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Element expr = null;
        try(Scanner scan = new Scanner(new File("input1.txt"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] info = line.split(":");
                // System.out.println(info[0] + " " + info[1].trim());
                info[1] = info[1].trim();
                if (info[0].equals(ElementComponent.type)) {
                    expr = ElementFactory.createElement(info[1]);
                } else if (info[0].equals(ElementComponent.name)) {
                    if (expr == null) {
                        System.err.println("Error: element type not specified, cannot set name");
                        throw new ElementNotCreatedException();
                    }

                    if (expr instanceof Button) {
                        ((Button) expr).setName(info[1]);
                    }
                }
            }
            if (expr != null) {
                System.out.println(expr.generate());
            }
        } catch (FileNotFoundException | ElementNotCreatedException e) {
            e.printStackTrace();
        }
    }
}
