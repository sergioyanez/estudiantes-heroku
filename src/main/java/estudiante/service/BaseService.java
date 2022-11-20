package estudiante.service;




import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Servicio base(interface) común al resto de servicios con las funcionalidades CRUD.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 * @param <T> Tipo de la entidad que manipula
 */
public interface BaseService<T,ID> {

    /**
     * Servicio encargado de retornar un listado completo de una entidad.
     *
     * @return Listado con entidades.
     * @throws Exception e
     */
    public List<T> findAll()throws Exception;

    /**
     * Servicio encargado de buscar y retornar una entidad coincidente con el id ingresado por parámetro.
     *
     * @param id Identificador únido de la entidad.
     * @return Entidad coincidente con id.
     * @throws Exception e
     */
    public T findById(Long id)throws Exception;

    /**
     * Servicio encargado de persistir una entidad ingresada por parámetro.
     * @param entity entidad a persistir
     * @return Entidad persistida con id asignado.
     * @throws Exception e
     */
    public T save(T entity)throws  Exception;

    /**
     * Servicio encargado de actualizar una entidad.
     * @param id Identificador único de la entidad a actualizar.
     * @param entity Entidad con los datos a a actualizar.
     * @return Retorna la entidad actualizada.
     * @throws Exception e
     */
    public T update(Long id, T entity)throws Exception;

    /**
     * Servicio encargado de eliminar una entidad correspondiente al id ingresado por parámetro.
     * @param id Identificador único de la entidad a eliminar.
     * @return True en caso de eliminación exitosa, caso contrario false.
     * @throws Exception e
     */
    public boolean delete(Long id)throws Exception;
}
