package by.gourianova.binocularvision.dao.Sevice;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.apache.commons.io.FilenameUtils.getPath;


public class Reader {

    Parser parser = new Parser();


        public void readXMLFile(String text) throws IOException {
            String[] xmlInform = text.split("\n");

            for (int i=0; i<xmlInform.length;i++){
                xmlInform[i] = xmlInform[i].trim();
                parser.parseOpenTag(xmlInform[i]);
                parser.parseDataTag(xmlInform[i]);
                parser.parseCloseTag(xmlInform[i]);

            }


   }

    public List<String> readTXTFile(String txt) {
//TODO: fail persons.txt in list form
        List<String> allLines=null;

        try {
            allLines = Files.readAllLines(Paths.get(String.valueOf(getPath(txt))));

        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return allLines;
     }
}
