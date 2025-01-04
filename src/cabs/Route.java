package cabs;
import java.util.*;

import java.util.LinkedList;

public class Route implements IRoute{
    private List<IPos> pos;

    public Route(){
        pos = new LinkedList<>();
    }
    
    /*
     * Adds a new position at the end of the route
     */
    @Override
    public void appendPos(IPos p){
        pos.add(p);
    }

    /*
     * Gets the first element from list of routes
     */
    @Override
    public IPos getFirst(){
        if(pos.isEmpty()){
            return null;
        }else{
            return pos.get(0);
        }
    }

    /*
     * Removes first position from list of routes
     */
    @Override
    public void removeFirst(){
        if(!pos.isEmpty()){
            pos.remove(0);
        }
    }

    /*
     * Returns number of elements in the list of routes
     */
    @Override
    public int getNbPos(){
        return pos.size();
    }

    /*
     * Returns total length of the route
     */
    @Override
    public double getLength(){
        if(pos == null || pos.size() == 1){
            return 0;
        }else{
            double sum = 0; 
            for(int i = 1; i<pos.size(); i++){
                //Calculates the distance between each position in the route and sums the results
                sum += pos.get(i-1).distance(pos.get(i));
            }
            return sum; 
        }
    }

    /*
     * Returns all positions of the route with a - to separate them
     */
    @Override
    public String toString(){
        StringJoiner j = new StringJoiner("-");
        for (IPos p : pos){
            j.add(p.toString());
        }
        return j.toString(); 
    }

}
