package com.Secretaria.Secretaria.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Secretaria.Secretaria.Model.Documento;
import com.Secretaria.Secretaria.repository.DocumentoRepository;

@Service
public class DocumentoService {

    @Value("${upload.dir}")
    private String uploadDir;

    @Autowired
    private DocumentoRepository documentoRepository;

    public Documento guardarDocumento(MultipartFile archivo) throws IOException {
        if (archivo.isEmpty()) {
            throw new IOException("El archivo está vacío");
        }

        // ✅ Crear la carpeta si no existe
        Path directorio = Paths.get(uploadDir);
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio);
        }

        // ✅ Nombre único del archivo
        String nombreArchivo = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();
        Path ruta = directorio.resolve(nombreArchivo);

        // ✅ Guardar el archivo físicamente
        Files.copy(archivo.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);

        // ✅ Crear registro en la BD
        Documento doc = new Documento();
        doc.setNombre(archivo.getOriginalFilename());
        doc.setTipo(archivo.getContentType());
        doc.setUrl("/uploads/" + nombreArchivo);

        return documentoRepository.save(doc);
    }

    // ✅ Método para obtener todos los documentos
    public List<Documento> listarDocumentos() {
        return documentoRepository.findAll();
    }

    // ✅ Método para obtener un documento específico
    public Optional<Documento> obtenerDocumento(Long id) {
        return documentoRepository.findById(id);
    }

    public void eliminarDocumento(Long id) throws IOException {
        Optional<Documento> documentoOpt = documentoRepository.findById(id);
        if (documentoOpt.isPresent()) {
            Documento doc = documentoOpt.get();

            // 📂 Ruta del archivo físico
            Path ruta = Paths.get(uploadDir).resolve(
                    doc.getUrl().replace("/uploads/", ""));

            // 🗑️ Eliminar el archivo del disco
            if (Files.exists(ruta)) {
                Files.delete(ruta);
            }

            // 🗃️ Eliminar de la base de datos
            documentoRepository.deleteById(id);
        } else {
            throw new IOException("El documento no existe");
        }
    }

}
