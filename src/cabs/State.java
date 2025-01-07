package cabs;

import java.util.ArrayList;
import java.util.Collection;

public class State implements IUpdate{
    private Collection<ICabRoute> cabs;
    
    public State(){
        cabs = new ArrayList<>(); 
    }

    /*
     * Add a cab to the collection
     */
    public void addCab(ICabRoute r){
        cabs.add(r); 
    }    

    /*
     * Return cabs' collection
     */
    public Collection<ICabRoute> getCabs(){
        return cabs; 
    }
    
    /*
     * Handle the change of position in a group of cabs
     */
    @Override
    public void handleChangePos(ICabRoute cab, IPos pos){
        if(!cabs.contains(cab)) return;
        cab.setPos(pos);
    }

    /*
     * Handle adding passenger in a fleet of cabs
     */
    @Override
    public void handleEnter(ICabRoute cab, String passenger){
        if(!cabs.contains(cab)) return;
        try{
            cab.addPassenger(passenger);
        } catch(CabFullException x){
            System.out.println(x);
        }
    }

    /*
     * Handle removing passenger in a fleet of cabs
     */
    @Override
    public void handleExit(ICabRoute cab, String passenger){
        if(!cabs.contains(cab))return;
        cab.removePassenger(passenger);
    }
}