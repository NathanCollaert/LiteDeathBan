package com.backtobedrock.augmentedhardcore.domain.configurationDomain;

import com.backtobedrock.augmentedhardcore.AugmentedHardcore;
import com.backtobedrock.augmentedhardcore.utils.ConfigUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Level;

public class ReviveConfiguration {
    private final boolean useRevive;
    private final int livesLostOnReviving;
    private final int livesGainedOnRevive;
    private final int timeBetweenRevives;
    private final boolean reviveOnFirstJoin;
    private final List<String> disableReviveInWorlds;

    public ReviveConfiguration(boolean useRevive, int livesLostOnReviving, int livesGainedOnRevive, int timeBetweenRevives, boolean reviveOnFirstJoin, List<String> disableReviveInWorlds) {
        this.useRevive = useRevive;
        this.livesLostOnReviving = livesLostOnReviving;
        this.livesGainedOnRevive = livesGainedOnRevive;
        this.timeBetweenRevives = timeBetweenRevives;
        this.reviveOnFirstJoin = reviveOnFirstJoin;
        this.disableReviveInWorlds = disableReviveInWorlds;
    }

    public static ReviveConfiguration deserialize(ConfigurationSection section) {
        boolean cUseRevive = section.getBoolean("UseRevive", true);
        int cLivesLostOnReviving = ConfigUtils.checkMin("LivesLostOnReviving", section.getInt("LivesLostOnReviving", 1), 1);
        int cLivesGainedOnRevive = ConfigUtils.checkMin("LivesGainedOnRevive", section.getInt("LivesGainedOnRevive", 1), 1);
        int cTimeBetweenRevives = ConfigUtils.checkMin("TimeBetweenRevives", section.getInt("TimeBetweenRevives", 1440), 0);
        boolean cReviveOnFirstJoin = section.getBoolean("ReviveOnFirstJoin", false);
        List<String> cDisableReviveInWorlds = ConfigUtils.getWorlds("DisableReviveInWorlds", section.getStringList("DisableReviveInWorlds"));

        if (cUseRevive && !JavaPlugin.getPlugin(AugmentedHardcore.class).getConfigurations().getLivesAndLifePartsConfiguration().isUseLives()) {
            JavaPlugin.getPlugin(AugmentedHardcore.class).getLogger().log(Level.SEVERE, "Reviving cannot be enabled without enabling lives.");
            cUseRevive = false;
        }

        if (cTimeBetweenRevives == -10 || cLivesLostOnReviving == -10 || cLivesGainedOnRevive == -10) {
            return null;
        }

        return new ReviveConfiguration(cUseRevive, cLivesLostOnReviving, cLivesGainedOnRevive, cTimeBetweenRevives, cReviveOnFirstJoin, cDisableReviveInWorlds);
    }

    public boolean isUseRevive() {
        return useRevive;
    }

    public int getTimeBetweenRevives() {
        return timeBetweenRevives;
    }

    public boolean isReviveOnFirstJoin() {
        return reviveOnFirstJoin;
    }

    public List<String> getDisableReviveInWorlds() {
        return disableReviveInWorlds;
    }

    public int getLivesLostOnReviving() {
        return livesLostOnReviving;
    }

    public int getLivesGainedOnRevive() {
        return livesGainedOnRevive;
    }
}
