package org.project.fotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

@Entity
@Table(name = "types")
public class Type {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @NotEmpty(message = "Name must not be empty")
     @Column(name = "name", unique = true, nullable = false)
     private String name;

     @ManyToMany(mappedBy = "types")
     private Set<Photo> photos;

     public Type(){
          super();
     }
     public Type(String name, Set<Photo> photos) {
          this.name = name;
          this.photos = photos;
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

     public Set<Photo> getPhotos() {
          return photos;
     }

     public void setPhotos(Set<Photo> photos) {
          this.photos = photos;
     }

     @Override
     public String toString() {
          return "Type{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  '}';
     }
}
