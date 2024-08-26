package io.github.minan65.core_persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity{

    @Column(name="createdDate")
    private LocalDateTime createdDate;
    @Column(name="updatedDate")
    private LocalDateTime updatedDate;
    @Column(name="deletedDate")
    private LocalDateTime deletedDate;

    @PrePersist
    protected void onCreate(){
        createdDate=LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedDate=LocalDateTime.now();
    }

    @PreRemove
    protected void onDelete(){
        deletedDate=LocalDateTime.now();
    }

}