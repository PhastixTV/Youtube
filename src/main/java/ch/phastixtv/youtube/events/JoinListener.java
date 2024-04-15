package ch.phastixtv.youtube.events;

import ch.phastixtv.youtube.util.AdminKit;
import ch.phastixtv.youtube.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    private final AdminKit adminKit = new AdminKit();



    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // Um globale Joinmessage auszuschalten einfach null reinschreiben!
        event.setJoinMessage(player.getName() + " " + "§aist auf den Server gejoint"); // Global, d.h. jeder Spieler sieht diese Nachricht!

        player.sendMessage("§dWillkommen auf dem Server");

        joinItems(player);
    }

    public void joinItems(Player player) {
        ItemStack adminKit_DIAMOND = ItemBuilder.createItem(Material.DIAMOND, adminKit.getGUI_NAME(), 1, "§aIch bin ein Admin");

        player.getInventory().setItem(0, adminKit_DIAMOND);
    }
}
