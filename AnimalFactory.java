public abstract class AnimalFactory {

    //This is a simple factory. It takes the type, name and the age of the animal and returns the correct type of animal
    //There is nothing much about to say. Simple as it is. 
    //I have made the returnAnimal method static so that every other class could reach to it easily. 
    //Since it is not a frequently invoked method, it should not be a problem.
    
    public static Animal returnAnimal(String type, String name, int age ){
        if(type.equals("Cat")){
            return new Cat(name, age);
        }
        else if(type.equals("Bird")){
            return new Bird(name, age);
        }
        else return null;
    }
    
}
