package cabs;

import java.util.Set;

public interface ICab {	
	public IPos getPos(); // getter de position
	public void setPos(IPos pos); // setter de position
	
	public int getCapacity(); // nombre maximal de passagers autorisé 
	public void addPassenger(String s) throws CabFullException; // un passager monte dans le taxi
	public void removePassenger(String s); // un passager descend du taxi
	public Set<String> getPassengers(); // les passagers dans le taxi
}
