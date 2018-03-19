package ContenedorDeEnteros;

public class ArbolBinario implements ContenedorDeEnteros{
    class Nodo{
        int dato;
        Nodo derecha;
        Nodo izquierda;

        public Nodo(){
            izquierda = null;
            derecha = null;
        }

        public Nodo(int v){
            this.dato = v;
            izquierda = null;
            derecha = null;
        }
    }

    private Nodo raiz;
    private int contador = 0;

    public boolean insertar(int valor){
        raiz = añadirAux(raiz, valor);
        return true;
    }

    public boolean buscar(int valor){
        return buscarAux(raiz,valor);
    }

    public boolean extraer(int valor){
        extraerAux(raiz, valor);
        return true;
    }


    private Nodo añadirAux(Nodo raiz, int valor) {
        if(raiz == null){
            contador++;
            return new Nodo(valor);
        }
        if(valor > raiz.dato){
            raiz.derecha = añadirAux(raiz.derecha, valor);
        }else if(valor < raiz.dato){
            raiz.izquierda = añadirAux(raiz.izquierda, valor);
        }else{
            return raiz;
        }
        return raiz;
    }

    private boolean buscarAux(Nodo raiz, int valor) {
        if(valor == raiz.dato){
            return true;
        }
        if (raiz == null){
         return false; // el arbol esta vacio
        }
        if(valor < raiz.dato){
            return buscarAux(raiz.izquierda, valor);
        }else{
            return buscarAux(raiz.derecha, valor);
        }
    }

    private Nodo extraerAux(Nodo raiz, int valor){
        if (raiz == null) {
            return null;
        }

        if (valor == raiz.dato) {
            if (raiz.izquierda == null && raiz.derecha == null) {
                return null;
            }else if (raiz.izquierda == null) {
                return raiz.derecha;
            }else if (raiz.derecha == null) {
                return raiz.izquierda;
            }else{

            }


        }
        if (valor < raiz.dato) {
            raiz.izquierda = extraerAux(raiz.izquierda, valor);
            return raiz;
        }
        raiz.derecha = extraerAux(raiz.derecha, valor);
        return raiz;
    }

    public void vaciar(){
        this.raiz = null;
    }

    public int cardinal(){ return contador;}
}
