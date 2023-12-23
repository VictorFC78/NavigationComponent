package com.example.examendiciembre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examendiciembre.databinding.FragmentConfirmarDatosBinding


class ConfirmarDatos : Fragment() {
  private var _binding :FragmentConfirmarDatosBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentConfirmarDatosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //recogemos los valores dela args y los mostramos
        val args:ConfirmarDatosArgs by navArgs()
        binding.nombre.text=getString(R.string.nombre_confirmacion,args.nombre)
        binding.pedido.text=getString(R.string.pedido_confirmacion,args.cantidad,args.producto)
        if(args.comer){
            binding.horarioRecogida.text=getString(R.string.horario_confirmacion,getString(R.string.para_comer_horario))
        }else{
            binding.horarioRecogida.text=getString(R.string.horario_confirmacion,getString(R.string.para_cenar_horario))
        }
        binding.botonContinuarPedido.setOnClickListener {
            findNavController().navigate(R.id.action_confirmarDatos_to_pedidoFinalizado)
        }
        binding.botonSalirPedido.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}