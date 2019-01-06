package bicca.lucas.agronutriapp.scene.info_form.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.InfoFormThreeFragmentBinding
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormThreeViewModel
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher

class InfoFormThreeFragment : Fragment() {

    // region --- ATTRIBUTES ---
    private lateinit var binding: InfoFormThreeFragmentBinding

    companion object {
        fun newInstance() = InfoFormThreeFragment()
    }

    lateinit var viewModel: InfoFormThreeViewModel
    // endregion

    // region --- LIFECYCLE ---
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(InfoFormThreeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form_three_fragment, container, false)
        binding.viewModel = viewModel
        setupWatchers()
        return binding.root
    }
    // endregion

    // region --- LISTENERS ---
    private fun setupWatchers() {
        binding.infoFormThreeFragmentTieAl.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormThreeFragmentTieBases.addTextChangedListener((ValorMonetarioWatcher()))
        binding.infoFormThreeFragmentTieIndexSmap.addTextChangedListener(ValorMonetarioWatcher())
    }
    // endregion
}
