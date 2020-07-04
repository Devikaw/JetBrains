import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
        
        Scanner scanner = new Scanner(System.in);
        Math.sqrt(6);
        
        System.out.println("Write how many ml of water the coffee machine has:");
        int totalWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int totalmilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int totalcoffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCups = scanner.nextInt();
        int count = 0;
        while(totalWater>=200 && totalmilk>=50 && totalcoffee>=15){
            totalWater = totalWater -200;
            totalmilk = totalmilk - 50;
            totalcoffee = totalcoffee -15;
            count++;
        } 
        if(count == numberOfCups){
            System.out.println("Yes, I can make that amount of coffee");
        }else if( count > numberOfCups){
            int extra = count-numberOfCups;
            System.out.println("Yes, I can make that amount of coffee (and even "+extra+" more than that)");
        }else{
            System.out.println("No, I can make only "+numberOfCups+" cup(s) of coffee");
        } 
        scanner.close();
    }
}
