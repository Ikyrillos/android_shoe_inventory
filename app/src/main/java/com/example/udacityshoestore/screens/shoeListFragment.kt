package com.example.udacityshoestore.screens

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.udacityshoestore.MainActivity
import com.example.udacityshoestore.R
import com.example.udacityshoestore.databinding.FragmentCardBinding
import com.example.udacityshoestore.databinding.FragmentShoeListBinding
import com.example.udacityshoestore.view_models.ShoeListViewModel

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var cardBinding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        cardBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_card, container, false)
        binding.addShoeBtn.setOnClickListener {
            it.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment())
        }
        val singleViewModel: ShoeListViewModel by activityViewModels()
        Log.i("ShoeListFragment", "onCreateView: ${singleViewModel.shoeList.value}")
        singleViewModel.shoeList.observe(viewLifecycleOwner) { newShoeList ->
            //first will remove the previous views to avoid duplicates
            // then fill the list with the new data from the view model
            binding.shoesBox.removeAllViews()
            for (shoe in newShoeList) {
                val itemBinding: FragmentCardBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.fragment_card,
                    binding.shoesBox,
                    false
                )
                itemBinding.shoe = shoe
                binding.shoesBox.addView(itemBinding.root)
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // remove all back stack pages
        if (item.itemId == R.id.go_loginFragment) {
            view?.findNavController()
                ?.navigate(R.id.loginFragment)
        }
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}