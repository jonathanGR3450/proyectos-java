/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficadora;

/**
 *
 * @author PERSONAL
 */
public class valoresY {
    private String ecuacion;
    public static String ecuacionc[];
    private int cont;
    private int contmatriz;
    private int apare;
    private int cpare;
    private char a;
    private char b;
    
    private boolean correcto=false;
    
    
    public  valoresY(String ecuacion){
        StringBuilder sb=new StringBuilder();
        this.ecuacion=ecuacion;
        ecuacionc=new String [this.ecuacion.length()];
        this.cont=0;
        this.contmatriz=-1;
        this.apare=0;
        this.cpare=0;
        this.a=0;
        this.b=0;
                //un for para recorrer el String.
                for(int i=0;i<ecuacion.length();i++){
                    char p=ecuacion.charAt(i);
                    //con los siguientes if revisamos que la ecuacion este bien escrita.
                    if (p==48||p==49||p==50||p==51||p==52||p==53||p==54||p==55||p==56||p==57){
                        this.contmatriz++;
                            sb.append(p);
                        for(int j=i+1;j<ecuacionc.length;j++){
                            char e=this.ecuacion.charAt(j);
                            if (e==48||e==49||e==50||e==51||e==52||e==53||e==54||e==55||e==56||e==57){
                                sb.append(e);
                                cont++;
                            }else{
                                System.out.println("hay un simbolo");
                                i=j-1;
                                break;
                            }
                        }
                        
                        if(cont==0){
                            System.out.println("es un numero: "+p);
                            valoresY.ecuacionc[this.contmatriz]=sb.toString();
                            this.correcto=true;
                            sb.delete(0, sb.length());
                        }else {
                            System.out.println("hay numeros seguidos");
                            System.out.println(sb.toString());
                            valoresY.ecuacionc[this.contmatriz]=sb.toString();
                            sb.delete(0, sb.length());
                        }
                            
                        }
                    else if(p=='+'){
                        if(i==0||i==this.ecuacion.length()-1){
                            System.out.println("este operador no puede ir en la ultima posicion");
                            this.correcto=false;
                            break;
                        }else{
                            a=this.ecuacion.charAt(i-1);
                            b=this.ecuacion.charAt(i+1);
                            if((a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='e'||a=='x'||a=='('||a==')')&&(b=='0'||b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8'||b=='9'||b=='e'||b=='x'||b=='y'||b=='('||b==')'||b=='s'||b=='c'||b=='t'||b=='l')){
                                this.contmatriz++;
                                valoresY.ecuacionc[this.contmatriz]=""+p;
                                System.out.println("es suma: "+p);
                                this.correcto=true;
                                }else {
                                    System.out.println("no puede ir dos operadores seguidos");
                                    this.correcto=false;
                                    break;
                            }
                        }
                    }
                    else if(p=='-'){
                        if(i==this.ecuacion.length()-1){
                            System.out.println("este operador no puede ir en la ultima posicion");
                            this.correcto=false;
                            break;
                        }else{
                            if(i==0){
                                b=this.ecuacion.charAt(i+1);
                                if(b=='0'||b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8'||b=='9'||b=='e'||b=='x'||b=='y'||b=='('||b=='s'||b=='c'||b=='t'||b=='l'){
                                    this.contmatriz++;
                                    valoresY.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("es resta: "+p);
                                    this.correcto=true;
                                }else{
                                    System.out.println("no puede ir dos operadores seguidos");
                                    this.correcto=false;
                                    break;
                            }
                                
                            }else{
                                    a=this.ecuacion.charAt(i-1);
                                    b=this.ecuacion.charAt(i+1);
                                if((a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='e'||a=='x'||a=='y'||a=='('||a=='^'||a=='*')&&(b=='0'||b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8'||b=='9'||b=='e'||b=='x'||b=='('||b==')'||b=='s'||b=='c'||b=='t'||b=='l'||b=='*')){
                                    this.contmatriz++;
                                    valoresY.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("es resta: "+p);
                                    this.correcto=true;
                                }else{
                                    System.out.println("no puede ir dos operadores seguidos");
                                    this.correcto=false;
                                    break;
                            }
                            }      
                        }
                        
                    }
                    else if(p=='*'){
                        if(i==0||i==this.ecuacion.length()-1){
                            System.out.println("este operador no puede ir en la primera ni en la ultima posicion");
                            this.correcto=false;
                            break;
                        }else{
                            a=this.ecuacion.charAt(i-1);
                            b=this.ecuacion.charAt(i+1);
                            if((a=='y'||a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='e'||a=='x'||a=='('||a==')')&&(b=='0'||b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8'||b=='9'||b=='e'||b=='x'||b=='('||b==')'||b=='s'||b=='c'||b=='t'||b=='l'||b=='-')){
                                this.contmatriz++;
                                valoresY.ecuacionc[this.contmatriz]=""+p;
                                System.out.println("es multiplicacion: "+p);
                                this.correcto=true;
                            }else{
                                System.out.println("no puede ir dos operadores seguidos");
                                this.correcto=false;
                                break;
                                }
                        }
                    }
                    else if(p=='/'){
                        if(i==0||i==this.ecuacion.length()-1){
                            System.out.println("este operador no puede ir en la primera ni en la ultima posicion");
                            this.correcto=false;
                            break;
                        } else {
                            
                            a=this.ecuacion.charAt(i-1);
                            b=this.ecuacion.charAt(i+1);
                            if((a=='y'||a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='e'||a=='x'||a==')')&&(b=='0'||b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8'||b=='9'||b=='e'||b=='x'||b=='('||b=='s'||b=='c'||b=='t'||b=='l'||b=='-')){
                                this.contmatriz++;
                                valoresY.ecuacionc[this.contmatriz]=""+p;
                                System.out.println("es division: "+p);
                                this.correcto=true;
                            }else{
                                    System.out.println("no puede ir dos operadores seguidos");
                                    this.correcto=false;
                                    break;
                                 }
                        }
                    }
                    else if(p=='^'){
                        if(i==0||i==this.ecuacion.length()-1){
                            System.out.println("este operador no puede ir en la primera ni en la ultima posicion");
                            this.correcto=false;
                            break;
                        } else {
                            a=this.ecuacion.charAt(i-1);
                            b=this.ecuacion.charAt(i+1);
                            if((a=='y'||a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='e'||a=='x'||a==')')&&(b=='0'||b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8'||b=='9'||b=='e'||b=='x'||b=='('||b=='-'||b=='s'||b=='c'||b=='t'||b=='l'||b=='-')){
                                this.contmatriz++;
                                valoresY.ecuacionc[this.contmatriz]=""+p;
                                System.out.println("es potencia: "+p);
                                this.correcto=true;
                                }else{
                                    System.out.println("no puede ir dos operadores seguidos");
                                    this.correcto=false;
                                    break;
                                 }
                        }
                    }
                    else if(p=='('){
                        if(i==this.ecuacion.length()-1){
                            System.out.println("este simbolo no puede ir en la ultima posicion");
                            this.correcto=false;
                            break;
                        } else {
                        if(i==0){
                            a=this.ecuacion.charAt(i+1);
                            if(a=='y'||a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='e'||a=='x'||a=='('||a=='-'||a=='l'||a=='s'||a=='c'||a=='t'||a=='s'||a=='c'||a=='t'||a=='l'){
                                this.apare++;
                                this.contmatriz++;
                                this.ecuacionc[this.contmatriz]=""+p;
                                System.out.println("abre parentesis: "+p);
                                this.correcto=true;
                            }else {
                                System.out.println("no puede haber un operador despues de abrir parentesis");
                                this.correcto=false;
                                break;
                            }
                            
                        }else if(i>0){
                                b=this.ecuacion.charAt(i-1);
                                a=this.ecuacion.charAt(i+1);
                                if((b=='+'||b=='-'||b=='/'||b=='*'||b=='^'||b=='(')&&(a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='e'||a=='x'||a=='y'||a=='('||a=='-'||a=='s'||a=='c'||a=='t'||a=='l')){
                                    this.apare++;
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("abre parentesis: "+p);
                                    this.correcto=true; 
                                }else {
                                    System.out.println("no debe haber un operador antes del parenteis");
                                    this.correcto=false;
                                    break;
                                }
                                
                            }
                            
                        }
                    }
                    else if(p==')'){
                        if(i==0||i==1){
                            System.out.println("este simbolo no puede ir en la primera posicion");
                            this.correcto=false;
                            break;
                        } else {
                            
                            if(i==this.ecuacion.length()-1){
                                a=this.ecuacion.charAt(i-1);
                                if(a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='e'||a=='x'||a=='y'||a==')'){
                                    this.cpare++;
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("cierra parentesis: "+p);
                                    this.correcto=true;
                                }else {
                                    System.out.println("no debe haber un operador antes del parenteis");
                                    this.correcto=false;
                                    break;
                                }
                                
                            }else if(i<this.ecuacion.length()-1){
                                 b=this.ecuacion.charAt(i+1);
                                if((b=='+'||b=='-'||b=='/'||b=='*'||b=='^'||b=='s'||b=='c'||b=='t'||b=='l'||b==')')){
                                    this.cpare++;
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("cierra parentesis: "+p);
                                    this.correcto=true;
                                }else {
                                    System.out.println("debe haber un operador despues del parenteis");
                                    this.correcto=false;
                                    break;
                                }
                            }
                        }
                    }else if(p=='y'){
                        
                        
                        if(i==0){
                            if(this.ecuacion.length()>1){
                                a=this.ecuacion.charAt(i+1);
                                    if (a=='+'||a=='-'||a=='/'||a=='*'||a=='^'){
                                        this.contmatriz++;
                                        this.ecuacionc[this.contmatriz]=""+p;
                                        System.out.println("la variable es: "+p);
                                        this.correcto=true; 
                                    }else {
                                        System.out.println("error, debe estar un aperador despues de x");
                                        this.correcto=false;
                                        break;
                                    }
                                }else{
                                    System.out.println("y esta solita");
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    this.correcto=true;
                                }
                        }else if(i==this.ecuacion.length()-1&&this.ecuacion.length()>1){
                            b=this.ecuacion.charAt(i-1);
                            if ((b=='+'||b=='-'||b=='/'||b=='*'||b=='^')){
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("la variable es: "+p);
                                    this.correcto=true; 
                                }else {
                                    System.out.println("error, debe estar un aperador antes o despues de y");
                                    this.correcto=false;
                                    break;
                                }
                            
                        }else{
                            a=this.ecuacion.charAt(i-1);
                            b=this.ecuacion.charAt(i+1);
                            if(this.apare>0){
                                if ((a=='+'||a=='-'||a=='/'||a=='*'||a=='^'||a=='(')&&(b=='+'||b=='-'||b=='/'||b=='*'||b=='^'||b==')')){
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("la variable es: "+p);
                                    this.correcto=true; 
                                }else {
                                    System.out.println("error, debe estar un aperador antes o despues de y");
                                    this.correcto=false;
                                    break;
                                }
                            }else{
                                if ((a=='+'||a=='-'||a=='/'||a=='*'||a=='^')&&(b=='+'||b=='-'||b=='/'||b=='*'||b=='^')){
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("la variable es: "+p);
                                    this.correcto=true; 
                                }else {
                                    System.out.println("error, debe estar un aperador antes o despues de x");
                                    this.correcto=false;
                                    break;
                                }
                            
                            }
                                
                        
                            }
                    }
                    else if(p=='x'){
                        if(i==0){
                            if(this.ecuacion.length()>1){
                                a=this.ecuacion.charAt(i+1);
                                    if (a=='+'||a=='-'||a=='/'||a=='*'||a=='^'){
                                        this.contmatriz++;
                                        this.ecuacionc[this.contmatriz]=""+p;
                                        System.out.println("la variable es: "+p);
                                        this.correcto=true; 
                                    }else {
                                        System.out.println("error, debe estar un aperador despues de x");
                                        this.correcto=false;
                                        break;
                                    }
                                }else{
                                    System.out.println("x esta solita");
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    this.correcto=true;
                                }
                        }else if(i==this.ecuacion.length()-1&&this.ecuacion.length()>1){
                            b=this.ecuacion.charAt(i-1);
                            if ((b=='+'||b=='-'||b=='/'||b=='*'||b=='^')){
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("la variable es: "+p);
                                    this.correcto=true; 
                                }else {
                                    System.out.println("error, debe estar un aperador antes o despues de x");
                                    this.correcto=false;
                                    break;
                                }
                            
                        }else{
                            a=this.ecuacion.charAt(i-1);
                            b=this.ecuacion.charAt(i+1);
                            if(this.apare>0){
                                if ((a=='+'||a=='-'||a=='/'||a=='*'||a=='^'||a=='(')&&(b=='+'||b=='-'||b=='/'||b=='*'||b=='^'||b==')')){
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("la variable es: "+p);
                                    this.correcto=true; 
                                }else {
                                    System.out.println("error, debe estar un aperador antes o despues de x");
                                    this.correcto=false;
                                    break;
                                }
                            }else{
                                if ((a=='+'||a=='-'||a=='/'||a=='*'||a=='^')&&(b=='+'||b=='-'||b=='/'||b=='*'||b=='^')){
                                    this.contmatriz++;
                                    this.ecuacionc[this.contmatriz]=""+p;
                                    System.out.println("la variable es: "+p);
                                    this.correcto=true; 
                                }else {
                                    System.out.println("error, debe estar un aperador antes o despues de x");
                                    this.correcto=false;
                                    break;
                                }
                            
                            }
                                
                        
                            }
                    }else if(p=='s'){
                        if(i+4<this.ecuacion.length())
                        b=this.ecuacion.charAt(i+4);
                        else{
                            this.correcto=false;
                            break;
                        }
                    if (b!=')'){
                        if(this.ecuacion.substring(i, i+4).equals("sin(")==true){
                            this.apare++;
                            this.contmatriz++;
                            this.ecuacionc[this.contmatriz]="sin(";
                            System.out.println("sin(: ");
                            this.correcto=true;
                            i+=3;
                        }else if(this.ecuacion.substring(i, i+4).equals("sec(")==true){
                            this.apare++;
                            this.contmatriz++;
                            this.ecuacionc[this.contmatriz]="sec(";
                            System.out.println("sec: ");
                            this.correcto=true;
                            i+=3;
                        }
                        else {
                            this.correcto=false;
                            break;
                        }
                    }else{
                        System.out.println("el angulo de la funcion trigonometrica no debe ser vacio");
                        this.correcto=false;
                        break;
                    }
                        
                    }
                    else if(p=='c'){
                        b=this.ecuacion.charAt(i+4);
                        if (b!=')'){
                        if("cos(".equals(this.ecuacion.substring(i, i+4))==true){
                            this.apare++;
                            this.contmatriz++;
                            this.ecuacionc[this.contmatriz]="cos(";
                            System.out.println("cos(: ");
                            this.correcto=true;
                            i+=3;
                        }else if("csc(".equals(this.ecuacion.substring(i, i+4))==true){
                            this.apare++;
                            this.contmatriz++;
                            this.ecuacionc[this.contmatriz]="csc(";
                            System.out.println("csc(: ");
                            this.correcto=true;
                            i+=3;
                        } else if("cot(".equals(this.ecuacion.substring(i, i+4))==true){
                            this.apare++;
                            this.contmatriz++;
                            this.ecuacionc[this.contmatriz]="cot(";
                            System.out.println("cot(: ");
                            this.correcto=true;
                            i+=3;
                        }
                        else {
                            this.correcto=false;
                        }
                        }else{
                        System.out.println("el angulo de la funcion trigonometrica no debe ser vacio");
                        this.correcto=false;
                        break;
                    }
                    }
                    else if(p=='t'){
                        b=this.ecuacion.charAt(i+4);
                        if (b!=')'){
                        if("tan(".equals(this.ecuacion.substring(i, i+4))==true){
                            this.apare++;
                            this.contmatriz++;
                            this.ecuacionc[this.contmatriz]="tan(";
                            System.out.println("tan(: ");
                            this.correcto=true;
                            i+=3;
                        }else {
                            this.correcto=false;
                        }
                        }else{
                        System.out.println("el angulo de la funcion trigonometrica no debe ser vacio");
                        this.correcto=false;
                        break;
                    }
                    }
                    else if(p=='l'){
                        b=this.ecuacion.charAt(i+3);
                        if (b!=')'){
                        if("ln(".equals(this.ecuacion.substring(i, i+3))==true){
                            this.apare++;
                            this.contmatriz++;
                            this.ecuacionc[this.contmatriz]="ln(";
                            System.out.println("ln(: ");
                            this.correcto=true;
                            i+=2;
                        }else {
                            this.correcto=false;
                        }
                        }else{
                        System.out.println("el logaritmo no debe ser vacio");
                        this.correcto=false;
                        break;
                    }
                    }else if(p=='e'){
                        this.contmatriz++;
                        this.ecuacionc[this.contmatriz]="e";
                        System.out.println("la constante e: "+Math.E);
                        this.correcto=true;
                    }
                    else{
                        this.correcto=false;
                        break;
                    }
                    }
                if((this.apare+this.cpare)==2||(this.apare+this.cpare)==4||(this.apare+this.cpare)==6){
                    if (this.apare==this.cpare){    
                        System.out.println("abrio y cerro un parenteis");
                        this.correcto=true;
                    }else{
                        System.out.println("abrio un partentesis y no lo cerro"); 
                        this.correcto=false;
                    }
                } else{
                    if(this.apare+this.cpare!=0){
                        
                            System.out.println("abrio un partentesis y no lo cerro"); 
                            this.correcto=false;
                           
                    }
                }
                }
        
        public boolean getcorrecto(){
            return correcto;
        }
        public String ecuacionc(){
            StringBuilder sb1=new StringBuilder();
                    for(int i=0;i<valoresY.ecuacionc.length;i++){
                        String str=valoresY.ecuacionc[i];
                    if(str!=null){
                    sb1.append(valoresY.ecuacionc[i]);
                    }
                    }
                    System.out.print(sb1.toString());
            
            return sb1.toString();
        }
        
    }
