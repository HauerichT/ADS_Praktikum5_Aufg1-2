public class BinaryTree extends Tree {
    Tree root = null;

    /* Method to add a new node to the tree */
    public void addTree(String b) {
        // Counter to get height of Tree element
        int heightCounter = 1;
        // Checks if the current tree is empty
        if (this.root == null) {
            this.root = bin(null, b, null);
            root.height = heightCounter;
            System.out.println("Added!");
        } else {
            // Sets root as the starting point
            Tree currentNode = root;
            // Future parent of our new node
            Tree parent;

            // Search for point to set new node
            while (true) {
                // Sets parent to current focused node
                parent = currentNode;
                // Checks if the key of the node to add is lower than the current focused node
                if (b.compareTo(value(currentNode)) < 0) {
                    heightCounter++;
                    currentNode = left(currentNode);
                    // Checks if the left child has no child
                    if (is_Empty(currentNode)) {
                        // Place the new node
                        parent.left = bin(null, b, null);
                        parent.left.height = heightCounter;
                        System.out.println("Added!");
                        return;
                    }
                } else {
                    heightCounter++;
                    currentNode = right(currentNode);
                    // Checks if the right child has no child
                    if (is_Empty(currentNode)) {
                        // Place the new node
                        parent.right = bin(null, b, null);
                        parent.right.height = heightCounter;
                        System.out.println("Added!");
                        return;
                    }
                }
            }
        }
    }

    /* Method to remove a tree */
    public Tree removeTree(Tree curTree, String value) {
        // Delete root if children are null
        if (root.left == null && root.right == null) {
            System.out.println("Deleted!");
            this.root = null;
            return null;
        }

        // Checks if value of tree to remove is bigger than current
        if (value.compareTo(value(curTree)) > 0) {
            curTree.right = removeTree(curTree.right, value);
        } else if (value.compareTo(value(curTree)) < 0) {   // Checks if value of tree to remove is smaller than current
            curTree.left = removeTree(curTree.left, value);
        } else {    // If both values are equal
            if (curTree.left == null && curTree.right == null) {    // Checks if tree has no children
                System.out.println("Deleted!");
                curTree = null;
            } else if (curTree.right != null) { // Checks if tree has no right children
                Tree curTreeTemp = curTree.right;
                while(curTreeTemp.left != null){
                    curTreeTemp = curTreeTemp.left;
                }
                curTree.value = value(curTreeTemp);
                curTree.right = removeTree(curTree.right, curTree.value);
            } else {    // Checks if tree has no left children
                Tree curTreeTemp = curTree.left;
                while(curTreeTemp.right != null){
                    curTreeTemp = curTreeTemp.right;
                }
                curTree.value = value(curTreeTemp);
                curTree.left = removeTree(curTree.left, curTree.value);
            }
        }

        return curTree;
    }


    /* Method to modify a tree */
    public void modifyTree(Tree root, String valueNew, String valueOld) {
        removeTree(root, valueOld);
        addTree(valueNew);
        System.out.println("Modified: " + valueOld + " -> " + valueNew);
    }

    /* Method to traverse tree pre-ordered */
    public void preorderTraverseTree(Tree currentTree) {
        if (currentTree != null) {
            System.out.println(currentTree);
            preorderTraverseTree(left(currentTree));
            preorderTraverseTree(right(currentTree));
        }
    }

    /* Method to traverse tree in order */
    public void inorderTraverseTree(Tree currentTree) {
        if (currentTree != null) {
            preorderTraverseTree(left(currentTree));
            System.out.println(currentTree);
            preorderTraverseTree(right(currentTree));
        }
    }

    /* Method to find Tree based on value */
    public Tree findTree(String value) {
        // Start with the root element
        Tree currentTree = root;

        // Search while we have not found the searched key
        while (value.compareTo(value(currentTree)) != 0) {
            // Check if we have to search in left tree
            if (value.compareTo(value(currentTree)) < 0) {
                // Sets the left child of the current element as next element
                currentTree = currentTree.left;
            } else {
                // Sets the right child of the current element as next element
                currentTree = currentTree.right;
            }
            // Checks if the node can not be found
            if (is_Empty(currentTree)) return null;
        }

        // Returns the node which has the searches key
        return currentTree;
    }
}