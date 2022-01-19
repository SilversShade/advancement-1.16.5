package advancement.tiles.chests;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

import javax.annotation.Nullable;

public class ChestContainer extends Container {
    protected ChestContainer(@Nullable ContainerType<?> p_i50105_1_, int p_i50105_2_) {
        super(p_i50105_1_, p_i50105_2_);
    }

    @Override
    public boolean stillValid(PlayerEntity p_75145_1_) {
        return false;
    }
}
