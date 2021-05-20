package com.sisipapa.graphql.dto;

import com.sisipapa.graphql.domain.RoleGraphQL;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Integer id;

    private Integer memberId;

    private String role;

    public static List<RoleDto> from(Collection<RoleGraphQL> entities) {
        if(entities == null) {
            return null;
        }
        return entities.stream().map(RoleDto::from).collect(Collectors.toList());
    }

    public static RoleDto from(RoleGraphQL entity) {
        return RoleDto.builder()
                .id(entity.getId())
                .memberId(entity.getMemberId())
                .role(entity.getRole())
                .build();
    }
}
