public abstract class AnimalFactory {
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
