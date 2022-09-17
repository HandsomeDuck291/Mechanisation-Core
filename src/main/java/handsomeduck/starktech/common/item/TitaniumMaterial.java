package handsomeduck.starktech.common.item;

import handsomeduck.starktech.common.registry.ObjectRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class TitaniumMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {0, 0, 16, 0};
    private static final int[] PROTECTION_VALUES = new int[] {0, 0, 3, 0};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 25;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ObjectRegistry.PALLADIUM_INGOT);
    }

    @Override
    public String getName() {
        // Must be all lowercase
        return "titanium";
    }

    @Override
    public float getToughness() {
        return 3.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.3F;
    }
}
