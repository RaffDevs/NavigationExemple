package com.example.navigationexemple.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationexemple.R
import com.example.navigationexemple.models.Person
import com.example.navigationexemple.databinding.FragmentPersonalDataBinding
import com.example.navigationexemple.extensions.text

class PersonalDataFragment : Fragment() {
    private var _binding: FragmentPersonalDataBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        group: ViewGroup?,
        saved: Bundle?
    ): View {
        _binding = FragmentPersonalDataBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            val person = Person(
                name = binding.tilName.text,
                age = binding.tilAge.text.toInt()
            )
            val directions = PersonalDataFragmentDirections.goToAddressFragment(person)
            findNavController().navigate(directions)
            // TODO Mandar os dados para outro fragment
            // TODO Navegar entre os fragments
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}