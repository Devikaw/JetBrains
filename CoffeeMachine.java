import java.util.Scanner;

public class CoffeeMachine {   
	static Scanner scanner = new Scanner(System.in);
    static Status status;
    
	public enum Status{
		BUY("buy"),
		FILL("fill"),
		TAKE("take"),
		REMAINING("remaining"),
		ESPRESSO("1"),
		LATTE("2"),
		CAPPUCCINO("3"),
		BACK("4"),
		EXIT("exit");
		
		String input;
		
		Status(String input){
			this.input = input;
		}
		
		public static Status findByInput(String ip) {
	        for (Status value: values()) {
	            if (ip.equals(value.input)) {
	                return value;
	            }
	        }
	        return null;
	    }
	}
	
	 static class MyMachine{	
		 int totalWater = 400;
         int totalMilk = 540;
         int totalCoffee = 120;
         int totalCups = 9;
         int totalMoney = 550;
         boolean stopped = false;
		
		 public void buy_drink() {
				System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, 4 - back");
				switch(Status.findByInput(getUserInput())) {
				case ESPRESSO:if(totalWater>=250 && totalCoffee>=16) {
					System.out.println("I have enough resources, making you a coffee!");
					totalCups = totalCups - 1;
					totalWater = totalWater - 250;
					totalCoffee = totalCoffee - 16;
					totalMoney = totalMoney + 4; 
					}else {
						if(totalWater<250)
							System.out.println("Sorry, not enough water!");
						if(totalCoffee<16)
							System.out.println("Sorry, not enough coffee beans!");
					}
					break;
				case LATTE:if(totalWater>=350 && totalMilk>=75 && totalCoffee>=20) {
					System.out.println("I have enough resources, making you a coffee!");
					totalCups = totalCups - 1;
					totalWater = totalWater - 350;
					totalMilk = totalMilk - 75;
					totalCoffee = totalCoffee - 20;
					totalMoney = totalMoney + 7; 
					}else {
						if(totalWater<350)
							System.out.println("Sorry, not enough water!");
						if(totalMilk<75)
							System.out.println("Sorry, not enough milk!");
						if(totalCoffee<20)
							System.out.println("Sorry, not enough coffee beans!");
					}
					break;
				case CAPPUCCINO:if(totalWater>=200 && totalMilk>=100 && totalCoffee>=12) {
					System.out.println("I have enough resources, making you a coffee!");
					totalCups = totalCups - 1;
					totalWater = totalWater - 200;
					totalMilk = totalMilk - 100;
					totalCoffee = totalCoffee - 12;
					totalMoney = totalMoney + 6; 
					}else {
						if(totalWater<200)
							System.out.println("Sorry, not enough water!");
						if(totalMilk<100)
							System.out.println("Sorry, not enough milk!");
						if(totalCoffee<12)
							System.out.println("Sorry, not enough coffee beans!");
					}
					break;
				case BACK:
					break;
				default:
					break;
				}
		 }
		
		 public void fill_machine() {
				System.out.println("Write how many ml of water do you want to add:");
				totalWater = totalWater + Integer.parseInt(getUserInput());
				System.out.println("Write how many ml of milk do you want to add:");
				totalMilk = totalMilk + Integer.parseInt(getUserInput());;
				System.out.println("Write how many grams of coffee beans do you want to add:");
				totalCoffee = totalCoffee + Integer.parseInt(getUserInput());;
				System.out.println("Write how many disposable cups of coffee do you want to add:");
				totalCups = totalCups + Integer.parseInt(getUserInput());;
		}
		
		public void take_money() {
			System.out.println("I gave you $"+totalMoney);
			totalMoney = 0;
		}
		
		public void print() {
			System.out.println("The coffee machine has:");
	        System.out.println(totalWater+" of water");
	        System.out.println(totalMilk+" of milk");
	        System.out.println(totalCoffee+" of coffee beans");
	        System.out.println(totalCups+" of disposable cups");
	        System.out.println("$"+totalMoney+" of money");
		}
		
		
	}
		
	public static String getUserInput() {
		String input = scanner.next();
		return input;			
	}
	
	public static void main(String[] args) {
		MyMachine machine = new MyMachine();
		do {
		    System.out.println("Write action(buy, fill, take, remaining, exit):");
		    status = Status.findByInput(scanner.next());
		    switch(status) {
		    	case BUY:
		    		machine.buy_drink();
		    		break;
		    	case FILL:
		        	machine.fill_machine();
		        	break;
		        case TAKE:
		        	machine.take_money();
		        	break;
		        case REMAINING:
		        	machine.print();
					break;
		        case EXIT:
		        	machine.stopped = true;
		        	break;
		        default:	
		    }
		}while(!machine.stopped);
        
        scanner.close();
    }
}
