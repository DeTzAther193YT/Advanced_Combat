
package net.mcreator.advancedcombat.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.SlabType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.advancedcombat.itemgroup.AdvancedCombatItemGroup;
import net.mcreator.advancedcombat.AdvancedCombatModElements;

import java.util.List;
import java.util.Collections;

@AdvancedCombatModElements.ModElement.Tag
public class UnstableSlabBlock extends AdvancedCombatModElements.ModElement {
	@ObjectHolder("advanced_combat:unstable_slab")
	public static final Block block = null;
	public UnstableSlabBlock(AdvancedCombatModElements instance) {
		super(instance, 640);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AdvancedCombatItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends SlabBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4.4f, 6.6000000000000005f).lightValue(0));
			setRegistryName("unstable_slab");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 11;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}
	}
}
