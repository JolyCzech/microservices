package com.elikhcode.scam;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ScamCheckHistory {

    @Id
    @SequenceGenerator(
            name = "scam_id_sequence",
            sequenceName = "scam_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "scam_id_sequence"
    )
    private Integer id;
    private Integer clientId;
    private Boolean isScammer;
    private LocalDateTime createdAt;
}
