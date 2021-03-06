package com.backtobedrock.augmentedhardcore.eventListeners;

import com.backtobedrock.augmentedhardcore.domain.enums.Permission;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class ListenerPlayerRegainHealth extends AbstractEventListener {

    @EventHandler
    public void onEntityRegainHealth(EntityRegainHealthEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (event.getEntity().getType() != EntityType.PLAYER) {
            return;
        }

        EntityRegainHealthEvent.RegainReason reason = event.getRegainReason();
        if (this.plugin.getConfigurations().getMiscellaneousConfiguration().isDisableArtificialRegeneration() && (reason == EntityRegainHealthEvent.RegainReason.EATING || reason == EntityRegainHealthEvent.RegainReason.MAGIC || reason == EntityRegainHealthEvent.RegainReason.MAGIC_REGEN)) {
            if (event.getEntity().hasPermission(Permission.BYPASS_ARTIFICIALREGENERATION.getPermissionString())) {
                return;
            }
            event.setCancelled(true);
        }
    }

    @Override
    public boolean isEnabled() {
        return (this.plugin.getConfigurations().getMiscellaneousConfiguration().isDisableArtificialRegeneration());
    }
}
