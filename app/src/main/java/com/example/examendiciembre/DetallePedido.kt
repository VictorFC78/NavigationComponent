package com.example.examendiciembre

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examendiciembre.databinding.FragmentDetallePedidoBinding


class DetallePedido : Fragment() {
private var _binding:FragmentDetallePedidoBinding?=null
    private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentDetallePedidoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //para recoger los arguememtos enviados con el argsSafe android genera una clase especifica par ello
        //el nombre de la clase es igual que la del fragmento acabada en Args
        val args:DetallePedidoArgs by navArgs()//variable que contendra el valor de las variable pasadas por FragmentHome mediante args
        //mostramos por pantalla el valor del producrto
        //escribe en el textview el valor del pructo, pero para ello recuperra el texto que tiene escrito el texvio mediante
        //getString y el id del recurso y al %s de dicho recurso le añade el args.producto
        binding.productoSeleccionado.text=getString(R.string.detalles_titulo,args.productp)

        //recogemos todos los valores del los inputtxt  cuando se hace click en el boto continuar y comprobamos que no esten vacios
        binding.botonContinuar.setOnClickListener {
            //recuperamos el texto de editinputtext lo pasamos a sating y despues a entero, recuperamos el nobre
            val cantidad=binding.edittxtCantidad.text?.toString()
            val nombre=binding.edittxtNombre.text?.toString()
            //comprobamos si alguno de los campos esta vacio
            if(cantidad!!.isEmpty()){
                //mostramos mensaje
                Toast.makeText(context,getString(R.string.error_cantidad_vacia),Toast.LENGTH_SHORT).show()
            }else if(nombre!!.isEmpty() || nombre.isBlank()){
                //mostramos mensaje
                Toast.makeText(context,getString(R.string.error_nombre_vacio),Toast.LENGTH_SHORT).show()
            }else{
                //enviamos los datos mediante en navedor
                val eleccion=binding.paraComer.isSelected
                val action =DetallePedidoDirections.actionDetallePedidoToConfirmarDatos(cantidad.toInt(),eleccion,nombre,args.productp)
                findNavController().navigate(action)
            }
        }
            binding.botonSalir.setOnClickListener {
                findNavController().popBackStack()//navega hacia atras en la pila de navegacion
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}