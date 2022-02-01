package advancement.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.Timer;
import java.util.TimerTask;

final class CooldownPickaxe extends TimerTask {
    private static boolean cooldown = false;

    @Override
    public void run() {
        changeCooldown(false);
    }

    public static boolean isOnCooldown() {
        return cooldown;
    }

    public static void changeCooldown(boolean change) {
        CooldownPickaxe.cooldown = change;
    }
}

public class CelestialPickaxe extends ItemModPickaxe {
    public CelestialPickaxe (IItemTier tier, Rarity rarity, String name, float attackSpeedModifier) {
        super(tier, rarity, name, attackSpeedModifier);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            if (CooldownPickaxe.isOnCooldown()) {
                TextComponent message = new StringTextComponent("Item is on cooldown!");
                message.withStyle(TextFormatting.DARK_RED);
                player.sendMessage(message, player.getUUID());
                return ActionResult.fail(player.getItemInHand(hand));
            }
            else {
                int amplifier = 0;
                int duration = 200;
                player.addEffect(new EffectInstance(Effects.DIG_SPEED, duration, amplifier+1));
                player.addEffect(new EffectInstance(Effects.NIGHT_VISION, duration, amplifier));
                CooldownPickaxe.changeCooldown(true);
                changeAfterDelay();
                return super.use(world, player, hand);
            }
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }

    private void changeAfterDelay() {
        Timer cooldownTimer = new Timer();
        CooldownPickaxe cooldownChanger = new CooldownPickaxe();
        cooldownTimer.schedule(cooldownChanger, 15000);
    }
}
