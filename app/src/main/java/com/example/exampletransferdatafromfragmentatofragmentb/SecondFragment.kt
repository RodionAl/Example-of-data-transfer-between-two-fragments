package com.example.exampletransferdatafromfragmentatofragmentb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {
    private var name: String? = null
    private var age: Int? = null
    private var userArgs: UserArgs? = null

    private var tvNameResult: TextView? = null
    private var tvAgeResult: TextView? = null
    private var tvUsersArgsResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_ARG)
            age = it.getInt(AGE_ARG)
            userArgs = it.getParcelable(USER_ARG)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }

    private fun initView(view: View) {
        tvNameResult = view.findViewById(R.id.tvNameResult)
        tvAgeResult = view.findViewById(R.id.tvAgeResult)
        tvUsersArgsResult = view.findViewById(R.id.tvUsersArgsResult)

        tvNameResult?.text = name.toString()
        tvAgeResult?.text = age.toString()
        tvUsersArgsResult?.text = userArgs.toString()
    }

    companion object {
        private const val NAME_ARG = "name_arg"
        private const val AGE_ARG = "age_arg"
        private const val USER_ARG = "user_arg"

        const val TAG = "SECOND_FRAGMENT"

        @JvmStatic
        fun newInstance(name: String, age: Int, userArgs: UserArgs) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME_ARG, name)
                    putInt(AGE_ARG, age)
                    putParcelable(USER_ARG, userArgs)
                }
            }
    }
}