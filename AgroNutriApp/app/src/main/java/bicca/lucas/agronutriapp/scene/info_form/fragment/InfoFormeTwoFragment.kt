package bicca.lucas.agronutriapp.scene.info_form.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormeTwoViewModel

class InfoFormeTwoFragment : Fragment() {

    companion object {
        fun newInstance() = InfoFormeTwoFragment()
    }

    private lateinit var viewModel: InfoFormeTwoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.info_forme_two_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoFormeTwoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
