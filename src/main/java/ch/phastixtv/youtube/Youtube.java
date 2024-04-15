package ch.phastixtv.youtube;

import ch.phastixtv.youtube.commands.TestCommand;
import ch.phastixtv.youtube.events.JoinListener;
import ch.phastixtv.youtube.events.QuitListener;
import ch.phastixtv.youtube.util.AdminKit;
import jdk.incubator.vector.VectorOperators;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Youtube extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Youtube-Plugin wurde gestartet...");

        getCommand("test").setExecutor(new TestCommand());

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new AdminKit(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Youtube-Plugin wurde gestoppt...");
    }
}
