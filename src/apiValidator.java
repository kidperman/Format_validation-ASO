import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class apiValidator {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            // Lee el archivo JSON local
            FileReader reader = new FileReader("src/apis/api-query.json");
           // FileReader dataM = new FileReader("src/apis/data-manager.json");

            // Parsea el JSON como un arreglo
            Object obj = parser.parse(reader);
           // Object dm = parser.parse(dataM);
            JSONArray jsonArray = (JSONArray) obj;
          //  JSONArray dmArray = (JSONArray) dm;

            // Iteración a través de los objetos en el arreglo al archivo local
            for (Object item : jsonArray) {
                JSONObject jsonObject = (JSONObject) item;

                // Accede a los datos del objeto dentro del arreglo
                String rfc = (String) jsonObject.get("rfc");
                String hom = (String) jsonObject.get("homonym");
                String id = (String) jsonObject.get("id");

                // VALIDACIÓN DE FORMATOS - PARECIDO A POSTMAN
                // String homonym = "123"; //linkeo a datos de DM
                if (validarFormato(hom, "^[0-9]{3}$")) {
                    System.out.println("Formato Homonimo correcto: " + hom);
                } else {
                    throw new RuntimeException("Ocurrio un error: error formato y/o sintaxis de la homonimia " + hom);
                }

                if (validarFormato(rfc, "^[A-Z]{4}[0-9]{6}$")) {
                    System.out.println("Formato RFC correcto: " + rfc);
                } else {
                    throw new RuntimeException("Ocurrio un error: error en RFC: " + rfc);
                }

                if (validarFormato(id, "^[a-zA-Z0-9]{1,8}$")) {
                    System.out.println("Formato ID correcto: " + id);
                } else {
                    throw new RuntimeException("Ocurrio un error: error en ID: " + id);
                }

            }

            reader.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static boolean validarFormato(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
