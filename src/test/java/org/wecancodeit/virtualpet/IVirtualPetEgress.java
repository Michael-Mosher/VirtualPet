package org.wecancodeit.virtualpet;

public interface IVirtualPetEgress {

	public void outputOpening(VirtualPetEngine pet);
	public void outputOptions(VirtualPetEngine pet);

	public void outputClosing(VirtualPetEngine pet);
	public void outputNameReaction(VirtualPetEngine pet);
	public void processOption(VirtualPetEngine pet, IVirtualPetIngress oVPIngress, String sOptionChosen);
	public void outputStatus(VirtualPetEngine pet);
}
