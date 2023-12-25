import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main
 */
public class Test {
    public static void main(String[] args) {
        boolean isUsing = true;
        Tracker tracker = Tracker.getInstance();
        Scanner scan = new Scanner(System.in);
        ArrayList<String> options = new ArrayList<String>();
    
        addOptions(options);
        System.out.print("*****Welcome to PeTracker*****\n");
        while(isUsing){
                printOptions(options);
                int choice = scan.nextInt();
                scan.nextLine();
                if(choice == 0){
                    tracker.twelveHoursPassed();
                    System.out.print("Do you want to continue testing? (y/n)");
                    String chooseContinue = scan.nextLine().trim();
                    if(chooseContinue.equals("y")){
                        isUsing = true;
                        
                    }
                    else if(chooseContinue.equals("n")){
                        isUsing = false;
                        System.out.println("Thanks for using PeTracker! Goodbye!\n");
                    }
                    else{
                        System.out.println("You have entered an invalid character.");
                    }
                }
                else if(choice == 1){
                    Person newPerson = addUser(scan);
                    tracker.registerObserver(newPerson);
                    System.out.println("\n*New user " + newPerson.getName() + " " + newPerson.getSurname() + " has been added.*\n");
                }
                else if(choice == 2){
                    Person existing = addUser(scan);
                    tracker.removeObserver(existing);
                }
                else if(choice == 3){

                    System.out.print("Please enter new pet's type (Cat or Bird): ");
                    String type = scan.nextLine().trim();
                    // if(type.equals("Cat")){
                    System.out.print("Please enter new pet's name: ");
                    String name = scan.nextLine().trim();
                    System.out.print("Please enter new pet's age: ");
                    int age = scan.nextInt();
                    scan.nextLine();
                    tracker.addAnimal(AnimalFactory.returnAnimal(type, name, age));
                    //     tracker.addAnimal(new Cat(name, age));    
                    // }
                    // else if (type.equals("Bird")){
                    //     System.out.print("Please enter new pet's name: ");
                    //     String name = scan.nextLine().trim();
                    //     System.out.print("Please enter new pet's age: ");
                    //     int age = scan.nextInt();
                    //     scan.nextLine();
                    //     tracker.addAnimal(new Bird(name, age));
                    // }
                    // else{System.out.println("You have entered an invalid type!");}
                }   
                else if(choice == 4){
                    System.out.print("Please enter a pet name: ");
                    String petName = scan.nextLine().trim();
                    tracker.careAnimal(petName);
                }
                else if(choice == 5){
                    tracker.careAnimals();
                }
                else if(choice == 6){
                    System.out.print("Please enter a pet name: ");
                    String petName = scan.nextLine().trim();
                    tracker.removeAnimal(petName);
                }
                else{
                    System.out.println("\n*Please enter a valid option integer.*\n");
                }
            }
           

        } 




    public static Person addUser(Scanner scan){
        System.out.print("Please enter new user's name: ");
        String name = scan.nextLine().trim();
        System.out.print("Please enter new user's surname: ");
        String surname = scan.nextLine().trim();
        return new Person(name, surname);
    }
    
    public static void addOptions(ArrayList<String> options){
        options.add("1 - Add new user.");
        options.add("2 - Remove existing user.");
        options.add("3 - Add new pet.");
        options.add("4 - Take care of a pet.");
        options.add("5 - Take care of all pets.");
        options.add("6 - Remove existing pet.");
        options.add("0 - *12 hours later*.");
    }
    public static void printOptions(ArrayList<String> options){
        System.out.println("What would you like to do?\n");
        for (String string : options) {
            System.out.println(string);
            
        }
        System.out.print("Please enter your choice: ");
    }
}