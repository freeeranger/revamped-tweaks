package com.freeranger.revampedtweaks;

import com.Da_Technomancer.crossroads.items.crafting.ModCrafting;
import com.freeranger.revampedtweaks.blocks.ModBlocks;
import com.freeranger.revampedtweaks.items.ModItems;
import com.freeranger.revampedtweaks.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = RevampedTweaks.MODID, name = RevampedTweaks.NAME, version = RevampedTweaks.VERSION,
        acceptedMinecraftVersions = RevampedTweaks.MC_VERSION, useMetadata = true,
        dependencies = "required-after:crossroads; required-after:jaopca;")
public class RevampedTweaks {
    public static final String MODID = "revampedtweaks";
    public static final String NAME = "Revamped Tweaks";
    public static final String VERSION = "1.0.0.0";
    public static final String MC_VERSION = "[1.12.2]";

    public static final Logger LOGGER = LogManager.getLogger(RevampedTweaks.MODID);

    @SidedProxy(serverSide = "com.freeranger.revampedtweaks.proxy.CommonProxy",
            clientSide = "com.freeranger.revampedtweaks.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {}

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RegistrationHandler.initRegistries();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static void initRegistries() {
            GameRegistry.addSmelting(ModBlocks.DEEP_COAL_ORE,       new ItemStack(Items.COAL,       1),  10);
            GameRegistry.addSmelting(ModBlocks.DEEP_DIAMOND_ORE,    new ItemStack(Items.DIAMOND,    1),  10);
            GameRegistry.addSmelting(ModBlocks.DEEP_LAPIS_ORE,      new ItemStack(Items.DYE,        1,
                    EnumDyeColor.BLUE.getDyeDamage()),10);
            GameRegistry.addSmelting(ModBlocks.DEEP_EMERALD_ORE,    new ItemStack(Items.EMERALD,    1),  10);
            GameRegistry.addSmelting(ModBlocks.DEEP_IRON_ORE,       new ItemStack(Items.IRON_INGOT, 1),  10);
            GameRegistry.addSmelting(ModBlocks.DEEP_GOLD_ORE,       new ItemStack(Items.GOLD_INGOT, 1),  10);
            GameRegistry.addSmelting(ModBlocks.DEEP_REDSTONE_ORE,   new ItemStack(Items.REDSTONE,   1),  10);

            ModCrafting.toRegisterOreDict.add(Pair.of(ModBlocks.DEEP_COPPER_ORE, new String[] {"oreCopper"}));
            OreDictionary.registerOre("oreCopper", ModBlocks.DEEP_COPPER_ORE);
            OreDictionary.registerOre("oreCoal", ModBlocks.DEEP_COAL_ORE);
            OreDictionary.registerOre("oreDiamond", ModBlocks.DEEP_DIAMOND_ORE);
            OreDictionary.registerOre("oreLapis", ModBlocks.DEEP_LAPIS_ORE);
            OreDictionary.registerOre("oreEmerald", ModBlocks.DEEP_EMERALD_ORE);
            OreDictionary.registerOre("oreIron", ModBlocks.DEEP_IRON_ORE);
            OreDictionary.registerOre("oreGold", ModBlocks.DEEP_GOLD_ORE);
            OreDictionary.registerOre("oreRedstone", ModBlocks.DEEP_REDSTONE_ORE);

        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }
}
