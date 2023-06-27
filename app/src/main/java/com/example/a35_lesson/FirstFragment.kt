package com.example.a35_lesson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a35_lesson.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var counterTen = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plusAndMinus()

    }
    private fun sendData(){
        val bundle = Bundle()
        bundle.putString("TRIGON",binding.tvResult.text.toString())
        val resultFragment = ResultFragment()
        resultFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container,resultFragment).commit()
    }

    private fun plusAndMinus(){
        var count = binding.tvResult.text.toString().toInt().plus(1)
        binding.btnPlusMinus.setOnClickListener {
            when (counterTen) {
                false -> {
                    when (count == 10) {
                        false -> {
                            binding.tvResult.text = count++.toString()
                        }
                        true -> {
                            counterTen = true
                            binding.tvResult.text = count--.toString()
                            binding.btnPlusMinus.text = "-"
                        }
                    }
                }
                true -> {
                    when (count == 0) {
                        false ->
                            binding.tvResult.text = count--.toString()
                        true -> sendData()
                    }
                }
            }
        }
    }
}