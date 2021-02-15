package com.freeranger.revampedtweaks.blocks;

import com.freeranger.revampedtweaks.base.BlockBase;
import com.freeranger.revampedtweaks.base.DeepRedstoneOre;
import com.freeranger.revampedtweaks.base.OreBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static BlockBase DEEP_STONE = new BlockBase(Material.ROCK, "deep_stone",
            3f, 9f, "pickaxe", 1)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

    public static OreBase DEEP_COAL_ORE = new OreBase("deep_coal_ore",
            3f, 3f, 0);

    public static OreBase DEEP_DIAMOND_ORE = new OreBase("deep_diamond_ore",
            3f, 3f, 2);

    public static OreBase DEEP_LAPIS_ORE = new OreBase("deep_lapis_ore",
            3f, 3f, 1);

    public static OreBase DEEP_EMERALD_ORE = new OreBase("deep_emerald_ore",
            3f, 3f, 2);

    public static OreBase DEEP_IRON_ORE = new OreBase("deep_iron_ore",
            3f, 3f, 1);

    public static OreBase DEEP_GOLD_ORE = new OreBase("deep_gold_ore",
            3f, 3f, 2);

    public static OreBase DEEP_COPPER_ORE = new OreBase("deep_copper_ore",
            3f, 3f, 1);
    public static OreBase DEEP_NATURAL_COPPER_ORE = new OreBase("deep_natural_copper_ore",
            3f, 3f, 1);

    public static DeepRedstoneOre DEEP_REDSTONE_ORE = new DeepRedstoneOre("deep_redstone_ore", false);
    public static DeepRedstoneOre LIT_DEEP_REDSTONE_ORE = new DeepRedstoneOre("lit_deep_redstone_ore", true);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                DEEP_STONE,
                DEEP_COAL_ORE,
                DEEP_DIAMOND_ORE,
                DEEP_LAPIS_ORE,
                DEEP_EMERALD_ORE,
                DEEP_IRON_ORE,
                DEEP_GOLD_ORE,
                DEEP_REDSTONE_ORE,
                LIT_DEEP_REDSTONE_ORE,
                DEEP_COPPER_ORE,
                DEEP_NATURAL_COPPER_ORE
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                DEEP_STONE.createItemBlock(),
                DEEP_COAL_ORE.createItemBlock(),
                DEEP_DIAMOND_ORE.createItemBlock(),
                DEEP_LAPIS_ORE.createItemBlock(),
                DEEP_EMERALD_ORE.createItemBlock(),
                DEEP_IRON_ORE.createItemBlock(),
                DEEP_GOLD_ORE.createItemBlock(),
                DEEP_REDSTONE_ORE.createItemBlock(),
                DEEP_COPPER_ORE.createItemBlock(),
                DEEP_NATURAL_COPPER_ORE.createItemBlock()
        );
    }

    public static void registerModels() {
        DEEP_STONE.registerItemModel(Item.getItemFromBlock(DEEP_STONE));
        DEEP_COAL_ORE.registerItemModel(Item.getItemFromBlock(DEEP_COAL_ORE));
        DEEP_DIAMOND_ORE.registerItemModel(Item.getItemFromBlock(DEEP_DIAMOND_ORE));
        DEEP_LAPIS_ORE.registerItemModel(Item.getItemFromBlock(DEEP_LAPIS_ORE));
        DEEP_EMERALD_ORE.registerItemModel(Item.getItemFromBlock(DEEP_EMERALD_ORE));
        DEEP_IRON_ORE.registerItemModel(Item.getItemFromBlock(DEEP_IRON_ORE));
        DEEP_GOLD_ORE.registerItemModel(Item.getItemFromBlock(DEEP_GOLD_ORE));
        DEEP_REDSTONE_ORE.registerItemModel(Item.getItemFromBlock(DEEP_REDSTONE_ORE));
        LIT_DEEP_REDSTONE_ORE.registerItemModel(Item.getItemFromBlock(LIT_DEEP_REDSTONE_ORE));
        DEEP_COPPER_ORE.registerItemModel(Item.getItemFromBlock(DEEP_COPPER_ORE));
        DEEP_NATURAL_COPPER_ORE.registerItemModel(Item.getItemFromBlock(DEEP_NATURAL_COPPER_ORE));
    }
}
