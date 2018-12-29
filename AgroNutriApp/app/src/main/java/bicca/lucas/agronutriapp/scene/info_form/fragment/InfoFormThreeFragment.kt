package bicca.lucas.agronutriapp.scene.info_form.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormThreeViewModel

class InfoFormThreeFragment : Fragment() {

    companion object {
        fun newInstance() = InfoFormThreeFragment()
    }

    private lateinit var viewModel: InfoFormThreeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.info_form_three_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoFormThreeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
