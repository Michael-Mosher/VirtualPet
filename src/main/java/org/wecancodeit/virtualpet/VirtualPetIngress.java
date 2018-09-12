package org.wecancodeit.virtualpet;

import java.io.InputStream;
import java.util.Scanner;

public class VirtualPetIngress implements IVirtualPetIngress 
{
	private Scanner sysInDelegate;
	
	public VirtualPetIngress(InputStream inArg)
	{
		this.sysInDelegate = new Scanner(inArg);
	}

	@Override
	public String currentInput() {
		return this.sysInDelegate.nextLine();
	}

}
