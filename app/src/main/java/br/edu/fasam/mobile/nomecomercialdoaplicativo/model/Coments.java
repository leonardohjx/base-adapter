package br.edu.fasam.mobile.nomecomercialdoaplicativo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Coments {
        Integer comentsId;
        Integer id;
        String name;
        String email;
        String body;
}
