package cabs;
import java.lang.Math; 

public class Pos implements IPos{

    private final double lat;
    private final double lng;

    public Pos(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }

    /*
     * Get Latitude
     */
    @Override
    public double getLat(){
        return lat;
    }

    /*
     * Get Longitude
     */
    @Override
    public double getLng(){
        return lng;
    }

    /*
     * Calculate distance between destination and current position
     */
    @Override
    public double distance(IPos dest){
        double x = Math.pow(2,Math.abs(this.getLat() - dest.getLat()));
        double y = Math.pow(2,Math.abs(this.getLng() - dest.getLng()));

        return Math.sqrt((x+y));
    }

    /*
     * Check if two positions are equal to eachother
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof IPos p){
            return p.getLng() == lng && p.getLat() == lat;
        }
        return false;
    }

    /*
     * Returns latitude,longitude
     */
    @Override
    public String toString(){
        return getLat() + "," + getLng(); 
    }
}