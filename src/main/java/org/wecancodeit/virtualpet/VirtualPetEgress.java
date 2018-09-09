package org.wecancodeit.virtualpet;

import java.io.InputStream;
import java.util.Scanner;

public class VirtualPetEgress implements IVirtualPetEgress {
	private static SysOutDelegate sysOutDelegate = (String value) -> System.out.println(value);

	@Override
	public void outputOptions(VirtualPetEngine pet) {
		this.sysOutDelegate.println("Choose an option.");
		this.sysOutDelegate.println("Press 1 to deposit funds.");
		this.sysOutDelegate.println("Press 2 to withdraw funds.");
		this.sysOutDelegate.println("Press 3 to get balance.");
		this.sysOutDelegate.println("Type \"quit\" at anytime to abandon " + pet.getName());
	}

}
