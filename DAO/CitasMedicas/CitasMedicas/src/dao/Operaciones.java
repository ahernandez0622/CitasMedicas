
package dao;

import java.util.List;


public interface Operaciones {
    public boolean insertar(Object obj);
    public boolean eliminar(Object obj);
    public boolean modificar(Object obj);
    public List<?> seleccionar ();
    
}
