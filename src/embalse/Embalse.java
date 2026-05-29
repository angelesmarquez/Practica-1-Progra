package embalse;
//Importaciones de las clases necesarias
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Embalse {
    //No lleva atributos, solo variables
    public static int numEmb=3;
    
    //Creacion los vectores, en Java los vectores son objetos, por lo tanto su declaracion e inicializacion
    //se pueden hacer en un solo paso o por separado (conmunmente en la misma linea).
    public static String[] codigo = new String[numEmb];
    public static int[] nivturbidez = new int[numEmb];
    public static String[] clasificacion = new String[numEmb];
    public static String[] estdAlerta = new String[numEmb];
    
    //arreglo para cargar datos historicos del mes pasado
    public static int[] turbidezMesPasado = new int[3];
    
    //Todo el código debe ir dentro de la clase (no se van a usar nada externo)
    //Metodo Principal o Main
    public static void main(String[] args) {
        
        //acentos y ñ,
        System.setOut(new java.io.PrintStream(System.out,true,java.nio.charset.StandardCharsets.UTF_8));
        //Crear un objeto de la clase Scanner
        Scanner teclado= new Scanner(System.in);
        //Declaracion de las variables del main (Primer y Segunda Parte)
        int acumTurbidez=0;
        int min=100000,max=0;
        int contAzul=0,contVerde=0,contAmarillo=0,contNaranja=0,contRojo=0;
        String posCodMax="",posCodMin="";
        
        //variables parte 4:
        
       int aumento=0;
       int disminuyo =0;
       int SeMantuvo=0;
       String MaxIncre="";
        
        for(int i=0;i<numEmb;i++){
           /* System.out.print("Ingrese el Código del Embalse"+(i+1)+": ");
            codigo[i]=teclado.nextLine();*/
           codigo[i]=JOptionPane.showInputDialog(null,"Ingrese el Código del Embalse "+(i+1)+":","Registro de Embalses",JOptionPane.QUESTION_MESSAGE);
            if (codigo[i]==null) {
                
                JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                return;
                
             }
      
            //añadir validacion de los números negativos
            /*System.out.println("Ingrese el Nivel de Tubidez"+(i+1)+": ");   
            nivturbidez[i]=teclado.nextInt();*/
            String tur=JOptionPane.showInputDialog(null,"Ingrese el Nivel de Turbidez","Registro de Embalses",JOptionPane.QUESTION_MESSAGE);
            if (tur==null) {
                
                JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                return;
                
             }
            nivturbidez[i]=Integer.parseInt(tur);
            acumTurbidez+=nivturbidez[i];
          
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
        System.out.printf("El Porcentaje de Embalses en la Categoria Azul: %.2f%%\n", (float)(contAzul * 100f / numEmb));
        System.out.printf("El Porcentaje de Embalses en la Categoria Verde: %.2f%%\n", (float)(contVerde * 100f / numEmb));
        System.out.printf("El Porcentaje de Embalses en la Categoria Amarillo: %.2f%%\n", (float)(contAmarillo * 100f / numEmb));
        System.out.printf("El Porcentaje de Embalses en la Categoria Naranja: %.2f%%\n", (float)(contNaranja * 100f / numEmb));
        System.out.printf("El Porcentaje de Embalses en la Categoria Rojo: %.2f%%\n", (float)(contRojo * 100f / numEmb));
        
        //Embalses en estado Crítico
        System.out.println("Hay "+(contNaranja+contRojo)+" cantidad de embalses en estado crítico");
        System.out.println("****************************************************");
        System.out.println("\n");
        
        
        //Menú Intercativo y Switch Case
       //Declaracion de Variables 3ra y 4ta parte
       int op;
       
       
       
       do{
           System.out.println("***************************************************");
           System.out.println("                  Menú de Opciones                 ");
           System.out.println("***************************************************");
           System.out.println("*** 1. Buscar Embalse por Código                ***");
           System.out.println("*** 2. Generar Informe                          ***");
           System.out.println("*** 3.Validacion y Tendencias                   ***");
            System.out.println("***4.Salir                                      ***");
           System.out.println("***************************************************");
           System.out.println("Ingrese su Opcion: ");
           op=teclado.nextInt();
           
           switch(op){
               case 1:
                    buscarCodigo(codigo,numEmb,nivturbidez,estdAlerta);
                    break;
               case 2:
                    InformeTurbidez(numEmb,nivturbidez,codigo,clasificacion);
                    break;
               case 3:
                    CargarDatePasadoMes(MaxIncre, codigo, nivturbidez, turbidezMesPasado, aumento, disminuyo, SeMantuvo);
                    break;
               default:
                   if (op!=4) {
                       System.out.println("Número equivocado, por favor revise las opciones del menú");
                       break;
                   }
                   
           }
       }while(op!=4);     
    }//Main
    
    //Métodos
    
    //Switch Metodo 1. Buscar Codigo
    public static void buscarCodigo(String codigo[],int numEmb,int turbidez[],String alerta[]){
        Scanner teclado = new Scanner(System.in);
        String codigoBuscado;
        boolean encontrado=false;
        
        //Pedir el codigo a buscar
        System.out.println("Ingrese el codigo a consultar: ");
        codigoBuscado=teclado.nextLine();
        
        //Buscar el codgio en el vector (se paso por referencia)
        for (int i = 0; i < numEmb; i++) {
            if(codigoBuscado.equalsIgnoreCase(codigo[i])){
                System.out.println("Código Buscado: "+codigo[i]);
                System.out.println("Nivel de Turbidez: "+turbidez[i]);
                System.out.println("Clasificacion de Alerta: "+alerta[i]);
                encontrado=true;
                break;
            }
        }//Si salio del for y no enocntro coinidencia, entonces encontrado es falso
        if(encontrado==false){
            System.out.println("Embalse no registrado...Por favor verifique");
        }         
    }//Fin Método 1
    
    //Switch Método 2. Generar Informe por Rango de Turbidez
    public static void InformeTurbidez (int numEmb,int nivTurbidez[],String codigo[],String clasif[]){
        Scanner teclado= new Scanner(System.in);
        int numMin,numMax;
        int cont=0;
        boolean encontrado=false;
        
        //Pedir NTU
        System.out.print("Ingrese el Valor Mínimo de NTU: ");
        numMin=teclado.nextInt();
        System.out.print("Ingrese el Valor Máximo de NTU: ");
        numMax=teclado.nextInt();
        
        //Buscar y Listar los códigos
        for (int i = 0; i < numEmb; i++) {
            if(nivTurbidez[i]>=numMin && nivTurbidez[i]<=numMax){
               System.out.printf("Código: %-8s NTU: %-5d Clasificación: %-15s%n", codigo[i], nivTurbidez[i], clasif[i]);
               cont++;
               encontrado=true; 
            } 
        }     
        if(encontrado==false){
            System.out.println("No se encontraron embalses en este rango de Turbidez...Por favor verifique");
        }else{
            System.out.println("Estos Embalses Represenan el: "+(cont*100/numEmb)+"% respecto al total");
        }
    }//Fin Método 2
    
    
    
    // for. Metodo: 2-Solicitar datos mes pasado 
    
    public static void CargarDatePasadoMes(String MaxIncre, String codigo[], int nivturbidez[],int turbidezMesPasado[],int aumento, int disminuyo,int SeMantuvo) {
        aumento=0;
        disminuyo=0;
        SeMantuvo=0;
        Scanner teclado= new Scanner (System.in);
        
        double maximo=0;
        
        for (int i = 0; i < numEmb; i++) {
            
            System.out.println("Ingrese el NTU del mes pasado del embalse "+(i+1)+":");
            turbidezMesPasado[i]=teclado.nextInt();
            teclado.nextLine();
            
            if (nivturbidez[i]>turbidezMesPasado[i]) {
                
                aumento++;
                int diferencia = nivturbidez[i] - turbidezMesPasado[i];
                if (diferencia > maximo) {      
                   maximo = diferencia;
                   MaxIncre = codigo[i];
                    
                    
                }
             
            }
            else if(nivturbidez[i]==turbidezMesPasado[i]){
                SeMantuvo++;
            
            }
            else{
                disminuyo++;
            }   
         }
        
         System.out.println("**********VALIDACION DE REPORTE Y TENDENCIAS*******");
         System.out.println("Cantidad de embalses donde la turbidez aumento:"+aumento);
         System.out.println("Cantidad de embalses donde la turbidez se redujo:"+disminuyo);
         System.out.println("Cantidad de embalses donde la turbidez se mantuvo:"+SeMantuvo);
            
         System.out.println("El embalse que sufrio el mayor incremento absoluto en su NTU fue:"+MaxIncre);
        
        
        
     }
    
}//Clase 
