package com.example.exampletransferdatafromfragmentatofragmentb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    private var btnSent: Button? = null
    private var etName: EditText? = null
    private var etAge: EditText? = null
    private var etAdditionalInfo: EditText? = null

    private lateinit var secondFragment: SecondFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
        setListeners()
    }

    private fun initView(view: View) {
        btnSent = view.findViewById(R.id.btnSent)
        etName = view.findViewById(R.id.etName)
        etAge = view.findViewById(R.id.etAge)
        etAdditionalInfo = view.findViewById(R.id.etAdditionalInfo)
    }

    private fun setListeners() {
        btnSent?.setOnClickListener {
            sentData()
        }
    }

    private fun sentData() {
        val name = etName?.text.toString()
        val age = etAge?.text.toString().toInt()
        val info = etAdditionalInfo?.text.toString()

        val userArgs = UserArgs(
            name = name,
            age = age,
            info = info
        )

        navigateToSecondFragment(
            name = name,
            age = age,
            userArgs = userArgs
        )
    }

    private fun navigateToSecondFragment(name: String, age: Int, userArgs: UserArgs) {
        secondFragment = SecondFragment.newInstance(
            name = name,
            age = age,
            userArgs = userArgs
        )

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, secondFragment, SecondFragment.TAG)
            .addToBackStack(SecondFragment.TAG)
            .commit()
    }

    companion object {
        const val TAG = "FIRST_FRAGMENT"

        fun newInstance() = FirstFragment()
    }
}