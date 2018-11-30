package me.terror.tgac;

import me.terror.tgac.events.CheckManager;
import me.terror.tgac.events.JoinLeaveListener;
import me.terror.tgac.util.User;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class MainClass extends JavaPlugin {

    public static final HashMap<UUID, User> USER = new HashMap();
    public static final ArrayList<CheckType> DISABLE_CHECKS = new ArrayList();
    public static final boolean SIMPLE_LOG = false;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Aska suge pula");
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinLeaveListener(), this);
        pm.registerEvents(new CheckManager(), this);

        new Cleaner().r
    }

    @Override
    public void onDisable() {
    }
}
