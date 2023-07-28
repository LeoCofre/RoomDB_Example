package cl.awakelab.roomdb_example

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TareaViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio: Repositorio

    init {
        repositorio = Repositorio(TareaBaseDatos.getDatabase(application).getTaskDao())
    }

    fun obtenerTareas(): LiveData<List<Tarea>> {
        return repositorio.obtenerTareas()

    }

    fun insertarTarea(tarea: Tarea) = viewModelScope.launch{
        repositorio.insertarTarea(tarea)
    }
}