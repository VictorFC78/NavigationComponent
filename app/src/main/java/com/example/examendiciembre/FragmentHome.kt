package com.example.examendiciembre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examendiciembre.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.hamburguesa.setOnClickListener {
            //findNavController().navigate(R.id.detallePedido) navegacion sin parametros
            //findNavController().navigate(R.id.action_fragmentHome_to_detallePedido) sin parametros mediante la accion del navigation
    //navegar pasando datos mediante args, esto se realiza mediante una clase asociada con el mismo nombre que el
            //fragmento acabdo en directions,y una funcion static de dicah clase con el nombre de la accion
            //en el actionFragmentHomeToDetallePedido(argumento1,argumento2,...)
            val actionHam=FragmentHomeDirections.actionFragmentHomeToDetallePedido(getString(R.string.hamburguesa))//dato producto
            findNavController().navigate(actionHam)
        }
        binding.pizza.setOnClickListener {
            val actionPizza=FragmentHomeDirections.actionFragmentHomeToDetallePedido(getString(R.string.pizza))//dato producto
            findNavController().navigate(actionPizza)
        }
        binding.enselada.setOnClickListener {
            val actionSalad=FragmentHomeDirections.actionFragmentHomeToDetallePedido(getString(R.string.ensalada))//dato producto
            findNavController().navigate(actionSalad)
        }
        binding.Taco.setOnClickListener {
            val actionTaco=FragmentHomeDirections.actionFragmentHomeToDetallePedido(getString(R.string.taco))//dato producto
            findNavController().navigate(actionTaco)
        }
    }
    //se llama para cuando se destruya el fragmemto desasocie el biding de la clase asociado y libera memoria
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}