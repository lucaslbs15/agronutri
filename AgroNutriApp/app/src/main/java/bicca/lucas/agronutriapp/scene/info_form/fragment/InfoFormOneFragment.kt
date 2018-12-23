package bicca.lucas.agronutriapp.scene.info_form.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.InfoFormOneFragmentBinding
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormOneViewModel

class InfoFormOneFragment : Fragment() {

    private lateinit var binding: InfoFormOneFragmentBinding
    lateinit var viewModel: InfoFormOneViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form_one_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(InfoFormOneViewModel::class.java)
        binding.viewModel = viewModel
        binding.context = context

        return binding.root
    }

    companion object {
        fun newInstance() = InfoFormOneFragment()
    }
}
