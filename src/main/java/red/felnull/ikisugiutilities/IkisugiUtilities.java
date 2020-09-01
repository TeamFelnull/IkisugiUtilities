package red.felnull.ikisugiutilities;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import red.felnull.ikisugiutilities.proxy.ClientProxy;
import red.felnull.ikisugiutilities.proxy.CommonProxy;
import red.felnull.otyacraftengine.client.config.ClientConfig;

@Mod(IkisugiUtilities.MODID)
public class IkisugiUtilities {
    public static final String MODID = "ikisugiutilities";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final CommonProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());

    public IkisugiUtilities() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        ClientConfig.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.preInit();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientProxy.clientInit();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        proxy.init();
    }

    private void processIMC(final InterModProcessEvent event) {
        proxy.posInit();
    }
}
