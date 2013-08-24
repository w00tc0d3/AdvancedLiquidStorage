package net.w00tc0d3.AdvancedLiquidStorage;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiAdvancedLiquidStorage extends GuiContainer {

	public GuiAdvancedLiquidStorage(TileAdvancedLiquidStorage tileEntity) {
		super(new ContainerAdvancedLiquidStorage(tileEntity));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.mc.renderEngine.func_110577_a(new ResourceLocation(AdvancedLiquidStorage.modid + ":textures/gui/container.png"));
	    int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
	    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
