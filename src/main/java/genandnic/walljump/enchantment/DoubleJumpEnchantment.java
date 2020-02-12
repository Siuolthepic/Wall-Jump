package genandnic.walljump.enchantment;

import genandnic.walljump.WallJump;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class DoubleJumpEnchantment extends Enchantment {

    public DoubleJumpEnchantment(Weight weight, EnchantmentTarget target, EquipmentSlot[] slots) {
        super(weight, target, slots);
    }

    @Override
    public int getMinimumLevel() {
        return 1;
    }

    @Override
    public int getMaximumLevel() {
        return 2;
    }

    @Override
    public int getMinimumPower(int level) {
        return level * 20;
    }

    @Override
    public int getMaximumPower(int level) {
        return level * 60;
    }

    @Override
    public boolean differs(Enchantment enchantment) {
        if(enchantment instanceof ProtectionEnchantment) {
            ProtectionEnchantment protection = (ProtectionEnchantment) enchantment;
            return protection.protectionType != ProtectionEnchantment.Type.FALL;
        }

        return this != enchantment;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {

        if(!WallJump.CONFIGURATION.enableEnchantments()) {
            return false;
        }

        return stack.isEnchantable();
    }
}
