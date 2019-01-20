package domini.adapters;
/*Autor Carlos Alvarado*/
public interface IControladorDatos {
    /*Post: Devuelve el objeto con el nombre nom guardado en disco*/
    public  Object get(String nom) throws Exception;

    /*Post: Devuelve un booleano que nos indica si el objeto con el nombre nom existe en disco */
    public  boolean exists(String nom) throws Exception;

    /*Post: Guarda el objeto con el nombre nom guardado en disco*/
    public  void guardar(Object objeto) throws Exception;

    /*Post: Borra el objeto con el nombre nom guardado en disco*/
    public  boolean borrar(String nom) throws Exception;
}
