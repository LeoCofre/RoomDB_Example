package cl.awakelab.roomdb_example

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TareaDao   {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

}