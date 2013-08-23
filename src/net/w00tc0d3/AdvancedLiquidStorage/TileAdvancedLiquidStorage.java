package net.w00tc0d3.AdvancedLiquidStorage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileAdvancedLiquidStorage extends TileEntity implements IFluidHandler {

	public final Tank tank = new Tank(FluidContainerRegistry.BUCKET_VOLUME * 2000000);
	public int fluidID;
	public int amount;
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (resource == null) {
			return 0;
		}

		int totalUsed = 0;

		FluidStack liquid = tank.getFluid();
		
		if (liquid != null && liquid.amount > 0 && !liquid.isFluidEqual(resource)) {
			return 0;
		}
		
		/* 
		 * This looks like a good point to update the info needed for the Container
		 */
		fluidID = resource.fluidID;
		amount = resource.amount;

		while (tank != null && resource.amount > 0) {
			int used = tank.fill(resource, doFill);
			resource.amount -= used;

			totalUsed += used;
		}
		return totalUsed;
	}
	
	@Override
	public FluidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {
		return tank.drain(maxEmpty, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if(resource == null)
			return null;
		
		if(!resource.isFluidEqual(tank.getFluid()))
			return null;
		
		/* 
		 * This looks like a good point to update the info needed for the Container
		 */
		fluidID = resource.fluidID;
		amount = resource.amount;
		
		return drain(from, resource.amount, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[]{tank.getInfo()};
	}
}
