package me.dlwinner1468.creeperantiexplodeplugin.events;

import me.dlwinner1468.creeperantiexplodeplugin.CreeperAntiExplodePlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CreeperDamageEventListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

        boolean active = CreeperAntiExplodePlugin.getPlugin().getConfig().getBoolean("Active");
        boolean disableDamage = CreeperAntiExplodePlugin.getPlugin().getConfig().getBoolean("DisableDamage");

        if (!active) return;
        if (!disableDamage) return;
        if (e.getDamager() == null) return;
        if (e.getDamager().getType() != EntityType.CREEPER) return;

        e.setCancelled(true);

    }

}
