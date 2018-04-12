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

        private Nodo(int v){
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
        raiz = extraerAux(raiz, valor);
        return true;
    }

    public int[] elementos(){
        int[] res = new int[this.cardinal()];
        int i = 0;
        return elementosAux(raiz, res, i);
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
        if (raiz == null){
            return false; // el arbol esta vacio
        }
        if(valor == raiz.dato){
            return true;
        }
        if(valor < raiz.dato){
            return buscarAux(raiz.izquierda, valor);
        }else{
            return buscarAux(raiz.derecha, valor);
        }
    }

    private Nodo extraerAux(Nodo raiz, int valor){
        if (raiz == null)  return raiz;
        if (valor < raiz.dato)
            raiz.izquierda = extraerAux(raiz.izquierda, valor);
        else if (valor > raiz.dato)
            raiz.derecha = extraerAux(raiz.derecha, valor);
        else
        {
            if (raiz.izquierda == null)
                return raiz.derecha;
            else if (raiz.derecha == null)
                return raiz.izquierda;

            raiz.dato = masPequeño(raiz.derecha);
            raiz.derecha = extraerAux(raiz.derecha, raiz.dato);
        }

        return raiz;
    }

    private int masPequeño(Nodo n) {
        int minv = n.dato;
        while (n.izquierda != null)
        {
            minv = n.izquierda.dato;
            n = n.izquierda;
        }
        return minv;

    }

    private int[] elementosAux(Nodo raiz, int[] res, int i){
        if (raiz != null) {
            elementosAux(raiz.izquierda, res, i);
            res[i] = raiz.dato;
            i++;
            elementosAux(raiz.derecha,res, i);
        }
        return  res;
    }

    public void vaciar(){
        this.raiz = null;
    }

    public int cardinal(){ return contador;}


}
