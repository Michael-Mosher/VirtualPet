package org.wecancodeit.virtualpet;

import java.io.InputStream;
import java.util.Scanner;

public class VirtualPetIngress implements IVirtualPetIngress 
{
	private InputStream sysInData = System.in;
	private Scanner sysInDelegate;
	
	public VirtualPetIngress()
	{
		this.sysInDelegate = new Scanner(this.sysInData);
	}

}
