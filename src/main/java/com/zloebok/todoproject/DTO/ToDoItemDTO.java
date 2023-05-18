package com.zloebok.todoproject.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ToDoItemDTO {

    private Long id;

    private String description;

    private Date created;

    private Date updated;

}
