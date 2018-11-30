package me.terror.tgac;

import org.bukkit.plugin.java.JavaPlugin;

public final class MainClass extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage("Aska suge pula");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
