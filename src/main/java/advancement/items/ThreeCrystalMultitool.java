package advancement.items;

import advancement.AdvancementMod;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraftforge.common.ToolType;

import java.util.Set;

public final class ThreeCrystalMultitool extends ToolItem {
    private static final Set<Block> USED_WITH = ImmutableSet.of();

    public ThreeCrystalMultitool(String name, Rarity rarity, IItemTier tier) {
        super(1.0f, -2.0f, tier, USED_WITH,
                new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB).addToolType(ToolType.AXE, tier.getLevel()).addToolType(ToolType.PICKAXE, tier.getLevel())
                        .addToolType(ToolType.SHOVEL, tier.getLevel()).durability(tier.getUses()).rarity(rarity));
        setRegistryName(name);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, null);
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getBlock().getHarvestLevel(state) <= getTier().getLevel())
            return this.speed;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        return Items.DIAMOND_HOE.useOn(context);
    }

    @Override
    public boolean canHarvestBlock (ItemStack stack, BlockState state) {
        return state.getBlock().getHarvestLevel(state) <= getTier().getLevel();
    }
}
