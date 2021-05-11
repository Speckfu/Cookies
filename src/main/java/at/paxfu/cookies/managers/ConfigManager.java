package at.paxfu.cookies.managers;

import at.paxfu.cookies.Cookies;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.List;

public class ConfigManager {

    final JavaPlugin javaPlugin;
    String name;
    String dir = "";
    String defFileName = null;
    File configFile;
    @Getter
    private FileConfiguration configuration;
    private boolean isLoaded = false;
    private String startPath = "";

    public ConfigManager(JavaPlugin javaPlugin, String name) {
        this.name = name.replace(".yml","");
        this.javaPlugin = javaPlugin;
        dir = javaPlugin.getDataFolder().getAbsolutePath();
        this.configFile = new File(dir + this.name + ".yml");

        init();
    }
    public ConfigManager(JavaPlugin javaPlugin, String dir, String name) {
        this.name = name.replace(".yml","");
        this.dir = dir;
        this.javaPlugin = javaPlugin;
        this.configFile = new File(dir + this.name + ".yml");
        init();
    }
    public ConfigManager(JavaPlugin javaPlugin, String dir, String name, String defFileName) {
        this.javaPlugin = javaPlugin;
        this.name = name.replace(".yml","");
        this.dir = dir;
        this.defFileName = defFileName;
        this.configFile = new File(dir + this.name + ".yml");
        init();
    }

    private void init() {
        File dir = new File(this.dir);
        if (!dir.exists()) dir.mkdirs();
        if (!configFile.exists()) {
            if (!copyDefault()) {
                try {
                    configFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        configuration = new YamlConfiguration();
        try {
            configuration.load(configFile);
            isLoaded = true;
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private boolean copyDefault() {
        if (defFileName == null) return false;
        BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + defFileName + ".yml")));
        try {
            String res = "";
            String in;
            while ((in = br.readLine()) != null) {
                res += in+"\n";
            }
            try {
                File f_file = new File(dir + name + ".yml");
                Writer f_writer = new FileWriter(f_file);
                f_writer.write(res);
                f_writer.close();
                f_file.setExecutable(true);
                f_file.setReadable(true);
                f_file.setWritable(true);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException var5) {
            var5.printStackTrace();
            return false;
        }
    }

    public boolean save() {
        try {
            configuration.save(configFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void set(String path, Object object){
        path = startPath+path;
        configuration.set(path,object);
        save();
    }
    public Object get(String path){
        path = startPath+path;
        return configuration.get(path);
    }
    public Object getOrSetDefault(String path, Object defaultValue){
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return configuration.get(path);
    }

    public String getString(String path){
        path = startPath+path;
        return configuration.getString(path);
    }
    public String getStringOrSetDefault(String path, String defaultValue){
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return configuration.getString(path);
    }

    public int getInt(String path){
        path = startPath+path;
        return configuration.getInt(path);
    }
    public int getIntOrSetDefault(String path,int defaultValue){
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return configuration.getInt(path);
    }

    public double getDouble(String path){
        path = startPath+path;
        return configuration.getDouble(path);
    }
    public double getDoubleOrSetDefault(String path, double defaultValue){
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return configuration.getDouble(path);
    }

    public boolean getBoolean(String path){
        path = startPath+path;
        return configuration.getBoolean(path);
    }
    public boolean getBooleanOrSetDefault(String path, boolean defaultValue){
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return configuration.getBoolean(path);
    }

    public List<?> getList(String path){
        path = startPath+path;
        return configuration.getList(path);
    }
    public List<?> getListOrSetDefault(String path, List<?> defaultValue){
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return getList(path);
    }


    public void addLocation( Location location, String path){
        path = startPath+path;
        configuration.set(String.format("%s.world", path), location.getWorld().getName());
        configuration.set(String.format("%s.x", path), location.getX());
        configuration.set(String.format("%s.y", path), location.getY());
        configuration.set(String.format("%s.z", path), location.getZ());
        configuration.set(String.format("%s.yaw", path), location.getYaw());
        configuration.set(String.format("%s.pitch", path), location.getPitch());
        save();
    }

  public Location getLocation(String path){
        path = startPath+path;
        if (getString(String.format("%s.world", path))==null)return null;
        String worldName = getString(String.format("%s.world", path));
        Bukkit.getServer().createWorld(new WorldCreator(worldName));
        World world = Bukkit.getWorld(worldName);
        int x = getInt(String.format("%s.x", path));
        int y = getInt(String.format("%s.y", path));
        int z = getInt(String.format("%s.z", path));
//        float yaw = getFloat(String.format("%s.yaw", path));
//        float pitch = getFloat(String.format("%s.pitch", path));
        return new Location(world, x, y, z);
    }

    public void setStartPath(String path){
        if (!path.endsWith(".")){
            this.startPath = path+".";
        }else{
            this.startPath = path;
        }
    }

    public ItemStack getItemStack(String path) {
        path = startPath+path;
        return configuration.getItemStack(path);
    }
    public ItemStack getItemStackOrSetDefault(String path, ItemStack defaultValue) {
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return configuration.getItemStack(path);
    }

    public List<String> getStringList(String path) {
        path = startPath+path;
        return configuration.getStringList(path);
    }
    public List<String> getStringListOrSetDefault(String path, List<String> defaultValue) {
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return configuration.getStringList(path);
    }


    public float getFloat(String path){
        path = startPath+path;
        return (float) configuration.get(path);
    }

    public float getFloatOrSetDefault(String path, float defaultValue){
        path = startPath+path;
        if (!configuration.contains(path)){
            configuration.set(path,defaultValue);
            save();
            return defaultValue;
        }
        return (float) configuration.get(path);
    }
}
