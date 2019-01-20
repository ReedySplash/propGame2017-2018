package dades;

import domini.adapters.IControladorDatos;

import java.io.*;
/*Autor Carlos Alvarado*/
public abstract class ControladorDatos implements IControladorDatos{

    /*Post: Devuelve el objeto con el nombre nom y la ruta en disco*/
    protected Object getObj(String nom, String ruta) throws Exception {
        Object objeto = new Object();
        File archivo = new File(ruta);
        FileInputStream fis = null;
        ObjectInputStream leerObjeto = null;
        try{
            fis = new FileInputStream(archivo);
            leerObjeto = new ObjectInputStream(fis);
            objeto = (Object) leerObjeto.readObject();
        }
        catch( Exception e ){
            e.printStackTrace();
        }
        finally
        {
            try{
                if( leerObjeto != null )  {
                    leerObjeto.close();
                    fis.close();
                }
            }catch( Exception ex ){
                ex.printStackTrace();
            }
        }
        return objeto;
    }

    /*Devuelve una parte de la ruta de los datos*/
    protected String getRuta() {
        File fakeForPath = new File(".");
        return fakeForPath.getAbsolutePath()+ File.separator + "datos" + File.separator;
    }

    /*Post: Devuelve un booleano que nos indica si el objeto con el nombre nom y la ruta en disco */
    protected boolean existsObj(String nom, String ruta)throws Exception{
        File file = new File(ruta);
        try {
            if (file.exists())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*Post: Guarda el objeto con el nombre nom guardado y la ruta en disco*/
    protected void guardaObj(Object objeto, String nom, String ruta) throws Exception {
        File file = new File(ruta);
        FileOutputStream fs = null;
        ObjectOutputStream os = null;
        try{
            fs = new FileOutputStream(file, true);
            os = new ObjectOutputStream(fs);
            os.writeObject(objeto);
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (null != os) os.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /*Post: Borra el objeto con el nombre nom guardado y la ruta en disco*/
    protected boolean borrarObj(String nom, String ruta) throws Exception {
        File file = new File(ruta);
        try {
            if (file.exists()) {
                file.delete();
                return true;
            }
            else
                throw new Exception("No existe el objeto");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /*Post: Devuelve el objeto con el nombre nom guardado en disco*/
    public abstract Object get(String nom) throws Exception;

    /*Post: Devuelve un booleano que nos indica si el objeto con el nombre nom existe en disco */
    public abstract boolean exists(String nom) throws Exception;

    /*Post: Guarda el objeto con el nombre nom guardado en disco*/
    public abstract void guardar(Object objeto) throws Exception;

    /*Post: Borra el objeto con el nombre nom guardado en disco*/
    public abstract boolean borrar(String nom) throws Exception;
}
