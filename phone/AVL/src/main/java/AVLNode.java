public class AVLNode {

    private String Firstname = null;
    private String LastName = null;

    private String email = null;

    private String mobile = null;

    private String phone = null;

    private String Job = null;
    private AVLNode leftChild = null;
    private AVLNode rightChild = null;
    private int height = 0;


    public AVLNode (String FirstName, String LastName,String email,String mobile, String phone, String Job){
        this.Firstname = FirstName;
        this.LastName = LastName;
        this.email = email;
        this.mobile = mobile;
        this.phone = phone;
        this.Job = Job;
        leftChild = null;
        rightChild = null;
        height = 0;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPhone() {
        return phone;
    }

    public String getJob() {
        return Job;
    }

    public String getFirstname(){
        return Firstname;
    }

    public String getLastName(){
        return LastName;
    }

    public AVLNode getLeftChild (){
        return leftChild;
    }

    public void setLeftChild (AVLNode n)
    {
        leftChild = n;
    }

    public AVLNode getRightChild (){
        return rightChild;
    }

    public void setRightChild (AVLNode n){
        rightChild = n;
    }

    public int getHeight (){
        return height;
    }

    public void setHeight (int h){
        height = h;
    }
}