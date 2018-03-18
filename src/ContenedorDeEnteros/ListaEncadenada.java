package ContenedorDeEnteros;

public class ListaEncadenada implements ContenedorDeEnteros{
    private Nodo first;
    private int count;

    // Clase Nodo
    private class Nodo {
        protected Nodo next;
        protected int val;

        public Nodo(Nodo next, int val) {
            this.val = val;
            this.next = next;
        }

    }

    // Constructor por defecto que permite crear contenedores vacÃ­os.
    public ListaEncadenada(){
        first = null;
        count = 0;
    }


    // Devuelve el nÃºmero de elementos del contenedor.
    public int cardinal(){
        return count;
    }

    /* AÃ±ade al contenedor un nuevo elemento pasado por parÃ¡metro,
     devuelve verdadero si lo aÃ±adiÃ³ y falso en caso contrario.
    */
    public boolean insertar(int i){
        if(this.buscar(i)){
            return false;
        } else {
            first = new Nodo(first,i);
            count++;
            return true;
        }
    }


    // Extraer del contenedor el elemento pasado por parÃ¡metro,
    // devuelve verdadero si lo eliminÃ³ y falso en caso contrario. Si no se encuentra no se altera el contenedor.
    public boolean extraer(int i){
        Nodo aux = first;
        Nodo ant = null;
        while(aux != null){
            if(aux.val == i){
                if (ant==null) {
                    first = aux.next;
                } else {
                    ant.next = aux.next;
                }
                count--;
                return true;
            } else {
                ant = aux;
                aux = aux.next;
            }
        }
        return false;
    }

    // Devuelve verdadero si el valor pasado por parÃ¡metro pertenece al contenedor y falso en caso contrario.
    public boolean buscar(int i){
        Nodo aux = first;
        while(aux != null){
            if(aux.val == i){
                return true;
            } else {
                aux = aux.next;
            }
        }
        return false;
    }

    // Deja el contenedor sin ningÃºn elemento.
    public void vaciar(){
        first = null;
        count = 0;
    }

    // Devuelve un vector de enteros con los elementos que se encuentren en el contenedor.
    public int[] elementos(){
        Nodo aux = first;
        int[] res = new int[this.cardinal()];
        for(int i = res.length-1; i>=0; i--) {
            res[i] = aux.val;
            aux = aux.next;
        }
        return res;
    }
}
