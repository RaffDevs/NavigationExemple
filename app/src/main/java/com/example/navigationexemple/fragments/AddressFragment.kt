package com.example.navigationexemple.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationexemple.databinding.FragmentAddressBinding
import com.example.navigationexemple.databinding.FragmentPersonalDataBinding
import com.example.navigationexemple.extensions.text
import com.example.navigationexemple.models.Person

class AddressFragment: Fragment() {
    private var _binding: FragmentAddressBinding? = null
    private  val binding get() = _binding!!

    private val args = navArgs<AddressFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        group: ViewGroup?,
        saved: Bundle?
    ): View {
        _binding = FragmentAddressBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("ARGUMENTOS", "onViewCreated: ${args.value.person}")

        binding.btnNext.setOnClickListener {
            val person = args.value.person.copy(
                street = binding.tilStreet.text,
                number = binding.tilNumber.text.toInt()
            )
            val directions = AddressFragmentDirections.goToResumeFragment(person)
            findNavController().navigate(directions)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}