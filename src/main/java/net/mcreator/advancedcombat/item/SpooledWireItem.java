
package net.mcreator.advancedcombat.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.advancedcombat.itemgroup.AdvancedCombatItemGroup;
import net.mcreator.advancedcombat.AdvancedCombatModElements;

import java.util.List;

@AdvancedCombatModElements.ModElement.Tag
public class SpooledWireItem extends AdvancedCombatModElements.ModElement {
	@ObjectHolder("advanced_combat:spooled_wire")
	public static final Item block = null;
	public SpooledWireItem(AdvancedCombatModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AdvancedCombatItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("spooled_wire");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(MetalSpoolItem.block, (int) (1));
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("You Spooled It!"));
		}
	}
}
