package club.sk1er.oldanimations.command;

import club.sk1er.oldanimations.config.OldAnimationsSettings;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class OldAnimationsCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "oldanimations";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("oam");
        return aliases;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/oam reload - Reloads the configuration file.";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0; // Позволяет использовать команду без админки (клиентский мод)
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            OldAnimationsSettings.loadConfig();
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "OldAnimations config reloaded!"));
        } else {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: " + getCommandUsage(sender)));
        }
    }
}