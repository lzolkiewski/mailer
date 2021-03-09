package com.mailer.cass.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    @PrimaryKey private UUID id = UUID.randomUUID();
    private String title;
    private String content;
    private String email;
    private Integer magic_number;
}
