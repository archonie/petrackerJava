public class Bird extends Animal{

    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void cleanToilets() {
        if(!this.hasCleanToilet()){
            this.setHasCleanToilet(true);
            System.out.println(this.getName() +"'s cage has been cleaned.");
        }
        else{
            System.out.println(this.getName()+ "'s cage is already clean.");
        }
    }

    @Override
    public void pet() {
        if(!this.isPetted()){
            this.setPetted(true);
            System.out.println(this.getName() + "'s head has been scratched.");   
        }else{
            System.out.println(this.getName() + "'s head is already scratched, but more scratching won't kill anyone.");
        }
    }

}
