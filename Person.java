public class Person implements Observer{
    private String name, surname;
    
 
    
    
    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public void updateNeeds(boolean hasFood, boolean hasWater, boolean hasCleanToilet, boolean isPetted) {
        if(!(hasFood && hasWater && hasCleanToilet && isPetted)){
            System.out.println("\n*"+this.name + " " + this.surname + " has been notified about pets' needs.*\n");
        }
    }
    

}
