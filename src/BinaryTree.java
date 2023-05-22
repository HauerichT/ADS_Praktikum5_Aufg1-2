public class BinaryTree extends Tree {
    Tree root = null;

    /* Method to add a new node to the tree */
    public void addTree(String b) {

        // Checks if the current tree is empty
        if (is_Empty(root)) {
            this.root = bin(null, b, null);
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
                    currentNode = left(currentNode);
                    // Checks if the left child has no child
                    if (is_Empty(currentNode)) {
                        // Place the new node
                        parent.left = bin(null, b, null);
                        return;
                    }
                } else {
                    currentNode = right(currentNode);
                    // Checks if the right child has no child
                    if (is_Empty(currentNode)) {
                        // Place the new node
                        parent.right = bin(null, b, null);
                        return;
                    }
                }
            }
        }
    }

    /* Method to remove a tree */
    public Tree removeTree(String value) {
        return null;
    }

    /* Method to modify a tree */
    public Tree modifyTree(String value) {
        return null;
    }

    public void preorderTraverseTree(Tree currentTree) {
        if (currentTree != null) {
            System.out.println(currentTree);
            preorderTraverseTree(left(currentTree));
            preorderTraverseTree(right(currentTree));
        }
    }

    public void inorderTraverseTree(Tree currentTree) {
        if (currentTree != null) {
            preorderTraverseTree(left(currentTree));
            System.out.println(currentTree);
            preorderTraverseTree(right(currentTree));
        }
    }

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