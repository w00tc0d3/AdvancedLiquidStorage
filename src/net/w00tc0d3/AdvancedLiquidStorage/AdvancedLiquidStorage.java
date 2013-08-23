package net.w00tc0d3.AdvancedLiquidStorage;

import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = AdvancedLiquidStorage.modid, version = AdvancedLiquidStorage.version, name = "Advanced Liquid Storage")
@NetworkMod(clientSideRequired=true, serverSideRequired=false,
channels={"AdvancedLiquid"}, packetHandler = PacketHandler.class)
public class AdvancedLiquidStorage {
	public static final String modid = "AdvancedLiquidStorage";
	public static final String version = "0.0.1";
	
	public static Block blockAdvancedLiquidStorage = new BlockAdvancedLiquidStorage(501).setUnlocalizedName("advancedLiquidStorage");
	
	@Instance
	public static AdvancedLiquidStorage advancedLiquidStorage;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// do stuff
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerBlock(blockAdvancedLiquidStorage, modid + blockAdvancedLiquidStorage.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(blockAdvancedLiquidStorage, "Advanced Liquid Storage");
		GameRegistry.registerTileEntity(net.w00tc0d3.AdvancedLiquidStorage.TileAdvancedLiquidStorage.class, "tileAdvancedLiquidStorage");
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// do stuff
	}
}
