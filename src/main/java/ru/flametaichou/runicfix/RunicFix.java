package ru.flametaichou.runicfix;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod (modid = "runicfix", name = "RunicFix", version = "0.1", acceptableRemoteVersions = "*")

public class RunicFix {
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
	}

	@EventHandler
	public void load(FMLPreInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(FMLEventHandler.INSTANCE);
	}
	
}
