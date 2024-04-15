package ch.phastixtv.youtube.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemBuilder {

    public static ItemStack createItem(Material id, String name, int ammount, String lore){
        ItemStack item = new ItemStack(id, ammount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> list = new ArrayList<>();
        list.add(lore);
        meta.setLore(list);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItemWithEnchantment(Material id, String name, int ammount, String lore, Map<Enchantment, Integer> enchantment){
        enchantment = new HashMap<>();
        ItemStack item = new ItemStack(id, ammount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> list = new ArrayList<>();
        list.add(lore);
        meta.setLore(list);
        item.setItemMeta(meta);
        item.addEnchantments(enchantment);
        return item;
    }

    public static ItemStack createItemHead(Material id, String name, int amount, String lore, Player player){
        ItemStack itemStack = new ItemStack(id, amount);
        SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwner(player.getName());
        skullMeta.setDisplayName(name);
        List<String> list = new ArrayList<>();
        list.add(lore);
        skullMeta.setLore(list);
        itemStack.setItemMeta(skullMeta);
        player.updateInventory();
        return itemStack;
    }

    public static ItemStack createItemLore(Material id, String name, int ammount, List<String> lore){
        ItemStack item = new ItemStack(id, ammount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> list = new ArrayList<>();
        list.addAll(lore);
        meta.setLore(list);
        item.setItemMeta(meta);
        return item;
    }
}
