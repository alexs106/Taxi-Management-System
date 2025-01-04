package cabs;

@SuppressWarnings("serial")
public class CabFullException extends Exception{
    public CabFullException(){
        super("Cab is full"); 
    }
}