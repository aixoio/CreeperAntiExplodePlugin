package me.dlwinner1468.creeperantiexplodeplugin;

import me.dlwinner1468.creeperantiexplodeplugin.events.CreeperDamageEventListener;
import me.dlwinner1468.creeperantiexplodeplugin.events.EntityExplodeEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CreeperAntiExplodePlugin extends JavaPlugin {

    private static CreeperAntiExplodePlugin PLUGIN;

    @Override
    public void onEnable() {

        this.getLogger().info("Starting...");

        CreeperAntiExplodePlugin.PLUGIN = this;

        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new EntityExplodeEventListener(), this);
        this.getServer().getPluginManager().registerEvents(new CreeperDamageEventListener(), this);

        this.getLogger().info("Started");

    }

    @Override
    public void onDisable() {

        this.getLogger().info("Stopping...");

        this.getLogger().info("Stopped");

    }

    public static CreeperAntiExplodePlugin getPlugin() {

        return CreeperAntiExplodePlugin.PLUGIN;

    }

}
