//The observer interface has an update method.
public interface Observer {
    public void updateNeeds(boolean hasFood, boolean hasWater, boolean hasCleanToilet, boolean isPetted);
}
