package com.chrisferdev.pragmabackend.hus1;

import com.chrisferdev.pragmabackend.domain.api.usecase.CategoryServiceImpl;
import com.chrisferdev.pragmabackend.domain.model.Category;
import com.chrisferdev.pragmabackend.domain.spi.output.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class UseCase1Tests {
    ICategoryPersistencePort iCategoryPersistencePort;
    CategoryServiceImpl categoryServiceImpl;

    @BeforeEach
    void setUp(){
        iCategoryPersistencePort = mock(ICategoryPersistencePort.class);
        categoryServiceImpl = new CategoryServiceImpl(iCategoryPersistencePort);
    }

    @Test
    void saveCategory(){
        // Arrange
        Category category = new Category();
        category.setName("Categoría prueba");
        category.setDescription("Descripción Categoria");

        // Mock behavior Crea el objeto
        when(iCategoryPersistencePort.saveCategory(any(Category.class))).thenReturn(category);

        // Acti
        Category saveCategory = categoryServiceImpl.saveCategory(category);

        // Assert
        assertNotNull(saveCategory);
        assertEquals("Categoría prueba", saveCategory.getName());
        assertEquals("Descripción Categoria", saveCategory.getDescription());

        // Verify
        verify(iCategoryPersistencePort, times(1)).saveCategory(any(Category.class));
    }
}