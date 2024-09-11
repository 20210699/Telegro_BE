package com.telegro.telegro.domain.company.entity;

import com.telegro.telegro.domain.user.entity.User;
import com.telegro.telegro.domain.user.entity.enums.Membership;
import com.telegro.telegro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column
    private Membership membership;

    @Column(length = 20)
    private String managerName;

    @Column(length = 20)
    private String managerNumber;

    @Column(length = 30)
    private String companyName;

    @Column(length = 30)
    private String companyNumber;

    @Column
    private String companyType;

    @Column
    private String companyItem;
}
