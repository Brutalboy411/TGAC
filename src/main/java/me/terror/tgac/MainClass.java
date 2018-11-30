package me.terror.tgac;

import me.terror.tgac.util.User;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class MainClass extends JavaPlugin {

    public static final HashMap<UUID, User> USER = new HashMap();
    public static final ArrayList<CheckType> DISABLE_CHECKS = new ArrayList();

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Aska suge pula");
    }

    @Override
    public void onDisable() {
    }
}
