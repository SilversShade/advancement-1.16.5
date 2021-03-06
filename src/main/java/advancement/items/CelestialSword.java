package advancement.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.*;

final class CooldownSword extends TimerTask {
    private static boolean cooldown = false;

    @Override
    public void run() {
        changeCooldown(false);
    }

    public static boolean isOnCooldown() {
        return cooldown;
    }

    public static void changeCooldown(boolean change) {
        CooldownSword.cooldown = change;
    }
}

public final class CelestialSword extends ItemModSword {
    public CelestialSword (IItemTier tier, Rarity rarity, String name, float attackSpeedModifier) {
        super(tier, rarity, name, attackSpeedModifier);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            if (CooldownSword.isOnCooldown()) {
                TextComponent message = new StringTextComponent("Item is on cooldown!");
                message.withStyle(TextFormatting.DARK_RED);
                player.sendMessage(message, player.getUUID());
                return ActionResult.fail(player.getItemInHand(hand));
            }
            else {
                int amplifier, duration;
                if (player.getHealth() <= 10.0) {
                    duration = 400;
                    amplifier = 1;
                }
                else {
                    duration = 200;
                    amplifier = 0;
                }
                player.addEffect(new EffectInstance(Effects.ABSORPTION, duration, amplifier));
                player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, duration, amplifier));
                CooldownSword.changeCooldown(true);
                changeAfterDelay();
                return super.use(world, player, hand);
            }
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }

    private void changeAfterDelay() {
        Timer cooldownTimer = new Timer();
        CooldownSword cooldownChanger = new CooldownSword();
        cooldownTimer.schedule(cooldownChanger, 30000);
    }
}
