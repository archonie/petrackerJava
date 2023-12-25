import java.util.ArrayList;

public class Tracker implements Subject{
    private ArrayList<Animal> animals;
    private static Tracker uniqueInstance;
    private ArrayList<Observer> observers;
    AnimalFactory animalFactory;
    
    private Tracker(){
        this.animals = new ArrayList<Animal>();
        this.observers = new ArrayList<Observer>();
    }
    
    //This is the getInstance method, it returns one and only one Tracker instance. The word synchronized prevents the multi-thread
    //activities from happening.
    public static synchronized Tracker getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Tracker();
        }
        return uniqueInstance;
    }


    //Animal related methods such as adding, removing and taking care of an animal. Will show them in the Animal class.
    public void addAnimal(Animal animal){
        for (Animal existing : animals) {
            if(existing.getName().equals(animal.getName()) && existing.getClass() == animal.getClass()){
                System.out.println("\n*" + existing.getName() + " is already in the pack!*\n");
                return;
            }else{
                continue;
            }
        }
        animals.add(animal);
        System.out.println("\n*"+animal.getName() + " is the new member of the pack!*\n");
    }
    public void removeAnimal(String name){
        for (Animal animal : animals) {
            if(animal.getName().equals(name)){
                animals.remove(animal); 
                System.out.println("\n*" +animal.getName() + " is no longer a member of the pack!*\n");
                return;
            }
        }
        System.out.println("\n*No such pet in your pack!*\n");
    }
    

    //careAnimal method is just 10 lines of code, if you use the interface to interact with the animal.
    public void careAnimal(String name){
        for (Animal animal : animals) {
            if(animal.getName().equals(name)){
                animal.careAnimal(); 
                notifyObservers();
                return;
            }
        }
        System.out.println("\n*No such pet in your pack!*\n");
    }
    
    //This is even shorter thanks to the careAnimal method.
    public void careAnimals(){
        for (Animal animal : animals) {
            animal.careAnimal();
        }
    }



    //The following are the mandatory methods of subject interface.
    
    //This method is for registering new users to the tracker.
    @Override
    public void registerObserver(Observer o) {
        if(!observers.contains(o)){
            observers.add(o);
        }
    }

    // I have messed up here a little, I have strongly violate the loose-couple principle but I couldn't find another way to remove an observer.
    @Override
    public void removeObserver(Observer o) {
        for (Observer observer : observers) {
            if(observer instanceof Person && o instanceof Person){
                if(((Person)observer).getName().equals(((Person)o).getName()) && ((Person)observer).getSurname().equals(((Person)o).getSurname())){
                    observers.remove(observer);
                    System.out.println("\n*" + ((Person)observer).getName() + " " + ((Person)observer).getSurname() + " has been removed from users.*\n" );
                    return;
                }
            }
        }
        System.out.println("\n*No such user.*\n");
    }
    
    //This method is for notifying all the observers (People) about the pets' needs.
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            for (Animal animal : animals) {
                o.updateNeeds(animal.hasFood(), animal.hasWater(), animal.hasCleanToilet(),animal.isPetted());
            }
        }
    }

    //The following are the wrong implementations that i have made
    // I have implemented all the care methods inside of this class unnecessarily
    // Before careAnimal method it was such a mess in here.
    // There are almost 50 lines of wrong implementation.
    
    
    // public void feedAll(ArrayList<Animal> animals){
    //     for (Animal animal : animals) {
    //         animal.feed();
    //     }
    //     System.out.println("");
    // }
    // public void giveMedicine(Animal animal){
    //     // if(animal.isSick() && !animal.isMedicineGiven()){
    //     //     animal.setMedicineGiven(true);
    //     //     animal.setMedicineLeft(animal.getMedicineLeft() - 1);
    //     //     System.out.println(animal.getName() + " got its medicine.");
    //     //     if(animal.getMedicineLeft() == 0){
    //     //         animal.setSick(false);
    //     //         System.out.println(animal.getName() + " is no longer sick.");
    //     //     }
    //     // }
    //     // else{
    //     //     System.out.println(animal.getName() + " is not sick or already had medicine. You can not give another medicine.");
    //     // }

    //     animal.giveMedicine();
    //     System.out.println("");
        
    // }
    // // public void fillWater(Animal animal){
    // //     if(!animal.hasWater()){
    // //         animal.setHasWater(true);
    // //         System.out.println(animal.getName() + "'s water is full now.");
    // //     }
    // //     else{
    // //         System.out.println(animal.getName() + "'s water is already full.");
    // //     }
    // // }
    // public void fillAllCups(ArrayList<Animal> animals){
    //     for (Animal animal : animals) {
    //         animal.fillWater();
    //     }
    //     System.out.println("");
    // }
    // public void pet(Animal animal){
    //     // animal.setPetted(true);
    //     // System.out.println(animal.getName() + " is happy.");
    //     animal.pet();
    // }
    // public void cleanToilets(ArrayList<Animal> animals){
    //     for (Animal animal : animals) {
    //         animal.cleanToilets();
    //     }
    //     System.out.println("");
    // }
    
    //A test method to simulate 12 hours later in the real world. 
    public void twelveHoursPassed(){
        for (Animal animal : animals) {
            animal.twelveHours();
        }
        System.out.println("--------------------------------- 12 hours passed --------------------------------- \n");
        notifyObservers();
    }
    

    //The getters and setters.
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    public ArrayList<Observer> getObservers() {
        return observers;
    }
    
    public ArrayList<Animal> getAnimals(){
        return animals;
    }
      
}
