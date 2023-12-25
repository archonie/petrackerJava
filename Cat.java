
//The Cat class extends the Animal abstract class
public class Cat extends Animal{
    


    Cat(String name, int age) {
        super(name, age);
    }


    // The abstract method's implementation specific to the concrete Cat class.
    @Override
    public void cleanToilets() {
        if(!this.hasCleanToilet()){
            this.setHasCleanToilet(true);
            System.out.println(this.getName() + "'s litter has been filtered out.");
        }
        else{
            System.out.println(this.getName() +"'s litter is already filtered out.");
        }
    }   

    //The abstract method's implementation specific to the concrete Cat class
    @Override
    public void pet() {
        if(!this.isPetted()){
            this.setPetted(true);
            System.out.println(this.getName() + "'s belly has been scratched.");   
        }else{
            System.out.println(this.getName() + "'s belly is already scratched, but some more scratching won't kill anyone.");
        }
       
}

}
