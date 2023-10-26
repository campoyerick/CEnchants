package redehid.com.campoyerick;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.Material;

public class CustomProtectionEnchantment extends EnchantmentWrapper {
    public CustomProtectionEnchantment() {
        super(Integer.parseInt("custom_protection"));
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        // Verifica se o item pode ser encantado com Protection (Proteção)
        Material itemType = item.getType();
        return EnchantmentTarget.ARMOR.includes(itemType) || EnchantmentTarget.ALL.includes(itemType);
    }

    public static ItemStack getProtection1Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtection2Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }
    public static ItemStack getProtection3Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }
    public static ItemStack getProtection4Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtectionFire1Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_FIRE, 1, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtectionFire2Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_FIRE, 2, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtectionFire3Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_FIRE, 3, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtectionFire4Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_FIRE, 4, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtectionPena1Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_FALL, 1, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtectionPena2Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_FALL, 2, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtectionPena3Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_FALL, 3, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getProtectionPena4Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.PROTECTION_FALL, 4, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getSharp1Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 1, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getSharp2Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 2, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getSharp3Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 3, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getSharp4Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 4, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getSharp5Book() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 5, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getFireSword1() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.FIRE_ASPECT, 1, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getFireSword2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.FIRE_ASPECT, 2, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getEffi1() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DIG_SPEED, 1, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getEffi2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DIG_SPEED, 2, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getEffi3() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DIG_SPEED, 3, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getEffi4() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DIG_SPEED, 4, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }

    public static ItemStack getEffi5() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        meta.addStoredEnchant(Enchantment.DIG_SPEED, 5, true);
        enchantedBook.setItemMeta(meta);
        return enchantedBook;
    }
}
