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
import bicca.lucas.agronutriapp.logic.`object`.InfoForm
import bicca.lucas.agronutriapp.scene.BundleConstants
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormTwoViewModel
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher

class InfoFormTwoFragment : Fragment() {

    // region --- ATTRIBUTES ---
    private lateinit var binding: InfoFormTwoFragmentBinding

    companion object {
        fun newInstance() = InfoFormTwoFragment()
    }

    lateinit var viewModel: InfoFormTwoViewModel
    // endregion

    // region --- LIFECYCLE ---
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form_two_fragment, container, false)
        setupWatchers()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoFormTwoViewModel::class.java)
        savedInstanceState?.getParcelable<InfoForm>(BundleConstants.INFO_FORM_TWO)?.let {
            viewModel.setValues(it)
        }
        binding.viewModel = viewModel
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(BundleConstants.INFO_FORM_TWO, viewModel.getValues())
    }
    // endregion

    private fun setupWatchers() {
        binding.infoFormTwoFragmentTiePhWater.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormTwoFragmentTieCa.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormTwoFragmentTieMg.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormTwoFragmentTieAl.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormTwoFragmentTieHAl.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormTwoFragmentTieCtc.addTextChangedListener(ValorMonetarioWatcher())
    }

}
