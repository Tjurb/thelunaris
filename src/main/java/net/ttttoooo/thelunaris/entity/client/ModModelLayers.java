package net.ttttoooo.thelunaris.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModModelLayers {
	//friendlys
	public static final ModelLayerLocation MOONCOW_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheLunaris.MODID, "mooncow_layer"), "main");
	public static final ModelLayerLocation ARCHFISH_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheLunaris.MODID, "archfish_layer"), "main");
	public static final ModelLayerLocation MOONSNAIL_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheLunaris.MODID, "moonsnail_layer"), "main");

	//enemies
	public static final ModelLayerLocation PHYREX_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheLunaris.MODID, "phyrex_layer"), "main");
	public static final ModelLayerLocation LUNARSLEEPER_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheLunaris.MODID, "lunarsleeper_layer"), "main");
	public static final ModelLayerLocation HEX_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheLunaris.MODID, "hex_layer"), "main");
}
