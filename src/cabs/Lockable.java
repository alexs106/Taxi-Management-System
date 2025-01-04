package cabs;

import java.util.Set;

public class Lockable implements ICab{
    private ICab cab;
    private boolean locked = false;

    public Lockable(ICab c){
        this.cab = c; 
    }

    /*
     * Set the status of cab, it's either locked or not
     */
    public void setLocked(boolean locked){
        this.locked = locked; 
    }

    /*
     * Get position of the cab
     */
    @Override
    public IPos getPos(){
        return cab.getPos();
    }

    /*
     * Set the position of the cab
     */
    @Override
    public void setPos(IPos pos){
        cab.setPos(pos);
    }

    /*
     * Get capacity  of the taxi, if it isn't locked.
     * Else, the capacity is 0
     */
    @Override
    public int getCapacity(){
        return locked ? 0 : cab.getCapacity(); 
    }

    /*
     * Add a passenger to the taxi if it isn't locked.
     * Else, it throws a CabFullException
     */
    @Override
    public void addPassenger(String s) throws CabFullException{
        if(locked){
            throw new CabFullException();
        }
        cab.addPassenger(s);
    }

    @Override
    public void removePassenger(String s){
        cab.removePassenger(s);
    }

    @Override
    public Set<String> getPassengers() {
        return cab.getPassengers(); 
    }

}