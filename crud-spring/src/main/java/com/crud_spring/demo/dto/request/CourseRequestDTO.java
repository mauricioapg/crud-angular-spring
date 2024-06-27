package com.crud_spring.demo.dto.request;

public class CourseRequestDTO {

    private String name;
    private String category;

    public CourseRequestDTO() {}

    public CourseRequestDTO(Long id, String name, String category) {
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
