package pw.znopp.theDeepestDark.drops;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class EntityDropRegistry {
    private static final Map<EntityType<?>, EntityDropHandler> HANDLERS = new HashMap<>();

    public static void register(EntityType<?> type, EntityDropHandler handler) {
        HANDLERS.put(type, handler);
    }

    public static void init() {
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            EntityDropHandler handler = HANDLERS.get(entity.getType());
            if (handler == null) {
                return;
            }
            handler.handleDrops(entity, source);
        });
    }
}
