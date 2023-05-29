package com.example.navigationexemple.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.navigationexemple.databinding.FragmentAddressBinding
import com.example.navigationexemple.databinding.FragmentResumeBinding
import com.example.navigationexemple.extensions.text
import com.example.navigationexemple.models.Person

class ResumeFragment: Fragment() {
    private var _binding: FragmentResumeBinding? = null
    private val binding get() = _binding!!

    private val args = navArgs<ResumeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        group: ViewGroup?,
        saved: Bundle?
    ): View {
        _binding = FragmentResumeBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvPerson.text = args.value.person.person
        binding.tvAddress.text = args.value.person.address

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}