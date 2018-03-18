package ContenedorDeEnteros;

interface ContenedorDeEnteros {
    public boolean insertar(int valor);
    public boolean extraer(int valor);
    public boolean buscar(int valor);
    public int cardinal();
    public void vaciar();
}
