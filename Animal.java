
public abstract class Animal {
    
    private String name;
    private int age;
    private boolean hasWater = false;
    private boolean hasFood = false;
    private boolean isPetted = false;
    private boolean hasCleanToilet = false;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //The template method for taking care of an Animal.
    public final void careAnimal(){
        System.out.println("");
        feed();
        fillWater();
        cleanToilets();
        pet();
        System.out.println("");
    }
    
    //These methods have different implementations for different types of Animals. Will show them in the concrete animal classes.
    public abstract void cleanToilets();
    public abstract void pet();
    
    //The following methods have similar implementations for different types of Animals. So, I have implemented them here.
    public void feed(){
        if(!this.hasFood()){
            this.setHasFood(true);
            System.out.println(this.getName() + " has been given food.");
        }
        else{
            System.out.println(this.getName() + " is already fed.");
        }
    }

    
    public void fillWater(){
        if(!this.hasWater()){
            this.setHasWater(true);
            System.out.println(this.getName()+ "'s water bowl has been filled.");
        }
        else{
            System.out.println(this.getName()+ "'s water bowl is already filled");
        }
    }
 

    //The testing method which turns every attribute to false.
    public void twelveHours(){
       this.hasWater = false;
       this.hasFood = false;
       this.isPetted = false;
       this.hasCleanToilet = false; 
    }



    //The getters and setters.
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean hasWater() {
        return hasWater;
    }
    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }
    public boolean hasFood() {
        return hasFood;
    }
    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }
    public boolean isPetted() {
        return isPetted;
    }
    public void setPetted(boolean isPetted) {
        this.isPetted = isPetted;
    }
    public boolean hasCleanToilet() {
        return hasCleanToilet;
    }
    public void setHasCleanToilet(boolean hasCleanToilet) {
        this.hasCleanToilet = hasCleanToilet;
    }
   
}

