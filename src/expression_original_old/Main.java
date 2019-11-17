package expression_original_old;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No path for test file given");
            System.exit(0);
        }
        Element expr = null;
        try(Scanner scan = new Scanner(new File(args[0]))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] info = line.split(":");
                // System.out.println(info[0] + " " + info[1].trim());
                info[1] = info[1].trim();
                switch (info[0]) {
                    case ElementComponent.element:
                        expr = ElementFactory.createElement(info[1]);
                        break;
                    case ElementComponent.name:
                        ElementFactory.checkElementType(expr);

                        if (expr instanceof Button) {
                            ((Button) expr).setName(info[1]);
                        }
                        break;
                    case ElementComponent.type:
                        ElementFactory.checkElementType(expr);

                        if (expr instanceof Button) {
                            ((Button) expr).setButtonType(info[1]);
                        }
                        break;
                    case ElementComponent.value:
                        ElementFactory.checkElementType(expr);

                        if (expr instanceof Button) {
                            ((Button) expr).setValue(info[1]);
                        }
                        break;
                }
            }
            if (expr != null) {
                System.out.println(expr.generate());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
