package embalse;
//Importaciones de las clases necesarias
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Embalse {
    //No lleva atributos, solo variables
    public static int numEmb=5;
    
    //Creacion los vectores, en Java los vectores son objetos, por lo tanto su declaracion e inicializacion
    //se pueden hacer en un solo paso o por separado (conmunmente en la misma linea).
    public static String[] codigo = new String[numEmb];
    public static int[] nivturbidez = new int[numEmb];
    public static String[] clasificacion = new String[numEmb];
    public static String[] estdAlerta = new String[numEmb];
    
    //Todo el código debe ir dentro de la clase (no se van a usar nada externo)
    //Metodo Principal o Main
    public static void main(String[] args) {
        
        //acentos y ñ,
        System.setOut(new java.io.PrintStream(System.out,true,java.nio.charset.StandardCharsets.UTF_8));
        //Crear un objeto de la clase Scanner
        Scanner teclado= new Scanner(System.in);
        //Declaracion de las variables del main
        int acumTurbidez=0;
        int min=100000,max=0;
        int contAzul=0,contVerde=0,contAmarillo=0,contNaranja=0,contRojo=0;
        String posCodMax="",posCodMin="";
        
        for(int i=0;i<numEmb;i++){
           /* System.out.print("Ingrese el Código del Embalse"+(i+1)+": ");
            codigo[i]=teclado.nextLine();*/
           codigo[i]=JOptionPane.showInputDialog(null,"Ingrese el Código del Embalse","Registro de Embalses",JOptionPane.QUESTION_MESSAGE);
      
            //añadir validacion de los números negativos
            /*System.out.println("Ingrese el Nivel de Tubidez"+(i+1)+": ");   
            nivturbidez[i]=teclado.nextInt();*/
            String tur=JOptionPane.showInputDialog(null,"Ingrese el Nivel de Turbidez","Registro de Embalses",JOptionPane.QUESTION_MESSAGE);
            nivturbidez[i]=Integer.parseInt(tur);
            acumTurbidez+=nivturbidez[i];
            //Para atrapar el salto de linea flotante
            teclado.nextLine();
            
            //If Max y min
            if(nivturbidez[i]>max){
                max=nivturbidez[i];
                posCodMax=codigo[i]; 
            }
            if(nivturbidez[i]<min){
                min=nivturbidez[i];
                posCodMin=codigo[i];
                
            }
            
            
            //Condicionales
            if (nivturbidez[i]>=0 && nivturbidez[i]<=5){
                clasificacion[i]="Excelente";
                estdAlerta[i]="Azul";
                contAzul++;
            } else if (nivturbidez[i]>=6 && nivturbidez[i]<=15) {

                clasificacion[i]="Aceptable";
                estdAlerta[i]="Verde";
                contVerde++;

            }else if (nivturbidez[i]>=16 && nivturbidez[i]<=30) {

                clasificacion[i]="Regular";
                estdAlerta[i]="Amarillo";
                contAmarillo++;

            }else if (nivturbidez[i]>=31 && nivturbidez[i]<=50) {

                clasificacion[i]="Alta";
                estdAlerta[i]="Naranja";
                contNaranja++;
            }else {

                clasificacion[i] = "Critica";
                estdAlerta[i] = "Roja";
                contRojo++;
            } //Fin del If
            
        }//Fin del For
        
        
        System.out.println("***************************************************");
        System.out.println("Código  Nivel de Turbidez  Clasificación    Alerta");
        System.out.println("***************************************************");
        for (int i = 0; i < numEmb; i++) {
            System.out.printf("%-10s %-10d  %-10s %-10s%n",codigo[i],nivturbidez[i],clasificacion[i],estdAlerta[i]);
            
        }
        System.out.println("****************************************************");
        System.out.println("\n");
        System.out.println("***************************************************");
        System.out.println("           Análisis Estadístico y Reporte          ");
        System.out.println("***************************************************");
        
        //Promedio 
        System.out.println("El Promedio de Turbidez en el Estado es de: "+(float)(acumTurbidez/numEmb));
        
        //Mayor y Menor
        System.out.println("El Emblase "+posCodMax+" tiene el nivel de turbidez mas alta: "+max);
        System.out.println("El Emblase "+posCodMin+" tiene el nivel de turbidez mas bajo: "+min);
        
        //Por color
        System.out.println("El Porcentaje de Embalses en la Categoria Azul: "+(float)(contAzul*100f/numEmb)+"%");
        System.out.println("El Porcentaje de Embalses en la Categoria Verde: "+(float)(contVerde*100f/numEmb)+"%");
        System.out.println("El Porcentaje de Embalses en la Categoria Amarillo: "+(float)(contAmarillo*100f/numEmb)+"%");
        System.out.println("El Porcentaje de Embalses en la Categoria Naranja: "+(float)(contNaranja*100f/numEmb)+"%");
        System.out.println("El Porcentaje de Embalses en la Categoria Rojo: "+(float)(contRojo*100f/numEmb)+"%");
        
        //Embalses en estado Crítico
        System.out.println("Hay "+(contNaranja+contRojo)+" cantidad de embalses en estado crítico");
        System.out.println("****************************************************");
        System.out.println("\n");
        
        //Menú Intercativo y Switch Case
        System.out.println("Hola Mariangel");
    } 
    
}
