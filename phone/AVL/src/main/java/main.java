import java.io.IOException;
import java.util.Scanner;
// Name: Omar ElHassan Mohamed Sadek                ID: 20100291
//Name:  khaled bahaaeldin ahmed mohammed           ID:20100238
public class main {
    public static void main(String[] args) throws IOException {
        AVLTree tree = new AVLTree();
        Read.Read_ip r = new Read.Read_ip();
        r.Read_ip1(tree);
        Scanner scanner = new Scanner(System.in);

        // print menu






        boolean quit = false;

        int menuItem;

        do {

            System.out.println("-------- MENU --------");
            System.out.println("1. Display all contacts");
            System.out.println("2. add new contact");
            System.out.println("3. delete a contact");
            System.out.println("4. Search for a contact with First name");
            System.out.println("5. Search for a contact with Last name");
            System.out.println("6. Search for a contact with Email");
            System.out.println("7. Disply Contacts with Same Profession");
            System.out.println("8. Quit\n----------------------");

            menuItem = scanner.nextInt();

            switch (menuItem) {

                case 1:
                    tree.Disply();
                    System.out.println();
                    break;

                case 2:
                    String firstname,lastname,email,mobile,phone,profession;
                    System.out.println("Please enter the First name");
                    firstname = scanner.next();
                    System.out.println("Please enter the Last name");
                    lastname= scanner.next();
                    System.out.println("Please enter the Email");
                    email = scanner.next();
                    System.out.println("Please enter the Mobile Number");
                    mobile = scanner.next();
                    System.out.println("Please enter the Phone number ");
                    phone = scanner.next();
                    System.out.println("Please enter the Profession");
                    profession = scanner.next();

                    tree.insert(firstname,lastname,email,mobile,phone,profession);
                    break;

                case 3:
                    String FirstName,LastName;
                    System.out.println("Please enter the First Name");
                    FirstName = scanner.next();
                    System.out.println("Please enter the Last Name");
                    LastName = scanner.next();
                    tree.remove(FirstName,LastName);
                    break;
                case 4:
                        System.out.println("Please enter the First Name:");
                    tree.SBFirst(scanner.next());
                    break;

                case 5:

                    System.out.println("Please enter the Last Name :");

                    tree.SBLast(scanner.next());
                    break;

                case 6:
                    System.out.println("Please enter the Email :");
                tree.SBEmail(scanner.next());
                break;

                case 7:
                    System.out.println("Please enter the Profession :");
                    tree.SBJob(scanner.next());
                    break;
                case 8:


                    quit = true;

                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (!quit);

        System.out.println("Bye-bye!");

    }
}


