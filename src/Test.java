import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you email: ");
        String email = sc.nextLine();
        Email mail = new Email();
        Email.sendMail(email);

        if(mail.isStatus()){
            System.out.print("Please enter confirmation code: ");
            int code = sc.nextInt();
            if(code == mail.getRandom()){
                System.out.println("User Authentication Passed!");
                System.out.println("Welcome!");
            }else{
                System.out.println("Sorry!");
            }
        }

    }
}
