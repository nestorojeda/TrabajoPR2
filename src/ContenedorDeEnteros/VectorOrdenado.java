package ContenedorDeEnteros;

public class VectorOrdenado implements ContenedorDeEnteros {

    //declaramos los atributos del contenedor
    private int[] contenedor;
    private int nElementos;

    //constructor con máximo número de elementos como parámetro
    public VectorOrdenado(int max){
        contenedor= new int[max];
        nElementos = 0;
    }

    public int cardinal(){
        return nElementos;
    }

    //Método insertar que devuelve true si lo inserta, o false si no es posible insertarlo
    //bien porque ya se encuentra en el contenedor o bien porque esta lleno.
    public boolean insertar(int i){
        //Devuelve false si está lleno
        if(nElementos == contenedor.length) {
            return false;
        }
        //Parámetros necesarios para la búsqueda dicotómica
        int inicio = 0;
        int fin = nElementos-1;
        int mitad;
        //Bucle para la búsqueda dicotómica
        while(inicio <= fin) {
            mitad = (inicio + fin)/2;
            if(contenedor[mitad] == i) {
                //Si está devuelve false
                return false;
            }
            //Si no lo encuentra asignamos, dependiendo de si el elemento es
            //mayor o menor que el buscado, el nuevo valor a fin o inicio
            if(contenedor[mitad] > i) {
                fin = mitad - 1;
            } else {
                inicio = mitad + 1;
            }
        }
        for(int j = nElementos; j > inicio; j--) {
            contenedor[j] = contenedor[j - 1];
        }
        contenedor[inicio] = i;
        nElementos++;
        return true;
    }

    //Método para extraer un elemento, devuelve true si lo encuentra y por tanto
    //extrae, y false si no lo encuentra
    public boolean extraer(int i){
        //Parámetros necesarios para la busqueda dicotómica
        int inicio = 0;
        int fin = nElementos-1;
        int mitad;
        //Bucle para la búsqueda dicotómica
        while(inicio<=fin) {
            mitad = (inicio + fin)/2;
            if(contenedor[mitad] == i) {
                //Si lo encuentra mueve todos los elementos una posición hacia
                //atrás a partir del siguiente del extraido y actualiza nElementos,
                //además de retornar true
                for(int j = mitad; j < nElementos -1; j++) {
                    contenedor[j] = contenedor[j + 1];
                }
                nElementos--;
                return true;
            }
            //Reasignación de fin o inicio
            if(contenedor[mitad] > i) {
                fin = mitad - 1;
            } else {
                inicio = mitad + 1;
            }
        }

        return false;
    }

    //Método de busqueda dicotómica similar a los anteriores
    public boolean buscar(int i){
        int inicio = 0;
        int fin = nElementos -1;
        int mitad;
        while(inicio<=fin) {
            mitad = (inicio + fin)/2;
            if(contenedor[mitad] == i) {
                return true;
            }
            if(contenedor[mitad] > i) {
                fin = mitad - 1;
            } else {
                inicio = mitad + 1;
            }
        }
        return false;
    }

    public void vaciar(){
        nElementos = 0;
    }

    //Devuelve un vector de enteros compuesto por los elementos del contenedor
    public int[] elementos(){
        int[] result = new int[nElementos];
        for(int i = 0; i < nElementos; i++) {
            result[i] = contenedor[i];
        }
        return result;
    }
}
