import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        /* menu to get input */
        Scanner scanner = new Scanner(System.in);
        String input;
        int inputInt = 0;
        do {
            System.out.println("----- Menü -----");
            System.out.println("1. Einfügen");
            System.out.println("2. Löschen");
            System.out.println("3. Modifizieren");
            System.out.println("4. Baumausgabe (preorder)");
            System.out.println("5. Baumausgabe (inorder)");
            System.out.println("6. Programm schließen");
            System.out.print("Menüpunkt wählen: ");
            input = scanner.next(); // get menu choice

            System.out.println();

            // check if menu choice input is digit
            if (input.matches("[0-9]+")) {
                inputInt = Integer.parseInt(input);

                switch (inputInt) {
                    case 1 -> {
                        System.out.println("Bitte Value des neuen Knotens eingeben: ");
                        String inputValue = scanner.next();
                        if (binaryTree.root == null) {  // checks if tree is empty
                            binaryTree.addTree(inputValue);
                        } else if (binaryTree.findTree(inputValue) == null) {  // checks if tree is empty and key is not in current tree
                            binaryTree.addTree(inputValue);
                        } else {
                            System.out.println("Value bereits im Tree!");
                        }
                    }
                    case 2 -> System.out.println("löschen");
                    case 3 -> System.out.println("modifizieren");
                    case 4 -> {
                        if (binaryTree.root == null) System.out.println("Tree ist leer!");
                        else binaryTree.preorderTraverseTree(binaryTree.root);
                    }
                    case 5 -> {
                        if (binaryTree.root == null) System.out.println("Tree ist leer!");
                        else binaryTree.inorderTraverseTree(binaryTree.root);
                    }
                    case 6 -> System.out.println("Verlassen...");
                }

                System.out.println();
            }


        } while (inputInt != 6);
        scanner.close();
    }
}
