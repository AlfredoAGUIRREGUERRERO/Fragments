package com.tallercmovil.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tallercmovil.fragments.adapter.GamesAdapter
import com.tallercmovil.fragments.databinding.FragmentGamesBinding
import com.tallercmovil.fragments.model.Game


class GamesFragment : Fragment(), GamesAdapter.OnItemListener {

    private lateinit var binding: FragmentGamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datos = ArrayList<Game>()

        for(i in 1 until 20){
            val gameTmp = Game(i, "Título $i", "Género $i", "Desarrollador $i")
            datos.add(gameTmp)
        }

        val adapter = GamesAdapter(requireContext(), datos, this)

        with(binding){
            //Recyclerview requiere un LayoutManager
            rvGames.layoutManager = LinearLayoutManager(requireContext())
            rvGames.adapter = adapter
        }

    }

    override fun miClick(game: Game) {
        Toast.makeText(requireContext(), "Juego: ${game.title}", Toast.LENGTH_SHORT).show()

        val bundle = Bundle()
        bundle.putString("dato1", "${game.title}")
        parentFragmentManager.setFragmentResult("datos",bundle)
    }

}