package ch.phastixtv.youtube.util;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class AdminKit implements Listener {
    private final String GUI_NAME = "§4Adminkit";

    public void openGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9*3);

        //enchantmens
        Map<Enchantment, Integer> enchantment = new HashMap<>();
        enchantment.put(Enchantment.KNOCKBACK, 500);
        enchantment.put(Enchantment.FIRE_ASPECT, 100);
        enchantment.put(Enchantment.DAMAGE_ALL, 100);

        //Inventoryitems
        inventory.setItem(0, ItemBuilder.createItem(Material.DIAMOND_AXE, "§bSieges Axt", 10, "§aIch bin cool"));
        inventory.setItem(1, ItemBuilder.createItemWithEnchantment(Material.DIAMOND_SWORD, "§bSieges Schwert", 1, "§aIch bin der Sieger", enchantment));

        player.openInventory(inventory);
    }

    @EventHandler
    public void onAdminKit(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item != null && item.getType() == Material.DIAMOND && item.getItemMeta().getDisplayName().equalsIgnoreCase(GUI_NAME)) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) return;
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) openGUI(player);
        }
    }

    public String getGUI_NAME() {
        return GUI_NAME;
    }
}
