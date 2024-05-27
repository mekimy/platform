package com.syskimy.scatalog.configs;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@Slf4j
public class StorageConfig {
    @Bean
    public MinioClient getMinIOClient() {
        MinioClient minioClient =  MinioClient
                .builder()
                .endpoint("http://localhost:9000")
                .credentials("FdTANJ8LaYgO3VNxbPRc", "O2y4eXjU0w6yL5uMzeJNOuBGyddGjES3gIyjzqDC")
                .build();

        return minioClient;
    }
}
