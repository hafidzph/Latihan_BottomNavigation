package com.latihan.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.latihan.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCurrentFragment(FirstFragment())
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.firstFragment -> setCurrentFragment(FirstFragment())
                R.id.secondFragment -> setCurrentFragment(SecondFragment())
                R.id.thirdFragment -> setCurrentFragment(ThirdFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment:Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}