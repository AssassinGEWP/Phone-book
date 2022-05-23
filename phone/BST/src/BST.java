public class BST {
    class TNode
    {
        int data;
        TNode left, right;

        public TNode(int item)
        {
            data = item;
            left=right = null;
        }
    }
    TNode root;
    BST(){
        root = null;
    }
    public void insert(int data) {root = InsertRec(root,data);}

    TNode InsertRec (TNode root, int data) {
        if (root == null) {
            root = new TNode(data);
            return root;
        }
        if (data <root.data){
            root.left= InsertRec(root.left,data);
        } else if (data >root.data) {
            root.right = InsertRec(root.right, data);
        }
        return root;
    }

    public void InOrder() {InOrderRec(root);}


    public void InOrderRec(TNode root) {
        if (root !=null) {
            InOrderRec(root.left);
            System.out.println(root.data);
            InOrderRec(root.right);
        }
    }
    public void PostOrder(){PostOrderRec(root);}

    public void PostOrderRec(TNode root) {
        if (root != null) {
            PostOrderRec(root.left);
            PostOrderRec(root.right);
            System.out.print(root.data + "  ");
        }
    }
    public void PreOrder(){PreOrderRec(root);}
    public void PreOrderRec(TNode root) {
        if (root != null) {
            System.out.print(root.data+ " ");
            PostOrderRec(root.left);
            PostOrderRec(root.right);
        }
    }
    public void DelteValue(int value){ root = DeleteRec(root,value);}
    TNode DeleteRec(TNode root, int value) {
        if (root == null){
            return root;
        }if (value < root.data) {
            root.left = DeleteRec(root.left,value);
        }else if (value> root.data) {
            root.right = DeleteRec(root.right,value);
        } else {
            if (root.left == null){
                return root.right;
            }else if ( root.right == null) {
                return root.left;
            }
        }
        return root;
    }
    public int MinValue(TNode root)  {
        int Min = root.data;

        while (root.left != null)  {
            Min = root.left.data;
            root = root.left;
        }
        return Min;
    }
    public boolean Search(int value)  {
        TNode current = root ;
        current = SearchRec(current, value);
        if (current != null)
            return true;
        else
            return false;
    }

    TNode SearchRec(TNode root, int value)  {
        if (root==null || root.data==value){
            return root;
        }
        if (root.data > value){
            return SearchRec(root.left, value);
        }
        else {
            return SearchRec(root.right, value);
        }
    }
}
