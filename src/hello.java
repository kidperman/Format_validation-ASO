import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.chart.Chart;

public class hello {
    public static void main(String[] args) throws Exception {
        //hola mundo en java
        System.out.println("Hello, World!"); 

        Integer myInt = 8; 
        myInt = myInt + 4;
        //aca debe imprimir 12...
        System.out.println(myInt); 
        //acá debe imprimir 0...
        System.out.println(myInt - 12); 

        Boolean myBoolean = true; 
        System.out.println(myBoolean);

        //suma simple con tres variables
        Integer x = 6; 
        Float y = 6.32f; 
        Float suma = x + y; 
        System.out.println("El resultado de la suma es: " + suma);
        //OBSERVACION: se concatena con un +

        //condicionales y los null

        Float myFloat = 4.90f;
        myFloat = null; 
        if(myFloat != null ){
            System.out.println(myFloat + 10);
            System.out.println("Mi float es distinto de nulo");
        }else{
            System.out.println("Mi float es nulo");
        }

        //arreglos
        List<String> myList = new ArrayList();
        myList.add("Goku");
        myList.add("Vegeta");
        myList.add("Krilin");
        myList.add("Frezer");
        myList.add("Majin Boo");
        //imprimimos array o lista
        System.out.println(myList);

        //mapas - TAMBIEN PUEDE ESPECIFICARSE EL TIPO DE DATOS <String, String>
        String id = "C83493C";
        Map myMap = new HashMap();
        myMap.put("int", myInt);
        myMap.put("ID", id );
        System.out.println(myMap);
        //imprimimos concretamente el ID...
        System.out.println(myMap.get("ID"));

        //CICLOS
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        //CONSTANTES = palabra reservada "final"
        final String nombre = "Franco";
        //nombre = "Ramon"; - Esto da error porque no se puede editar un final
        System.out.println(nombre); 

        /* Mandamos a llamar a la funcion que se definió mas abajo: 
         * Para realizar esto y que funcione, debemos crear una nueva instancia de nuestra clase hello, 
         * que es la clase principal donde hemos estado trabajando
         */
        hello myMain = new hello();
        myMain.myFunction(5,5);

    }

    //FUNCIONES: es importante indicar si retornara algo o no. Son utiles para aglutinar codigo que en principio queremos separar y es susceptible a repetirse
    public void myFunction(int number1, int number2){
        System.out.println(number1 * number2);
    }

}
