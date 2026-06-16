package club.sk1er.oldanimations.config;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class OldAnimationsSettings {

    public static Configuration config;

    // Position
    public static boolean oldModel = true;
    public static boolean oldBow = true;
    public static boolean oldSwordBlock = true;
    public static boolean oldRod = true;
    public static boolean oldSwordBlock3 = true;

    // Interaction
    public static boolean oldEating = true;
    public static boolean oldBlockhitting = true;
    public static boolean smoothSneaking = true;
    public static boolean longSneaking = true;
    public static boolean redArmor = true;
    public static boolean punching = true;
    public static boolean itemSwitch = true;

    // HUD & World
    public static boolean oldHealth = true;
    public static boolean oldDebugScreen = true;
    public static boolean oldTab = false;
    public static boolean oldDebugHitbox = true;

    public static void init(File configFile) {
        config = new Configuration(configFile);
        loadConfig();
    }

    public static void loadConfig() {
        try {
            config.load();
            
            oldModel = config.getBoolean("1.7 Item Positions", "Position", true, "Change all item models to be in the same position as 1.7.");
            oldBow = config.getBoolean("1.7 Bow Pullback", "Position", true, "Change the bow pullback animation to be like 1.7.");
            oldSwordBlock = config.getBoolean("1.7 Block Animation", "Position", true, "Change the sword block animation to be like 1.7.");
            oldRod = config.getBoolean("1.7 Rod Position", "Position", true, "Change the fishing rod model to be in the same position as 1.7.");
            oldSwordBlock3 = config.getBoolean("1.7 3rd Person Block Animation", "Position", true, "Change the 3rd person blocking animation to be like 1.7.");

            oldEating = config.getBoolean("Consume Animation", "Interaction", true, "Change the eating and drinking animation to look like 1.7.");
            oldBlockhitting = config.getBoolean("Block-Hitting Animation", "Interaction", true, "Makes block hitting look much smoother, like it did in 1.7.");
            smoothSneaking = config.getBoolean("Smooth Sneaking", "Interaction", true, "Makes the transition between sneaking/not sneaking smooth.");
            longSneaking = config.getBoolean("Longer Unsneak", "Interaction", true, "Makes moving up take longer than moving down.");
            redArmor = config.getBoolean("Red Armor", "Interaction", true, "Makes an entity's armor turn red when it's hit, like in 1.7.");
            punching = config.getBoolean("Punching During Usage", "Interaction", true, "Allows you to punch blocks whilst using an item.");
            itemSwitch = config.getBoolean("Item Switching Animation", "Interaction", true, "Stop held items from playing the switching animation when right clicking on blocks.");

            oldHealth = config.getBoolean("Remove Health Bar Flashing", "HUD", true, "Stops your health bar flashing when you take damage.");
            oldDebugScreen = config.getBoolean("Debug Screen", "HUD", true, "Remove the boxes in the debug screen.");
            oldTab = config.getBoolean("Tab Overlay", "HUD", false, "Remove player heads in tab.");
            
            oldDebugHitbox = config.getBoolean("Debug Hitbox", "World", true, "Remove the entity eye line and box from F3+B hitboxes.");

        } catch (Exception e) {
            System.out.println("Sk1er Old Animations: Error loading config file!");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}