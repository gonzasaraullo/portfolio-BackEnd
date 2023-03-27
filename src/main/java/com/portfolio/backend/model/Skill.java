package com.portfolio.backend.model;

import javax.persistence.*;import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombreSkill;
    @NotBlank
    @Min(1) @Max(100)
    private int gradoSkill;

    public Skill() {
    }

    public Skill(Long id, String nombreSkill, int gradoSkill) {
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.gradoSkill = gradoSkill;
    }

}
