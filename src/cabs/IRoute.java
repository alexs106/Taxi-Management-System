package cabs;

public interface IRoute {
	public void appendPos(IPos p); // ajoute une position en fin de liste
	public IPos getFirst(); // première position de la liste, ou null
	public void removeFirst(); // supprime la première position de la liste
	public int getNbPos(); // nombre d'éléments de la liste de positions
	public double getLength(); // longueur totale du chemin
}
