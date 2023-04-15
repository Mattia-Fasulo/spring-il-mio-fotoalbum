package org.project.fotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name must not be empty")
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Lob
    private String description;

    @NotEmpty(message = "Url must not be empty")
    private String url;

    // @Value("${visible:false}")
    private boolean visible;

    @ManyToMany
    @JoinTable(
        name = "category_photo",
        joinColumns = @JoinColumn(name = "photo_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")

    )
    public Set<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "photo_type",
            joinColumns = @JoinColumn(name = "photo_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    public Set<Type> types;

    private LocalDateTime createdAt;


    public Photo() {
        super();
    }

    public Photo(String name, String description, String url, boolean visible, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.visible = visible;
        this.categories = categories;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return visible == photo.visible && Objects.equals(id, photo.id) && Objects.equals(name, photo.name) && Objects.equals(description, photo.description) && Objects.equals(url, photo.url) && Objects.equals(categories, photo.categories);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", visible=" + visible +
                ", categories=" + categories +
                ", types=" + types +
                ", createdAt=" + createdAt +
                '}';
    }
}
