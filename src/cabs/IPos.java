package cabs;

public interface IPos {
	public double getLat();  // latitude
	public double getLng(); // longitude
	public double distance(IPos dest);
}
