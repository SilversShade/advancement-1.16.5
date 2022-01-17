package advancement.items;

import net.minecraft.entity.LivingEntity;
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

class Cooldown extends TimerTask {
    private static boolean cooldown = false;

    @Override
    public void run() {
        changeCooldown(false);
    }

    public static boolean isOnCooldown() {
        return cooldown;
    }

    public static void changeCooldown(boolean change) {
        Cooldown.cooldown = change;
    }
}

public class CelestialSword extends ItemModSword {
    public CelestialSword (IItemTier tier, Rarity rarity, String name, float attackSpeedModifier) {
        super(tier, rarity, name, attackSpeedModifier);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            if (Cooldown.isOnCooldown()) {
                TextComponent message = new StringTextComponent("Item is on cooldown!");
                message.withStyle(TextFormatting.DARK_RED);
                player.sendMessage(message, player.getUUID());
                return ActionResult.fail(player.getItemInHand(hand));
            }
            else {
                int amplifier, duration;
                if (player.getHealth() <= 5.0) {
                    duration = 400;
                    amplifier = 1;
                }
                else {
                    duration = 200;
                    amplifier = 0;
                }
                player.addEffect(new EffectInstance(Effects.ABSORPTION, duration, amplifier));
                player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, duration, amplifier));
                Cooldown.changeCooldown(true);
                changeAfterDelay();
                return super.use(world, player, hand);
            }
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }

    public void changeAfterDelay() {
        Timer cooldownTimer = new Timer();
        Cooldown cooldownChanger = new Cooldown();
        cooldownTimer.schedule(cooldownChanger, 30000);
    }
}
