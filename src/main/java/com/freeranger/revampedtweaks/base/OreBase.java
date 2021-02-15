package com.freeranger.revampedtweaks.base;

import com.Da_Technomancer.crossroads.items.itemSets.OreSetup;
import com.freeranger.revampedtweaks.RevampedTweaks;
import com.freeranger.revampedtweaks.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class OreBase extends Block {
    protected String name;

    public OreBase(String name, float hardness, float resistance, int harvestLevel) {
        super(Material.ROCK);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setHarvestLevel("pickaxe", harvestLevel);
        setHardness(hardness);
        setResistance(resistance);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (this == ModBlocks.DEEP_COAL_ORE) {
            return Items.COAL;
        } else if (this == ModBlocks.DEEP_DIAMOND_ORE) {
            return Items.DIAMOND;
        } else if (this == ModBlocks.DEEP_LAPIS_ORE) {
            return Items.DYE;
        } else if (this == ModBlocks.DEEP_EMERALD_ORE) {
            return Items.EMERALD;
        } else if(this == ModBlocks.DEEP_NATURAL_COPPER_ORE) {
            return OreSetup.nuggetCopper;
        } else {
            return Item.getItemFromBlock(this);
        }
    }

    public void registerItemModel(Item itemBlock) {
        RevampedTweaks.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    public int quantityDropped(Random random)
    {
        if(this == ModBlocks.DEEP_LAPIS_ORE ||this == ModBlocks.DEEP_NATURAL_COPPER_ORE){
            return 4 + random.nextInt(5);
        }

        return 1;
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) !=
                this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0) i = 0;

            return this.quantityDropped(random) * (i + 1);
        } else {
            return this.quantityDropped(random);
        }
    }

    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;

            if (this == ModBlocks.DEEP_COAL_ORE || this == ModBlocks.DEEP_NATURAL_COPPER_ORE) {
                i = MathHelper.getInt(rand, 0, 2);
            } else if (this == ModBlocks.DEEP_DIAMOND_ORE) {
                i = MathHelper.getInt(rand, 3, 7);
            } else if (this == ModBlocks.DEEP_EMERALD_ORE) {
                i = MathHelper.getInt(rand, 3, 7);
            } else if (this == ModBlocks.DEEP_LAPIS_ORE) {
                i = MathHelper.getInt(rand, 2, 5);
            }
            return i;
        }
        return 0;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this);
    }

    public int damageDropped(IBlockState state) {
        return this == ModBlocks.DEEP_LAPIS_ORE ? EnumDyeColor.BLUE.getDyeDamage() : 0;
    }
}
