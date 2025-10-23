package com.Secretaria.Secretaria.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "upload")
public class StorageProperties {

    /**
     * Directorio de subida de archivos en el sistema de archivos.
     */
    private String dir = "uploads";

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
