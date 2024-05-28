package com.syskimy.scatalog.services.impl;

import com.syskimy.scatalog.exceptions.InternalServerErrorException;
import com.syskimy.scatalog.exceptions.enums.InternalServerErrorExceptionTitleEnum;
import com.syskimy.scatalog.services.LocalStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
public class LocalStorageServiceImpl implements LocalStorageService {
    private final Path root = Paths.get("uploads");

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception ex) {
            log.error("error occurred while copying the file");

            throw new InternalServerErrorException(
                    InternalServerErrorExceptionTitleEnum.FILE_COPY,
                    "error occurred while copying the file"
            );
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            log.error("error occurred while loading the file {}", filename);
            throw new InternalServerErrorException(
                    InternalServerErrorExceptionTitleEnum.FILE_LOAD,
                    "error occurred while loading the file"
            );
        }

    }
}
