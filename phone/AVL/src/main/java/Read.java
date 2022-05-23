import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Read {

    public static class Read_ip {
        Read_ip(){

        }

        public void Read_ip1(AVLTree tree1) throws IOException {

            File file = new File(
                    "C:\\Users\\MSI\\Desktop\\phone\\contacts-data.txt");
            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            String Reading ;
            while ((Reading = br.readLine()) != null) {
                String[] Line = Reading.split(",");
                String FirstName = Line[0];
                String LastName = Line[1];
                String email = Line[2];
                String mobile = Line[3];
                String phone = Line[4];
                String Job = Line[5];
                tree1.insert(FirstName,LastName,email,mobile,phone,Job);
//                System.out.println(s1 + " " + s2);


            }
            br.close();
            return;
        }
    }
}
