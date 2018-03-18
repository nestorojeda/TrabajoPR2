package ContenedorDeEnteros.practica3;

public class ArbolBinario {
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

    public void insertar(int valor){
        raiz = añadirAux(raiz, valor);
    }

    public boolean buscar(int valor){
        return buscarAux(raiz,valor);
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

    public void vaciar(){
        this.raiz = null;
    }

    public int cardinal(){ return contador;}
}
