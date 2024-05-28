package com.syskimy.scatalog.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface LocalStorageService {
    void save(MultipartFile file);
    Resource load(String filename);
}
