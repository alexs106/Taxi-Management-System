package cabs;

public class CabRoute extends Cab implements ICabRoute{
    private IRoute route; 

    public CabRoute(int capacity, IPos pos){
        super(capacity,pos); 
        route = new Route(); 
    }

    /*
     * Returns the route from CabRoute
     */
    @Override
    public IRoute getRoute(){
        return route; 
    }

    @Override
    public void setPos(IPos pos){
        if(route.getFirst()!=null && route.getFirst().equals(pos)){
            route.removeFirst();
        }
        super.setPos(pos);
    }


}