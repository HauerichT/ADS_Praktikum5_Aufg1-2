class Tree {
    String value;
    int height;
    Tree left;
    Tree right;

    private Tree(Tree x, String b, Tree y) {
        this.left = x;
        this.value = b;
        this.right = y;
    }

    public Tree() {}

    public Tree right(Tree tree) {
        return tree.right;
    }

    public Tree left(Tree tree) {
        return tree.left;
    }

    public Tree bin(Tree x, String b, Tree y) {
        return new Tree(x,b,y);
    }

    public boolean is_Empty(Tree tree) {
        return tree == null;
    }

    public String value(Tree tree) {
        return tree.value;
    }

    public String toString() {
        if (this.left != null && this.right != null) {
            return this.value + " (height=" + height + "): " + this.left.value + " (height=" + this.left.height + ")" + ", " + this.right.value + " (height=" + this.right.height + ")";
        } else if (this.left == null && this.right != null) {
            return this.value + " (height=" + height + "): null, " + this.right.value + " (height=" + this.right.height + ")";
        } else if (this.left != null) {
            return this.value + " (height=" + height + "): " + this.left.value + " (height=" + this.left.height + ")" + ", null";
        } else {
            return this.value + " (height=" + height + "): null, null";
        }
    }
}