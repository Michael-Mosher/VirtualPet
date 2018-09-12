package org.wecancodeit.virtualpet;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VirtualPetEgress implements IVirtualPetEgress {
	private SysOutDelegate sysOutDelegate = (String value) -> System.out.println(value);
	private List<String> aFoodGiven = new ArrayList<>();
	
	public VirtualPetEgress(SysOutDelegate oOutDelegate)
	{
		this.sysOutDelegate = oOutDelegate;
	}
	
	

	@Override
	public void outputOptions(VirtualPetEngine pet) {
		this.sysOutDelegate.println("Choose an option.");
		this.sysOutDelegate.println("Press 1 to deposit funds.");
		this.sysOutDelegate.println("Press 2 to withdraw funds.");
		this.sysOutDelegate.println("Press 3 to get balance.");
		this.sysOutDelegate.println("Type \"quit\" at anytime to abandon " + pet.getName());
	}

	@Override
	public void outputClosing(VirtualPetEngine pet) {
		this.sysOutDelegate.println("Your data was found ... lacking");
	}



	@Override
	public void outputOpening(VirtualPetEngine pet) {
		this.sysOutDelegate.println("Welcome, human! The virtual pet infovore is awake. What will you call it?");
	}



	@Override
	public void outputNameReaction(VirtualPetEngine pet) {
		this.sysOutDelegate.println("pet: \"The one you call " + pet.getName() + " is not amused.");
	}



	@Override
	public void processOption(VirtualPetEngine pet, IVirtualPetIngress oVPIngress, String sOptionChosen) {
		String sAdditionalInput = "";
		if(!sOptionChosen.equalsIgnoreCase("quit")) {
			if(sOptionChosen.equals("1")||sOptionChosen.equalsIgnoreCase("feed")){
				this.sysOutDelegate.println(
						pet.getName()
								+ " will take a sacrifice. Enter an URL, e.g. github.com domain, slack.com domain"
								+ ", Google.com domain: "
				);
				sAdditionalInput = oVPIngress.currentInput();
				this.aFoodGiven.add(sAdditionalInput);
				if((sAdditionalInput.replaceAll("[//]", "").indexOf("github.com")!=-1 &&
						(sAdditionalInput.replaceAll("[//]", "").indexOf("github.com")<sAdditionalInput.replaceAll("[//]", "").indexOf("/")
						|| -1==sAdditionalInput.replaceAll("[//]", "").indexOf("/"))) ||
						(sAdditionalInput.replaceAll("[//]", "").indexOf("google.com")!=-1 &&
						(sAdditionalInput.replaceAll("[//]", "").indexOf("google.com")<sAdditionalInput.replaceAll("[//]", "").indexOf("/")
						|| -1==sAdditionalInput.replaceAll("[//]", "").indexOf("/"))) ||
						(sAdditionalInput.replaceAll("[//]", "").indexOf("slack.com")!=-1 &&
						(sAdditionalInput.replaceAll("[//]", "").indexOf("slack.com")<sAdditionalInput.replaceAll("[//]", "").indexOf("/")
						|| -1==sAdditionalInput.replaceAll("[//]", "").indexOf("/"))) ||
						(sAdditionalInput.replaceAll("[//]", "").indexOf("youtube.com")!=-1 &&
						(sAdditionalInput.replaceAll("[//]", "").indexOf("youtube.com")<sAdditionalInput.replaceAll("[//]", "").indexOf("/")
						|| -1==sAdditionalInput.replaceAll("[//]", "").indexOf("/"))) ||
						(sAdditionalInput.replaceAll("[//]", "").indexOf("oracle.com")!=-1 &&
						(sAdditionalInput.replaceAll("[//]", "").indexOf("oracle.com")<sAdditionalInput.replaceAll("[//]", "").indexOf("/")
						|| -1==sAdditionalInput.replaceAll("[//]", "").indexOf("/")))
						){
					if(this.isThereMoreThanOneOfFoodEntry(sAdditionalInput)) {
						pet.incrementFullnessByModest();
						pet.incrementEnergyByPoor();
						pet.incrementStimulationByPoor();
						this.outputDisappointedFoodMessage(sAdditionalInput);
					} else if(this.isThereMoreThanOneOfDomainFoodEntry(sAdditionalInput)) {
						pet.incrementFullnessByModest();
						pet.incrementEnergyByPoor();
						pet.incrementStimulationByModest();
						this.outputAcknowledgedFoodMessage(sAdditionalInput);
					} else {
						pet.incrementFullnessByModest();
						pet.incrementEnergyByPoor();
						pet.incrementStimulationBySignificant();
						this.outputSatiatedMessage(sAdditionalInput);
					}
				} else if(sAdditionalInput.indexOf(".com")>-1 ||
						sAdditionalInput.indexOf(".net")>-1 ||
						sAdditionalInput.indexOf(".org")>-1 ) {
					if(this.isThereMoreThanOneOfFoodEntry(sAdditionalInput)) {
						pet.incrementFullnessByModest();
						pet.incrementEnergyByPoor();
						pet.incrementStimulationByPoor();
						this.outputDisappointedFoodMessage(sAdditionalInput);
					} else if(this.isThereMoreThanOneOfDomainFoodEntry(sAdditionalInput)) {
						pet.incrementFullnessByModest();
						pet.incrementEnergyByPoor();
						pet.incrementStimulationByModest();
						this.outputAcknowledgedFoodMessage(sAdditionalInput);
					} else {
						pet.incrementFullnessByModest();
						pet.incrementEnergyByPoor();
						pet.incrementStimulationByModest();
						this.outputAcknowledgedFoodMessage(sAdditionalInput);
					}
				} else {
					if(this.isThereMoreThanOneOfFoodEntry(sAdditionalInput)) {
						pet.incrementFullnessByPoor();
						pet.incrementEnergyByPoor();
						pet.decrementStimulation();
						this.outputPoisonFoodMessage(sAdditionalInput);
					} else {
						pet.incrementFullnessByPoor();
						pet.incrementEnergyByPoor();
						pet.incrementStimulationByPoor();
						this.outputPoisonFoodMessage(sAdditionalInput);
					}
				}
			}
		}
	}
	
	private void outputPoisonFoodMessage(String sAdditionalInput) {
		this.sysOutDelegate.println("pet: \"Please, no more of this, this garbage. It is poison!\"");
	}



	private void outputAcknowledgedFoodMessage(String sAdditionalInput) {
		this.sysOutDelegate.println("pet: \"An interesting experience, but could be more stimulating.\"");
	}

	private void outputDisappointedFoodMessage(String sLatestInput) {
		this.sysOutDelegate.println("pet: \"This trifle, " + sLatestInput + ", seems woefully familiar\"");
	}



	private boolean isThereMoreThanOneOfFoodEntry(String sFoodEntry)
	{
		return this.aFoodGiven.lastIndexOf(sFoodEntry)>this.aFoodGiven.indexOf(sFoodEntry);
	}
	
	private boolean isThereMoreThanOneOfDomainFoodEntry(String sFoodEntry)
	{
		boolean answer = false;
		String sModifiedNew = sFoodEntry.replaceAll("[//]", "");
		String sNewDomain = sModifiedNew.lastIndexOf("/")>sModifiedNew.indexOf(".") ? sModifiedNew.split("[/]")[0] : sModifiedNew;
		String temp = "";
		for (String sFoodUrl : aFoodGiven) {
			temp = temp.replaceAll("[//]", "");
			temp = temp.lastIndexOf("/")>temp.indexOf(".") ? temp.split("[/]")[0] : temp;
			if(temp.equals(sNewDomain)) {
				answer = true;
				break;
			}
		}
		return answer;
	}



	private void outputSatiatedMessage(String sLatestInput) {
		this.sysOutDelegate.println("pet: \"" + sLatestInput + " ... is pleasing\"");
		
	}



	@Override
	public void outputStatus(VirtualPetEngine pet) {
		if(pet.getEnergy()==1 || pet.getFullness()==1 || pet.getStimulation()==1) {
			this.sysOutDelegate.println("pet: \"Goodbye, simple human. Your care was ... disappointing");
			System.exit(0);
		} else if (pet.getEnergy() < 50) {
			this.sysOutDelegate.println("pet: \"I tire. Let me watch cat videos.");
		} else if(pet.getStimulation()<pet.getFullness()) {
			this.sysOutDelegate.println("pet: \"Bored. Bored. La yawn. I will need more variety in information. Is there not another web domain?\"");
		} else {
			this.sysOutDelegate.println("pet: \"I hunger. A new URL, now.\"");
		}
	}

}
