package me.terror.tgac;

import me.terror.tgac.checks.CheckResult;
import me.terror.tgac.checks.CheckType;
import me.terror.tgac.checks.events.CheckManager;
import me.terror.tgac.checks.events.JoinLeaveListener;
import me.terror.tgac.util.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class MainClass extends JavaPlugin implements Listener {

    public static final HashMap<UUID, User> USERS = new HashMap();
    public static final ArrayList<CheckType> DISABLED_CHECKS = new ArrayList();
    public static final boolean SIMPLE_LOG = false;

    public void onEnable()
    {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinLeaveListener(), this);
        pm.registerEvents(new CheckManager(), this);

        new Cleaner().runTaskTimerAsynchronously(this, 200L, 200L);
        for (Player p : Bukkit.getOnlinePlayers()) {
            USERS.put(p.getUniqueId(), new User(p));
        }
    }

    public static void log(User u, CheckResult result)
    {
        if (DISABLED_CHECKS.contains(result.getType())) {
            throw new IllegalStateException("Error! Tried to log a disabled check!");
        }
        String message = ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "TGAC: " + ChatColor.AQUA.toString() + u.getPlayer().getName() + ChatColor.GRAY + " tried to use " + ChatColor.RED + result.getType().getName();

        message = message + ChatColor.GRAY + ", " + result.getMessage();
        u.getPlayer().sendMessage(message);
        Bukkit.getLogger().info(message);
    }

    public static User getUser(Player player)
    {
        for (User user : USERS.values()) {
            if ((user.getPlayer() == player) || (user.getPlayer().getUniqueId().equals(player.getUniqueId()))) {
                return user;
            }
        }
        return null;
    }

    public static boolean shouldCheck(User user, CheckType type)
    {
        return !DISABLED_CHECKS.contains(type);
    }

    public static boolean isSilent()
    {
        return false;
    }

}
