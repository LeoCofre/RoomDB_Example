package cl.awakelab.roomdb_example

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TareaDAO {

    //Insertamos la tarea
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    //Devolvemos una lista de tareas
    @Query("Select * From tabla_tarea order by id asc")
    fun obtenerTareas(): LiveData<List<Tarea>>

}