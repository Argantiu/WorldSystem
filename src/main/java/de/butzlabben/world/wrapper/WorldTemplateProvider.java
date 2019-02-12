package de.butzlabben.world.wrapper;

import de.butzlabben.world.config.PluginConfig;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author Butzlabben
 * @since 16.12.2018
 */
public class WorldTemplateProvider {

    private static WorldTemplateProvider instance = new WorldTemplateProvider();

    public static WorldTemplateProvider getInstace() {
        return instance;
    }

    private HashMap<String, WorldTemplate> templates = new HashMap<>();

    private WorldTemplateProvider() {
        ConfigurationSection section = PluginConfig.getConfig().getConfigurationSection("worldtemplates.templates");
        for (String key : section.getKeys(false)) {
            String name = section.getString(key + ".name");
            String permission = null;
            if (section.isString(key + ".permission"))
                 permission = section.getString(key + ".permission");
            templates.put(name, new WorldTemplate(name, permission));
        }
    }

    public WorldTemplate getTemplate(String key) {
        return templates.get(key);
    }

    public Collection<WorldTemplate> getTemplates() {
        return templates.values();
    }
}
