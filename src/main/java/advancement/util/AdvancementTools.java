package advancement.util;

import advancement.registries.ItemRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum AdvancementTools implements IItemTier {
    THREE_CRYSTAL_PICKAXE(4, 3000, 15.0f, 4.0f, 15, () -> {
        return Ingredient.of(ItemRegistry.platinum_ingot);
    }),
    THREE_CRYSTAL_SWORD(4, 3000, 4.0f, 12.0f, 15, () -> {
        return Ingredient.of(ItemRegistry.platinum_ingot);
    }),
    THREE_CRYSTAL_AXE(4, 3000, 15.0f, 7.0f, 15, () -> {
        return Ingredient.of(ItemRegistry.platinum_ingot);
    }),
    THREE_CRYSTAL_SHOVEL(4, 3000, 15.0f, 4.0f, 15, () -> {
        return Ingredient.of(ItemRegistry.platinum_ingot);
    });

    //TODO: improved version of TCSword that is able to attack on right mouse click while in other hand

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    AdvancementTools (int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        if (repairMaterial!=null)
            return repairMaterial.get();
        return null;
    }
}
