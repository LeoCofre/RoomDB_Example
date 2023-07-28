package cl.awakelab.roomdb_example

import androidx.lifecycle.LiveData

class Repositorio(private val tareaDAO: TareaDAO) {

    //Insertamos tareas
    suspend fun insertarTarea(tarea: Tarea){
        tareaDAO.insertarTarea(tarea)
    }

    //Obtenemos tareas
    fun  obtenerTareas(): LiveData<List<Tarea>>{
        return tareaDAO.obtenerTareas()
    }
}