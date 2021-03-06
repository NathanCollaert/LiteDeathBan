package com.backtobedrock.augmentedhardcore.domain.configurationDomain;

import com.backtobedrock.augmentedhardcore.AugmentedHardcore;
import com.backtobedrock.augmentedhardcore.domain.configurationDomain.configurationHelperClasses.Display;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class ConfigurationGuis {
    private final Display fillerDisplay;
    private final Display accentDisplay;
    private final Display loadingDisplay;
    private final Display notAvailableDisplay;
    private final Display nextPageDisplay;
    private final Display previousPageDisplay;
    private final Display pageInformationDisplay;
    private final Display previousGuiDisplay;
    private final Display confirmationDisplay;
    private final Display cancellationDisplay;
    private final Display livesAndLifePartsDisplay;
    private final Display maxHealthDisplay;
    private final Display reviveDisplay;
    private final Display reviveOnCooldownDisplay;
    private final Display lifePartDisplay;
    private final Display previousBansDisplay;
    private final Display PlayerDisplay;
    private final Display serverDisplay;
    private final Display banDisplay;
    private final Display revivingDisplay;

    public ConfigurationGuis(Display fillerDisplay, Display accentDisplay, Display loadingDisplay, Display notAvailableDisplay, Display nextPageDisplay, Display previousPageDisplay, Display pageInformationDisplay, Display previousGuiDisplay, Display confirmationDisplay, Display cancellationDisplay, Display livesAndLifePartsDisplay, Display maxHealthDisplay, Display reviveDisplay, Display reviveOnCooldownDisplay, Display lifePartDisplay, Display previousBansDisplay, Display playerDisplay, Display serverDisplay, Display banDisplay, Display revivingDisplay) {
        this.fillerDisplay = fillerDisplay;
        this.accentDisplay = accentDisplay;
        this.loadingDisplay = loadingDisplay;
        this.notAvailableDisplay = notAvailableDisplay;
        this.nextPageDisplay = nextPageDisplay;
        this.previousPageDisplay = previousPageDisplay;
        this.pageInformationDisplay = pageInformationDisplay;
        this.previousGuiDisplay = previousGuiDisplay;
        this.confirmationDisplay = confirmationDisplay;
        this.cancellationDisplay = cancellationDisplay;
        this.livesAndLifePartsDisplay = livesAndLifePartsDisplay;
        this.maxHealthDisplay = maxHealthDisplay;
        this.reviveDisplay = reviveDisplay;
        this.reviveOnCooldownDisplay = reviveOnCooldownDisplay;
        this.lifePartDisplay = lifePartDisplay;
        this.previousBansDisplay = previousBansDisplay;
        this.PlayerDisplay = playerDisplay;
        this.serverDisplay = serverDisplay;
        this.banDisplay = banDisplay;
        this.revivingDisplay = revivingDisplay;
    }

    public static ConfigurationGuis deserialize(ConfigurationSection section) {
        AugmentedHardcore plugin = JavaPlugin.getPlugin(AugmentedHardcore.class);

        Map<String, Display> cDisplays = new HashMap<>();

        for (String e : Arrays.asList(
                "FillerDisplay",
                "AccentDisplay",
                "LoadingDisplay",
                "NotAvailableDisplay",
                "NextPageDisplay",
                "PreviousPageDisplay",
                "PageInformationDisplay",
                "PreviousGuiDisplay",
                "ConfirmationDisplay",
                "CancellationDisplay",
                "LivesAndLifePartsDisplay",
                "MaxHealthDisplay",
                "ReviveDisplay",
                "ReviveOnCooldownDisplay",
                "LifePartDisplay",
                "PreviousBansDisplay",
                "PlayerDisplay",
                "ServerDisplay",
                "BanDisplay",
                "RevivingDisplay"
        )) {
            ConfigurationSection displaySection = section.getConfigurationSection(e);
            if (displaySection != null) {
                Display display = Display.deserialize(e, displaySection);
                if (display == null) {
                    return null;
                }
                cDisplays.put(e, display);
            } else {
                plugin.getLogger().log(Level.SEVERE, String.format("%s was not found, plugin is unable to load.", e));
                return null;
            }
        }

        return new ConfigurationGuis(
                cDisplays.get("FillerDisplay"),
                cDisplays.get("AccentDisplay"),
                cDisplays.get("LoadingDisplay"),
                cDisplays.get("NotAvailableDisplay"),
                cDisplays.get("NextPageDisplay"),
                cDisplays.get("PreviousPageDisplay"),
                cDisplays.get("PageInformationDisplay"),
                cDisplays.get("PreviousGuiDisplay"),
                cDisplays.get("ConfirmationDisplay"),
                cDisplays.get("CancellationDisplay"),
                cDisplays.get("LivesAndLifePartsDisplay"),
                cDisplays.get("MaxHealthDisplay"),
                cDisplays.get("ReviveDisplay"),
                cDisplays.get("ReviveOnCooldownDisplay"),
                cDisplays.get("LifePartDisplay"),
                cDisplays.get("PreviousBansDisplay"),
                cDisplays.get("PlayerDisplay"),
                cDisplays.get("ServerDisplay"),
                cDisplays.get("BanDisplay"),
                cDisplays.get("RevivingDisplay")
        );
    }

    public Display getFillerDisplay() {
        return fillerDisplay;
    }

    public Display getAccentDisplay() {
        return accentDisplay;
    }

    public Display getNextPageDisplay() {
        return nextPageDisplay;
    }

    public Display getPreviousPageDisplay() {
        return previousPageDisplay;
    }

    public Display getPageInformationDisplay() {
        return pageInformationDisplay;
    }

    public Display getLivesAndLifePartsDisplay() {
        return livesAndLifePartsDisplay;
    }

    public Display getMaxHealthDisplay() {
        return maxHealthDisplay;
    }

    public Display getReviveDisplay() {
        return reviveDisplay;
    }

    public Display getLifePartDisplay() {
        return lifePartDisplay;
    }

    public Display getPreviousBansDisplay() {
        return previousBansDisplay;
    }

    public Display getBanDisplay() {
        return banDisplay;
    }

    public Display getConfirmationDisplay() {
        return confirmationDisplay;
    }

    public Display getCancellationDisplay() {
        return cancellationDisplay;
    }

    public Display getLoadingDisplay() {
        return loadingDisplay;
    }

    public Display getNotAvailableDisplay() {
        return notAvailableDisplay;
    }

    public Display getPreviousGuiDisplay() {
        return previousGuiDisplay;
    }

    public Display getPlayerDisplay() {
        return PlayerDisplay;
    }

    public Display getReviveOnCooldownDisplay() {
        return reviveOnCooldownDisplay;
    }

    public Display getServerDisplay() {
        return serverDisplay;
    }

    public Display getRevivingDisplay() {
        return revivingDisplay;
    }
}
