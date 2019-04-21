package bicca.lucas.agronutriapp.scene.result

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import bicca.lucas.agronutriapp.BR
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.ActivityViewResultBinding
import bicca.lucas.agronutriapp.logic.`object`.InfoForm
import bicca.lucas.agronutriapp.scene.BundleConstants

import kotlinx.android.synthetic.main.activity_view_result.*

class ViewResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityViewResultBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_result)
        setSupportActionBar(toolbar)

        intent.extras?.let {
            val infoForm: InfoForm = it.getParcelable(BundleConstants.INFO_FORM_EXTRAS)
            binding.setVariable(BR.viewModel, ViewResultViewModel(application, infoForm))
        }
    }

}
