package cl.awakelab.roomdb_example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.awakelab.roomdb_example.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgregarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgregarFragment : Fragment() {

    lateinit var binding: FragmentAgregarBinding
    lateinit var repositorio: Repositorio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initRepositorio()
        initListener()
        obtenerListaTareas()
        return binding.root
    }

    //Iniciamos repositorio
    private fun initRepositorio() {
        repositorio = Repositorio(TareaBaseDatos.getDatabase(requireContext()).getTaskDao())
    }

    private fun initListener() {
        binding.btnAgregarTarea.setOnClickListener {
            val texto = binding.editTextTarea.text.toString()
            guardarTarea(texto)
        }
    }

    private fun guardarTarea(texto: String) {
        val tarea = Tarea(texto)
        GlobalScope.launch { repositorio.insertarTarea(tarea) }

    }

    private fun obtenerListaTareas() {

        val tareas = repositorio.obtenerTareas().observe(requireActivity()) {
            val tasksAsText = it.joinToString("\n") { it.nombre }
            binding.tvLista.text = tasksAsText
        }

    }


}

