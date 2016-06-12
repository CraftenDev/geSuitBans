package net.cubespace.geSuitBans.tasks;

import net.cubespace.geSuitBans.geSuitBans;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;
import java.util.Collection;

public class PluginMessageTask extends BukkitRunnable {
    private final ByteArrayOutputStream bytes;

    public PluginMessageTask(ByteArrayOutputStream bytes) {
        this.bytes = bytes;
    }

    public void run() {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        if (onlinePlayers.isEmpty()) {
            geSuitBans.INSTANCE.getLogger().info("Tried to send a pluginMessage with an empty server. Cancelling.");
        } else {
            onlinePlayers.iterator().next().sendPluginMessage(geSuitBans.INSTANCE, "geSuitBans", bytes.toByteArray());
        }
    }
}
