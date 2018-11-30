package me.terror.tgac;

import me.terror.tgac.util.User;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class MainClass extends JavaPlugin {

    public static final HashMap<UUID, User> USER = new HashMap();

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Aska suge pula");
    }

    @Override
    public void onDisable() {
    }
}
