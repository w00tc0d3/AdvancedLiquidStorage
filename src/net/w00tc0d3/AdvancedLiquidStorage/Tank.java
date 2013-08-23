package net.w00tc0d3.AdvancedLiquidStorage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class Tank extends FluidTank {

	public Tank(int capacity) {
		super(capacity);
	}
	
	public boolean isEmpty() {
		if(getFluid() == null || getFluid().amount <= 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		return getFluid() != null && getFluid().amount >= getCapacity();
	}

	public Fluid getFluidType() {
		return getFluid() != null ? getFluid().getFluid() : null;
	}
}
