package by.gourianova.binocularvision.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class XMLDto implements Serializable {

    private String text;
}
