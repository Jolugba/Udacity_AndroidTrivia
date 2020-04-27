package com.tinuade.udacity_androidtrivia.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.tinuade.udacity_androidtrivia.R
import com.tinuade.udacity_androidtrivia.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentTitleBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)
        binding.playButton.setOnClickListener{ view:View ->
            Navigation.findNavController(view).navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
            setHasOptionsMenu(true)
        }
    return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return view?.findNavController()?.let { NavigationUI.onNavDestinationSelected(item, it) }!!
                || super.onOptionsItemSelected(item)
    }
}


