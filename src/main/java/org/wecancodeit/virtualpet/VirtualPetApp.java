package org.wecancodeit.virtualpet;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.wecancodeit.virtualpet.SysOutDelegate;

import atm.AtmApp;

public class VirtualPetApp {
	private static IVirtualPetIngress oVPIngress;
	private static IVirtualPetEgress oVPEgress;
	private static VirtualPetEngine pet;
	private static boolean bIsTesting = false;
	private static SysOutDelegate outArg = (value) -> System.out.println(value);
	private static InputStream inArg = System.in;
	
	public static void main(String[] args)
	{
		
		VirtualPetApp.oVPIngress = new VirtualPetIngress(VirtualPetApp.inArg);
		VirtualPetApp.oVPEgress = new VirtualPetEgress(VirtualPetApp.outArg);
		VirtualPetApp.pet = new VirtualPetEngine(100,100,100);
		boolean bContinueLoop = true;
		boolean bFirstPass = true;
		String sOptionChosen = new String("");
		VirtualPetApp.oVPEgress.outputOpening(pet);
		VirtualPetApp.pet.setName(VirtualPetApp.oVPIngress.currentInput());
		VirtualPetApp.oVPEgress.outputNameReaction(VirtualPetApp.pet);
		VirtualPetApp.oVPEgress.outputOptions(VirtualPetApp.pet);
		sOptionChosen = VirtualPetApp.oVPIngress.currentInput();
		VirtualPetApp.tick();
		while(sOptionChosen.compareToIgnoreCase("quit")!=0 /*&& bContinueLoop*/) {
			if(!bFirstPass) {
				VirtualPetApp.tick();
				VirtualPetApp.oVPEgress.outputStatus(VirtualPetApp.pet);
				VirtualPetApp.oVPEgress.outputOptions(VirtualPetApp.pet);
				sOptionChosen = VirtualPetApp.oVPIngress.currentInput();
			}
			bFirstPass = false;
			VirtualPetApp.oVPEgress.processOption(VirtualPetApp.pet, VirtualPetApp.oVPIngress, sOptionChosen);
			bContinueLoop = !VirtualPetApp.bIsTesting;
		}
		if(!VirtualPetApp.bIsTesting) VirtualPetApp.oVPEgress.outputClosing(VirtualPetApp.pet);
	}

	protected static void setSysOutDelegate(SysOutDelegate sysOutFunction)
	{
		VirtualPetApp.outArg = sysOutFunction;
	}
	
	protected static void setSysInDelegate(InputStream in)
	{
		VirtualPetApp.inArg = in;
	}
	
	protected static void setIsTesting()
	{
		VirtualPetApp.bIsTesting = true;
	}
	
	protected static void setIsTesting(boolean testing)
	{
		VirtualPetApp.bIsTesting = testing;
	}
	
	private static void tick()
	{
		VirtualPetApp.pet.decrementEnergy();
		VirtualPetApp.pet.decrementFullness();
		VirtualPetApp.pet.decrementStimulation();
	}

//	protected static void setInitialBalance(BigDecimal bigDecimal) {
//		if (VirtualPetApp.bIsTesting) {
//			VirtualPetApp.oInitialBalance = bigDecimal;
//		}
//		
//	}
}
