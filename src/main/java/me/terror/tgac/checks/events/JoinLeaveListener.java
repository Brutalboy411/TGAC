package me.terror.tgac.checks.events;

import me.terror.tgac.MainClass;
import me.terror.tgac.util.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        MainClass.USERS.put(e.getPlayer().getUniqueId(), new User(e.getPlayer()));
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e)
    {
        MainClass.USERS.remove(e.getPlayer().getUniqueId());
    }
}
