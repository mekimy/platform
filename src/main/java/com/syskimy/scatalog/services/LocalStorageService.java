package com.syskimy.scatalog.services;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void save(MultipartFile file);
}
