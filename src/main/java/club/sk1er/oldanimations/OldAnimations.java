package club.sk1er.oldanimations;

import club.sk1er.oldanimations.command.OldAnimationsCommand;
import club.sk1er.oldanimations.config.OldAnimationsSettings;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = OldAnimations.MODID, name = "Sk1er Old Animations", version = OldAnimations.VERSION, acceptedMinecraftVersions = "[1.8.9]")
public class OldAnimations {

    public static final String MODID = "sk1er_old_animations";
    public static final String VERSION = "0.2.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Инициализируем конфиг до загрузки всего остального
        OldAnimationsSettings.init(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // Регистрация обработчиков событий
        MinecraftForge.EVENT_BUS.register(AnimationHandler.getInstance());
        MinecraftForge.EVENT_BUS.register(SneakHandler.getInstance());
        
        // Регистрация клиентской команды через фордж
        ClientCommandHandler.instance.registerCommand(new OldAnimationsCommand());
    }
}