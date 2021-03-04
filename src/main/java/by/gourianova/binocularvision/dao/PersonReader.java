package by.gourianova.binocularvision.dao;

import by.gourianova.binocularvision.dao.Sevice.deserializationFromFileType;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.io.FileUtils.readFileToString;

public class PersonReader {
    private static final String FILE_XML_PATH = "persons.xml";
    private static final String FILE_TXT_PATH = "persons.txt";

    private XMLDto request1;
    private TextDto request2;

public PersonReader(deserializationFromFileType type){
      switch (type){
        case XML :
                 //=private static XMLDto deserializationFromFile() {
            try {
                ClassLoader classLoader = PersonReader.class.getClassLoader();
                String resource = requireNonNull(classLoader.getResource(FILE_XML_PATH)).getFile();
                String text = readFileToString(new File(resource), UTF_8);
                request1= new XMLDto(text);
            } catch (IOException ex) {
                System.out.println("Can't read resource for reason: {}" + ex.getMessage());
                throw new RuntimeException("Can't read resource.");

        };
        case TXT :
            try {
                ClassLoader classLoader = PersonReader.class.getClassLoader();
                String resource = requireNonNull(classLoader.getResource(FILE_TXT_PATH)).getFile();
                String text = readFileToString(new File(resource), UTF_8);
                request2 = new TextDto(text);
            } catch (IOException ex) {
                System.out.println("Can't read resource for reason: {}" + ex.getMessage());
                throw new RuntimeException("Can't read resource.");

        };

        default: throw new IllegalStateException("Unexpected value: " + type);
    }
 //request = deserializationFromFile();
}


   public XMLDto getXMLDto(){
       return request1;
   }


    public TextDto getTextDto(){
        return request2;
    }
            
    
}
