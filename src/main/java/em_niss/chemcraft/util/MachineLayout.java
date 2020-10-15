package em_niss.chemcraft.util;

import java.util.ArrayList;
import java.util.List;

public class MachineLayout
{
	public List<Integer> inSlots = new ArrayList<>();
	public List<Integer> outSlots = new ArrayList<>();
	
	public MachineLayout(int numInSlots, int numOutSlots)
	{
		for (int i = 0; i < numInSlots; i++) { inSlots.add(i); }
		for (int j = numInSlots; j < numOutSlots + numInSlots; j++) { outSlots.add(j); }
	}
}
