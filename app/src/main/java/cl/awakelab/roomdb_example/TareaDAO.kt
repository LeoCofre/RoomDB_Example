package cl.awakelab.roomdb_example

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TareaDAO   {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

}