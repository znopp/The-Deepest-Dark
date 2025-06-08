package pw.znopp.theDeepestDark.drops;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class DropRegistry {
    private static final Map<EntityType<?>, DropHandler> HANDLERS = new HashMap<>();

    public static void register(EntityType<?> type, DropHandler handler) {
        HANDLERS.put(type, handler);
    }

    public static void init() {
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            DropHandler handler = HANDLERS.get(entity.getType());
            if (handler == null) {
                return;
            }
            handler.handleDrops(entity, source);
        });
    }
}
