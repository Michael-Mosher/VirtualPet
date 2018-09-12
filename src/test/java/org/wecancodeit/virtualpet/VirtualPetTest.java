package org.wecancodeit.virtualpet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;

import org.junit.Test;


public class VirtualPetTest implements IVirtualPetIngress, IVirtualPetEgress {
	
	VirtualPetEngine petTest = new VirtualPetEngine(100, 100, 100);
	private String lastSysOutMessage = "";
	
	/*
	 * Horace the Hippo
Hunger: 27 // Fullness
Thirst: 5  // Hydration
Boredom: 5 // Stimulation
Tiredness: 50 // Energy

What do you want to do?
1. Feed Horace
2. Water Horace
3. Play with Horace
4. Put Horace to sleep
5. Do nothing

Infovore edition
 Fullness
 * Stimulation
 * Energy
	 */
	
	@Test
	public void assertTheFullnessStatusIs100WhenInitial100NoTicks()
	{
		// assemble
		//	VirtualPet petTest = new VirtualPet(100, 100, 100);
		// execute
		int fullness = petTest.getFullness();
		// assert
		assertThat(fullness, is(100));
	}
	
	@Test
	public void assertTheFullnessStatusIs90AfterTickNoEatInitial100()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementFullness();
		int fullness = petTest.getFullness();
		// assert
		assertThat(fullness, is(90));
	}
	
	@Test
	public void assertTheFullnessIs1WhenDecrementTenTimes()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementFullness();
		petTest.decrementFullness();
		petTest.decrementFullness();
		petTest.decrementFullness();
		petTest.decrementFullness();
		petTest.decrementFullness();
		petTest.decrementFullness();
		petTest.decrementFullness();
		petTest.decrementFullness();
		petTest.decrementFullness();
		int fullness = petTest.getFullness();
		// assert
		assertThat(fullness, is(1));
	}
	
	@Test
	public void assertTheFullnessis95WhenDecrementBy5Initial100()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementFullnessBy(5);
		int fullness = petTest.getFullness();
		// assert
		assertThat(fullness, is(95));
	}
	
	@Test
	public void assertTheFullnessIs100WhenDecrementByNegative5Initial100()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementFullnessBy(-5);
		int fullness = petTest.getFullness();
		// assert
		assertThat(fullness, is(100));
	}
	
	@Test
	public void assertTheStimulationIs100WhenNoTickInitial100()
	{
		// assemble
		//	VirtualPet petTest = new VirtualPet(100, 100, 100);
		// execute
		int stimulation = petTest.getStimulation();
		// assert
		assertThat(stimulation, is(100));		
	}
	
	@Test
	public void assertTheStimulationIs90WhenOneDecrementInitial100()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementStimulation();
		int stimulation = petTest.getStimulation();
		// assert
		assertThat(stimulation, is(90));
	}
	
	@Test
	public void assertTheStimulationIs95WhenDecrementBy5Initial100()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementStimulationBy(5);
		int stimulation = petTest.getStimulation();
		// assert
		assertThat(stimulation, is(95));
	}
	
	@Test
	public void assertTheStimulationIs1WhenDecrementTenTimes()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		petTest.decrementStimulation();
		
		int stimulation = petTest.getStimulation();
		// assert
		assertThat(stimulation, is(1));
	}
	
	@Test
	public void assertTheStimulationIs100WhenDecrementByMinus5Initial100()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementStimulationBy(-5);
		int stimulation = petTest.getStimulation();
		// assert
		assertThat(stimulation, is(100));
	}
	
	@Test
	public void assertTheEnergyIs100WithoutTicksInitial100()
	{
		int energy = petTest.getEnergy();
		assertThat(energy, is(100));
	}
	
	@Test
	public void assertTheEnergyIs1WhenDecrementTenTimes()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		petTest.decrementEnergy();
		
		int energy = petTest.getEnergy();
		// assert
		assertThat(energy, is(1));
	}
	
	@Test
	public void assertTheEnergyIs100WhenDecrementByMinus5Initial100()
	{
		// assemble
//		VirtualPet petTest = new VirtualPet(100, 100, 100);
		//execute
		petTest.decrementEnergyBy(-5);
		int energy = petTest.getEnergy();
		// assert
		assertThat(energy, is(100));
	}
	
	@Test
	public void assertInputQuitWillExitVirtualPetApp()
	{
		String sExpectedOut = new String("Your data was found ... lacking");
		VirtualPetApp.setSysOutDelegate((value) -> this.lastSysOutMessage  = value);
		String sInputPayload = "Ralf\nquit\n";
		VirtualPetApp.setSysInDelegate(
				new ByteArrayInputStream(
						sInputPayload.getBytes()
						)
				);
		// act
		VirtualPetApp.main(new String[0]);
		// assert
		assertThat(this.lastSysOutMessage, is(sExpectedOut));
	}
	
	@Test
	public void assertInputGithubAddressWillGiveSatiatedMessage()
	{
		String sExpectedOut = new String("pet: \"This is the satiated message\"");
		VirtualPetApp.setSysOutDelegate((value) -> this.lastSysOutMessage  = value);
		String option = "1"; //feed
		String sFeedPayload = new String("https://github.com/Michael-Mosher/Module3ShoppingCart");
		String sInputPayload = "Ralf\n" + option + "\n" + sFeedPayload + "\nquit\n";
		VirtualPetApp.setSysInDelegate(
				new ByteArrayInputStream(
						sInputPayload.getBytes()
						)
				);
		VirtualPetApp.setIsTesting();
		// act
		VirtualPetApp.main(new String[0]);
		// assert
		assertThat(this.lastSysOutMessage, is(sExpectedOut));
	}

	@Override
	public void outputOpening(VirtualPetEngine pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outputOptions(VirtualPetEngine pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outputClosing(VirtualPetEngine pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outputNameReaction(VirtualPetEngine pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processOption(VirtualPetEngine pet, IVirtualPetIngress oVPIngress, String sOptionChosen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outputStatus(VirtualPetEngine pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String currentInput() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Test
//	public void assertInputGithubAddressTwiceWillGiveDisappointedMessage()
//	{
//		String sExpectedOut = new String("pet: \"This is the disappointed message\"");
//		VirtualPetApp.setSysOutDelegate((value) -> this.lastSysOutMessage  = value);
//		String option = "1"; //feed
//		String sFeedPayload = new String("https://github.com/Michael-Mosher/Module3ShoppingCart");
//		String sInputPayload = "Ralf\n" + option + "\n" + sFeedPayload + "\n" + option + "\n" + sFeedPayload + "\nquit\n";
//		VirtualPetApp.setSysInDelegate(
//				new ByteArrayInputStream(
//						sInputPayload.getBytes()
//						)
//				);
//		VirtualPetApp.setIsTesting();
//		// act
//		VirtualPetApp.main(new String[0]);
//		// assert
//		assertThat(this.lastSysOutMessage, is(sExpectedOut));
//	}
	
	/*
	 * @Test
	public void consolePinThatMatchesInitialPinOutputPress4ToExit()
	{
		// arrange
		String sInitialPin = "1234";
		String sInputPayload = sInitialPin + "\n4\n";
		AtmApp.setSysOutDelegate((value) -> this.lastSysOutMessage = value);
		AtmApp.setSysInDelegate(
				new ByteArrayInputStream(
						sInputPayload.getBytes()
						)
				);
		// act
		AtmApp.main(new String[0]);
		// assert
		assertArrayEquals(AtmTest.sExitText.toCharArray(), AtmTest.lastSysOutMessage.toCharArray());
	}
	 */
}
