import java.util.*;
public class Atminterface {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> str = new ArrayList<>();
    public static void Transaction(float bal){
        for(String i : str){
            System.out.println(i);
        }
        Ask(bal);
    }
    public static void Transfer(float bal , float amount){
        if((amount <= bal)&& (amount >= 0)){
            System.out.println("Enter Account Name: ");
            String account_name = sc.next();
            bal-=amount;
            System.out.println(amount +" ruppee/s sent to "+account_name);
            System.out.println("Transaction successful....");
            System.out.println("Balance is "+bal);
            str.add(amount+" Transfered to amount "+account_name);
            Ask(bal);
        }
        else{
            System.out.println("Enter amount :");
            Transfer(bal,sc.nextFloat());
        }
    }
    public static void Login(String username , int pin){
        if(username.contains("Moudika") && pin == 1073){
            str.add("Logged in");
            Ask(10000);
        }
        else{
            System.out.println("Enter valid info !");
            System.out.println("Username follwed by pin seperated with a space :");
            Login(sc.next() , sc.nextInt());
        }
    }
    public static void Deposit(float bal , float amount ){
        if(amount >= 0){
            bal += amount;
            System.out.println("Transaction successful");
            System.out.println("Balance is "+bal);
            str.add(amount + "ruppee/s deposited!");
            Ask(bal);
        }
        else{
            System.out.println("Enter amount :");
            Deposit(bal,sc.nextFloat());
        }
    }
    public static void Withdraw(float bal , float amount ){
        if(amount <= bal && amount >= 0){
            bal-= amount;
            System.out.println("Transaction successful , current balance is "+bal);
            str.add("Rupees/s" +amount +"Withdraw.");
            Ask(bal);
        }
        else{
            System.out.println("Enter amount");
            Withdraw(bal,sc.nextFloat());
        }
    }
    public static void Quit(float bal , String quickResponse){
        if(quickResponse.equals("Yes") || quickResponse.equals("Yes")){
            System.out.println("Logged out");
            System.out.println();
        }
        else{
            Ask(bal);
        }
    }
    public static void Ask(float bal){
        System.out.println();
        System.out.println("Choose the action :");
        System.out.println(" 1 -> Transaction History.");
        System.out.println(" 2 -> Transfer");
        System.out.println(" 3 -> Deposit");
        System.out.println(" 4 -> Withdraw");
        System.out.println(" 5 -> Exit");
        int Operation =sc.nextInt();
        System.out.println();
        switch (Operation){
            case 1:
                System.out.println("History");
                Transaction(bal);
                break;
            case 2 :
                System.out.println("Enter transferred amount :");
                Transfer(bal,sc.nextInt());
                break;
            case 3:
                System.out.println("Enter deposit amount :");
                Deposit(bal,sc.nextInt());
                break;
            case 4:
                System.out.println("Enter Withdraw amount :");
                Withdraw(bal,sc.nextInt());
                break; 
            case 5:
                System.out.println("Do you want to exit ?");
                System.out.println("Yes");
                System.out.println("No");
                String quickResponse = sc.next();
                Quit(bal,quickResponse);
                break;
        }
    }
    public static void main(String[] args) {
        System.out.println("ATM");
        System.out.println("LOGIN");
        System.out.println("Enter username :");
        String username = sc.next();
        System.out.println("Enter pin no :");
        int pin = sc.nextInt();
        Login(username, pin);
    }
}