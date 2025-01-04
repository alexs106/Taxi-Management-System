package cabs;

import java.util.*; 

public class Cab implements ICab{

    private IPos pos;
    private Set<String> passengers = new HashSet<>();
    private int capacity;

    public Cab(int capacity, IPos pos){
        this.capacity = capacity;
        this.pos = pos; 
    }

    /*
     * Get the position of the taxi
     */
    @Override
    public IPos getPos(){
        return pos; 
    }

    /*
     * Modify the position of the taxi
     */
    @Override
    public void setPos(IPos pos){
        this.pos = pos; 
    }

    /*
     * Returns the capacity of the taxi
     */
    @Override
    public int getCapacity(){
        return capacity; 
    }

    /*
     * Adds new passenger as long as the cab still has place
     */
    @Override
    public void addPassenger(String s) throws CabFullException{
        if(!passengers.contains(s) && this.capacity <= passengers.size()){
            throw new CabFullException(); 
        }else{
            passengers.add(s); 
        }
    }

    /*
     * Removes a passenger from the taxi
     */
    @Override
    public void removePassenger(String s){
        passengers.remove(s); 
    }

    /*
     * Displays the list of passengers inside the cab
     */
    @Override
    public Set<String> getPassengers(){
        return passengers; 
    }
    
}