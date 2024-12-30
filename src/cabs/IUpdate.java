package cabs;

public interface IUpdate {
	public void handleChangePos(ICabRoute cab, IPos pos); // un taxi s’est déplacé
	public void handleEnter(ICabRoute cab, String passenger); // un passager est monté dans un taxi
	public void handleExit(ICabRoute cab, String passenger); // un passager est descendu d’un taxi
}
