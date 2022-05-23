import java.util.*;

public class AVLTree {

    private AVLNode root = null;
    private int size = 0;

    public AVLTree (){
        root = null;
        size = 0;
    }

    public void insert (String FirstName, String LastName, String email, String mobile, String phone, String Job){
        root = insert(FirstName, LastName, email, mobile, phone,  Job, root);
    }

    private AVLNode insert (String FirstName, String LastName, String email, String mobile, String phone, String Job, AVLNode node){
        if (node == null){
            node = new AVLNode (FirstName, LastName, email, mobile, phone,  Job);
            size++;
            return node;
        }
        else{
            if (FirstName.compareTo (node.getFirstname()) < 0){
                node.setLeftChild (insert (FirstName, LastName, email, mobile, phone, Job, node.getLeftChild ()));
                if (height (node.getLeftChild ()) - height (node.getRightChild ()) == 2){
                    if (FirstName.compareTo ((node.getLeftChild ()).getFirstname()) < 0)
                        node = rotateWithLeft (node);
                    else
                        node = doubleWithLeft (node);
                }
            }
            else{
                if (FirstName.compareTo (node.getFirstname()) > 0){
                    node.setRightChild (insert (FirstName, LastName, email, mobile, phone, Job, node.getRightChild ()));
                    if (height (node.getRightChild ()) - height (node.getLeftChild ()) == 2){
                        if (FirstName.compareTo ((node.getRightChild ()).getFirstname()) > 0)
                            node = rotateWithRight (node);
                        else
                            node = doubleWithRight (node);
                    }
                }
            }
        }
        node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
        return node;
    }

    public AVLNode root(){
        return root;
    }

    public int size (){
        return size;
    }

    public int height (){
        return height (root);
    }

    private int height (AVLNode node){
        if (node == null)
            return -1;
        return node.getHeight ();
    }

    public boolean isEmpty (){
        return (size == 0);
    }

    private AVLNode rotateWithLeft (AVLNode node){
        AVLNode newNode = node.getLeftChild ();
        node.setLeftChild (newNode.getRightChild ());
        newNode.setRightChild (node);
        node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
        newNode.setHeight (max (height (newNode.getLeftChild ()), node.getHeight ()) + 1);
        return newNode;
    }


    private AVLNode rotateWithRight (AVLNode node){
        AVLNode newNode = node.getRightChild ();
        node.setRightChild (newNode.getLeftChild ());
        newNode.setLeftChild (node);
        node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
        newNode.setHeight (max (height (newNode.getRightChild ()), node.getHeight ()) + 1);
        return newNode;
    }

    private AVLNode doubleWithLeft (AVLNode node){
        node.setLeftChild (rotateWithRight (node.getLeftChild ()));
        return rotateWithLeft (node);
    }


    private AVLNode doubleWithRight (AVLNode node){
        node.setRightChild (rotateWithLeft (node.getRightChild ()));
        return rotateWithRight (node);
    }

    public static int max (int first, int second){
        if (first >= second)
            return first;
        else
            return second;
    }
    public boolean Disply (){
        return Disply (root);
    }

    private boolean Disply (AVLNode node){

        if (node == null)
            return false;
            System.out.println("\n----------------- Next Contact ------------------\n");
            System.out.println("   "+node.getFirstname()+" " + node.getLastName()+ "\n     Email: "+node.getEmail()+ "\n     Mobile: "+node.getMobile()+"\n     Phone: "+ node.getPhone()+ "\n     Profession: "+node.getJob()+".");
            Disply ( node.getLeftChild ());
             Disply ( node.getRightChild ());
        return true;
    }

    public boolean SBFirst(String FirstName){
        if (SBFirst(FirstName, root))
        return true;
        System.out.println("---Contact Not Found---");
        return false;
    }

    private boolean SBFirst(String FirstName, AVLNode node){

        if (node == null)
            return false;
        if (node.getFirstname().toLowerCase().contains(FirstName.toLowerCase())){
            System.out.println("------Found!------\n");
            System.out.println("   "+node.getFirstname()+" " + node.getLastName()+ "\n     Email: "+node.getEmail()+ "\n     Mobile: "+node.getMobile()+"\n     Phone: "+ node.getPhone()+ "\n     Profession: "+node.getJob()+".");
            return true;}

        if (FirstName.toLowerCase().compareTo (node.getFirstname().toLowerCase()) < 0)
            return SBFirst(FirstName, node.getLeftChild ());

        if (FirstName.toLowerCase().compareTo (node.getFirstname().toLowerCase()) > 0)
            return SBFirst(FirstName, node.getRightChild ());
        return true;
    }

    public boolean SBLast(String LastName){
        if (SBLast(LastName, root))
            return true;
        System.out.println("---Contact Not Found---");
        return false;
    }
    private boolean SBLast(String LastName, AVLNode node){


        if (node == null)
            return false;
boolean found = false;
        if (node.getLastName().toLowerCase().contains(LastName.toLowerCase())){
            System.out.println("------Found!------\n");
            System.out.println("   "+node.getFirstname()+" " + node.getLastName()+ "\n     Email: "+node.getEmail()+ "\n     Mobile: "+node.getMobile()+"\n     Phone: "+ node.getPhone()+ "\n     Profession: "+node.getJob()+".");
            return true;}
        if (node.getLeftChild() !=null)
            found=SBLast(LastName,node.getLeftChild());
        if (found==true)
            return true;
        if (node.getRightChild() != null)
            found=SBLast(LastName,node.getRightChild());
        return found;
        // the following code doesn't seem to be working , as the tree is sorted by First name only , any attempts to sort it by both  First name and Last name would render most of the contacts missing.
//        if (node.getLastName().toLowerCase().contains(LastName.toLowerCase())){
//            System.out.println("------Found!------\n");
//            System.out.println("   "+node.getFirstname()+" " + node.getLastName()+ "\n     Email: "+node.getEmail()+ "\n     Mobile: "+node.getMobile()+"\n     Phone: "+ node.getPhone()+ "\n     Profession: "+node.getJob()+".");
//            return true;}
//        if (LastName.toLowerCase().compareTo (node.getLastName().toLowerCase()) < 0)
//            return SBLast(LastName, node.getLeftChild ());
//
//        if (LastName.toLowerCase().compareTo (node.getLastName().toLowerCase()) > 0)
//            return SBLast(LastName, node.getRightChild ());
//        return true;
    }

    public boolean SBEmail(String email){
        if (SBEmail(email, root))
            return true;
        System.out.println("---Contact Not Found---");
        return false;
    }

    private boolean SBEmail(String Email, AVLNode node) {

        if (node == null)
            return false;
        boolean found = false;
        if (node.getEmail().toLowerCase().contains(Email.toLowerCase())) {
            System.out.println("------Found!------\n");
            System.out.println("   " + node.getFirstname() + " " + node.getLastName() + "\n     Email: " + node.getEmail() + "\n     Mobile: " + node.getMobile() + "\n     Phone: " + node.getPhone() + "\n     Profession: " + node.getJob() + ".");
            return true;
        }
        if (node.getLeftChild() != null)
            found = SBEmail(Email, node.getLeftChild());
        if (found == true)
            return true;
        if (node.getRightChild() != null)
            found = SBEmail(Email, node.getRightChild());
        return found;
    }
    public boolean SBJob(String Job){
        if (SBJob(Job, root))
            return true;
        System.out.println("---No Contacts Were Found!---");
        return false;
    }
    private boolean SBJob(String Job, AVLNode node) {

        if (node == null)
            return false;
        boolean found = false;
        if (node.getJob().toLowerCase().contains(Job.toLowerCase())) {
            System.out.println("\n----------------- Next Contact ------------------\n");
            System.out.println("   " + node.getFirstname() + " " + node.getLastName() + "\n     Email: " + node.getEmail() + "\n     Mobile: " + node.getMobile() + "\n     Phone: " + node.getPhone() + "\n     Profession: " + node.getJob() + ".");
            found = true;
        }
        if (node.getLeftChild() != null)
            found = SBJob(Job, node.getLeftChild());
        if (node.getRightChild() != null)
            found = SBJob(Job, node.getRightChild());
        return found;
    }


    public String[] getBestMatches(String word, int limit) {
        if (SBFirst(word.toLowerCase(), root))
            return new String[] { word };
        if (word.length() <= 1)
            return new String[0];
        // strip off last letter and search for first node that "starts with" the term
        String searchTerm = word;
        AVLNode bestPartialMatchedNode = null;
        do {
            searchTerm = searchTerm.substring(0, word.length() - 1).toLowerCase();
            bestPartialMatchedNode = getBestPartialMatch(searchTerm, root);
        }
        while (searchTerm.length() > 1 && bestPartialMatchedNode == null);
        if (bestPartialMatchedNode == null)
            return new String[0];            // nothing to suggest
        LinkedList<String> bestMatches = new LinkedList<String>();
        LinkedList<AVLNode> currentLevel = new LinkedList<AVLNode>();
        LinkedList<AVLNode> nextLevel = new LinkedList<AVLNode>();
        currentLevel.push(bestPartialMatchedNode);
        while(!currentLevel.isEmpty() && bestMatches.size() < limit){
            AVLNode node = currentLevel.pollLast();
            if (node != null) {
                if (node.getFirstname().startsWith(searchTerm))
                    bestMatches.add(node.getLastName());
                if(node.getLeftChild() != null)
                    nextLevel.push(node.getLeftChild());
                if(node.getRightChild() != null)
                    nextLevel.push(node.getRightChild());
                if (currentLevel.isEmpty()) {
                    LinkedList<AVLNode> temp = nextLevel;
                    nextLevel = currentLevel;
                    currentLevel = temp;
                }
            }
        }
        Collections.sort(bestMatches);
        return bestMatches.toArray(new String[bestMatches.size()]);
    }

    private AVLNode getBestPartialMatch(String key, AVLNode node) {
        if (node == null)
            return null;
        if (node.getFirstname().startsWith(key))
            return node;
        if (key.compareTo (node.getFirstname()) < 0)
            return getBestPartialMatch (key, node.getLeftChild ());
        if (key.compareTo (node.getFirstname()) > 0)
            return getBestPartialMatch (key, node.getRightChild ());
        return null;
    }

    public void remove (String FirstName,String LastName) {
        AVLNode parent = null;
        AVLNode target = null;
        AVLNode node = root;

        // need a non-recusrive search alogorithm, because we have to
        // not only find the target node, but it's parent as well
        while (target == null && node != null){
            if (FirstName.compareTo(node.getFirstname()) < 0 ){
                parent = node;
                node = node.getLeftChild ();
            }
            else if (FirstName.compareTo(node.getFirstname()) > 0 ){
                parent = node;
                node = node.getRightChild ();
            }
            else if (LastName.toLowerCase().contains(node.getLastName().toLowerCase())){
                // ok, we've found the node we want to delete
                target = node;
            }else break;
        }
        if (target == null) { // target not found, nothing to delete
            System.out.println("Contact Not Found");
            return;
        }
        // we need to find a replcement node to our target node
        // in the tree.
        AVLNode replacement = null;
        // seek a replacement node if there are two children
        if (target.getLeftChild() != null || target.getRightChild() != null){
            replacement = getReplacementRecursive(target.getLeftChild(), target, target);
        }
        else{
            // the replacement node is the node that exists
            if (target.getLeftChild() != null)
                replacement = target.getLeftChild();
            else
                replacement = target.getRightChild();
        }
        if (replacement != null){    // the replacement was a leaf node, so we can safely
            // dock the target's children on to the replacement
            replacement.setLeftChild(target.getLeftChild());
            replacement.setRightChild(target.getRightChild());
            updateHeight(replacement);
        }
        if (root == target){
            root = replacement;
        }
        else{
            if (parent.getLeftChild() == target)
                parent.setLeftChild(replacement);
            else
                parent.setRightChild(replacement);
        }
        System.out.println("Contact Deleted Successfully !");
        size--;
    }

    private AVLNode getReplacementRecursive(AVLNode node, AVLNode parent, AVLNode target){
        if (node == null)
            return parent;
        AVLNode replacement = getReplacementRecursive(node.getRightChild(), node, target);
        if (parent.getRightChild() == replacement){
            parent.setRightChild(null);
            if (parent.getLeftChild() == null && parent != target)
                parent.setHeight(parent.getHeight() -1);
        }
        else{
            updateHeight(parent);
        }
        return replacement;
    }

    private void updateHeight(AVLNode node){
        int iLeftHeight = -1;
        int iRightHeight = -1;
        if (node.getLeftChild() != null)
            iLeftHeight = node.getLeftChild().getHeight();
        if (node.getRightChild() != null)
            iRightHeight = node.getRightChild().getHeight();
        node.setHeight(max(iLeftHeight, iRightHeight) + 1);
    }
}