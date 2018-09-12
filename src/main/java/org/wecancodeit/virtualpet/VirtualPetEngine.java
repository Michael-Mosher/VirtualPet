package org.wecancodeit.virtualpet;

import java.util.Observable;

public class VirtualPetEngine extends Observable {

	private int fullness;
	private int stimulation;
	private int energy;
	protected int fullness_minimum = 1;
	protected int stimulation_minimum = 1;
	protected int energy_minimum = 1;
	private String name = "";
	private int iAbstractAge = 0;

	/**
	 * The constructor for an Infovore (just calling it VirtualPet for the project, but will extended VirtualPet on next chapter)
	 * @param fullness
	 * @param stimulation
	 * @param energy
	 */
	public VirtualPetEngine(int fullness, int stimulation, int energy) {
		this.fullness = fullness;
		this.stimulation = stimulation;
		this.energy = energy;
	}

	public int getFullness() {
		return this.fullness;
	}

	public void decrementFullness() {
		if(this.fullness>(9 + this.fullness_minimum)) {
			this.fullness -= 10;
		} else {
			this.fullness = this.fullness_minimum;
		}
	}
	
	/**
	 * Decrease pet's Fullness by a specified, non-negative, amount, but not that would cause it to be less than 1.
	 * @param decrement
	 */
	public void decrementFullnessBy(int decrement) {
		if(decrement>0) {
			if(this.fullness> (decrement + this.fullness_minimum)) {
				this.fullness -= decrement;
			} else {
				this.fullness = this.fullness_minimum;
			}
		}
	}

	public int getStimulation()
	{
		return this.stimulation;
	}

	public void decrementStimulation() {
		if(this.stimulation> (10 + this.stimulation_minimum) ){
			this.stimulation -= 10;
		} else {
			this.stimulation = this.stimulation_minimum;
		}
		
	}

	public void decrementStimulationBy(int decrement)
	{
		if(decrement>0) {
			if(this.stimulation>(decrement + this.stimulation_minimum) ) {
				this.stimulation -= decrement;
			} else {
				this.stimulation = this.stimulation_minimum;
			}
		}
	}

	public int getEnergy() {
		return this.energy;
	}

	public void decrementEnergy() {
		if(this.energy > (10 + this.energy_minimum) ){
			this.energy -= 10;
		} else {
			this.energy = this.energy_minimum;
		}
	}

	public void decrementEnergyBy(int decrement) {
		if(decrement>0) {
			if(this.energy > (decrement + this.energy_minimum) ) {
				this.energy -= decrement;
			} else {
				this.energy = this.energy_minimum;
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String sInstanceName) {
		this.name = sInstanceName;
	}
	
	public void incrementFullnessByTotal()
	{
		this.fullness = 100;
	}
	
	public void incrementFullnessBySignificant()
	{
		int magnitude = 20;
		if(100-magnitude > this.fullness) {
			this.fullness += magnitude;
		} else this.fullness = 100;
	}
	
	public void incrementFullnessByModest()
	{
		int magnitude= 10;
		if(100-magnitude > this.fullness) {
			this.fullness += magnitude;
		} else this.fullness = 100;
	}
	
	public void incrementFullnessByPoor()
	{
		int magnitude= 0;
		if(100-magnitude > this.fullness) {
			this.fullness += magnitude;
		}
	};
	
	public void incrementEnergyByTotal()
	{
		this.energy = 100;
	}
	
	public void incrementEnergyBySignificant()
	{
		int magnitude= 20;
		if(100-magnitude > this.energy) {
			this.energy += magnitude;
		} else this.energy = 100;
	}
	
	public void incrementEnergyByModest()
	{
		int magnitude= 10;
		if(100-magnitude > this.energy) {
			this.energy += magnitude;
		} else this.energy = 100;
	}
	
	public void incrementEnergyByPoor()
	{
		this.energy += 0;
	}
	
	public void incrementStimulationByTotal()
	{
		this.stimulation = 100;
	}
	
	public void incrementStimulationBySignificant()
	{
		int magnitude = 20;
		if(100-magnitude > this.stimulation) {
			this.stimulation += magnitude;
		} else this.stimulation = 100;
	}
	
	public void incrementStimulationByModest()
	{
		int magnitude = 10;
		if(100-magnitude > this.stimulation) {
			this.stimulation += magnitude;
		} else this.stimulation = 100;
	}
	
	public void incrementStimulationByPoor()
	{
		this.stimulation += 0;
	}
	
	public void incrementAge()
	{
		this.iAbstractAge++;
	}
	
	public int getAge()
	{
		return this.iAbstractAge;
	}
}
