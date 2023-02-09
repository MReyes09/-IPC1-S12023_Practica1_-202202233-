
package practica1_supermercado.pkgsuper.pkg25;

import java.util.Scanner;

/**
 * @author Matthew Emmanuel Reyes Melgar
 * Carne: 202202233
 * Introducción a la Programación de Computadoras 1
 */

public class Practica1_SupermercadoSUPER25 {
    
    static String[][] productos = new String[20][3];
    static String[][] cupones = new String[20][2];
    static String[][] reporte = new String[100][2];
    static String[][] carrito = new String[100][4];
    static Scanner entrada = new Scanner(System.in);
    static String usuario = "cajero_202202233";
    static String password = "ipc1_202202233";
    static String user;
    static String pass;
    static boolean valor;
    static int opcion;
    
    public static void main(String[] args) {
        System.out.println("Bienvenido a Super-25");
        //Validacion de datos
        //PASO 1 INICIO
        do{
            System.out.println(" ");
            System.out.println("Por favor, ingresar el usuario");
            user = entrada.nextLine();
            System.out.println(" ");
            System.out.println("Por favor, ingresar la contraseña");
            pass = entrada.nextLine();
        }while(validacionCajero(user,pass));
        //PASO 1 FINALIZADO
        //PASO 2 INICIO
        do{
            System.out.println("-----MENU PRINCIPAL-----");
            System.out.println("¿Què deseas hacer?");
            System.out.println("1. Agrega nuevos productos");
            System.out.println("2. Agrega cupones de descuento");
            System.out.println("3. Realizar ventas");
            System.out.println("4. Realizar reporte");
            System.out.println("5. salir");
            System.out.println("Su opciòn");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" AGREGA MERCADERIA NUEVA ");
                    agregarProductos();
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("AGREGAR CUPONES DE DESCUENTO");
                    cuponesDesc();  
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("REALIZAR VENTA");
                    venta();
                break;
                case 4:
                    System.out.println("Realizar reporte");
                    reporte();
                    break;
                case 5:
                    System.out.println("Hasta la pròxima");                    
                    break;
                default:
                    System.out.println("opcion no valida");
                break;
            }
        }while(opcion != 5);
        System.exit(0);
        //PASO 2 FINAL
    }
    
    //----------------------------------------------FUNCIONES Y METODOS ---------------------------------------
    //FUNCION #1
    public static Boolean validacionCajero(String cajero, String contra){
        
        if(cajero.equals(usuario) && contra.equals(password)){
            System.out.println("datos validos");
            System.out.println("Bienvenido usuario, puedes comenzar tu orden");
            return false;
        }else{
            System.out.println("datos invalidos");
            return true;
        }        
    }
    //FUNCION #2
    public static void agregarProductos(){
        
        do{
            System.out.println("¿Què desea hacer?");
            System.out.println("1. Listar productos ");
            System.out.println("2. Agregar producto");
            System.out.println("3. Volver al menù anterior");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    listarProductos();
                    break;
                case 2:
                    String nameProducto;
                    float precio;
                    String cantidad;
                    System.out.println("Llena los datos solicitados");
                    for(int fila = 0; fila<20; fila++ ){
                        if(productos[fila][0] == null){
                            for(int columna = 0; columna<3; columna++){
                                switch(columna){
                                case 0:
                                    entrada.nextLine();
                                    do{
                                        System.out.println("Nombre del producto: ");
                                        nameProducto = entrada.nextLine();
                                        if(nameProducto.equals("") || nameProducto.trim().equals("")){
                                        System.out.println("El nombre del producto no puede estar vacio");
                                        System.out.println("Nombre del producto: ");
                                        nameProducto = entrada.nextLine();
                                        }else{
                                            for(int f=0;f<20; f++){
                                                if(nameProducto.equals(productos[f][0])){
                                                   System.out.println("Este producto ya es existente");
                                                   f = 19;
                                                   nameProducto = "";
                                               }
                                            }
                                        }
                                    }while(nameProducto.equals("") || nameProducto.trim().equals(""));
                                    productos[fila][columna] = nameProducto;
                                    break;
                                case 1:
                                    System.out.println("Precio del producto");
                                    precio = entrada.nextFloat();
                                    do{
                                        if(precio < 0 || precio == 0){
                                        System.out.println("El precio del producto no puede ser 0 o inferior");
                                        System.out.println("Precio del producto:");
                                        precio = entrada.nextFloat();
                                        }
                                    }while(precio < 0 || precio == 0 );
                                    productos[fila][columna] = Float.toString(precio);
                                    break;
                                case 2:
                                    System.out.println("Stock del producto");
                                    entrada.nextLine();
                                    cantidad = entrada.nextLine();
                                    int cantp;
                                    do{
                                        if(isInteger(cantidad)){
                                            if(Integer.parseInt(cantidad)==0 || Integer.parseInt(cantidad) < 0 ){
                                            System.out.println("El Stock del producto no puede ser 0 o menos, solo enteros");
                                            System.out.println("Stock del producto:");
                                            cantidad = entrada.nextLine();
                                            }                                        
                                        }else{
                                            System.out.println("El Stock del producto no puede ser 0 o menos, solo enteros");
                                            System.out.println("Stock del producto:");
                                            entrada.nextLine();
                                            cantidad = entrada.nextLine();
                                        }
                                    }while(isInteger(cantidad) == false || Integer.parseInt(cantidad) < 0 || Integer.parseInt(cantidad)==0);
                                    productos[fila][columna] = cantidad;
                                    System.out.println(productos[fila][0] + " "
                                            + productos[fila][1] + " " 
                                            + productos[fila][2]);
                                    int opc2;
                                    do{
                                        System.out.println("¿Deseas continuar agregando productos?");
                                        System.out.println("1. Si   2. No");
                                        opc2 = entrada.nextInt();
                                        switch(opc2){
                                            case 1:
                                                break;
                                            case 2:
                                                fila = 19;
                                            break;
                                            default:
                                                System.out.println("opcion no valida");
                                        }
                                    }while(opc2 < 1 || opc2 > 2);
                                    break;
                                default:
                                    System.out.println("swtich bugueado");
                                    break;
                                }
                            }
                        }                        
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    System.out.println("Volver al menù anterior");
                    break;
                default:
                    System.out.println("opcion no valida");
                break;
            }
        }while(opcion != 3);
        System.out.println(" ");
        System.out.println(" ");
    }
    //FUNCION VALIDAR ENTERO
    public static boolean isInteger(String text) {
    int v;
    try {
      v=Integer.parseInt(text);
      return true;
    } catch (NumberFormatException ex) {
       return false;
    }
}
    //FUNCIONN #3
    public static void cuponesDesc(){
        
        do{
        System.out.println("¿Què desea hacer?");
        System.out.println("1. Listar cupones ");
        System.out.println("2. Agregar cupones");
        System.out.println("3. Volver al menù anterior");
        opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    listarCupones();
                    break;
                case 2:
                    String codigo;
                    float descuento;
                    System.out.println("Llena los datos solicitados");
                    for(int fila = 0; fila < 20; fila++){
                        if(cupones[fila][0] == null){
                            for(int columna = 0; columna < 2; columna++){
                                switch(columna){
                                    case 0:
                                        entrada.nextLine();
                                        System.out.println("Codigo de descuento: ");
                                        codigo = entrada.nextLine();
                                        do{
                                            if(codigo.equals("") || codigo.trim().equals("")){
                                                System.out.println("El codigo no puede estar vacio");
                                                System.out.println("Codigo de descuento: ");
                                                codigo = entrada.nextLine();
                                            }else if(codigo.length() != 4){
                                                System.out.println("El codigo no puede excederse de 4 caracteres o tener menos");
                                                System.out.println("Codigo de descuento: ");
                                                codigo = entrada.nextLine();
                                            }else if(codigo.length() ==4){
                                                for(int filaP = 0; filaP < 20; filaP++){
                                                    if(cupones[filaP][0] == null){
                                                        
                                                    }else if(cupones[filaP][0].equals(codigo)){
                                                        System.out.println("El codigo ya existe, por favor ponga otro");
                                                        System.out.println("Codigo de descuento: ");                                                        
                                                        codigo = entrada.nextLine();
                                                    }
                                                }                                                
                                            }                                          
                                        }while(codigo.length() != 4);
                                        cupones[fila][columna] = codigo;
                                        break;
                                    case 1:
                                        System.out.println("descuento mayor a 0 y menor a 100");
                                        descuento = entrada.nextFloat();
                                        do{
                                            if(descuento <= 0 || descuento >= 100){
                                                System.out.println("descuento mayor a 0 y menor a 100");
                                                descuento = entrada.nextFloat();
                                            }
                                        }while(descuento <= 0 || descuento >= 100);
                                        cupones[fila][columna] = Float.toString(descuento);
                                        System.out.println(cupones[fila][0]+ " " + cupones[fila][1]);
                                        int opc2;
                                    do{
                                        System.out.println("¿Deseas continuar agregando cupones?");
                                        System.out.println("1. Si   2. No");
                                        opc2 = entrada.nextInt();
                                        switch(opc2){
                                            case 1:
                                                break;
                                            case 2:
                                                fila = 19;
                                            break;
                                            default:
                                                System.out.println("opcion no valida");
                                        }
                                    }while(opc2 < 1 || opc2 > 2);
                                        break;
                                    default:
                                        System.out.println("swtich bugueado");
                                    break;    
                                }
                            }
                        }
                    }
                    System.out.println(" ");
                    break;
                default:
                    break;
            }
        }while(opcion != 3);
        
    }
    //FUNCION #4
    public static void venta(){
        int opc2;
        String nameCl;
        String nit;
        System.out.println("Bienvenido cliente a Super-25, puede ordenar aquì");
        System.out.println("por favor, ingrese lo que se le solicita");
        System.out.println("Nombre del cliente: ");
        entrada.nextLine();
        nameCl = entrada.nextLine();
        do{
            if(nameCl.equals("") || nameCl.trim().equals("")){
            System.out.println("El nombre del cliente no puede estar vacio");
            System.out.println("Nombre del cliente: ");
            nameCl = entrada.nextLine();
            }
        }while(nameCl.equals("") || nameCl.trim().equals(""));
        System.out.println("Nit del cliente (deje vacio si quiere C/F): ");
        nit = entrada.nextLine(); 
        if(nit != ""){
            do{
                if(isInteger(nit)){
                    if(Integer.parseInt(nit)==0 || Integer.parseInt(nit) < 0 ){
                        System.out.println("El nit del cliente no puede ser 0 o menos");
                        System.out.println("nit del cliente:");
                        nit = entrada.nextLine();
                    }                                        
                }else{
                    System.out.println("El nit es solo numeros");
                    System.out.println("nit del cliente:");
                    entrada.nextLine();
                    nit = entrada.nextLine();
                }
            }while(isInteger(nit) == false || Integer.parseInt(nit) < 0 || Integer.parseInt(nit)==0);
        }else{
            nit = "C/F";
        }
        String nameProducto;
        String cantidad;
        int stockMax = 0;
        float valor = 0;
        float subtotal = 0;
        float total = 0;
        String codigo;
        do{
            System.out.println("¿Què desea hacer?");
            System.out.println("1. Agregar producto al carrito ");
            System.out.println("2. cancelar compra");
            if(carrito[0][0]!=null){
                System.out.println("3. finalizar compra (factura)");
            }
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Lista de productos en existencia");
                    System.out.println("Llena los datos solicitados");
                    for(int f=0; f<99;f++){
                        if(carrito[f][0] ==null){
                            for(int c=0;c<3;c++){
                                switch(c){
                                    case 0:
                                        boolean aprovacion = false;
                                        do{
                                        listarProductos();
                                        System.out.println("Producto para agregar: ");
                                        entrada.nextLine();
                                        nameProducto = entrada.nextLine();
                                        do{
                                            if(nameProducto.equals("") || nameProducto.trim().equals("")){
                                            System.out.println("El nombre del producto no puede estar vacio");
                                            System.out.println("Nombre del producto: ");
                                            nameProducto = entrada.nextLine();
                                            }
                                        }while(nameProducto.equals("") || nameProducto.trim().equals(""));
                                        for(int fp = 0; fp<20; fp++){
                                            if(nameProducto.equals(productos[fp][0])){
                                                stockMax = Integer.parseInt(productos[fp][2]);
                                                valor = Float.parseFloat(productos[fp][1]);
                                                fp = 19;
                                                aprovacion = true;
                                            }else{
                                                aprovacion = false;
                                            }
                                        }
                                        }while(aprovacion = false);
                                        
                                        carrito[f][c]= nameProducto;
                                        System.out.println("producto agregado: " + carrito[f][c]);
                                        carrito[f][c+1]= Float.toString(valor);
                                    break;
                                    case 2:
                                        do{
                                        System.out.println("unidades del producto");                                        
                                        cantidad = entrada.nextLine();
                                        int cantp;
                                            do{
                                                if(isInteger(cantidad)){
                                                    if(Integer.parseInt(cantidad)==0 || Integer.parseInt(cantidad) < 0 ){
                                                    System.out.println("las unidades no puede ser 0 o menos, solo enteros");
                                                    System.out.println("unidades del producto:");
                                                    cantidad = entrada.nextLine();
                                                    }                                        
                                                }else{
                                                    System.out.println("las unidades no puede ser 0 o menos, solo enteros");
                                                    System.out.println("unidades del producto:");
                                                    entrada.nextLine();
                                                    cantidad = entrada.nextLine();
                                                }
                                            }while(isInteger(cantidad) == false || Integer.parseInt(cantidad) < 0 || Integer.parseInt(cantidad)==0);
                                            cantp = Integer.parseInt(cantidad);
                                            if(cantp > stockMax || cantp <= 0){
                                                System.out.println("no se pueden solicitar 0 unidades o menos, no puede ser mayor al stock total");
                                                aprovacion = false;
                                            }else{
                                                aprovacion = true;
                                            }
                                        }while(aprovacion = false);
                                        carrito[f][c]= cantidad;                                        
                                        carrito[f][c+1] = Float.toString(Integer.parseInt(cantidad)*valor);
                                        System.out.println("Productos en el carrito");
                                        System.out.println("No.   Producto       C/U       Unidades      Total");
                                        for(int fc=0;fc<99;fc++){
                                            if(carrito[fc][0] != null){
                                                System.out.print((fc + 1) + "     ");
                                                for(int cc=0;cc<4;cc++){
                                                    System.out.print(carrito[fc][cc]+"            ");
                                                }
                                            System.out.println(" ");   
                                            }
                                        }
                                        do{
                                            System.out.println("¿Deseas continuar agregando productos?");
                                            System.out.println("1. Si   2. No");
                                            opc2 = entrada.nextInt();
                                            switch(opc2){
                                                case 1:
                                                    break;
                                                case 2:
                                                    f = 99;
                                                break;
                                                default:
                                                    System.out.println("opcion no valida");
                                            }
                                        }while(opc2 < 1 || opc2 > 2);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    for(int f=0;f<100;f++){
                        for(int c=0; f<3;f++){
                        carrito[f][c]=null;
                        }
                    }
                    System.out.println("Los productos contenidos en el carrito an sido eliminados");
                    break;
                case 3:
                    for(int f=0;f<100;f++){
                        if(carrito[f][0]!=null){
                            subtotal = subtotal + Float.parseFloat(carrito[f][3]);
                        }
                    }
                    System.out.println("Total a pagar: "+subtotal);
                        System.out.println("El cliente posee un codigo de descuento");
                        System.out.println("1. Si   2. No");
                        opc2 = entrada.nextInt();
                        switch(opc2){
                            case 1:
                                float porcentaje=0;
                                System.out.println("Codigo de descuento: ");
                                entrada.nextLine();
                                codigo = entrada.nextLine();
                                do{
                                    if(codigo.equals("") || codigo.trim().equals("")){
                                        System.out.println("El codigo no puede estar vacio");
                                        System.out.println("Codigo de descuento: ");
                                        codigo = entrada.nextLine();
                                    }else if(codigo.length() != 4){
                                        System.out.println("El codigo no puede excederse de 4 caracteres o tener menos");
                                        System.out.println("Codigo de descuento: ");
                                        codigo = entrada.nextLine();
                                    }else if(codigo.length() ==4){
                                        for(int filaP = 0; filaP < 20; filaP++){
                                            if(cupones[filaP][0] == null){
                                                        
                                            }else if(cupones[filaP][0].equals(codigo)){
                                                porcentaje = Float.parseFloat(cupones[filaP][1]);
                                                total = subtotal - subtotal*(porcentaje/100);
                                            }
                                       }                                                
                                   }                                          
                                }while(codigo.length() != 4);
                                generarFactura(nameCl, nit, subtotal, total, porcentaje);
                                limpiarCarrito();
                                break;
                            case 2:
                                total = subtotal;
                                porcentaje = 0;
                                generarFactura(nameCl, nit, subtotal, total, porcentaje);
                                limpiarCarrito();
                                break;
                            default:
                                    System.out.println("opcion no valida");
                                break;
                        }
                    break;
                default:
                    System.out.println("swtich bugueado");
                    break;
            }
        }while(opcion == 1);
        //FALTA SOLICITAR AL CLIENTE QUE PRODUCTOS COMPRARA, TOTAL COMPRA, DESCUENTO, FACTURA        
    }
    
    //FUNCIONES DE LISTAR
    public static void listarProductos(){
        for(int fila = 0; fila<20; fila++ ){
            if(productos[fila][0] != null){
                System.out.println("No.-----Producto-----Precio-----Unidades");
                System.out.print((fila + 1) + "         ");
            for(int columna = 0; columna<3; columna++){
                System.out.print(productos[fila][columna] + "         ");
            }
            System.out.println(" ");
            }
        }
        System.out.println("----------------------");
        System.out.println(" ");
    }
    
    public static void listarCupones(){
    
        for(int fila = 0; fila<20; fila++ ){
            if(cupones[fila][0] != null){
                System.out.println("No.-----CODIGO-----DESCUENTO (%)");
                System.out.print((fila + 1) + "        ");
                for(int columna = 0; columna<2; columna++){
                    System.out.print(cupones[fila][columna] + "        ");
                }
            System.out.println(" ");
            }            
        }
        System.out.println("----------------------");
        System.out.println(" ");
    }
    //FIN DE FUNCIONES DE LISTAR
    
    public static void generarFactura(String nomCliente, String NIT, float subTotal, float Total, float percent){
        System.out.println("        Empresa SUPER-25");
        System.out.println("Atendido por " + usuario);
        System.out.println("Factura emitida a nombre de Matthew Reyes");
        System.out.println("Con NIT: " + NIT);
        System.out.println("Facura emitida en el dia: " + "10/02/2022");
        System.out.println("Productos en el carrito");
        System.out.println("No.   Producto       C/U       Unidades      Total");
            for(int fc=0;fc<99;fc++){
                if(carrito[fc][0] != null){
                    System.out.print((fc + 1) + "     ");
                    for(int cc=0;cc<4;cc++){
                        System.out.print(carrito[fc][cc]+"            ");
                    }
                    System.out.println(" ");   
                }
            }
        System.out.println("Subtotal: " + subTotal);
        if(percent != 0){
            System.out.println("porcentaje de descuento: " + percent+"%");
        }
        System.out.println("Total: " + Total);
        
        for(int f=0;f<99;f++){
            if(carrito[f][0]!=null){
                for(int fp = 0; fp<99; fp++){
                    if(reporte[fp][0] == null){
                        reporte[fp][0] = carrito[f][0];
                        reporte[fp][1] = carrito[f][2];
                        fp = 99;
                    }else if(reporte[fp][0].equals(carrito[f][0])){
                        int x = Integer.parseInt(reporte[fp][1]);
                        reporte[fp][1] = Integer.toString(x + Integer.parseInt(carrito[f][2]));
                        fp = 99;
                    }
                }
            }
        }
    }
    
    public static void limpiarCarrito(){
        for(int f=0;f<100;f++){
            for(int c=0; f<3;f++){
                carrito[f][c]=null;
            }
        }
    }
    
    public static void reporte(){
        for(int f=0; f<99;f++){
            if(reporte[f][0] != null && reporte[f+1][0] != null){
                for(int j=0; j<98; j++){
                    if(reporte[j+1][0] != null){
                        if(Integer.parseInt(reporte[j][1]) < Integer.parseInt(reporte[j+1][1])){
                            String prod1, prod2, stock1, stock2;

                            prod1 = reporte[j][0];
                            stock1 = reporte[j][1];
                            prod2 = reporte[j+1][0];
                            stock2 = reporte[j+1][1];

                            reporte[j][0]= prod2;
                            reporte[j][1] = stock2;
                            reporte[j+1][0] = prod1;
                            reporte[j+1][1] = stock1;
                        }
                    }
                }
            }
        }
        
        for(int fila = 0; fila<99; fila++ ){
            if(reporte[fila][0] != null){
                System.out.println("No.-----Producto-----Unidades vendidas");
                System.out.print((fila + 1) + "       ");
                for(int columna = 0; columna<2; columna++){
                    System.out.print(reporte[fila][columna] + "        ");
                }
            System.out.println(" ");
            }            
        }
        System.out.println("----------------------");
        System.out.println(" ");
    }
}
