package cabs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiCab implements ICab{
    private List<ICab> cabs; 

    public MultiCab(){
        cabs = new ArrayList<>(); 
    }

    /*
     * Adds a cab to the list of cabs
     */
    public void addCab(ICab c){
        cabs.add(c); 
    }

    /*
     * Set the position of all the cabs in the list
     */
    @Override
    public void setPos(IPos pos){
        for(ICab c : cabs){
            c.setPos(pos);
        }
    }

    /*
     * Gets the position of all cabs.
     * Since their position is the same, we can get the position from the first cab.
     */
    @Override
    public IPos getPos(){
        return cabs.get(0).getPos(); 
    }

    /*
     * Gets the sum of all the taxis' capacities 
     */
    @Override
    public int getCapacity(){
        int res = 0;
        for(ICab c : cabs){
            res += c.getCapacity(); 
        }
        return res; 
    }

    /*
     * Add a new passenger in the first cab with availability.
     * If none are free, then we raise a CabFullException
     */
    @Override
    public void addPassenger(String s) throws CabFullException{
        for(ICab c : cabs){
            if(c.getCapacity() > 0){
                c.addPassenger(s);
                return ;
            }
        }   
        throw new CabFullException(); 
    }

    /*
     * Remove passenger from the taxi that has them
     */
    @Override
    public void removePassenger(String s){
        for(ICab c : cabs){
            if(c.getPassengers().contains(s)){
                c.removePassenger(s);
            }
        }
    }

    /*
     * Get the passenger list from all of the cabs
     */
    @Override
    public Set<String> getPassengers(){
        Set<String> s = new HashSet<>();
        for(ICab c : cabs){
            s.addAll(c.getPassengers()); 
        }
        return s; 
    }


}