import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;


public class consumoApi {
    public static void main(String[] args){
        /* SOLICITUD DE PETICION - SIEMPRE EN TRY Catch */
        //https://jsonplaceholder.typicode.com/posts/1 - GET, POST SE UTILIZA POST PARA ENCRIPTAR DATOS SENSIBLES
        
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            //objeto para conexiones http
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();


            /* PETICION CORRECTA - COMPROBAR 200*/
            int responseCode = conn.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("Ocurrio un error: " + responseCode);
            } else {
                 /* ABRIR UN SCANNER QUE LEA EL FLUJO DE DATOS */
                StringBuilder infoString = new StringBuilder();
                //escanear flujo de datos
                Scanner scann = new Scanner(url.openStream());

                //leer de forma constante el flujo de datos hasta que termine
                while(scann.hasNext()){
                    infoString.append(scann.nextLine());
                }
                //cerramos scaner
                scann.close();

                /* PINTAR INFO EN CONSOLA */
                //System.out.println(infoString);
                JSONObject myJson = new JSONObject(infoString.toString());
                System.out.println(myJson.getString("body"));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
