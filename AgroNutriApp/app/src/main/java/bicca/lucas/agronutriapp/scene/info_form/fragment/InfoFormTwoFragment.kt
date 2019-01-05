package bicca.lucas.agronutriapp.scene.info_form.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.InfoFormTwoFragmentBinding
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormTwoViewModel
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher

class InfoFormTwoFragment : Fragment() {

    private lateinit var binding: InfoFormTwoFragmentBinding

    companion object {
        fun newInstance() = InfoFormTwoFragment()
    }

    private lateinit var viewModel: InfoFormTwoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form_two_fragment, container, false)
        binding.infoFormTwoFragmentTesteWatcher.addTextChangedListener(ValorMonetarioWatcher())
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoFormTwoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
