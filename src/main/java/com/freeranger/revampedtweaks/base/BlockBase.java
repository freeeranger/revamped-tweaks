package com.freeranger.revampedtweaks.base;

import com.freeranger.revampedtweaks.RevampedTweaks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {
    protected String name;

    public BlockBase(Material material, String name, float hardness, float resistance, String breakTool, int harvestLevel) {
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setHarvestLevel(breakTool, harvestLevel);
        setHardness(hardness);
        setResistance(resistance);
    }

    public void registerItemModel(Item itemBlock) {
        RevampedTweaks.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
