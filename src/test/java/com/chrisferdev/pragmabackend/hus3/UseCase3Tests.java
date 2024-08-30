package com.chrisferdev.pragmabackend.hus3;

import com.chrisferdev.pragmabackend.domain.api.usecase.BrandServiceImpl;
import com.chrisferdev.pragmabackend.domain.model.Brand;
import com.chrisferdev.pragmabackend.domain.spi.output.IBrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class
UseCase3Tests {
    IBrandPersistencePort iBrandPersistencePort;
    BrandServiceImpl brandServiceImpl;

    @BeforeEach
    void setUp(){
        iBrandPersistencePort = mock(IBrandPersistencePort.class);
        brandServiceImpl = new BrandServiceImpl(iBrandPersistencePort);
    }

    @Test
    void saveBrand(){
        // Arrange
        Brand brand = new Brand();
        brand.setName("Marca prueba");
        brand.setDescription("Descripción Marca");

        // Mock behavior Crea el objeto
        when(iBrandPersistencePort.saveBrand(any(Brand.class))).thenReturn(brand);

        // Acti
        Brand saveBrand = brandServiceImpl.saveBrand(brand);

        // Assert
        assertNotNull(saveBrand);
        assertEquals("Marca prueba", saveBrand.getName());
        assertEquals("Descripción Marca", saveBrand.getDescription());

        // Verify
        verify(iBrandPersistencePort, times(1)).saveBrand(any(Brand.class));
    }
}
