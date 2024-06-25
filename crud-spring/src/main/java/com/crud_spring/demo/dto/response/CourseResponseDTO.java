package com.crud_spring.demo.dto.response;

public class CourseResponseDTO {

    private String name;
    private String category;

    // Construtor padrão
    public CourseResponseDTO() {}

    // Construtor com parâmetros
    public CourseResponseDTO(Long id, String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
