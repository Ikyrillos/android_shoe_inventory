package com.example.udacityshoestore.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.udacityshoestore.R
import com.example.udacityshoestore.databinding.FragmentAddShoeBinding
import com.example.udacityshoestore.models.Shoe
import com.example.udacityshoestore.view_models.ShoeListViewModel


class AddShoeFragment : Fragment() {
    private lateinit var binding: FragmentAddShoeBinding
    private val singleViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container, false)
        binding.shoe = singleViewModel.shoe
        binding.addShoeObjectBtn.setOnClickListener {

            val shoe = Shoe(
               binding.shoe!!.name,
                binding.shoe!!.size,
                binding.shoe!!.company,
                binding.shoe!!.description
            )
            singleViewModel.addShoe(shoe)

            Log.i("AddShoeFragment", "Shoe added to list and shoeList is now ${shoe}")
        }
        return binding.root
    }

}