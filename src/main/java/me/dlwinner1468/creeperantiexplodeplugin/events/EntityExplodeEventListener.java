package me.dlwinner1468.creeperantiexplodeplugin.events;

import me.dlwinner1468.creeperantiexplodeplugin.CreeperAntiExplodePlugin;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplodeEventListener implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {

        boolean active = CreeperAntiExplodePlugin.getPlugin().getConfig().getBoolean("Active");
        boolean removeCreeperEntityOnExplode = CreeperAntiExplodePlugin.getPlugin().getConfig().getBoolean("RemoveCreeperEntityOnExplode");
        boolean showParticles = CreeperAntiExplodePlugin.getPlugin().getConfig().getBoolean("ShowParticles");
        int particleCount = CreeperAntiExplodePlugin.getPlugin().getConfig().getInt("ParticleCount");
        boolean playSound = CreeperAntiExplodePlugin.getPlugin().getConfig().getBoolean("PlaySound");

        if (!active) return;
        if (e.getEntityType() == null) return;
        if (e.getEntityType() != EntityType.CREEPER) return;

        e.setCancelled(true);

        if (removeCreeperEntityOnExplode) e.getEntity().remove();

        if (showParticles) {

            Location location = e.getEntity().getLocation();

            e.getEntity().getWorld().spawnParticle(Particle.SMOKE_LARGE, location, particleCount);

        }

        if (playSound) {

            Location location = e.getEntity().getLocation();

            e.getEntity().getWorld().playSound(location, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);

        }

    }

}
