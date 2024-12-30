package cabs;

public class Request {
	private final int nb;
	private final IPos org, dest;
	
	public Request(int nb, IPos org, IPos dest) {
		this.nb = nb;
		this.org = org;
		this.dest = dest;
	}
	
	public int getNb() { return nb; }
	public IPos getOrg() { return org; }
	public IPos getDest() { return dest; }
}
