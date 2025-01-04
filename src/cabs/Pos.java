package cabs;
import java.lang.Math; 

public class Pos implements IPos{

    private final double lat;
    private final double lng;

    public Pos(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public double getLat(){
        return lat;
    }

    @Override
    public double getLng(){
        return lng;
    }

    @Override
    public double distance(IPos dest){
        double x = Math.pow(2,Math.abs(this.getLat() - dest.getLat()));
        double y = Math.pow(2,Math.abs(this.getLng() - dest.getLng()));

        return Math.sqrt((x+y));
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof IPos p){
            return p.getLng() == lng && p.getLat() == lat;
        }
        return false;
    }

    @Override
    public String toString(){
        return getLat() + "," + getLng(); 
    }
}