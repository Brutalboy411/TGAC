package me.terror.tgac.util;

import org.bukkit.Location;
import org.bukkit.Material;

public class MovementUtil {
    public static final double PLAYER_WIDTH = 0.6D;
    public static final double PLAYER_HEIGTH = 1.8D;
    public static final double PLAYER_HEIGTH_SNEAKING = 1.6D;

    public static boolean isStepping(Location location)
    {
        return (isColliding(location, CHECK_STAIR)) || (isColliding(location, CHECK_STEP));
    }

    public static boolean isColliding(Location location, MaterialCheck material)
    {
        double d = 0.3D;
        return (material.checkMaterial(location)) ||
                (material.checkMaterial(location.clone().add(d, 0.0D, 0.0D))) ||
                (material.checkMaterial(location.clone().add(-d, 0.0D, 0.0D))) ||
                (material.checkMaterial(location.clone().add(d, 0.0D, d))) ||
                (material.checkMaterial(location.clone().add(-d, 0.0D, d))) ||
                (material.checkMaterial(location.clone().add(d, 0.0D, -d))) ||
                (material.checkMaterial(location.clone().add(-d, 0.0D, -d))) ||
                (material.checkMaterial(location.clone().add(0.0D, 0.0D, -d))) ||
                (material.checkMaterial(location.clone().add(0.0D, 0.0D, d)));
    }

    public static boolean shouldNotFlag(Location loc)
    {
        return (isMaterialGlideable(loc.getBlock().getType())) ||
                (isMaterialGlideable(loc.clone().add(0.3D, 0.0D, 0.0D).getBlock().getType())) ||
                (isMaterialGlideable(loc.clone().add(0.3D, 0.0D, 0.3D).getBlock().getType())) ||
                (isMaterialGlideable(loc.clone().add(0.3D, 0.0D, -0.3D).getBlock().getType())) ||
                (isMaterialGlideable(loc.clone().add(-0.3D, 0.0D, 0.0D).getBlock().getType())) ||
                (isMaterialGlideable(loc.clone().add(-0.3D, 0.0D, -0.3D).getBlock().getType())) ||
                (isMaterialGlideable(loc.clone().add(0.0D, 0.0D, -0.3D).getBlock().getType())) ||
                (isMaterialGlideable(loc.clone().add(0.0D, 0.0D, 0.3D).getBlock().getType())) ||
                (isOnGround(loc.clone().add(0.0D, 0.0D, 0.0D)));
    }

    public static boolean isOnGround(Location loc)
    {
        return (loc.getBlock().getLocation().clone().add(0.0D, -1.0D, 0.0D).getBlock().getType().isSolid()) || (loc.clone().add(0.3D, -1.0D, 0.0D).getBlock().getType().isSolid()) ||
                (loc.clone().add(0.3D, -1.0D, 0.3D).getBlock().getType().isSolid()) ||
                (loc.clone().add(0.3D, -1.0D, -0.3D).getBlock().getType().isSolid()) ||
                (loc.clone().add(-0.3D, -1.0D, 0.0D).getBlock().getType().isSolid()) ||
                (loc.clone().add(-0.3D, -1.0D, -0.3D).getBlock().getType().isSolid()) ||
                (loc.clone().add(0.0D, -1.0D, -0.3D).getBlock().getType().isSolid()) ||
                (loc.clone().add(0.0D, -1.0D, 0.3D).getBlock().getType().isSolid());
    }

    public static boolean isMaterialGlideable(Material mat)
    {
        switch (mat)
        {
            case COMMAND_MINECART:
            case EMERALD:
                return true;
        }
        return false;
    }

    private static final MaterialCheck CHECK_STAIR = new MaterialCheck()
    {
        public boolean checkMaterial(Material material)
        {
            switch (material)
            {
                case CHEST:
                case COOKED_BEEF:
                case EMERALD_ORE:
                case EMPTY_MAP:
                case ENDER_PORTAL:
                case FISHING_ROD:
                case GHAST_TEAR:
                case GLASS:
                case GLASS_BOTTLE:
                case GOLD_SPADE:
                case HAY_BLOCK:
                case HOPPER:
                case IRON_INGOT:
                    return true;
            }
            return false;
        }
    };
    private static final MaterialCheck CHECK_STEP = new MaterialCheck()
    {
        public boolean checkMaterial(Material material)
        {
            switch (material)
            {
                case CARROT:
                case FIREWORK:
                    return true;
            }
            return false;
        }
    };
}
