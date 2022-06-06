package handsomeduck.herebedragons.common.item;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import handsomeduck.herebedragons.api.entity.DragonEggEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class EggItem extends Item {
    private final EntityType<?> dragonegg;

    public EggItem(Settings settings, EntityType<?> egg) {
        super(settings);
        this.dragonegg = egg;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos().offset(context.getSide());
        boolean client = world.isClient;
        if (world.getBlockState(pos).isAir()) {
            if (!client) {
                Entity entity = dragonegg.create(world);
                if (entity instanceof DragonEggEntity dragonEggEntity) {
                    entity.updatePositionAndAngles(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, context.getPlayerYaw(), context.getPlayer() == null ? 0 : context.getPlayer().getPitch());
                    if (context.getPlayer() != null) {
                        context.getStack().getOrCreateNbt().putUuid("OwnerUUID", context.getPlayer().getUuid());
                    }
                    ItemStack stack = context.getStack().split(1);
                    dragonEggEntity.init(stack);
                    dragonEggEntity.stack = stack;
                    world.spawnEntity(entity);
                }
            }
            return ActionResult.success(client);
        }
        return super.useOnBlock(context);
    }

}
