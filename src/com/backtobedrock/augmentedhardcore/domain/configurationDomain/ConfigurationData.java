package com.backtobedrock.augmentedhardcore.domain.configurationDomain;

import com.backtobedrock.augmentedhardcore.domain.Connection;
import com.backtobedrock.augmentedhardcore.domain.enums.StorageType;
import com.backtobedrock.augmentedhardcore.utils.ConfigUtils;
import org.bukkit.configuration.ConfigurationSection;

public class ConfigurationData {
    private final StorageType storageType;
    private final Connection connection;

    public ConfigurationData(StorageType storageType, Connection connection) {
        this.storageType = storageType;
        this.connection = connection;
    }

    public static ConfigurationData deserialize(ConfigurationSection section) {
        //configurations
        StorageType cStorageType = ConfigUtils.getStorageType("StorageType", section.getString("StorageType", "YAML"));
        ConfigurationSection connectionSection = section.getConfigurationSection("Connection");
        Connection cConnection = (cStorageType == StorageType.MYSQL && connectionSection != null) ? Connection.deserialize(connectionSection) : null;

        if (cStorageType == StorageType.MYSQL && cConnection == null) {
            return null;
        }

        return new ConfigurationData(cStorageType, cConnection);
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public Connection getConnection() {
        return connection;
    }
}