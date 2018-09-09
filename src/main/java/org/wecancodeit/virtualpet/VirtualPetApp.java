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
	private static boolean bIsTesting;
	
	public static void main(String[] args)
	{
		
		IVirtualPetIngress oVPIngress = new VirtualPetIngress();
		IVirtualPetEgress oVPEgress = new VirtualPetEgress();
		VirtualPetApp.pet = new VirtualPetEngine(100,100,100);
		boolean bContinueLoop = true;
		do {
			
			if(!VirtualPetApp.bIsTesting) {
				VirtualPetApp.oVPEgress.outputOptions(VirtualPetApp.pet);
				
				sOptionChosen = VirtualPetApp.sysInDelegate.nextLine();
			} else {
				bContinueLoop = !VirtualPetApp.bIsTesting;
			}
		} while(VirtualPetApp.oVPIngress.currentInput().compareToIgnoreCase("quit")!=0 && bContinueLoop);
	}

	protected static void setSysOutDelegate(SysOutDelegate sysOutFunction)
	{
		VirtualPetApp.sysOutDelegate = sysOutFunction;
	}
	
	protected static void setSysInDelegate(InputStream in)
	{
		VirtualPetApp.sysInData = in;
	}
	
	protected static void setIsTesting()
	{
		VirtualPetApp.bIsTesting = true;
	}
	
	protected static void setIsTesting(boolean testing)
	{
		VirtualPetApp.bIsTesting = testing;
	}

//	protected static void setInitialBalance(BigDecimal bigDecimal) {
//		if (VirtualPetApp.bIsTesting) {
//			VirtualPetApp.oInitialBalance = bigDecimal;
//		}
//		
//	}
}
