package com.example.examendiciembre

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examendiciembre.databinding.FragmentPedidoFinalizadoBinding


class PedidoFinalizado : Fragment() {
    private var _binding:FragmentPedidoFinalizadoBinding?=null
    private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentPedidoFinalizadoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cerrarApp.setOnClickListener {
            activity?.finish()
        }
        binding.txtEnviar.setOnClickListener {
            //crea el intent implicito de tipo send texto plano
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "textMessage")
                type = "text/plain"
            }
    //para realizar el intento tiene que existuar una aplicacion que la reciba, en este caso como se trata de un fragment
            //hay que consegiuir el contexto ya que estamos en un fragmento ya que la funcion resolver necesita una
            //actividad para resover y lanzar otra la actividad con el intento, si el intento lo realizasemos desde una
            //actividad seria if (sendIntent.resolveActivity(packageManager) != null) {
            //    startActivity(sendIntent)
            if (context?.let { it1 -> sendIntent.resolveActivity(it1.packageManager) } != null) {
                startActivity(sendIntent)
            }
        }

    }
}