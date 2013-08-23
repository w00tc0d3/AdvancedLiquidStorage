package net.w00tc0d3.AdvancedLiquidStorage;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileAdvancedLiquidStorage)
			return new ContainerAdvancedLiquidStorage((TileAdvancedLiquidStorage) tileEntity);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileAdvancedLiquidStorage){
                return new GuiAdvancedLiquidStorage(new ContainerAdvancedLiquidStorage((TileAdvancedLiquidStorage) tileEntity));
        }
        return null;
	}
}

