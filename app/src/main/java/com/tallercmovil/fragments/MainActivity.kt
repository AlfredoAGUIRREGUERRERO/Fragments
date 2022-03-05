package com.tallercmovil.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.tallercmovil.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var animesFragment: AnimesFragment
    private lateinit var gamesFragment: GamesFragment
    private lateinit var initialFragment: InitialFragment

    //Este objeto va a manejar las transacciones de los fragmentos
    private lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animesFragment = AnimesFragment()
        gamesFragment = GamesFragment()
        initialFragment = InitialFragment()

        supportFragmentManager.beginTransaction().add(R.id.flFragmentContainer, initialFragment).commit()

    }

    fun click(view: View) {

        val transaction = supportFragmentManager.beginTransaction()

        when(view.id){
            R.id.btnAnimes -> {
                transaction.replace(binding.flFragmentContainer.id, animesFragment).commit()
                transaction.addToBackStack(null)
            }

            R.id.btnGames -> {
                transaction.replace(R.id.flFragmentContainer, gamesFragment).commit()
                transaction.addToBackStack(null )
            }
        }

    }
}